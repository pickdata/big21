DROP TABLE credits;

CREATE TABLE credits
(
   id       int,
   result   int,
   score    float
);

load data local infile 'test_set.csv' 
into table credits fields terminated by ",";