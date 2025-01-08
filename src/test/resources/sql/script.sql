# show tables
#show tables;

# select from table
select * from users;

# describe table
desc users;

# employees
CREATE TABLE employees (
    EmployeeID INT PRIMARY KEY AUTO_INCREMENT,
    EmployeeName VARCHAR(100) NOT NULL,
    Department VARCHAR(50),
    Salary DECIMAL(10, 2),
    HireDate DATE
);


INSERT INTO employees (EmployeeName, Department, Salary, HireDate)
VALUES 
    ('Alice Johnson', 'Engineering', 75000.00, '2020-05-15'),
    ('Bob Smith', 'Engineering', 80000.00, '2019-11-20'),
    ('Charlie Brown', 'HR', 60000.00, '2021-01-10'),
    ('Diana Ross', 'Marketing', 70000.00, '2018-07-25'),
    ('Eve Adams', 'Finance', 65000.00, '2020-10-05'),
    ('Frank White', 'Engineering', 85000.00, '2017-03-14'),
    ('Grace Lee', 'Finance', 67000.00, '2019-08-30'),
    ('Henry Ford', 'Marketing', 73000.00, '2021-06-12'),
    ('Isabel Clark', 'HR', 62000.00, '2022-02-18'),
    ('Jack Ryan', 'Engineering', 90000.00, '2016-12-01');
   
select * from employees;
   
select * from employees e1#e1.EmployeeId, e1.EmployeeName, e1.Department, e1.Salary
left join employees e2
on e1.Department = e2.Department and e1.Salary < e2.Salary
where e2.Salary is null;

# distinct
select DISTINCT Department from employees




SELECT Salary from employees e 
order by Salary desc
limit 10 offset 0;






