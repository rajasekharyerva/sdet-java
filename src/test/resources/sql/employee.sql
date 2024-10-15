docker-compose up -d
docker exec -it mysql-container mysql -u root -p
mysql -h 127.0.0.1 -P 3306 -u user -p
CREATE DATABASE <my_database>;
SHOW DATABASES;
exit;
GRANT ALL PRIVILEGES ON *.* TO 'user'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
show privileges;
use <my_database>
select * from employee;
docker-compose down

CREATE TABLE employee (
    emp_no INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    doj DATE NOT NULL,
    city VARCHAR(100) NOT NULL,
    dep_id VARCHAR(100) NOT NULL
);

INSERT INTO employee (first_name, last_name, doj, city) VALUES
('John', 'Doe', '2022-01-15', 'New York', '1'),
('Jane', 'Smith', '2023-03-22', 'Los Angeles', '2'),
('Mike', 'Johnson', '2021-07-30', 'Chicago', '2'),
('Emily', 'Davis', '2022-11-10', 'Houston', '3'),
('David', 'Wilson', '2023-05-05', 'Phoenix', '4');

-- Create the table
CREATE TABLE employeeV2 (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(100),
    city VARCHAR(100)
);

-- Insert sample data
INSERT INTO employeeV2 (emp_id, emp_name, city) VALUES (1, 'John Doe', 'New York');
INSERT INTO employeeV2 (emp_id, emp_name, city) VALUES (2, 'Jane Smith', 'Los Angeles');
INSERT INTO employeeV2 (emp_id, emp_name, city) VALUES (3, 'Mike Johnson', 'Chicago');
INSERT INTO employeeV2 (emp_id, emp_name, city) VALUES (4, 'Emily Davis', 'Houston');
INSERT INTO employeeV2 (emp_id, emp_name, city) VALUES (5, 'David Wilson', 'Phoenix');
INSERT INTO employeeV2 (emp_id, emp_name, city) VALUES (6, 'David Davis', 'Chicago');

-- Create the department table
CREATE TABLE department (
    dep_id INT PRIMARY KEY,
    emp_id INT,
    dep_name VARCHAR(100)
);

ALTER TABLE department
DROP COLUMN emp_id;

CREATE TABLE department_employee (
    dep_id INT,
    emp_id INT,
    PRIMARY KEY (dep_id, emp_id),
    FOREIGN KEY (dep_id) REFERENCES department(dep_id),
    FOREIGN KEY (emp_id) REFERENCES employeeV2(emp_id)
);

ALTER TABLE department_employee
Add COLUMN dep_name VARCHAR(100);


-- Insert sample data
INSERT INTO department_employee (dep_id, emp_id, dep_name) VALUES (1, 1, 'Human Resources');
INSERT INTO department_employee (dep_id, emp_id, dep_name) VALUES (2, 2, 'Finance');
INSERT INTO department_employee (dep_id, emp_id, dep_name) VALUES (1, 3, 'Human Resources');
INSERT INTO department_employee (dep_id, emp_id, dep_name) VALUES (2, 4, 'Finance');
INSERT INTO department_employee (dep_id, emp_id, dep_name) VALUES (3, 5, 'Sales');
INSERT INTO department_employee (dep_id, emp_id, dep_name) VALUES (2, 6, 'Finance');


select dep_id, count(*)
from department_employee
group by dep_id;

select emp_name from employeeV2
inner join department_employee
on employeeV2.emp_id=department_employee.emp_id
where department_employee.dep_name='Human Resources';




