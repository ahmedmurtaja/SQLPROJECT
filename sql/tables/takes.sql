CREATE TABLE TAKES(
	cid int NOT NULL,
	sid int NOT NULL,
	foreign key (cid) references courses(cid) ON DELETE CASCADE,	
	foreign key (sid) references students(sid) ON DELETE CASCADE,
	takesid int primary key);
