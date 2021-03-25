
/*DROP TABLE IF EXISTS user;

create table `user` (
	`id` bigint auto_increment primary key,
    `name` varchar(50) not null
);
*/

/** Please delete above code and write your database tables */


DROP TABLE IF EXISTS Project;

create table `Project` (
	`id` bigint auto_increment primary key,
    `name` varchar(200) not null,
    `status` varchar(100) not null,
    `date` Date,
    `archived` varchar(100) not null
);