use `event-management-database`;


DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_USER_idx` (`user_id`),
  
  CONSTRAINT `FK_USER` FOREIGN KEY (`user_id`) 
  REFERENCES `users` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_ROLES` FOREIGN KEY (`role_id`) 
  REFERENCES `role` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `user_roles` (`user_id`,`role_id`) VALUES (1,1);
INSERT INTO `user_roles` (`user_id`,`role_id`) VALUES (1,2);
INSERT INTO `user_roles` (`user_id`,`role_id`) VALUES (1,3);
INSERT INTO `user_roles` (`user_id`,`role_id`) VALUES (2,2);
INSERT INTO `user_roles` (`user_id`,`role_id`) VALUES (3,3);
INSERT INTO `user_roles` (`user_id`,`role_id`) VALUES (4,1);
INSERT INTO `user_roles` (`user_id`,`role_id`) VALUES (4,2);