USE world;

DROP TABLE credits;

CREATE TABLE credits
(
   id       int,
   result   int,
   score    float
);

load data local infile 'test_set.csv' 
into table tbl_credits fields terminated by ",";