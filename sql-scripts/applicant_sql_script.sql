CREATE DATABASE  IF NOT EXISTS `resume_matcher_directory`;
USE `resume_matcher_directory`;

--
-- Table structure for table `applicant`
--

DROP TABLE IF EXISTS `applicant`;

CREATE TABLE `applicant` (
  `id` int NOT NULL,
  `location` varchar(45) DEFAULT NULL,
  `years_of_exprnce` int DEFAULT NULL,
  `skills` varchar(3000) DEFAULT NULL,
  `interested_field` varchar(50) DEFAULT NUll,
  PRIMARY KEY (`id`)
  --  KEY `FK_DETAIL_idx` (`user_id`),
  -- CONSTRAINT `FK_DETAIL` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `applicant`
--

INSERT INTO `applicant` VALUES 
	(1,'Vantaa, Finland',2,'Java', 'Software Developer'),
	(2,'Uusimaa, Finland',3,'Kubernetes,Docker', 'DevOps'),
	(3,'Turku, Finland',1,'Manufacturing, Supplu Chain','Business Analyst'),
	(4,'Tampare, Finland',7,'MySQL','Database Engineer'),
	(5,'Finland',5,'HR, Account, Finance','Accountant'),
    (6,'Tikkurila, Finland',5,'.NET, React', 'Software Developer');

