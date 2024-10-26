# Docker commands
| Command Name                       | Command                                            |
|------------------------------------|----------------------------------------------------|
| Start Services                     | `docker-compose up`                                |
| Run Services in Detached Mode      | `docker-compose up -d`                             |
| Stop Services                      | `docker compose down`                              |
| Access MySQL in a Docker Container | `docker exec -it mysql-container mysql -u root -p` |
| Access MySQL from Host             | `mysql -h 127.0.0.1 -P 3306 -u user -p`            |
## SQL Queries
| Command Name     | Command                                                              |
|------------------|----------------------------------------------------------------------|
| Show Databases   | `SHOW DATABASES;`                                                    |
| Create database  | `CREATE DATABASE <my_database>;`                                     |
| Select Database  | `USE database_name;`                                                 |
| Show Tables      | `SHOW TABLES;`                                                       |
| Describe Table   | `DESCRIBE table_name;`                                               |
| Insert Data      | `INSERT INTO table_name (column1, column2) VALUES (value1, value2);` |
| Select Data      | `SELECT * FROM table_name;`                                          |
| Exit             | `exit;`                                                              |
| Grant Privileges | `GRANT ALL PRIVILEGES ON *.* TO 'user'@'%' WITH GRANT OPTION;`       |
| Flush Privileges | `FLUSH PRIVILEGES;`                                                  |
| Show Privileges  | `show privileges;`                                                   |
### Create table
    CREATE TABLE employee (
    emp_no INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    doj DATE NOT NULL,
    city VARCHAR(100) NOT NULL,
    dep_id VARCHAR(100) NOT NULL
    );

    CREATE TABLE employee_v2 (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(100),
    city VARCHAR(100)
    );

    CREATE TABLE department (
    dep_id INT AUTO_INCREMENT PRIMARY KEY,
    dep_name VARCHAR(100)
    );

    CREATE TABLE department_employee (
    dep_id INT,
    emp_id INT,
    dep_name VARCHAR(100)
    );

    CREATE TABLE department_employee_v2 (
    dep_id INT,
    emp_id INT,
    PRIMARY KEY (dep_id, emp_id),
    FOREIGN KEY (dep_id) REFERENCES department(dep_id),
    FOREIGN KEY (emp_id) REFERENCES employee_v2(emp_id)
    );

### Insert
    INSERT INTO employee (first_name, last_name, doj, city, dep_id) VALUES
    ('John', 'Doe', '2022-01-15', 'New York', '1'),
    ('Jane', 'Smith', '2023-03-22', 'Los Angeles', '2'),
    ('Mike', 'Johnson', '2021-07-30', 'Chicago', '2'),
    ('Emily', 'Davis', '2022-11-10', 'Houston', '3'),
    ('David', 'Wilson', '2023-05-05', 'Phoenix', '4');

    INSERT INTO employee_v2 (emp_id, emp_name, city) VALUES 
    (1, 'John Doe', 'New York'),
    (emp_id, emp_name, city) VALUES (2, 'Jane Smith', 'Los Angeles'),
    (emp_id, emp_name, city) VALUES (3, 'Mike Johnson', 'Chicago'),
    (emp_id, emp_name, city) VALUES (4, 'Emily Davis', 'Houston'),
    (emp_id, emp_name, city) VALUES (5, 'David Wilson', 'Phoenix'),
    (emp_id, emp_name, city) VALUES (6, 'David Davis', 'Chicago');

    INSERT INTO department (dep_name) VALUES
    ('Finance'),
    ('Sales'),
    ('Human Resources');

    INSERT INTO department_employee (dep_id, emp_id, dep_name) VALUES 
    (1, 1, 'Human Resources'),
    (2, 2, 'Finance'),
    (1, 3, 'Human Resources'),
    (2, 4, 'Finance'),
    (3, 5, 'Sales'),
    (2, 6, 'Finance');

### Describe table
    desc <table_name>

### Alter table & Add column & Drop column
    ALTER TABLE department_employee_v2
    Add COLUMN dep_name VARCHAR(100);

    ALTER TABLE department_employee_v2
    DROP COLUMN dep_name;

### Group by
    select dep_id, count(*)
    from department_employee
    group by dep_id;

### Inner join on column & where condition
    select first_name 
    from employee
    inner join department_employee
    on employee.emp_no=department_employee.emp_id
    where department_employee.dep_name='Human Resources';

### Inner join on columns
    select t1.*
    from tabel1 t1
    inner join table2 t2
    on t1.column1 = t2.column1
    and t1.column2 = t2.column2
    and t1.column3 = t2.column3