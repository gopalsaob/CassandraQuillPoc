CREATE KEYSPACE IF NOT EXISTS ks WITH replication = {'class':'SimpleStrategy', 'replication_factor':1};

USE ks;

CREATE TYPE ks.a (
x TEXT,
y TEXT
);

CREATE TABLE IF NOT EXISTS ks.a (
id TEXT,
xyz LIST<FROZEN <b>>,
PRIMARY KEY (id));