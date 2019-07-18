create table `file`(
`id`int auto_increment primary key ,
`name` varchar(255) NOT NULL ,
`time` long NOT NULL ,
`filerecord_id` int ,
foreign key(filerecord_id) references filerecord(id),
`procuratorate_id` int,
foreign key(procuratorate_id) references procuratorate(id)
)