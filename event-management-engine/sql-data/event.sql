use `event-management-database`;

DROP TABLE IF EXISTS `event`;

CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_name` varchar(80) DEFAULT NULL,
  `event_description` varchar(80) DEFAULT NULL,
  `venue` varchar(80) DEFAULT NULL,
  `event_date` varchar(80) DEFAULT NULL,
  `event_start_time` varchar(80) DEFAULT NULL,
  `evnt_end_time` varchar(80) DEFAULT NULL,
  `event_images` varchar(80) DEFAULT NULL,
  `ponser` varchar(80) DEFAULT NULL,
  `brand` varchar(80) DEFAULT NULL,
  `booking` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `event-management-database`.`event` (`id`, `event_name`, `event_description`, `venue`, `event_date`, `event_start_time`, `evnt_end_time`, `event_images`, `ponser`, `brand`, `booking`) VALUES ('1', 'SANAM -LIVE IN CONCERT', 'Each Ticket Grants One Person ', ' Hyderabad, Telangana, India', ' Saturday,', ' 07:00 PM', '11:00 PM IST', 'xyz.jpg', 'TATA GROUP', 'TATA', 'Start');

