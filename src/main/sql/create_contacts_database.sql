CREATE DATABASE regis;

GRANT ALL PRIVILEGES
ON regis.*
TO 'errygg'@'localhost'
IDENTIFIED BY 'password'
WITH GRANT OPTION;

GRANT ALL PRIVILEGES
ON regis.*
TO 'errygg'@'%'
IDENTIFIED BY 'password'
WITH GRANT OPTION;

USE regis;