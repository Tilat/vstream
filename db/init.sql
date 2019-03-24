CREATE USER apiserver WITH ENCRYPTED PASSWORD 'api-server';

CREATE DATABASE apiserver_db;

GRANT ALL PRIVILEGES ON DATABASE apiserver_db TO apiserver;

