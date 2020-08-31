-- schema 1
DROP TABLE IF EXISTS project1.ers_user_roles CASCADE;
CREATE TABLE project1.ers_user_roles (
	ers_user_role_id SERIAL PRIMARY KEY,
	user_role VARCHAR(20) NOT NULL
);

-- schema 2
DROP TABLE IF EXISTS project1.ers_reimbursement_type CASCADE;
CREATE TABLE project1.ers_reimbursement_type (
	reimb_type_id SERIAL PRIMARY KEY,
	reimb_type VARCHAR(10) NOT NULL
);

-- schema 3
DROP TABLE IF EXISTS project1.ers_reimbursement_status CASCADE;
CREATE TABLE project1.ers_reimbursement_status (
	reimb_status_id SERIAL PRIMARY KEY,
	reimb_status VARCHAR(10) NOT NULL
);

-- schema 4
DROP TABLE IF EXISTS project1.ers_users CASCADE;
CREATE TABLE project1.ers_users (
	ers_users_id SERIAL PRIMARY KEY,
	ers_username VARCHAR(50) UNIQUE NOT NULL,
	ers_password VARCHAR(50) NOT NULL,
	user_first_name VARCHAR(100) NOT NULL,
	user_last_name VARCHAR(100) NOT NULL,
	user_email VARCHAR(150) UNIQUE NOT NULL,
	user_role_id INTEGER NOT NULL,
	FOREIGN KEY (user_role_id) REFERENCES project1.ers_user_roles (ers_user_role_id)
);

-- schema 5
DROP TABLE IF EXISTS project1.ers_reimbursement CASCADE;
CREATE TABLE project1.ers_reimbursement (
	reimb_id SERIAL PRIMARY KEY,
	reimb_amount DECIMAL(10, 2) NOT NULL,
	reimb_submitted TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	reimb_resolved TIMESTAMP,
	reimb_description VARCHAR(250),
	reimb_receipt BYTEA,
	reimb_author INTEGER NOT NULL,
	reimb_resolver INTEGER NOT NULL,
	reimb_status_id INTEGER NOT NULL,
	reimb_type_id INTEGER NOT NULL,
	FOREIGN KEY (reimb_author) REFERENCES project1.ers_users (ers_users_id),
	FOREIGN KEY (reimb_resolver) REFERENCES project1.ers_users (ers_users_id),
	FOREIGN KEY (reimb_status_id) REFERENCES project1.ers_reimbursement_status (reimb_status_id),
	FOREIGN KEY (reimb_type_id) REFERENCES project1.ers_reimbursement_type (reimb_type_id)
);

-- seed 1
INSERT INTO project1.ers_user_roles (user_role) VALUES ('manager');
INSERT INTO project1.ers_user_roles (user_role) VALUES ('employee');

-- seed 2
INSERT INTO project1.ers_reimbursement_type (reimb_type) VALUES ('lodging');
INSERT INTO project1.ers_reimbursement_type (reimb_type) VALUES ('travel');
INSERT INTO project1.ers_reimbursement_type (reimb_type) VALUES ('food');
INSERT INTO project1.ers_reimbursement_type (reimb_type) VALUES ('other');

-- seed 3
INSERT INTO project1.ers_reimbursement_status (reimb_status) VALUES ('pending');
INSERT INTO project1.ers_reimbursement_status (reimb_status) VALUES ('approved');
INSERT INTO project1.ers_reimbursement_status (reimb_status) VALUES ('denied');

-- seed 4
INSERT INTO project1.ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES ('tb@mail.com', '1212', 'tom', 'brady', 'tb@mail.com', 1);
INSERT INTO project1.ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES ('rg@mail.com', '8787', 'rob', 'gronkowski', 'rg@mail.com', 2);

-- seed 5
INSERT INTO project1.ers_reimbursement (reimb_amount, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (100, 'flight to tampa for recruitment', 2, 1, 1, 2);

-- query 1
SELECT * FROM project1.ers_reimbursement;
SELECT * FROM project1.ers_users;
SELECT * FROM project1.ers_reimbursement_status;
SELECT * FROM project1.ers_reimbursement_type;
SELECT * FROM project1.ers_user_roles;