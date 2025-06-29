BEGIN
  FOR cust IN (
    SELECT c.CustomerID, c.Name, FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) AS age
    FROM Customers c
    WHERE FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) > 60
  ) LOOP
    UPDATE Loans
    SET InterestRate = InterestRate - 1
    WHERE CustomerID = cust.CustomerID;

    DBMS_OUTPUT.PUT_LINE('1% discount applied for customer: ' || cust.Name);
  END LOOP;
END;
/
  
SELECT CustomerID, InterestRate FROM Loans;
