
create user dream identified by dream;
grant connect ,resource to dream;
conn dream/dream;

/*DROP TABLE VIEWING ;
DROP TABLE PROPERTY_FOR_RENT;
DROP TABLE STAFF;
DROP TABLE BRANCH;
DROP TABLE RENTER;
DROP TABLE OWNER;*/

CREATE TABLE BRANCH (
BNO VARCHAR2(4) PRIMARY KEY,
STREET VARCHAR2(20),
AREA   VARCHAR2(10),
CITY   VARCHAR2(15),
PCODE  VARCHAR2(10),
TEL_NO VARCHAR2(15),
FAX_NO VARCHAR2(15));

CREATE TABLE STAFF (
SNO VARCHAR2(4) PRIMARY KEY,
FNAME VARCHAR2(10),
LNAME   VARCHAR2(10),
ADDRESS VARCHAR2(50),
TEL_NO VARCHAR2(15),
POSITION   VARCHAR2(10) NOT NULL,
SEX CHAR,
DOB DATE,
SALARY NUMBER(8,2),
NIN  VARCHAR2(10),
BNO VARCHAR2(4),
FOREIGN KEY (BNO) REFERENCES BRANCH );

CREATE TABLE OWNER (
ONO VARCHAR2(4) PRIMARY KEY,
FNAME VARCHAR2(10),
LNAME   VARCHAR2(10),
ADDRESS VARCHAR(50),
TEL_NO VARCHAR2(15));

CREATE TABLE RENTER (
RNO VARCHAR2(4) PRIMARY KEY,
FNAME VARCHAR2(10),
LNAME   VARCHAR2(10),
ADDRESS VARCHAR2(50),
TEL_NO VARCHAR2(15),
PREF_TYPE VARCHAR2(10),
MAX_RENT NUMBER(5),
BNO    VARCHAR2(4),
FOREIGN KEY (BNO) REFERENCES BRANCH);


CREATE TABLE PROPERTY_FOR_RENT (
PNO VARCHAR2(4) PRIMARY KEY,
STREET VARCHAR2(20),
AREA   VARCHAR2(10),
CITY   VARCHAR2(15),
PCODE  VARCHAR2(10),
TYPE   VARCHAR(10),
ROOMS  NUMBER(2),
RENT   NUMBER(5),
ONO    VARCHAR2(4),
SNO    VARCHAR2(4),
BNO    VARCHAR2(4),
FOREIGN KEY (BNO) REFERENCES BRANCH,
FOREIGN KEY (ONO) REFERENCES OWNER,
FOREIGN KEY (SNO) REFERENCES STAFF);

CREATE TABLE VIEWING (
RNO VARCHAR2(4),
PNO VARCHAR2(4),
VDATE DATE,
COMMENTS VARCHAR2(30),
PRIMARY KEY (RNO,PNO,VDATE),
FOREIGN KEY (PNO) REFERENCES PROPERTY_FOR_RENT,
FOREIGN KEY (RNO) REFERENCES RENTER);

-------------------------------------------------------
insert into branch
values ('B5','22 Deer Rd','Sidcup','London','SW1 4EH','0171-886-1212','0171-886-1214');

insert into branch
values ('B7','16 Argyll St','Dyce','Aberdeen','AB2 3SU','01224-67125','01224-67111');

insert into branch
values ('B3','163 Main St','Partick','Glasgow','G11 9QX','0141-339-2178','0117-776-1114');

insert into branch
values ('B4','32 Manse Rd','Leigh','Bristol','BS99 1NZ','0117-916-1170','0117-776-1114');

insert into branch
values ('B2','56 Clover Dr','','London','NW10 6EU','0181-963-1030','0181-453-7992');

=====================================++++++++++++============================================

insert into staff
values('SL21','John','White','19 Taylor St,Cranford,London','0171-884-5112',
'Manager','M',to_date('01-10-45','dd-mm-yy'),30000,'WK442011B','B5');

