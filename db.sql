-- EMPLOYEE INFO
CREATE TABLE Employee (
	employee_id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(50)
);
CREATE TABLE Nurse (
    nurse_id VARCHAR(10) PRIMARY KEY, 
	CONSTRAINT C2 FOREIGN KEY(nurse_id) REFERENCES Employee(employee_id)
);
CREATE TABLE Technician (
    technician_id VARCHAR(10) PRIMARY KEY, 
	CONSTRAINT C2 FOREIGN KEY(technician_id) REFERENCES Employee(employee_id)
);
CREATE TABLE Doctor (
    doctor_id VARCHAR(10) PRIMARY KEY, 
	CONSTRAINT C2 FOREIGN KEY(doctor_id) REFERENCES Employee(employee_id)
);
CREATE TABLE Primary_Doctor (
	primary_doctor_id VARCHAR(10) PRIMARY KEY, 
	CONSTRAINT C2 FOREIGN KEY(primary_doctor_id) REFERENCES Doctor(doctor_id)
);
CREATE TABLE Administrator (
    administrator_id VARCHAR(10) PRIMARY KEY, 
	CONSTRAINT C2 FOREIGN KEY(administrator_id) REFERENCES Employee(employee_id)
);

-- TREATMENT INFO
CREATE TABLE OrderTreatment (
    order_treatment_id VARCHAR(10) PRIMARY KEY, 
    is_medication bool
);
CREATE TABLE Administer_Treatment (
    administer_treatment_id VARCHAR(10) PRIMARY KEY,
    timestamp timestamp NOT NULL,
    employee_id VARCHAR(10) NOT NULL,
    order_treatment_id VARCHAR(10) NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id),
    FOREIGN KEY (order_treatment_id) REFERENCES OrderTreatment(order_treatment_id)
);

-- PATIENT INFO
CREATE TABLE Insurance (
	insurance_id VARCHAR(10) PRIMARY KEY, 
    company_name VARCHAR(25), 
    policy_number VARCHAR(10)
);
CREATE TABLE Emergency_Contact (
	emergency_contact_id VARCHAR(10) PRIMARY KEY, 
    phone_number VARCHAR(10), 
    name VARCHAR(50), 
    relationship VARCHAR(25)
);
CREATE TABLE Patient ( 
    patient_id VARCHAR(10) PRIMARY KEY, 
    insurance_id VARCHAR(10), 
    emergency_contact_id VARCHAR(10), 
    administrator_id VARCHAR(10), 
    room_id VARCHAR(10),
    order_treatment_id VARCHAR(10),
    administer_treatment_id VARCHAR(10),
    primary_doctor_id VARCHAR(10),
    FOREIGN KEY (insurance_id) REFERENCES Insurance(insurance_id), 
    FOREIGN KEY (emergency_contact_id) REFERENCES Emergency_Contact(emergency_contact_id), 
    FOREIGN KEY (administrator_id) REFERENCES Administrator(administrator_id), 
	FOREIGN KEY (room_id) REFERENCES Room(room_id), 
	FOREIGN KEY (order_treatment_id) REFERENCES OrderTreatment(order_treatment_id), 
	FOREIGN KEY (administer_treatment_id) REFERENCES Administer_Treatment(administer_treatment_id), 
	FOREIGN KEY (primary_doctor_id) REFERENCES Primary_Doctor(primary_doctor_id) );
CREATE TABLE Room (
    room_id VARCHAR(10) PRIMARY KEY, 
    room_num int, 
    check (room_num between 1 and 20)
);

