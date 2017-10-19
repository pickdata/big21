USE world;

truncate table tbl_credits;

load data local infile 'Data_set_utf8_sql.csv' 
into table tbl_credits fields terminated by ",";
