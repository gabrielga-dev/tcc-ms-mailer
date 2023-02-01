create table email_template
(
    id          bigint primary key not null AUTO_INCREMENT,
    name        varchar(75)        not null,
    description varchar(500)       not null,
    version     varchar(20)        not null,
    content     text               not null
);