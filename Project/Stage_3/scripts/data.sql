INSERT INTO case_info (responsible_person_name, bodyID, address, procedureID)
VALUES
('John Doe', 1, '123 Main St', 201),
('Jane Smith', 2, '456 Oak Ave', 202),
('Bob Johnson', 3, '789 Elm Rd', 203),
('Bob Johnson', 3, '789 Elm Rd', 204),
('David Wilson', 5, '876 Cedar Dr', 205);

INSERT INTO death_data (body_id, date_of_death, description_document_id)
VALUES
(1, '2023-05-15', 301),
(2, '2023-08-20', 302),
(3, '2023-03-10', 303),
(4, '2023-06-25', 304),
(5, '2023-11-05', 305);

INSERT INTO params (body_id, sex, height, weight)
VALUES
(1, 'M', 175.5, 70.2),
(2, 'F', 160.0, 55.8),
(3, 'M', 182.3, 80.5),
(4, 'F', 155.8, 52.4),
(5, 'M', 190.2, 90.0);

INSERT INTO procedures (body_id, note, pathologist_1_id, pathologist_2_id, intern_id)
VALUES
(1,'Autopsy', 401, 402, 501),
(2,'Forensic examination', 403, 404, 502),
(3,'Postmortem analysis', 405, 406, 503),
(4,'Pathological study', 407, 408, 504),
(5,'Medical examination', 409, 410, 505);

INSERT INTO relative_data (name, second_name, phone_number, passport_id, address, to_whom_ID)
VALUES
('Mary', 'Johnson', '123-456-7890', 'AB1234567', '456 Oak St', 1),
('Michael', 'Smith', '987-654-3210', 'CD9876543', '789 Elm Ave', 2),
('Emily', 'Jones', '555-123-4567', 'EF5554321', '123 Pine Ln', 3),
('Daniel', 'Williams', '333-999-8888', 'GH3338888', '890 Cedar Rd', 4),
('Olivia', 'Davis', '777-888-9999', 'IJ7779999', '567 Maple Dr', 5);

INSERT INTO personal_data (name, second_name, phone_number, passport_id)
VALUES
('John', 'Doe', '123-456-7890', 'AB1234567'),
('Jane', 'Smith', '987-654-3210', 'CD9876543'),
('Bob', 'Johnson', '555-123-4567', 'EF5554321'),
('Alice', 'Brown', '333-999-8888', 'GH3338888'),
('David', 'Wilson', '777-888-9999', 'IJ7779999');

INSERT INTO additional_info (bodyID, work_name, address, contact_info, note)
VALUES
(1, 'John`s Auto Repair', '123 Main St', '555-1234','Customer vehicle involved in an accident'),
(2, 'Smith Law Firm', '456 Oak Ave', '555-5678', 'Legal representative for the deceased'),
(3, 'Johnson Construction', '789 Elm Rd', '555-9876', 'Construction site incident'),
(4, 'Brown Family Clinic', '567 Pine Ln', '555-4321', 'Medical records required'),
(5, 'Wilson Insurance Agency', '876 Cedar Dr', '555-8765', 'Insurance claim processing');

INSERT INTO body_reciving (facility_address, receiving_date, receiver_name, receiver_second_name, receiver_ID, receiver_phone_number, body_treatment_type, graveyard_order_ID)
VALUES
('Hospital A', '2024-01-09 10:30:00', 'Olivia', 'Davis', 1, '777-888-9999', 'Autopsy', 1),
('Clinic B', '2024-01-09 12:15:00', 'Daniel', 'Williams', 2, '333-999-8888', 'Burial', 2),
('Lab C', '2024-01-09 09:45:00', 'Emily', 'Jones', 3, '555-123-4567', 'Cremation', 3),
('Emergency Center D', '2024-01-09 14:00:00', 'Michael', 'Smith', 4, '987-654-3210', 'Donation', 4),
('Radiology Center E', '2024-01-09 16:30:00', 'Mary', 'Johnson', 5, '123-456-7890', 'Research', 5);

INSERT INTO facility (address, registration_ID, working_hours_from, working_hours_until)
VALUES
('Hospital A', 501, '08:00:00', '17:00:00'),
('Clinic B', 502, '09:00:00', '18:00:00'),
('Lab C', 503, '07:30:00', '16:30:00'),
('Emergency Center D', 504, '24:00:00', '24:00:00'),
('Radiology Center E', 505, '10:00:00', '19:00:00');

INSERT INTO worker (name, second_name, is_intern, id_of_facility)
VALUES
('John', 'Doe', FALSE, 1),
('Jane', 'Smith', TRUE, 2),
('Bob', 'Johnson', FALSE, 3),
('Alice', 'Brown', TRUE, 4),
('David', 'Wilson', FALSE, 5),
('Sarah', 'Miller', TRUE, 1),
('Michael', 'Jones', FALSE, 2),
('Emma', 'Davis', TRUE, 3),
('Christopher', 'Clark', FALSE, 4),
('Sophia', 'Wilson', TRUE, 5),
('Matthew', 'Taylor', FALSE, 1),
('Olivia', 'Anderson', TRUE, 2),
('Daniel', 'Martin', FALSE, 3),
('Isabella', 'Hill', TRUE, 4),
('Ethan', 'Moore', FALSE, 5),
('Ava', 'White', TRUE, 1),
('James', 'Williams', FALSE, 2),
('Emily', 'Johnson', TRUE, 3),
('Benjamin', 'Hall', FALSE, 4),
('Abigail', 'Jones', TRUE, 5);
INSERT INTO funeral_services_acc_data (login, password, personid)
VALUES
('mary.doe@example.com', 'hashed_password_1', 1),
('michael.smith@example.com', 'hashed_password_2', 2),
('emily.johnson@example.com', 'hashed_password_3', 3),
('daniel.brown@example.com', 'hashed_password_4', 4),
('olivia.wilson@example.com', 'hashed_password_5', 5);

INSERT INTO graveyard_info (address, funeral_date, plot_number, body_id)
VALUES
('Cemetery A', '2024-01-15', 101, 1),
('Memorial Park B', '2024-01-20', 202, 2),
('Eternal Gardens C', '2024-01-25', 303, 3),
('Restful Meadows D', '2024-02-01', 404, 4),
('Tranquil Haven E', '2024-02-10', 505, 5);