insert into staff
values('SG37','Ann','Beech','18 George St,Glasgow PA1 2JR','0141-848-3345',
'Snr Asst','F',to_date('10-11-60','dd-mm-yy'),12000,'WL432514c','B3');

insert into staff
values('SG14','David','Ford','63 Ashby St,Partrick,Glasgow G11','0141-339-2177',
'Deputy','M',to_date('24-03-58','dd-mm-yy'),18000,'WL220658D','B3');

insert into staff
values('SA9','Mary','Howe','2 Elm Pl,Aberdeen AB2 3SU','',
'Assistant','F',to_date('19-02-70','dd-mm-yy'),9000,'WM532187D','B7');

insert into staff
values('SG5','Susan','Brand','5 Gt Western Rd,Glasgow G12','0141-334-2001',
'Manager','F',to_date('3-02-40','dd-mm-yy'),24000,'WK588932E','B3');

insert into staff
values('SL41','Julie','Lee','28 Malvern St,Kilburn NW2','0181-554-3541',
'Assistant','F',to_date('13-02-65','dd-mm-yy'),9000,'WA290573K','B5');
----------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------

insert into Renter 
values('CR76','Jhon','Kay','56 High St,Putney,London SW1 4EH','0171-774-5632','Flat',425,'B5');

insert into Renter 
values('CR56','Aline','Stewart','64 Fern Dr,Pollock,Glasgow G42 oBL','0141-848-1825','Flat',350,'B3');

insert into Renter 
values('CR74','Mike','Ritchie','18 Tain St,Gourock PA1G 1YQ','01475-392178','House',750,'B3');

insert into Renter 
values('CR62','Mary','Tregear','5 Tarbot RD,Kildary,Aberdeen AB9 3ST','01224-196720','Flat',600,'B7');


----------------------------------------------------------------------------------------
insert into owner
values ('CO46','Joe','Keogh','2 Fergus Dr,Banchory,Aberdeen AB2 7Sx','01224-861212');

insert into owner
values ('CO87','Carol','Farrel','6 Achray St,Glasgow G32 9Dx','0141-357-7419');

insert into owner
values ('CO40','Tine','Murphy','63 Well St,Shawlands,Glasgow G42','0141-943-1728');

insert into owner
values ('CO93','Tony','Shaw','12 Park P1,Hillhead,Glasgow G4 0QR','0141-225-7025');

----------------------------------------------------------------------------------------
insert into property_for_rent 
values ('PA14','16 Holhead','Dee','Aberdeen','AB7 5SU','House',6,650,'CO46','SA9','B7');

insert into property_for_rent 
values ('PL94','6 Argyll St','Killburn','London','NW2','Flat',4,400,'CO87','SL41','B5');

insert into property_for_rent 
values ('PG4','6 Lawrence St','Partick','Glasgow','G11 9QX','Flat',3,350,'CO40','SG14','B3');

insert into property_for_rent 
values ('PG36','2 Manor Rd','','Glasgow','G32 4QX','Flat',3,375,'CO93','SG37','B3');

insert into property_for_rent 
values ('PG21','18 Dale Rd','Hyndland','Glasgow','G12','House',5,600,'CO87','SG37','B3');

insert into property_for_rent 
values ('PG16','5 Nover DR','Hyndland','Glasgow','G12 9AX','Flat',4,450,'CO93','SG14','B3');
--------------------------------------------------------------------------------------------
insert into viewing
values ('CR56','PA14',to_date('24-05-98','dd-mm-yy'),'too small');

insert into viewing
values ('CR76','PG4',to_date('20-04-98','dd-mm-yy'),'too remote');

insert into viewing
values ('CR56','PG4',to_date('26-05-98','dd-mm-yy'),'');

insert into viewing
values ('CR62','PA14',to_date('14-05-98','dd-mm-yy'),'no dining room');

insert into viewing
values ('CR56','PG36',to_date('28-04-98','dd-mm-yy'),'queen');




