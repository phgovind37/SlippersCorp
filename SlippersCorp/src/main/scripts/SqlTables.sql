DROP DATABASE IF EXISTS slipperscorp;

 CREATE DATABASE slipperscorp;
 
USE slipperscorp;

set foreign_key_checks = 0;

--
-- 16 MB max size of file upload
--

-- SET GLOBAL max_allowed_packet = 16777216; 

--
-- Table Structure for table organization
--
DROP TABLE IF EXISTS organization;
CREATE TABLE organization (
	id BIGINT NOT NULL AUTO_INCREMENT,
	name varchar(100) NOT NULL,
	address_id BIGINT NOT NULL,
	phone varchar(15),
	mobile varchar(15),
	fax varchar(15),
	email varchar(50),
	tan_no varchar(11),
	tin_no varchar(12),
	image varchar(150),
	lastUpdatedBy BIGINT,
	lastUpdatedTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table State
--

DROP TABLE IF EXISTS state;
CREATE TABLE state (
	id BIGINT NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	country_id BIGINT NOT NULL,
	lastUpdatedBy BIGINT,
	lastUpdatedTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (Id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table Country
--

DROP TABLE IF EXISTS country;
CREATE TABLE country (
	id BIGINT NOT NULL AUTO_INCREMENT,
	name varchar(30) NOT NULL,
	lastUpdatedBy BIGINT,
	lastUpdatedTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (Id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table Structure for table Functionality
--
DROP TABLE IF EXISTS functionality;
CREATE TABLE functionality (
	id BIGINT NOT NULL AUTO_INCREMENT,
	functionality_name varchar(50) NOT NULL,
	PRIMARY KEY (Id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table Structure for table Authority
--
DROP TABLE IF EXISTS authority;
CREATE TABLE authority (
	id BIGINT NOT NULL AUTO_INCREMENT,
	functionality_id BIGINT NOT NULL,
	authority_name varchar(50) NOT NULL,
	authority_display_text varchar(50) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table Structure for table Role
--

DROP TABLE IF EXISTS role;
CREATE TABLE role (
	id BIGINT NOT NULL AUTO_INCREMENT,
	tenant_id BIGINT NOT NULL default 1,
	role_name varchar(20) NOT NULL,
	PRIMARY KEY (Id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table Structure for table roleauthoritymapping
--

DROP TABLE IF EXISTS roleauthoritymapping;
CREATE TABLE roleauthoritymapping (
	id BIGINT NOT NULL AUTO_INCREMENT,
	tenant_id BIGINT NOT NULL default 1,
	role_id BIGINT NOT NULL,
	authority_id BIGINT NOT NULL,
	PRIMARY KEY (Id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table User
--
DROP TABLE IF EXISTS user;
CREATE TABLE user (
	id BIGINT NOT NULL AUTO_INCREMENT,
	tenant_id BIGINT NOT NULL default 1,
	user_name varchar(30) NOT NULL,
	password varchar(50) NOT NULL,
	role_id BIGINT NOT NULL,
	lastUpdatedBy BIGINT,
	lastUpdatedTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (Id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table Structure for table employee
--
DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
	id BIGINT NOT NULL AUTO_INCREMENT,
	tenant_id BIGINT NOT NULL default 1,
	user_id BIGINT NOT NULL,
	first_name varchar(30) NOT NULL,
	middle_name varchar(30),
	last_name varchar(30) NOT NULL,
	communication_address_id BIGINT NOT NULL,
	permanent_address_id BIGINT NOT NULL,
	phone varchar(15),
	mobile varchar(15),
	email varchar(50),
	image varchar(150),
	dob date NOT NULL,
	gender char(1),
	blood_group varchar(10),
	marital_status varchar(20),
	lastUpdatedBy BIGINT,
	lastUpdatedTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table Structure for table address
--
DROP TABLE IF EXISTS address;
CREATE TABLE address (
	id BIGINT NOT NULL AUTO_INCREMENT,
	tenant_id BIGINT NOT NULL default 1,
	line1 varchar(300) NOT NULL,
	city varchar(25) NOT NULL,
	state_id BIGINT NOT NULL,
	country_id BIGINT NOT NULL,
	pin BIGINT,
	lastUpdatedBy BIGINT,
	lastUpdatedTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table Structure for table productcategories
--
DROP TABLE IF EXISTS productcategories;
CREATE TABLE productcategories (
	id BIGINT NOT NULL AUTO_INCREMENT,
	tenant_id BIGINT NOT NULL default 1,
	category varchar(50) NOT NULL,
	lastUpdatedBy BIGINT,
	lastUpdatedTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


set foreign_key_checks = 1;