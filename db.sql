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
	CONSTRAINT C3 FOREIGN KEY(technician_id) REFERENCES Employee(employee_id)
);
CREATE TABLE Doctor (
    doctor_id VARCHAR(10) PRIMARY KEY, 
	CONSTRAINT C4 FOREIGN KEY(doctor_id) REFERENCES Employee(employee_id)
);
CREATE TABLE Primary_Doctor (
	primary_doctor_id VARCHAR(10) PRIMARY KEY, 
	CONSTRAINT C5 FOREIGN KEY(primary_doctor_id) REFERENCES Doctor(doctor_id)
);
CREATE TABLE Administrator (
    administrator_id VARCHAR(10) PRIMARY KEY, 
	CONSTRAINT C6 FOREIGN KEY(administrator_id) REFERENCES Employee(employee_id)
);

-- TREATMENT INFO
CREATE TABLE OrderTreatment (
    order_treatment_id VARCHAR(10) PRIMARY KEY, 
	timestamp timestamp NOT NULL,
    doctor_id VARCHAR(10) NOT NULL,
    treatment_id VARCHAR(10),
    admit_id VARCHAR(10),
	FOREIGN KEY (admit_id) REFERENCES Patient_Admitted(admit_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id), 
	FOREIGN KEY (treatment_id) REFERENCES Treatment(treatment_id)
);
CREATE TABLE Treatment (
	treatment_id VARCHAR(10),
    is_procedure boolean
);
CREATE TABLE PerformTreatment (
    perform_treatment_id VARCHAR(10) PRIMARY KEY, 
	timestamp timestamp NOT NULL,
    doctor_id VARCHAR(10) NOT NULL,
    treatment_id VARCHAR(10),
	admit_id VARCHAR(10),
	FOREIGN KEY (admit_id) REFERENCES Patient_Admitted(admit_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id), 
	FOREIGN KEY (treatment_id) REFERENCES Treatment(treatment_id) 
);
CREATE TABLE Administer_Treatment (
    administer_treatment_id VARCHAR(10) PRIMARY KEY,
    timestamp timestamp NOT NULL,
	treatment_id VARCHAR(10),
	admit_id VARCHAR(10),
	FOREIGN KEY (admit_id) REFERENCES Patient_Admitted(admit_id),
	FOREIGN KEY (treatment_id) REFERENCES Treatment(treatment_id) 
);
CREATE TABLE Employees_Involved (
	administer_treatment_id VARCHAR(10),
    employee_id VARCHAR(10) NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id),
    FOREIGN KEY (administer_treatment_id) REFERENCES Administer_Treatment(adminster_treatment_id)
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
CREATE TABLE Patient_Admitted (
	admit_id VARCHAR(10) PRIMARY KEY, 
	room_id VARCHAR(10),
    patient_id VARCHAR(10),
	timestamp timestamp NOT NULL,
	administrator_id VARCHAR(10), 
    primary_doctor_id VARCHAR(10),
    diagnosis VARCHAR(50),
	insurance_id VARCHAR(10), 
    FOREIGN KEY (insurance_id) REFERENCES Insurance(insurance_id), 
	FOREIGN KEY (room_id) REFERENCES Room(room_id), 
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (administrator_id) REFERENCES Administrator(administrator_id), 
	FOREIGN KEY (primary_doctor_id) REFERENCES Primary_Doctor(primary_doctor_id)
);

CREATE TABLE Assigned_To (
	admit_id VARCHAR(10),
	patient_id VARCHAR(10),
	doctor_id VARCHAR(10),
	is_primary bool,
	FOREIGN KEY (admit_id) REFERENCES Patient_Admitted(admit_id), 
	FOREIGN KEY (admit_id) REFERENCES Patient_Admitted(admit_id), 
	FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);
CREATE TABLE Patient_Discharged (
	discharge_id VARCHAR(10) PRIMARY KEY,
    admit_id VARCHAR(10),
    patient_id VARCHAR(10),
	timestamp timestamp NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id), 
	FOREIGN KEY (admit_id) REFERENCES Patient_Admitted(admit_id)
);
CREATE TABLE Patient ( 
    patient_id VARCHAR(10) PRIMARY KEY, 
    emergency_contact_id VARCHAR(10), 
	order_treatment_id VARCHAR(10),
    administer_treatment_id VARCHAR(10),
    FOREIGN KEY (emergency_contact_id) REFERENCES Emergency_Contact(emergency_contact_id) 
 );
CREATE TABLE Room (
    room_id VARCHAR(10) PRIMARY KEY, 
    room_num int, 
    check (room_num between 1 and 20), 
    occupied bool
);
