CREATE DATABASE pva3_ddl;

CREATE TABLE pva3_ddl . prvnitabulka (
    id INT PRIMARY KEY AUTO_INCREMENT, 
    username VARCHAR(20),
    phonenumber VARCHAR(13) DEFAULT ""
    );