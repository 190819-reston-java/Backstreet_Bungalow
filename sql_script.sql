CREATE DATABASE BBungalow;

CREATE TABLE Users(

	id VARCHAR(20) PRIMARY KEY,
	-- The ID has 20 characters to distinguish
	-- from the other tables that will be
	-- referred to in the Activity table.
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	username VARCHAR(15) UNIQUE NOT NULL,
	role VARCHAR(15) NOT NULL,
	email VARCHAR(30) UNIQUE NOT NULL,
	pswd VARCHAR(50) NOT NULL,
	show_info BOOLEAN

);

CREATE TABLE Posts(

	id VARCHAR(15) PRIMARY KEY,
	users_id VARCHAR(30) NOT NULL,
	title VARCHAR(50) NOT NULL,
	content VARCHAR NOT NULL

);

CREATE TABLE Activity(

	id VARCHAR(15) PRIMARY KEY,
	users_id VARCHAR(10) NOT NULL,
	status VARCHAR(15) NOT NULL,
	likes INTEGER NOT NULL,
	num_of_comments INTEGER NOT NULL,
	views INTEGER NOT NULL,

	FOREIGN KEY users_id REFERENCES Users(id),

);

CREATE TABLE Comments(

	id VARCHAR(15) PRIMARY KEY, 
	users_id VARCHAR(10) NOT NULL,
	post_id VARCHAR(10) NOT NULL,
	content VARCHAR NOT NULL,

	FOREIGN KEY users_id REFERENCES Users(id),
	FOREIGN KEY post_id REFERENCES Posts(id)

);

-- This function exists for the Messages table
-- to check if the end_user_id is not the same
-- as the sender.
CREATE OR REPLACE FUNCTION same_user
	(username_match VARCHAR) RETURNS BOOLEAN 
AS
$$
        SELECT username FROM Users 
        WHERE username = username_match;
$$ LANGUAGE SQL;


CREATE TABLE Messages(

	id VARCHAR(20) PRIMARY KEY, 
	-- Message ID also has 20 character limit
	-- for the same reason the User ID has it.
	users_id VARCHAR(15) NOT NULL,
	content VARCHAR NOT NULL,
	end_users_id VARCHAR(15) NOT NULL 
		CHECK(same_user(user_id) = false),
	draft BOOLEAN NOT NULL,

	FOREIGN KEY users_id REFERENCES Users(id),
	FOREIGN KEY end_users_id REFERENCES Users(id)

);

CREATE TABLE Photos(

	id VARCHAR(15) PRIMARY KEY, 
	users_id VARCHAR(10) NOT NULL,
	content_desc VARCHAR NOT NULL,
	content_hash VARCHAR NOT NULL,

	FOREIGN KEY users_id REFERENCES Users(id)

);