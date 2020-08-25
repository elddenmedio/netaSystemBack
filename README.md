# Start

To start you need to clone this back project.

# Compile

This project need to update/install maven dependencies project.

# Deploy

You need to use payara or glasfich server as application.
You need to add JDBC Connection to Postgres.
You need to add JDBC Resources to link the new connection to webapp.
This project dont need properties.
You need to add application web app.

The final url_endpoint_api is: http://localhost:8080/neta-endpoint-web/services/v1/account/

If you want to see all the endpoints available you can see here

![picture](pictures/neta6.png)

# Connect to DB

This project use :

you need to compile the project with this command  `mvn clean package -DskipTests`, this will generate the war project back

# DataBase

Create new DB server called `neta` and then create their tables as:

CREATE TABLE IF NOT EXISTS public.customer (
  id SERIAL PRIMARY KEY,
  "name" char(100) NOT NULL,
  "surname" char(200) NOT NULL,
  "secondsurname" char(200) NULL,
  "active" boolean NOT NULL DEFAULT false,
  "deleted" boolean NOT NULL DEFAULT false
);

CREATE TABLE IF NOT EXISTS public.customer_info (
  id SERIAL PRIMARY KEY,
  "customer_id" bigint NOT NULL,
  "mail" char(200) NOT NULL,
  "birthday" timestamp NULL,
  "avatar" text NULL,
  "active" boolean NOT NULL DEFAULT true,
  "deleted" boolean NOT NULL DEFAULT false
);

CREATE TABLE IF NOT EXISTS public.login (
  id SERIAL PRIMARY KEY,
  "customer_id" bigint NOT NULL,
  "username" char(200) NOT NULL,
  "password" char(200) NOT NULL,
  "active" boolean NOT NULL DEFAULT false,
  "deleted" boolean NOT NULL DEFAULT false
);

CREATE TABLE IF NOT EXISTS public.customer_token (
  id SERIAL PRIMARY KEY,
  "customer_id" bigint NOT NULL,
  "token_id" bigint NOT NULL
);

CREATE TABLE IF NOT EXISTS public.token (
  id SERIAL PRIMARY KEY,
  "customer_id" bigint NOT NULL,
  "token" char(200) NOT NULL,
  "date_created" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "date_renewal" timestamp NULL,
  "date_down" timestamp NULL,
  "active" boolean NOT NULL DEFAULT true,
  "deleted" boolean NOT NULL DEFAULT false
);

# Creating the first row


INSERT INTO customer (name, surname, secondsurname, active)
VALUES ('jorge', 'malagon', 'procuna', true);
SELECT * FROM customer;

INSERT INTO customer_info (customer_id, mail, birthday, avatar)
VALUES (1, 'jorge@mail.com', '1987-08-07', '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');
SELECT * FROM customer_info;

INSERT INTO token (customer_id, token, date_created, date_renewal, date_down)
VALUES(1, '--token--', '2020-08-25', null, null);
SELECT * FROM token;

INSERT INTO customer_token (customer_id, token_id)
VALUES (1, 1);
SELECT * FROM customer_token;

INSERT INTO login (customer_id, username, password, active)
VALUES (1, 'jorge', 'jorge', true);
SELECT * FROM login;