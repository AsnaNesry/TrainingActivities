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