BEGIN
  FOR cust IN (
    SELECT CustomerID, Name, Balance FROM Customers
    WHERE Balance > 10000
  ) LOOP
    UPDATE Customers
    SET IsVIP = 'TRUE'
    WHERE CustomerID = cust.CustomerID;

    DBMS_OUTPUT.PUT_LINE('VIP status granted to: ' || cust.Name);
  END LOOP;
END;
/

-- Check VIP status
SELECT CustomerID, Name, Balance, IsVIP FROM Customers;
