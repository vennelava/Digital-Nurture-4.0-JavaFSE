BEGIN
  FOR loan_rec IN (
    SELECT l.LoanID, l.CustomerID, l.EndDate, c.Name
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE l.EndDate <= SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: ' || loan_rec.Name ||
                         ' has a loan (ID: ' || loan_rec.LoanID ||
                         ') due on ' || TO_CHAR(loan_rec.EndDate, 'DD-MON-YYYY'));
  END LOOP;
END;
/
  
SELECT l.LoanID, c.Name AS CustomerName, l.LoanAmount, l.InterestRate, 
       TO_CHAR(l.EndDate, 'DD-MON-YYYY') AS DueDate
FROM Loans l
JOIN Customers c ON l.CustomerID = c.CustomerID
WHERE l.EndDate <= SYSDATE + 30;
