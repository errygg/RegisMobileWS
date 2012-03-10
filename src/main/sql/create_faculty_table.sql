USE regis;

CREATE TABLE faculty (
	first_name	VARCHAR(50) 	NOT	NULL,
	last_name	VARCHAR(50)		NOT	NULL,
	address		VARCHAR(100),
	city		VARCHAR(50),
	state		VARCHAR(2),
	zip			INT,
	cell		VARCHAR(12),
	office		VARCHAR(12),
	home		VARCHAR(12),
	fax			VARCHAR(12)
);
	
	