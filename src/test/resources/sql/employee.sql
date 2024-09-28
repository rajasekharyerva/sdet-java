docker-compose up -d
docker exec -it mysql-container mysql -u root -p
mysql -h 127.0.0.1 -P 3306 -u user -p
CREATE DATABASE <my_database>;
SHOW DATABASES;
exit;
use <my_database>
select * from employee;
docker-compose down

CREATE TABLE employee (
    emp_no INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    doj DATE NOT NULL,
    city VARCHAR(100) NOT NULL
);

INSERT INTO employee (first_name, last_name, doj, city) VALUES
('John', 'Doe', '2022-01-15', 'New York'),
('Jane', 'Smith', '2023-03-22', 'Los Angeles'),
('Mike', 'Johnson', '2021-07-30', 'Chicago'),
('Emily', 'Davis', '2022-11-10', 'Houston'),
('David', 'Wilson', '2023-05-05', 'Phoenix');
