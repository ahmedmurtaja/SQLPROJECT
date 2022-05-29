CREATE TABLE Students (
    sid int NOT NULL PRIMARY KEY,
    LastName varchar(20) NOT NULL,
    FirstName varchar(20) NOT NULL,
    Address varchar(20),
    sex varchar(20)
);

INSERT INTO STUDENTS (SID, LASTNAME, FIRSTNAME,ADDRESS, SEX)
VALUES (1, 'Abercrombie', 'Kim', 'gaza','male');
