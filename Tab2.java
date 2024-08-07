package  Akshay;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tab2 {
 public static JPanel createTab2() {
  JPanel secondtabPanel = new JPanel(new BorderLayout());

  // Left Panel (innerPanel)
  JPanel innerPanel = new JPanel(new GridLayout(4, 2));
  JLabel idLabel = new JLabel("ID");
  JTextField idField = new JTextField();
  JLabel monthLabel = new JLabel("Select Month:");
  String[] months = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
  JComboBox<String> monthComboBox = new JComboBox<>(months);
  JLabel submissionLabel = new JLabel("Submission Date");
  JTextField submissionField = new JTextField();
  JLabel amountLabel = new JLabel("Amount");
  JTextField amountField = new JTextField();
  innerPanel.add(idLabel);
  innerPanel.add(idField);
  innerPanel.add(monthLabel);
  innerPanel.add(monthComboBox);
  innerPanel.add(submissionLabel);
  innerPanel.add(submissionField);
  innerPanel.add(amountLabel);
  innerPanel.add(amountField);

  // Right Panel (previous_tablePanel)
  JPanel previous_tablePanel = new JPanel(new BorderLayout(0,10));
  // Vertically split previous_tablePanel with outputTable
  JTable outputTable = new JTable();
  DefaultTableModel tableModel = new DefaultTableModel();
  tableModel.addColumn("Month");
  tableModel.addColumn("Submission Date");
  tableModel.addColumn("Tuition Fee");
  tableModel.addColumn("Amount Paid");
  tableModel.addColumn("Pending");
  outputTable.setModel(tableModel);
  JPanel outputTablePanel = new JPanel(new BorderLayout());
  outputTablePanel.add(new JScrollPane(outputTable), BorderLayout.CENTER);
  previous_tablePanel.add(outputTablePanel, BorderLayout.CENTER);
  // Add other components to previous_tablePanel (Name, ID, Class, Phone)
  JLabel nameLabel = new JLabel("Name of Student :");
  JLabel nameInput = new JLabel();
  JLabel iddLabel = new JLabel("ID :");
  JLabel idInput = new JLabel();
  JLabel classLabel = new JLabel("Class :");
  JLabel classInput = new JLabel();
  JLabel phoneLabel = new JLabel("Phone Number : ");
  JLabel phoneInput = new JLabel();
  JPanel infoPanel = new JPanel(new GridLayout(4, 2,10,10));
  infoPanel.add(iddLabel);
  infoPanel.add(idInput);
  infoPanel.add(nameLabel);
  infoPanel.add(nameInput);
  infoPanel.add(classLabel);
  infoPanel.add(classInput);
  infoPanel.add(phoneLabel);
  infoPanel.add(phoneInput);
  previous_tablePanel.add(infoPanel, BorderLayout.NORTH);


  // Split Pane
  JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, innerPanel, previous_tablePanel);
  splitPane.setResizeWeight(0.3); // Adjust the resize weight as needed

  secondtabPanel.add(splitPane, BorderLayout.CENTER);

  // Add buttons or other components as needed
  JPanel buttonPanel = new JPanel();
  JButton update = new JButton("Update");
  JButton exit = new JButton("Exit");
  JButton search = new JButton("Search");
  buttonPanel.add(search);
  buttonPanel.add(update);
  buttonPanel.add(exit);
  secondtabPanel.add(buttonPanel, BorderLayout.SOUTH);

  // Action listeners for buttons
  search.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    SearchFee.searchFee(idInput, nameInput, classInput, phoneInput, idField, monthComboBox, submissionField, amountField, tableModel);
    //SearchFee.searchprofile(idField,idInput,nameInput,classInput, phoneInput);
   }
  });
  update.addActionListener(e -> {
  UpdateFee.updateFee(idInput, nameInput, classInput, phoneInput, idField, monthComboBox, submissionField, amountField, tableModel);
  });
  exit.addActionListener(e -> System.exit(0));

  return secondtabPanel;
 }
}