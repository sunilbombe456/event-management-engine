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


INSERT INTO `user_detail` (`id`,`first_name`,`middle_name`,`last_name`,`email`,`mobile`,`Address`,`city`,`dist`,`state`,`pin_code`) VALUES (1,'Sunil','Sakharam','bombe','sunilbombe456@gmail.com','8605705665','pimpri','pune','pune','Maharashtra','411018');
INSERT INTO `user_detail` (`id`,`first_name`,`middle_name`,`last_name`,`email`,`mobile`,`Address`,`city`,`dist`,`state`,`pin_code`) VALUES (2,'Ganesh',NULL,'Bombe','ganeshbombe@gmail.com','9730573220','pimparkhed','shirur','pune','Maharashtra','410504');
INSERT INTO `user_detail` (`id`,`first_name`,`middle_name`,`last_name`,`email`,`mobile`,`Address`,`city`,`dist`,`state`,`pin_code`) VALUES (3,'Sahil',NULL,'Dabhade','SahilDabhade@gmail.com','6748538763','devgoan','shirur','pune','Maharashtra','410504');
INSERT INTO `user_detail` (`id`,`first_name`,`middle_name`,`last_name`,`email`,`mobile`,`Address`,`city`,`dist`,`state`,`pin_code`) VALUES (4,'Nikhil',NULL,'Khale','nikhilkhale@gmail.com','7664972579','devgoan','shirur','pune','Maharashtra','410504');
