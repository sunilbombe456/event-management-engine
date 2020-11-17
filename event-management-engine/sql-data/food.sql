use `event-management-database`;

DROP TABLE IF EXISTS `food`;

CREATE TABLE `food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL,
  `price` float DEFAULT NULL,
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