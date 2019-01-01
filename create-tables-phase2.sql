
CREATE TABLE users
(
  username integer NOT NULL,
  pass integer NOT NULL,
  asl integer NOT NULL,
  rsl integer NOT NULL,
  wsl integer NOT NULL,
  ail integer NOT NULL,
  ril integer NOT NULL,
  wil integer NOT NULL,
  hash character varying(50) NOT NULL,
  enc_tuple character varying(255) NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (username)
)











CREATE TABLE doctors
(

  s_id integer NOT NULL,
  firstname integer,
  lastname integer,
  ssid integer,
  specialty integer,
  hsection integer,
  hdate integer,
  age integer,
  salary integer,
  mstatus integer,
  username integer,
  hash character varying(50) NOT NULL,
  enc_tuple character varying(255) NOT NULL,
  CONSTRAINT doctors_pkey PRIMARY KEY (s_id),
  CONSTRAINT doctors_username_fkey FOREIGN KEY (username)
      REFERENCES users (username) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

Drop Table doctors
Drop Table patient
Drop Table nurses
Drop Table users
Drop Table employee



CREATE TABLE nurses
(
  s_id integer NOT NULL,
  firstname integer,
  lastname integer,
  ssid integer,
  hsection integer,
  hdate integer,
  age integer,
  salary integer,
  mstatus integer,
  username integer,
  hash character varying(50) NOT NULL,
  enc_tuple character varying(255) NOT NULL,
  CONSTRAINT nurses_pkey PRIMARY KEY (s_id),
  CONSTRAINT nurses_username_fkey FOREIGN KEY (username)
      REFERENCES users (username) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)



CREATE TABLE patient
(
  r_id integer NOT NULL,
  firstname integer,
  lastname integer,
  ssid integer,
  age integer,
  gender integer,
  illness integer,
  hsection integer,
  drugs integer,
  doctor integer,
  nurse integer,
  username integer,
  hash character varying(50) NOT NULL,
  enc_tuple character varying(255) NOT NULL,
  CONSTRAINT patient_pkey PRIMARY KEY (r_id),
  CONSTRAINT patient_doctor_fkey FOREIGN KEY (doctor)
      REFERENCES doctors (s_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT patient_nurse_fkey FOREIGN KEY (nurse)
      REFERENCES nurses (s_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT patient_username_fkey FOREIGN KEY (username)
      REFERENCES users (username) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)





CREATE TABLE employee
(
  s_id integer NOT NULL,
  firstname integer,
  lastname integer,
  ssid integer,
  job integer,
  hdate integer,
  age integer,
  salary integer,
  mstatus integer,
  isstaff integer,
  username integer,
  hash character varying(50) NOT NULL,
  enc_tuple character varying(255) NOT NULL,
  CONSTRAINT employee_pkey PRIMARY KEY (s_id),
  CONSTRAINT employee_username_fkey FOREIGN KEY (username)
      REFERENCES users (username) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)