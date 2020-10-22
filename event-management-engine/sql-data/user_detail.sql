use `event-management-database`;

DROP TABLE IF EXISTS `user_detail`;

CREATE TABLE `user_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(80) DEFAULT NULL,
  `middle_name` varchar(80) DEFAULT NULL,
  `last_name` varchar(80) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `mobile` varchar(80) DEFAULT NULL,
  `Address` varchar(80) DEFAULT NULL,
   `city` varchar(80) DEFAULT NULL,
    `dist` varchar(80) DEFAULT NULL,
     `state` varchar(80) DEFAULT NULL,
     `pin_code` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
