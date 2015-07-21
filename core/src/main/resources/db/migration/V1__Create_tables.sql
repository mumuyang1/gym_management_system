CREATE TABLE employees(
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR (50) NOT NULL,
  gender VARCHAR (20) NOT NULL ,
  position varchar(50) NOT NULL,
  email VARCHAR (100) NOT NULL);

CREATE TABLE users(
  id INT AUTO_INCREMENT PRIMARY KEY,
  userName VARCHAR (50) NOT NULL ,
  password VARCHAR (100) NOT NULL,
  employee_id INT NOT NULL ,
  FOREIGN KEY(employee_id) REFERENCES employees(id));

CREATE TABLE courses(
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR (50) NOT NULL ,
  coach_id INT NOT NULL,
  FOREIGN KEY(coach_id) REFERENCES employees(id) ON DELETE CASCADE );

CREATE TABLE customers(
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(20) NOT NULL ,
  coach_id INT);

CREATE TABLE schedules(
  id INT AUTO_INCREMENT PRIMARY KEY,
  date DATE NOT NULL ,
  course_id INT NOT NULL ,
  customer_id INT ,
  FOREIGN KEY (course_id) REFERENCES courses(id),
  FOREIGN KEY (customer_id) REFERENCES customers(id));

CREATE TABLE customers_courses(
  id INT AUTO_INCREMENT PRIMARY KEY,
  customer_id INT NOT NULL ,
  FOREIGN KEY (customer_id) REFERENCES customers(id),
  course_id INT NOT NULL,
  FOREIGN KEY (course_id) REFERENCES courses(id));


