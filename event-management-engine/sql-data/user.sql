use `event-management-database`;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  `user_pwd` varchar(45) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  `user_detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`user_detail_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`user_detail_id`) 
  REFERENCES `user_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `users` (`id`,`user_name`,`user_pwd`,`enabled`,`user_detail_id`) VALUES (1,'sunilbombe456','sunil',1,1);
INSERT INTO `users` (`id`,`user_name`,`user_pwd`,`enabled`,`user_detail_id`) VALUES (2,'ganeshbombe','ganesh',1,2);
INSERT INTO `users` (`id`,`user_name`,`user_pwd`,`enabled`,`user_detail_id`) VALUES (3,'sahildabhade','sahil',1,3);
INSERT INTO `users` (`id`,`user_name`,`user_pwd`,`enabled`,`user_detail_id`) VALUES (4,'nikhilkhale','nikhil',1,4);
