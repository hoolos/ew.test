insert into note_tag (_ID,name, description) values (1,'Java','Java тэг');
insert into note_tag (_ID,name, description) values (2,'С++','С++ тэг');
insert into note_tag (_ID,name, description) values (3,'С#','С# тэг');


insert into note (_ID,body, header, note_tag_id) values (1,'Заметка 1','Первая заметка',1);
insert into note (_ID,body, header, note_tag_id) values (2,'Заметка 2','Вторая заметка',2);
insert into note (_ID,body, header, note_tag_id) values (3,'Заметка 3','Третья заметка',3);
insert into note (_ID,body, header, note_tag_id) values (4,'Заметка 4','Четвертая заметка',3);