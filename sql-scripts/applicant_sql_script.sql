CREATE DATABASE  IF NOT EXISTS `resume_matcher_directory`;
USE `resume_matcher_directory`;

--
-- Table structure for table `applicant`
--

DROP TABLE IF EXISTS `applicant`;

CREATE TABLE `applicant` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `years_of_exprnce` int DEFAULT NULL,
  `skills` varchar(3000) DEFAULT NULL,
  `interested_field` varchar(50) DEFAULT NUll,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `applicant`
--

INSERT INTO `applicant` VALUES 
	(1,'Leslie','Andrews','leslie@gmail.com','Vantaa, Finland',2,'Java', 'SoftwareDev'),
	(2,'Emma','Baumgarten','emma@gmail.com','Uusimaa, Finland',3,'Kubernetes,Docker', 'DevOps'),
	(3,'Avani','Gupta','avani@gmail.com','Turku, Finland',1,'Manufacturing, Supplu Chain','Consultant'),
	(4,'Yuri','Petrov','yuri@gmail.com','Tampare, Finland',7,'MySQL','DatabaseEngi'),
	(5,'Juan','Vega','juan@gmail.com','Aviapolis, Finland',5,'HR, Account, Finance','Accountant'),
    (6,'Kashi','Jason','kashi@gmail.com','Tikkurila, Finland',5,'.NET, React', 'SoftwareDev');

