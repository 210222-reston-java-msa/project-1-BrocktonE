DROP TABLE IF EXISTS employee;
CREATE TABLE brocktone.employee (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR (50),
	last_name VARCHAR(50),
	username VARCHAR(50),
	pass_word VARCHAR(50)

);

INSERT INTO brocktone.employee (first_name, last_name, username, pass_word)
VALUES ('Timmy', 'Maximoff', 'tmax', 'secret');


	PRIMARY KEY (ers_user_role_id)
	CONSTRAINT ers_user_roles_PK PRIMARY KEY(ers_user_role_id) REFERENCES ers_users(user_role_id)
	
	
CREATE TABLE ers_reimbursement (
	reimb_id SERIAL PRIMARY KEY,
	reimb_amount DECIMAL(2, 2),
	reimb_submitted TIMESTAMP,
	reimb_resolved TIMESTAMP,
	reimb_description VARCHAR,
	reimb_receipt Bytea,
	reimb_author INTEGER,
	reimb_resolver INTEGER,
	reimb_status_id NUMERIC,
	reimb_type_id NUMERIC,
	FOREIGN KEY(reimb_type_id) REFERENCES ers_reimbursement_type(reimb_type_id),
	FOREIGN KEY(reimb_status_id) REFERENCES ers_reimbursement_status(reimb_status_id),
	FOREIGN KEY(reimb_author) REFERENCES ers_users(ers_users_id),
	FOREIGN KEY(reimb_resolver) REFERENCES ers_users(ers_users_id)
);

	FOREIGN KEY(reimb_type_id) REFERENCES ers_reimbursement_type(reimb_type_id)
	FOREIGN KEY(reimb_resolver) REFERENCES ers_users(user_role_id),
	FOREIGN KEY(reimb_status_id) REFERENCES ers_reimbursement_status(reimb_status_id),
	FOREIGN KEY(reimb_author) REFERENCES ers_users(ers_users_id),


INSERT INTO brocktone.ers_reimbursement (reimb_amount, reimb_description, reimb_submitted, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
VALUES (5005.22, 'For food', current_timestamp , 2, 1, 2, 1);

UPDATE brocktone.ers_reimbursement SET reimb_resolved = current_timestamp , reimb_status_id = 3, reimb_resolver=1 WHERE reimb_id = 6;

CREATE TABLE ers_users (
	ers_users_id SERIAL PRIMARY KEY,
	ers_username VARCHAR(50) UNIQUE,
	ers_password VARCHAR(50),
	user_first_name VARCHAR(50),
	user_last_name VARCHAR(100),
	user_email VARCHAR(150) UNIQUE,
	user_role_id NUMERIC,
	FOREIGN KEY(user_role_id) REFERENCES ers_user_roles(ers_user_role_id)
);

ALTER TABLE brocktone.ERS_USERS
ADD CONSTRAINT ERS_USERS_UNv1  UNIQUE (ERS_USERNAME, USER_EMAIL);



FOREIGN KEY(user_role_id) REFERENCES ers_user_roles(ers_user_role_id)


CREATE TABLE ers_reimbursement_status (
	reimb_status_id NUMERIC,
	reimb_status VARCHAR(10),
	PRIMARY KEY(reimb_status_id)
);

CREATE TABLE ers_reimbursement_type (
	reimb_type_id NUMERIC,
	reimb_type VARCHAR(10),
	PRIMARY KEY(reimb_type_id)
);



CREATE TABLE ers_user_roles (
	ers_user_role_id NUMERIC,
	user_role VARCHAR(10),
	PRIMARY KEY(ers_user_role_id)
);

INSERT INTO brocktone.ers_user_roles (ers_user_role_id,user_role)
VALUES 
(1, 'Employee'),
 (2, 'Manager');

INSERT INTO brocktone.ers_reimbursement_type (reimb_type_id ,reimb_type)
VALUES 
(1, 'Lodging'),
(2, 'Travel'),
(3, 'Food'),
(4, 'Other')
;

INSERT INTO brocktone.ers_reimbursement_status (reimb_status_id, reimb_status)
VALUES
(1, 'Pending'),
(2, 'Approved'),
(3, 'Denied')
;




INSERT INTO brocktone.ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
VALUES
( 'BestManager', 'password', 'John', 'Smith', 'JS@gmail.com', 2),
('BestEmployee', 'test123', 'Will', 'Tell', 'WT@gmail.com', 1)
;

INSERT INTO brocktone.ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
VALUES
('BestManager12', 'password12', 'John1', 'Smith1', 'JS21@gmail.com', 1)
;

SELECT * FROM brocktone.ers_reimbursement WHERE reimb_status_id = 2 OR reimb_status_id = 3;



update 











