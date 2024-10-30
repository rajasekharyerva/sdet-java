Common Aggregate Functions:
COUNT():

Returns the number of rows (or non-NULL values) in a column.
Example: SELECT COUNT(*) FROM Employees;
SUM():

Returns the sum of numeric values in a column.
Example: SELECT SUM(Salary) FROM Employees;
AVG():

Returns the average of numeric values in a column.
Example: SELECT AVG(Salary) FROM Employees;
MAX():

Returns the maximum value from a set of values.
Example: SELECT MAX(Salary) FROM Employees;
MIN():

Returns the minimum value from a set of values.
Example: SELECT MIN(Salary) FROM Employees;
COUNT(DISTINCT):

Returns the count of distinct (unique) values in a column.
Example: SELECT COUNT(DISTINCT Department) FROM Employees;