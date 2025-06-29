CREATE OR REPLACE PROCEDURE TransferFunds (
  from_account_id IN NUMBER,
  to_account_id IN NUMBER,
  transfer_amount IN NUMBER
) IS
  current_balance NUMBER;
  insufficient_balance EXCEPTION;
BEGIN
  SELECT Balance INTO current_balance
  FROM Accounts
  WHERE AccountID = from_account_id
  FOR UPDATE;

  IF current_balance < transfer_amount THEN
    RAISE insufficient_balance;
  END IF;
  UPDATE Accounts
  SET Balance = Balance - transfer_amount,
      LastModified = SYSDATE
  WHERE AccountID = from_account_id;

  UPDATE Accounts
  SET Balance = Balance + transfer_amount,
      LastModified = SYSDATE
  WHERE AccountID = to_account_id;

  DBMS_OUTPUT.PUT_LINE('Transferred ' || transfer_amount || 
                       ' from Account ' || from_account_id || 
                       ' to Account ' || to_account_id);

EXCEPTION
WHEN insufficient_balance THEN
    DBMS_OUTPUT.PUT_LINE('Error: Insufficient balance in Account ' || from_account_id);
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;

BEGIN
  TransferFunds(2, 1, 200);
END;

SELECT AccountID, Balance FROM Accounts WHERE AccountID IN (1, 2);
