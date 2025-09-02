insert into user_details(BIRTH_DATE, ID, NAME)
values (current_date(), 1001, 'SATYA');

insert into user_details(BIRTH_DATE, ID, NAME)
values (current_date(), 1004, 'SHYAM');

insert into user_details(BIRTH_DATE, ID, NAME)
values (current_date - interval '20' day, 1003, 'SRAVAN');

insert into user_details(BIRTH_DATE, ID, NAME)
values (current_date(), 1002, 'SATHWIK');

insert into user_details(BIRTH_DATE, ID, NAME)
values (current_date - interval '30' day, 1008, 'KIRAN');

insert into post(ID, USER_ID, DESCRIPTION)
values (2001, 1001, 'I want to learn AWS');

insert into post(ID, USER_ID, DESCRIPTION)
values (2002, 1001, 'I want to learn JAVA');

insert into post(ID, USER_ID, DESCRIPTION)
values (2003, 1002, 'I want to learn AZURE');

insert into post(ID, USER_ID, DESCRIPTION)
values (2004, 1002, 'I want to learn C++');
