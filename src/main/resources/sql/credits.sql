USE world;

TRUNCATE TABLE tbl_credits;

load data local infile 'Data_set_utf8_sql.csv'
into table tbl_credits fields terminated by ",";
