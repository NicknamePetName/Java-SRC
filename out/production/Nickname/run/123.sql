-- Active: 1683973826757@@127.0.0.1@3306@nickname_zt

CREATE TABLE Student(
  stu_id VARCHAR(10) NOT NULL,
  stu_name VARCHAR(30) NOT NULL,
	stu_age INT(10),
  PRIMARY KEY (stu_id)
);

INSERT INTO Student  
VALUES
('202001','小明',20),
('202002','小红',21),
('202003','小花',21);

