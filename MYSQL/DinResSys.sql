drop database if exists DinResSys;

/*==============================================================*/
/* Database: DinResSys                                         */
/*==============================================================*/
create database DinResSys;

use DinResSys;

/*==============================================================*/
/* Table: Appraise                                              */
/*==============================================================*/
create table Appraise
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
/* Table: Menu_Type_Table                                       */
/*==============================================================*/
create table Menu_Type_Table
(
   id                   int not null auto_increment,
   typeID               int not null,
   menuID               int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: Type_Table                                            */
/*==============================================================*/
create table Type_Table
(
   id                   int not null auto_increment,
   typeName             varchar(20) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: activity                                              */
/*==============================================================*/
create table activity
(
   id                   int not null auto_increment,
   activity             varchar(64) not null,
   beginTime            datetime not null,
   endTime              datetime not null,
   descri           varchar(256),
   primary key (id)
);

/*==============================================================*/
/* Table: address                                               */
/*==============================================================*/
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
create table menu
(
   id                   int not null auto_increment,
   item                 varchar(20) not null,
   price                int not null,
   isHot                int(1) not null default 0,
   praiseNum            int not null default 0,
   status               int not null default 1,
   isInActivity         int not null default 0,
   picture              varchar(20),
   descri               varchar(256),
   primary key (id)
);

/*==============================================================*/
/* Table: order                                               */
/*==============================================================*/
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
/* Table: promotion                                             */
/*==============================================================*/
create table promotion
(
   id                   int not null auto_increment,
   menuId               int not null,
   activityId           int not null,
   discount             int not null default 100,
   lessen               int not null default 0,
   primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
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
create table userAutho
(
   userId               int not null,
   authoId              int not null,
   primary key (userId, authoId)
);

alter table Appraise add constraint FK_Menu_Appraise_Reference foreign key (menuId)
      references menu (id) on delete restrict on update restrict;

alter table Appraise add constraint FK_User_Appraise_Reference foreign key (userId)
      references user (id) on delete restrict on update restrict;

alter table Menu_Type_Table add constraint FK_Menu_MenuType_Refenrence foreign key (menuID)
      references menu (id) on delete restrict on update restrict;

alter table Menu_Type_Table add constraint FK_Type_MenuType_Reference foreign key (typeID)
      references Type_Table (id) on delete restrict on update restrict;

alter table address add constraint FK_User_Address_Reference foreign key (userId)
      references user (id) on delete restrict on update restrict;

alter table menu add constraint FK_Order_Menu_Reference foreign key (id)
      references orders (id) on delete restrict on update restrict;

alter table orders add constraint FK_Order_Address_Reference foreign key (adId)
      references address (id) on delete restrict on update restrict;

alter table orders add constraint FK_User_Order_Reference foreign key (userId)
      references user (id) on delete restrict on update restrict;

alter table promotion add constraint FK_Activity_Promotion_Reference foreign key (activityId)
      references activity (id) on delete restrict on update restrict;

alter table promotion add constraint FK_Menu_Promotion_Reference foreign key (menuId)
      references menu (id) on delete restrict on update restrict;

alter table userAutho add constraint FK_Autho_UserAutho_Reference foreign key (authoId)
      references authority (id) on delete restrict on update restrict;

alter table userAutho add constraint FK_User_UserAutho_Reference foreign key (userId)
      references user (id) on delete restrict on update restrict;
