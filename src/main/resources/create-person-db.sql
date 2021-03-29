DROP TABLE PERSON IF EXISTS;
CREATE TABLE PERSON (
    ID integer identity primary key,
    NAME varchar(50) not null,
);