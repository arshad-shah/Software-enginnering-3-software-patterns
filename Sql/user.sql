CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `USERNAME` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  PRIMARY KEY  (`ID`)
  );

insert into user values(1,'admin','admin','admin');
insert into user values(2,'user1','user1','user1');
insert into user values(3,'user2','user2','user2');
insert into user values(4,'user3','user3','user3');
insert into user values(5,'user4','user4','user4');