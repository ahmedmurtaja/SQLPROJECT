-- -- /*Name					   Null?    Type
--  ----------------------------------------- -------- ----------------------------
--  CID					   NOT NULL NUMBER(38)
--  CNAME					   NOT NULL VARCHAR2(20)
--  HOURS					   NOT NULL NUMBER(38)

--  sql schema
--  */

-- --  



INSERT INTO courses (CID, CNAME, HOURS)
VALUES (seq_course.nextval, 'Chemistry', 4);

INSERT INTO courses (CID, CNAME, HOURS)
VALUES (seq_course.nextval, 'Physics', 4);

INSERT INTO courses (CID, CNAME, HOURS)
VALUES (seq_course.nextval, 'Calculus', 4);

INSERT INTO courses (CID, CNAME, HOURS)
VALUES (seq_course.nextval, 'Poetry', 2);

INSERT INTO courses (CID, CNAME, HOURS)
VALUES (seq_course.nextval, 'Composition', 3);

INSERT INTO courses (CID, CNAME, HOURS)
VALUES (seq_course.nextval, 'Literature', 4);

INSERT INTO courses (CID, CNAME, HOURS)
VALUES (seq_course.nextval, 'Microeconomics', 3)
;
INSERT INTO courses (CID, CNAME, HOURS)
VALUES (seq_course.nextval, 'Macroeconomics', 3);

INSERT INTO courses (CID, CNAME, HOURS)
VALUES (seq_course.nextval, 'Quantitative', 2);

INSERT INTO courses (CID, CNAME, HOURS)
VALUES (seq_course.nextval, 'Trigonometry', 4);