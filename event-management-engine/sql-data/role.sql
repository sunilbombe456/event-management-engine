use `event-management-database`;

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `role` (`id`,`name`) VALUES (1,'ROLE_ADMIN');
INSERT INTO `role` (`id`,`name`) VALUES (2,'ROLE_EMPLOYEE');
INSERT INTO `role` (`id`,`name`) VALUES (3,'ROLE_CUSTOMER');
