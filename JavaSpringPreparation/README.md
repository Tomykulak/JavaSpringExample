# Java Spring App
- docker-compose up --build -d

### Run database
- create database`docker run --rm --name postgresPrep -p 5433:5432 -e POSTGRES_PASSWORD=123 postgres`
- login: `postgres:123`
- port `5433`
- create database `create database test;`