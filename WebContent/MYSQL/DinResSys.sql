drop database if exists DinResSys;

/*==============================================================*/
/* Database: DinResSys                                         */
/*==============================================================*/
create database DinResSys;

use DinResSys;

/*==============================================================*/
/* Table: appraise                                              */
/*==============================================================*/
DROP TABLE IF EXISTS appraise;
create table appraise
(
   id                   int not null auto_increment,
   userId               int not null,
   menuId               int not null,
   praiseTime           datetime not null,
   praiseLevel          int not null default 5,
   detail               varchar(256),
   primary key (id)
);

/*==============================================================*/
/* Table: menuType                                       */
/*==============================================================*/
DROP TABLE IF EXISTS menuType;
create table menuType
(
   id                   int not null auto_increment,
   typeID               int not null,
   menuID               int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: types                                           */
/*==============================================================*/
DROP TABLE IF EXISTS types;
create table types
(
   id                   int not null auto_increment,
   typeName             varchar(20) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: activity                                              */
/*==============================================================*/
DROP TABLE IF EXISTS activity;
create table activity
(
   id                   int not null auto_increment,
   activityName         varchar(64) not null,
   beginTime            datetime not null,
   endTime              datetime not null,
   descri           varchar(256),
   primary key (id)
);

/*==============================================================*/
/* Table: address                                               */
/*==============================================================*/
DROP TABLE IF EXISTS address;
create table address
(
   id                   int not null auto_increment,
   ad                   varchar(256) not null,
   userId               int not null,
   isDefault            int(1) not null default 0,
   primary key (id)
);

/*==============================================================*/
/* Table: authority                                             */
/*==============================================================*/
DROP TABLE IF EXISTS authority;
create table authority
(
   id                   int not null auto_increment,
   autho                varchar(20) not null,
   authoUrl             varchar(20),
   primary key (id)
);

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
DROP TABLE IF EXISTS menu;
create table menu
(
   id                   int not null auto_increment,
   activityId   		int,
   item                 varchar(20) not null,
   price                int not null,
   isHot                int(1) not null default 0,
   praiseNum            int not null default 0,
   status               int not null default 1,
   isInActivity         int not null default 0,
   discount				int not null default 100,
   picture              varchar(20),
   descri               varchar(256),
   primary key (id)
);

/*==============================================================*/
/* Table: orders                                               */
/*==============================================================*/
DROP TABLE IF EXISTS orders;
create table orders
(
   id                   int not null auto_increment,
   userId               int not null,
   adId                 int not null,
   price                int not null,
   createTime           datetime not null,
   status               varchar(20) not null,
   message              varchar(256),
   primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
DROP TABLE IF EXISTS user;
create table user
(
   id                   int not null auto_increment,
   name                 varchar(20) not null,
   password             varchar(256) not null,
   tel                  varchar(11) not null,
   authoLevel           int not null default 2,
   primary key (id)
);

/*==============================================================*/
/* Table: userAutho                                             */
/*==============================================================*/
DROP TABLE IF EXISTS userAutho;
create table userAutho
(
   id                   int not null auto_increment,
   userId               int not null,
   authoId              int not null,
   primary key (id)
);

alter table appraise add constraint FK_Menu_Appraise_Reference foreign key (menuId)
      references menu (id) on delete restrict on update restrict;

alter table appraise add constraint FK_User_Appraise_Reference foreign key (userId)
      references user (id) on delete restrict on update restrict;

alter table menuType add constraint FK_Menu_MenuType_Refenrence foreign key (menuID)
      references menu (id) on delete restrict on update restrict;

alter table menuType add constraint FK_Type_MenuType_Reference foreign key (typeID)
      references types (id) on delete restrict on update restrict;

alter table address add constraint FK_User_Address_Reference foreign key (userId)
      references user (id) on delete restrict on update restrict;

alter table menu add constraint FK_Menu_Activity_Reference foreign key (activityId)
      references activity (id) on delete restrict on update restrict;

alter table orders add constraint FK_Order_Address_Reference foreign key (adId)
      references address (id) on delete restrict on update restrict;

alter table orders add constraint FK_User_Order_Reference foreign key (userId)
      references user (id) on delete restrict on update restrict;

alter table userAutho add constraint FK_Autho_UserAutho_Reference foreign key (authoId)
      references authority (id) on delete restrict on update restrict;

alter table userAutho add constraint FK_User_UserAutho_Reference foreign key (userId)
      references user (id) on delete restrict on update restrict;
