CREATE TABLE case_info (ID SERIAL PRIMARY KEY,
responsible_person_name VARCHAR(64) NOT NULL,
bodyID INTEGER NOT NULL,
address VARCHAR(64) NOT NULL,
procedureID INTEGER NOT NULL
);

CREATE TABLE death_data(body_id INTEGER NOT NULL,
date_of_death DATE NOT NULL,
description_document_id INTEGER
);

CREATE TABLE params(body_id INTEGER NOT NULL,
sex VARCHAR(1),
height DECIMAL,
weight DECIMAL
);

CREATE TABLE procedures(procedure_id SERIAL PRIMARY KEY,
body_id INTEGER NOT NULL,
note TEXT,
pathologist_1_id INTEGER NOT NULL, 
pathologist_2_id INTEGER NOT NULL,
intern_id INTEGER DEFAULT NULL
);

CREATE TABLE relative_data (personID SERIAL PRIMARY KEY,
name VARCHAR(32) NOT NULL,
second_name VARCHAR(32) NOT NULL,
phone_number VARCHAR(12),
passport_id VARCHAR(10) NOT NULL,
address VARCHAR(64),
to_whom_ID INTEGER NOT NULL
);

CREATE TABLE personal_data (ID SERIAL PRIMARY KEY,
name VARCHAR(32) NOT NULL,
second_name VARCHAR(32) NOT NULL,
phone_number VARCHAR(12),
passport_id VARCHAR(10) NOT NULL
);

CREATE TABLE additional_info (bodyID INTEGER NOT NULL,
work_name TEXT,
address VARCHAR(64),
contact_info TEXT,
note TEXT
);

CREATE TABLE body_receiving(ID SERIAL PRIMARY KEY,
facility_address VARCHAR(64) NOT NULL,
receiving_date TIMESTAMP NOT NULL,
receiver_name VARCHAR(32),
receiver_second_name VARCHAR(32) NOT NULL,
receiver_ID INTEGER NOT NULL,
receiver_phone_number VARCHAR(12),
body_treatment_type TEXT,
graveyard_order_ID INTEGER NOT NULL
);

CREATE TABLE facility(ID SERIAL PRIMARY KEY,
address VARCHAR(64) NOT NULL,
registration_ID INTEGER NOT NULL,
working_hours_from TIME NOT NULL,
working_hours_until TIME NOT NULL
);

CREATE TABLE worker(ID SERIAL PRIMARY KEY,
name VARCHAR(32) NOT NULL,
second_name VARCHAR(32) NOT NULL,
is_intern BOOLEAN DEFAULT FALSE,
id_of_facility INTEGER NOT NULL
);

CREATE TABLE funeral_services_acc_data(ID SERIAL PRIMARY KEY,
login VARCHAR(64) NOT NULL,
password TEXT NOT NULL,
personid INTEGER NOT NULL
);

CREATE TABLE graveyard_info(ID SERIAL PRIMARY KEY,
address VARCHAR(64) NOT NULL,
funeral_date DATE,
plot_number INTEGER,
body_id INTEGER NOT NULL
);