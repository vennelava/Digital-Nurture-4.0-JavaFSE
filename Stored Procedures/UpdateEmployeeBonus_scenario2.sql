CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  dept_name IN VARCHAR2,
  bonus_percent IN NUMBER
) IS
BEGIN
  FOR emp IN (
    SELECT EmployeeID, Salary
    FROM Employees
    WHERE Department = dept_name
  ) LOOP
    UPDATE Employees
    SET Salary = Salary + (Salary * bonus_percent / 100)
    WHERE EmployeeID = emp.EmployeeID;

    DBMS_OUTPUT.PUT_LINE('Bonus applied to Employee ID: ' || emp.EmployeeID);
  END LOOP;
END;

BEGIN
  UpdateEmployeeBonus('IT', 10);
END;

SELECT EmployeeID, Name, Department, Salary FROM Employees;
