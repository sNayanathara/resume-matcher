CREATE DATABASE  IF NOT EXISTS `resume_matcher_directory`;
USE `resume_matcher_directory`;

--
-- Table structure for table `applicant`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `matching_password` varchar(45) DEFAULT NULL,
  `user_type` varchar(45) DEFAULT NULL,
 --  `location` varchar(45) DEFAULT NULL,
--   `years_of_exprnce` int DEFAULT NULL,
--   `skills` varchar(3000) DEFAULT NULL,
--   `interested_field` varchar(50) DEFAULT NUll,
--   `organization` varchar(3000) DEFAULT NULL,
--   `discriminator` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `applicant`
--

INSERT INTO `user` VALUES 
	-- (1,'Leslie','Andrews','leslie@gmail.com','+358678904555','test123', 'test123','Applicant','Vantaa, Finland',2,'Java', 'Software Developer',NULL,'A'),
-- 	(2,'Emma','Baumgarten','emma@gmail.com','+358678904556','test123', 'test123','Applicant','Uusimaa, Finland',3,'Kubernetes,Docker', 'DevOps',NULL,'A'),
--  	(3,'Avani','Gupta','avani@gmail.com','+358678904554','test123', 'test123','Applicant','Turku, Finland',1,'Manufacturing, Supplu Chain','Business Analyst',NULL,'A'),
--  	(4,'Yuri','Petrov','yuri@gmail.com','+358678904559','test123', 'test123','Applicant','Tampare, Finland',7,'MySQL','Database Engineer',NULL,'A'),
--  	(5,'Juan','Vega','juan@gmail.com','+358678904550','test123', 'test123','Applicant','Finland',5,'HR, Account, Finance','Accountant',NULL,'A'),
--     (6,'Kashi','Jason','kashi@gmail.com','+358678904551','test123', 'test123','Applicant','Tikkurila, Finland',5,'.NET, React', 'Software Developer',NULL,'A'),
-- 	(7,'Saman','Wash','saman@gmail.com','+358678904552','test123', 'test123','Recruiter',NULL,NULL,NULL,NULL,'IFS','R'),
-- 	(8,'John','Doe','john@gmail.com','+358678904558','test123', 'test123','Recruiter',NULL,NULL,NULL,NULL,'99x','R'); 

	(1,'Leslie','Andrews','leslie@gmail.com','+358678904555','test123', 'test123','Applicant'),
	(2,'Emma','Baumgarten','emma@gmail.com','+358678904556','test123', 'test123','Applicant'),
 	(3,'Avani','Gupta','avani@gmail.com','+358678904554','test123', 'test123','Applicant'),
 	(4,'Yuri','Petrov','yuri@gmail.com','+358678904559','test123', 'test123','Applicant'),
 	(5,'Juan','Vega','juan@gmail.com','+358678904550','test123', 'test123','Applicant'),
    (6,'Kashi','Jason','kashi@gmail.com','+358678904551','test123', 'test123','Applicant'),
	(7,'Saman','Wash','saman@gmail.com','+358678904552','test123', 'test123','Recruiter'),
	(8,'John','Doe','john@gmail.com','+358678904558','test123', 'test123','Recruiter'); 

