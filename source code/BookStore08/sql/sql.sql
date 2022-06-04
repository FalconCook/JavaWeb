CREATE DATABASE bookstore_0816;

CREATE TABLE bs_user(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(100) NOT NULL UNIQUE,
	PASSWORD VARCHAR(100),
	email VARCHAR(100)
);

CREATE TABLE bs_order(
	order_id CHAR(50) PRIMARY KEY,
	create_date DATETIME,
	total_money DOUBLE(11,2),
	STATUS INT(2),
	user_id INT(11),
	FOREIGN KEY (user_id) REFERENCES bs_user(id)
)

CREATE TABLE bs_order_item(
	id INT(11) PRIMARY KEY auto_increment,
	title VARCHAR(200),
	count INT(11),
	price DOUBLE(11,2),
	total_price DOUBLE(11,2),
	order_id CHAR(50),
	FOREIGN KEY (order_id) REFERENCES bs_order(order_id)
)