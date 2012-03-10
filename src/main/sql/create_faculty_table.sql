USE regis;

CREATE TABLE faculty (
	id			INT(10)	UNSIGNED NOT NULL AUTO_INCREMENT,
	first_name	VARCHAR(50) 	NOT	NULL,
	last_name	VARCHAR(50)		NOT	NULL,
	address		VARCHAR(100),
	city		VARCHAR(50),
	state		VARCHAR(2),
	zip			INT(5),
	cell		VARCHAR(12),
	office		VARCHAR(12),
	home		VARCHAR(12),
	fax			VARCHAR(12),
	PRIMARY KEY (`ID`) USING BTREE
);
	
	