create table crudfive.file (id bigserial not null, name varchar(255), primary key (id));
create table crudfive.user (id bigserial not null, name varchar(255), primary key (id));
create table crudfive.event (id bigserial not null, status varchar(255), createtime TIMESTAMP, updatetime TIMESTAMP, user_id INTEGER, file_id INTEGER, primary key (id));