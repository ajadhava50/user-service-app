create table usr_user (user_id bigint generated by default as identity, name varchar(255), address varchar(255), created date, updated date, primary key (user_id));