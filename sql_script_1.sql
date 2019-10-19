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
--INSERT INTO Users (first_name, last_name, username, "role", email, pswd, show_info) VALUES ('Zach', 'Marshello', 'marsh3825', 'admin', 'marsh3825@gmail.com', 'password', TRUE);

DROP TABLE posts;
CREATE TABLE Posts (

	id serial PRIMARY KEY,
	users_id INT UNIQUE NOT null,
	title VARCHAR(50) NOT NULL,
	content VARCHAR NOT NULL,

);

DROP TABLE photos;
CREATE TABLE Photos (

	id serial PRIMARY KEY,
	users_id INT REFERENCES users(id) NOT NULL,
	img bytea NOT NULL
	-- num_of_comments is moved here for the same reason
	-- that's it's moved into the Posts table.

);