create table `procurator`(
`id`int auto_increment primary key ,
`name` varchar(255) NOT NULL,
`procuratorate_id` int ,
 foreign key(procuratorate_id) references procuratorate(id)
)