drop table if exists account cascade;

create table account (
	id serial primary key not null
	, user_name text not null
	, mailaddress text unique not null
	, password text not null
	, location text not null
	, registered_date date not null
	, modified_date date not null
	, super_flag boolean not null
	, resign_flag boolean not null
);

drop table if exists company cascade;

create table company (
	id serial primary key not null
	, company_name text not null
	, location text not null
	, image_path text not null
	, intro text not null
	, registered_date date not null
	, modified_date date not null
	, delete_flag boolean not null
);

drop table if exists company_user cascade;

create table company_user (
	id serial primary key not null
	, company_id int REFERENCES company(id)
	, user_name text not null
	, mailaddress text unique not null
	, password text not null
	, registered_date date not null
	, modified_date date not null
	, resign_flag boolean not null
);

drop table if exists offer_gacha cascade;

create table offer_gacha (
	id serial primary key not null
	, company_id int REFERENCES company(id)
	, registered_by int REFERENCES company_user(id)
	, name text not null
	, image_path text unique
	, content text not null
	, rate float not null
	, period date
	, registered_date date not null
	, modified_date date not null
	, delete_flag boolean not null
);

drop table if exists possesion_gacha cascade;

create table possesion_gacha (
	id serial primary key not null
	, user_id int REFERENCES account(id)
	, gacha_id int REFERENCES offer_gacha(id)
	, registered_date date not null
	, modified_date date not null
	, use_flag boolean not null
);