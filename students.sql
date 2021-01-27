CREATE TABLE `students` (
  `id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `stream` varchar(45) NOT NULL,
  `mark` int NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `school`.`students`(`id`,`name`,`gender`,`stream`,`mark`)
VALUES(1,'A','F','commerce',120);
INSERT INTO `school`.`students`(`id`,`name`,`gender`,`stream`,`mark`)
VALUES(2,'B','M','science',119);
INSERT INTO `school`.`students`(`id`,`name`,`gender`,`stream`,`mark`)
VALUES(3,'C','F','commerce',117);
INSERT INTO `school`.`students`(`id`,`name`,`gender`,`stream`,`mark`)
VALUES(4,'D','M','science',118);

select name,SUM(English),SUM(maths),SUM(Social) from students_report group by name;

select name,SUM(English),SUM(maths),SUM(Social) from students_report group by name having name='B' ;

select AVG(mark) from students where stream='science';

setting password correct:
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'asna1997';

executed quries:

select *from students;
select *from mark_details;

SELECT students.name ,students.stream, mark_details.english, mark_details.maths, mark_details.social,mark_details.period
FROM students
INNER JOIN mark_details ON students.id=mark_details.id;
-- 1) English mark of A
SELECT students.name , mark_details.english
FROM students
INNER JOIN mark_details ON students.id=mark_details.id  where name='A';

-- 2) find maximum marks
select MAX(mark) as max_mark from students;
-- 3) who got max marks
select name, MAX(mark) as max_mark from students ;



-- 4)view of two tables
create view students_report as select students.id,students.name,
 students.stream,students.mark, mark_details.English, mark_details.Maths,
 mark_details.Social,mark_details.Term
FROM students
INNER JOIN mark_details ON students.id=mark_details.id;

select *from students_report;

-- 5) show all details of stream science in names ascending order 
select * from students_report where stream='science' order by name asc;

-- 6) show all details of stream science in names ascending order and having marks>=118
select * from students_report where stream='science' having mark>=118 order by name asc;


-- 7) find total of subject wise mark for each term
select id,English,Maths,Social,English+Maths+Social as Total_Marks
from mark_details;


ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'asna1997';

select name,SUM(English),SUM(maths),SUM(Social) from students_report group by name;

select name,SUM(English),SUM(maths),SUM(Social) from students_report group by name having name='B' ;

select AVG(mark) from students where stream='science';

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'asna1997';

insert into students values(5,'E','F','science',120);