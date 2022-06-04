
create database atto;

create table t_host
(
    id            bigint auto_increment
        primary key,
    createdDate   datetime(6)  null,
    ip            varchar(255) not null unique ,
    lastAliveDate datetime(6)  null,
    modifiedDate  datetime(6)  null,
    host          varchar(255) not null unique

);

