/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/4/8 18:15:58                            */
/*==============================================================*/


drop table if exists department;

drop table if exists employee;

drop table if exists gender;

drop table if exists type;

drop table if exists user;

/*==============================================================*/
/* Table: department                                            */
/*==============================================================*/
create table department
(
   depid                smallint(2) not null,
   dep                  char(4) not null,
   primary key (depid)
);

/*==============================================================*/
/* Table: employee                                              */
/*==============================================================*/
create table employee
(
   empid                int(4) not null,
   depid                smallint(2) not null,
   employee             varchar(4),
   primary key (empid)
);

/*==============================================================*/
/* Table: gender                                                */
/*==============================================================*/
create table gender
(
   genderid             tinyint(1) not null,
   gender               char(1) not null,
   primary key (genderid)
);

/*==============================================================*/
/* Table: type                                                  */
/*==============================================================*/
create table type
(
   typeid               tinyint(1) not null,
   type                 char(4) not null,
   primary key (typeid)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   userid               int(8) not null,
   genderid             tinyint(1),
   empid                int(4),
   typeid               tinyint(1),
   username             varchar(20) not null,
   password             varchar(200) not null,
   money                char(10),
   phone                char(10),
   primary key (userid)
);

alter table employee add constraint FK_Reference_3 foreign key (depid)
      references department (depid) on delete restrict on update restrict;

alter table user add constraint FK_Reference_2 foreign key (empid)
      references employee (empid) on delete restrict on update restrict;

alter table user add constraint FK_Reference_4 foreign key (typeid)
      references type (typeid) on delete restrict on update restrict;

alter table user add constraint FK_gender foreign key (genderid)
      references gender (genderid) on delete restrict on update restrict;

