CREATE TABLE category (
	id 		NUMBER(19) NOT NULL AUTO_INCREMENT,
	name 	VARCHAR(255),
	PRIMARY KEY (id),
	UNIQUE (id)
);


CREATE TABLE product (
	id 		NUMBER(19) NOT NULL AUTO_INCREMENT,
	name 	VARCHAR(255),
	category_id NUMBER(19), 
	PRIMARY KEY (id),
	UNIQUE (id),
	CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES category(id)
);