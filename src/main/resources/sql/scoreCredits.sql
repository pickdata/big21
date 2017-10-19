USE world;

TRUNCATE TABLE credit;

CREATE TABLE credit
(
	bno		int,
	id		int,
	score	float,
	target	int
);

load data local infile 'Data_set_utf8_sql.csv'
into table credit fields terminated by ",";

