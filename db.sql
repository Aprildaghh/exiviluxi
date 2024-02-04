drop schema if exists `exiviluxi`;
create schema `exiviluxi`;
USE `exiviluxi`;

DROP TABLE IF EXISTS `presentation`;
DROP TABLE IF EXISTS `user`;

create table `user` (
	`id` int not null auto_increment,
    `username` varchar(32) not null,
    `password` varchar(64) not null,
    `intention_id` int not null,
    primary key(`id`)
);

CREATE TABLE `presentation` (
	`id` int auto_increment not null,
	`presentation_date` date not null,
    `password` varchar(64) not null,
    `user_id` int not null,
	PRIMARY KEY (`id`),
    key `FK_USER_idx` (`user_id`),
    constraint `FK_USER`
    foreign key (`user_id`)
    references `user`(`id`)
);