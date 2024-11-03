CREATE DATABASE  IF NOT EXISTS `resume_matcher_directory`;
USE `resume_matcher_directory`;

--
-- Table structure for table `applicant`
--

DROP TABLE IF EXISTS `recruiter`;

CREATE TABLE `recruiter` (
  `id` int NOT NULL,
  `organization` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`id`)
   -- KEY `FK_DETAIL_idx` (`user_id`),
--   CONSTRAINT `FK_DETAIL2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `applicant`
--

INSERT INTO `recruiter` VALUES 
	(7,'99x'),
	(8,'IFS');
	

