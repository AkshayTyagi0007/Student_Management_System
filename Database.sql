UPDATE fee
SET Amount_Paid = 500
WHERE Id = 1 AND Fee_Month = 'May';



CREATE TABLE fee (
Trans_ID INT PRIMARY KEY AUTO_INCREMENT,
ID INT,
Submission_Date DATE,
Fee_Month VARCHAR(10),
Tution_Fee INT,
Amount_Paid INT DEFAULT 0,
Pending INT
);
CREATE TABLE student (
ID INT PRIMARY KEY AUTO_INCREMENT,
Student_Name VARCHAR(20),
Father_Name VARCHAR(20),
Mother_Name VARCHAR(20),
DOB DATE,
Class INT,
Phone_Number VARCHAR(12) UNIQUE
);

DELIMITER //
CREATE TRIGGER insert_fee_records
AFTER INSERT ON student
FOR EACH ROW
BEGIN
DECLARE tution_fee INT;
DECLARE i INT;
CASE NEW.Class
WHEN 1 THEN SET tution_fee := 17500;
WHEN 2 THEN SET tution_fee := 18000;
WHEN 3 THEN SET tution_fee := 18500;
WHEN 4 THEN SET tution_fee := 19000;
WHEN 5 THEN SET tution_fee := 19500;
WHEN 6 THEN SET tution_fee := 20000;
WHEN 7 THEN SET tution_fee := 20500;
WHEN 8 THEN SET tution_fee := 21000;
WHEN 9 THEN SET tution_fee := 22000;
WHEN 10 THEN SET tution_fee := 22500;
WHEN 11 THEN SET tution_fee := 23000;
WHEN 12 THEN SET tution_fee := 23500;
END CASE;
SET i := 1;
WHILE i <= 12 DO
        INSERT INTO fee (Id, Fee_Month, Tution_Fee, Pending)
        VALUES (
            NEW.ID,
            CASE i
                WHEN 1 THEN 'January'
                WHEN 2 THEN 'February'
                WHEN 3 THEN 'March'
                WHEN 4 THEN 'April'
                WHEN 5 THEN 'May'
                WHEN 6 THEN 'June'
                WHEN 7 THEN 'July'
                WHEN 8 THEN 'August'
                WHEN 9 THEN 'September'
                WHEN 10 THEN 'October'
                WHEN 11 THEN 'November'
                WHEN 12 THEN 'December'
            END,
            tution_fee,
            tution_fee
        );
        SET i := i + 1;
    END WHILE;
END; //

-- Drop the old trigger if it exists
DROP TRIGGER IF EXISTS update_pending_on_amount_paid;

-- Create the trigger to recalculate pending fee before updating any row in the fee table
CREATE TRIGGER update_pending_before_update
BEFORE UPDATE ON fee
FOR EACH ROW
BEGIN
    -- Recalculate the pending amount before the update occurs
    SET NEW.Pending = NEW.Tution_Fee - NEW.Amount_Paid;
END; //

-- Restore delimiter to default
DELIMITER ;
