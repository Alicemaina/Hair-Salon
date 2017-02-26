# Hair-Salon

#By Alice Maina
#Description

a practice in java, gradle, sparkJava, postresql, junit, and fluentlenium.
Setup/Installation Requirement

$ postgres

    Open a new tab in terminal and create the hair_salon database:

psql

CREATE DATABASE hair_salon;

CREATE TABLE stylists (id serial PRIMARY KEY,  varchar name, varchar contact);

CREATE TABLE clients (id serial PRIMARY KEY, varchar name, varchar contact);

(for the tests to pass): CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;

**or** simply:

psql

CREATE DATABASE hair_salon;

psql hair_salon < hair_salon.sql

(for the tests to pass): CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;

    Navigate back to the directory where this repository has been cloned and run gradle:

$ gradle run

    Open localhost:4567 in a browser.

Known Bugs
Support and contact details

To contact, leave a comment on Github.
Technologies Used

    Java
    JUnit
    FluentLenium
    Gradle
    Spark
    PostgreSQL
