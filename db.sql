drop schema if exists `exiviluxi`;
create schema `exiviluxi`;
USE `exiviluxi`;

DROP TABLE IF EXISTS `presentation`;

CREATE TABLE `presentation` (
	`id` int auto_increment not null,
	`presentation_date` date not null,
	`password` varchar(32) not null,
    `video_url` varchar(512),
    `background_color` varchar(64),
    `background_url` varchar(512),
	PRIMARY KEY (`id`)
);