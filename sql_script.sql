CREATE DATABASE backstreet;
CREATE TABLE Users (

	id SERIAL PRIMARY KEY,
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	username VARCHAR(15) UNIQUE NOT NULL,
	role VARCHAR(15) NOT NULL,
	email VARCHAR(30) UNIQUE NOT NULL,
	pswd VARCHAR(50) NOT NULL,
	show_info BOOLEAN

);

CREATE TABLE Activity (

	id SERIAL PRIMARY KEY,
	users_id INT REFERENCES users(id) NOT NULL,
	status VARCHAR(15) NOT NULL,
	likes INTEGER NOT NULL,
	views INTEGER NOT NULL
);

DROP TABLE posts;
CREATE TABLE Posts (

	post_id INT REFERENCES Activity(id),
	users_id INT REFERENCES users(id) NOT NULL,
	title VARCHAR(50) NOT NULL,
	content VARCHAR NOT NULL,
	num_of_comments INTEGER NOT null
	-- num_of_comments is moved here because
	-- of a potential issue when counting the
	-- number of comments on the post, when 
	-- comments aren't technically posts.
);

drop table comments;

CREATE TABLE Comments (

	comment_id INT REFERENCES Activity(id), 
	users_id INT REFERENCES users(id) NOT NULL,
	content VARCHAR NOT NULL

);

-- This function exists for the Messages table
-- to check if the end_user_id is not the same
-- as the sender.

-- We use JavaScript here to easily insert a conditional
-- statement. In order for it to work, auto formatting convert
-- case must be turned off and PLV8 must be marked as the
-- language and run as an extension before creating the function.
-- to turn off auto-format for capitalization:
-- file>properties>SQLCompletion>GlobalSettings uncheck convert keyword case
-- THIS TECHNIQUE IS NOT REVATURE SANCTIONED

CREATE EXTENSION PLV8;

CREATE OR REPLACE FUNCTION same_user
	(username_match int, end_users_id int) RETURNS BOOLEAN 
AS
$$

let results = true;
if (username_match === end_users_id) {
	results = false;
}
return results;
$$ LANGUAGE PLV8;

drop table messages;

CREATE TABLE Messages (

	id SERIAL PRIMARY KEY, 
	title VARCHAR(100) NOT NULL,
	content VARCHAR(500) NOT NULL

);

DROP TABLE Messages_map;
CREATE TABLE Messages_map (
	
	message_id INT REFERENCES Messages(id),
	author_id INT REFERENCES users(id),
	reciever_id INT CHECK(same_user(reciever_id,author_id) = false),
	is_sent BOOLEAN NOT NULL,
	is_in_trash BOOLEAN NOT NULL

);

DROP TABLE photos;
CREATE TABLE Photos (

	photo_id INT PRIMARY KEY REFERENCES Activity(id), 
	users_id INT REFERENCES users(id) NOT NULL,
	status boolean NOT NULL,
	img bytea NOT NULL
	-- num_of_comments is moved here for the same reason
	-- that's it's moved into the Posts table.

);