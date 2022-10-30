INSERT INTO `hospital`.`Emergency_Contact` (`emergency_contact_id`, `phone_number`, `name`, `relationship`) VALUES ('1', '3245559981', 'Steve', 'Father');
INSERT INTO `hospital`.`Emergency_Contact` (`emergency_contact_id`, `phone_number`, `name`, `relationship`) VALUES ('2', '2227776543', 'Tim', 'Friend');
INSERT INTO `hospital`.`Emergency_Contact` (`emergency_contact_id`, `phone_number`, `name`, `relationship`) VALUES ('3', '8726354677', 'Stacey', 'Mother');
INSERT INTO `hospital`.`Emergency_Contact` (`emergency_contact_id`, `phone_number`, `name`, `relationship`) VALUES ('4', '7655344876', 'Mathilde', 'Sister');
INSERT INTO `hospital`.`Emergency_Contact` (`emergency_contact_id`, `phone_number`, `name`, `relationship`) VALUES ('5', '9874565342', 'Robot', 'Friend');
INSERT INTO `hospital`.`Emergency_Contact` (`emergency_contact_id`, `phone_number`, `name`, `relationship`) VALUES ('6', '1980374899', 'Bobby', 'Friend');
INSERT INTO `hospital`.`Emergency_Contact` (`emergency_contact_id`, `phone_number`, `name`, `relationship`) VALUES ('7', '6783746655', 'Rick', 'Brother');


 
INSERT INTO `hospital`.`employee` (`employee_id`, `name`) VALUES ('1', 'Bob Steve');
INSERT INTO `hospital`.`employee` (`employee_id`, `name`) VALUES ('2', 'Tim Joe');
INSERT INTO `hospital`.`employee` (`employee_id`, `name`) VALUES ('3', 'Randolph Silva');
INSERT INTO `hospital`.`employee` (`employee_id`, `name`) VALUES ('4', 'Melinda Yates');
INSERT INTO `hospital`.`employee` (`employee_id`, `name`) VALUES ('5', 'Krista Mack');
INSERT INTO `hospital`.`employee` (`employee_id`, `name`) VALUES ('6', 'Dora Glover');
INSERT INTO `hospital`.`employee` (`employee_id`, `name`) VALUES ('7', 'Glen James');
INSERT INTO `hospital`.`EMPLOYEE` (`employee_id`, `name`) VALUES ('8', 'Adrian Carlson');
INSERT INTO `hospital`.`EMPLOYEE` (`employee_id`, `name`) VALUES ('9', 'Miguel Kim');


INSERT INTO `hospital`.`doctor` (`doctor_id`) VALUES ('1');
INSERT INTO `hospital`.`doctor` (`doctor_id`) VALUES ('2');
INSERT INTO `hospital`.`doctor` (`doctor_id`) VALUES ('3');

INSERT INTO `hospital`.`primary_doctor` (`primary_doctor_id`) VALUES ('1');
INSERT INTO `hospital`.`primary_doctor` (`primary_doctor_id`) VALUES ('2');
INSERT INTO `hospital`.`primary_doctor` (`primary_doctor_id`) VALUES ('3');


 
INSERT INTO `hospital`.`nurse` (`nurse_id`) VALUES ('4');
INSERT INTO `hospital`.`nurse` (`nurse_id`) VALUES ('5');


 
INSERT INTO `hospital`.`technician` (`technician_id`) VALUES ('6');
INSERT INTO `hospital`.`technician` (`technician_id`) VALUES ('7');

 
INSERT INTO `hospital`.`administrator` (`administrator_id`) VALUES ('8');
INSERT INTO `hospital`.`administrator` (`administrator_id`) VALUES ('9');



INSERT INTO `hospital`.`treatment` (`treatment_id`, `is_procedure`) VALUES ('1', '1');
INSERT INTO `hospital`.`treatment` (`treatment_id`, `is_procedure`) VALUES ('2', '0');
INSERT INTO `hospital`.`treatment` (`treatment_id`, `is_procedure`) VALUES ('3', '0');
INSERT INTO `hospital`.`treatment` (`treatment_id`, `is_procedure`) VALUES ('4', '1');
INSERT INTO `hospital`.`treatment` (`treatment_id`, `is_procedure`) VALUES ('5', '1');
INSERT INTO `hospital`.`treatment` (`treatment_id`, `is_procedure`) VALUES ('6', '0');


 
INSERT INTO `hospital`.`insurance` (`insurance_id`, `company_name`, `policy_number`) VALUES ('1', 'United', '1114827');
INSERT INTO `hospital`.`insurance` (`insurance_id`, `company_name`, `policy_number`) VALUES ('2', 'Aetna', '9998762');
INSERT INTO `hospital`.`insurance` (`insurance_id`, `company_name`, `policy_number`) VALUES ('3', 'Premera', '4448762');
INSERT INTO `hospital`.`insurance` (`insurance_id`, `company_name`, `policy_number`) VALUES ('4', 'Aetna', '7465364');
INSERT INTO `hospital`.`insurance` (`insurance_id`, `company_name`, `policy_number`) VALUES ('5', 'Premera', '0009876');
INSERT INTO `hospital`.`insurance` (`insurance_id`, `company_name`, `policy_number`) VALUES ('6', 'United', '1728374');
INSERT INTO `hospital`.`insurance` (`insurance_id`, `company_name`, `policy_number`) VALUES ('7', 'Cigna', '7587463');
INSERT INTO `hospital`.`insurance` (`insurance_id`, `company_name`, `policy_number`) VALUES ('8', 'Cigna', '8374567');
INSERT INTO `hospital`.`insurance` (`insurance_id`, `company_name`, `policy_number`) VALUES ('9', 'United', '2938484');



INSERT INTO `hospital`.`room` (`room_id`, `room_num`, `occupied`) VALUES ('1', '1', '1');
INSERT INTO `hospital`.`room` (`room_id`, `room_num`, `occupied`) VALUES ('2', '2', '0');
INSERT INTO `hospital`.`room` (`room_id`, `room_num`, `occupied`) VALUES ('3', '3', '0');
INSERT INTO `hospital`.`room` (`room_id`, `room_num`, `occupied`) VALUES ('4', '4', '0');
INSERT INTO `hospital`.`room` (`room_id`, `room_num`, `occupied`) VALUES ('5', '5', '1');
INSERT INTO `hospital`.`room` (`room_id`, `room_num`, `occupied`) VALUES ('6', '6', '1');


 
INSERT INTO `hospital`.`patient` (`patient_id`, `emergency_contact_id`, `name`) VALUES ('1', '7', "Steve");
INSERT INTO `hospital`.`patient` (`patient_id`, `emergency_contact_id`, `name`) VALUES ('2', '3', "Bob");
INSERT INTO `hospital`.`patient` (`patient_id`, `emergency_contact_id`, `name`) VALUES ('3', '4', "Larry");



 
INSERT INTO `hospital`.`Patient_Admitted` (`admit_id`, `room_id`, `patient_id`, `timestamp`, `administrator_id`, `primary_doctor_id`, `diagnosis`, `insurance_id`) VALUES ('1', '2', '1', '2013-07-23 13:10:11', '8', '1', 'Broken Arm', '1', '8');
INSERT INTO `hospital`.`Patient_Admitted` (`admit_id`, `room_id`, `patient_id`, `timestamp`, `administrator_id`, `primary_doctor_id`, `diagnosis`, `insurance_id`) VALUES ('2', '3', '2', '2011-02-13 13:07:11', '9', '2', 'Stomach Illness', '2', '2');
INSERT INTO `hospital`.`Patient_Admitted` (`admit_id`, `room_id`, `patient_id`, `timestamp`, `administrator_id`, `primary_doctor_id`, `diagnosis`, `insurance_id`) VALUES ('3', '1', '3', '2020-12-13 13:05:11', '9', '3', 'Broken Leg', '3', '5');



INSERT INTO `hospital`.`ordertreatment` (`order_treatment_id`, `timestamp`, `doctor_id`, `treatment_id`, `admit_id`) VALUES ('1', '2022-09-10 09:05:12', '1', '5', '1');
INSERT INTO `hospital`.`ordertreatment` (`order_treatment_id`, `timestamp`, `doctor_id`, `treatment_id`, `admit_id`) VALUES ('2', '2022-12-10 10:05:12', '2', '6', '1');
INSERT INTO `hospital`.`ordertreatment` (`order_treatment_id`, `timestamp`, `doctor_id`, `treatment_id`, `admit_id`) VALUES ('3', '2020-12-10 10:05:12', '2', '3', '2');
INSERT INTO `hospital`.`ordertreatment` (`order_treatment_id`, `timestamp`, `doctor_id`, `treatment_id`, `admit_id`) VALUES ('4', '2020-01-10 10:05:12', '3', '3', '3');



INSERT INTO `hospital`.`PerformTreatment` (`perform_treatment_id`, `timestamp`, `doctor_id`, `treatment_id`, `admit_id`) VALUES ('1', '2010-01-10 10:05:12', '1', '1', '1');
INSERT INTO `hospital`.`PerformTreatment` (`perform_treatment_id`, `timestamp`, `doctor_id`, `treatment_id`, `admit_id`) VALUES ('2', '2022-01-10 10:05:12', '3', '4', '2');
INSERT INTO `hospital`.`PerformTreatment` (`perform_treatment_id`, `timestamp`, `doctor_id`, `treatment_id`, `admit_id`) VALUES ('3', '2022-02-10 10:05:12', '3', '3', '2');
INSERT INTO `hospital`.`PerformTreatment` (`perform_treatment_id`, `timestamp`, `doctor_id`, `treatment_id`, `admit_id`) VALUES ('4', '2022-03-10 10:05:12', '2', '2', '3');


INSERT INTO `hospital`.`patient_discharged` (`discharge_id`, `admit_id`, `patient_id`, `timestamp`) VALUES ('1', '1', '1', '2022-06-10 10:05:12');
INSERT INTO `hospital`.`patient_discharged` (`discharge_id`, `admit_id`, `patient_id`, `timestamp`) VALUES ('2', '2', '2', '2022-06-10 10:05:12');



UPDATE `hospital`.`room` SET `occupied` = '0' WHERE (`room_id` = '5');
UPDATE `hospital`.`room` SET `occupied` = '0' WHERE (`room_id` = '6');

INSERT INTO `hospital`.`administer_treatment` (`administer_treatment_id`, `timestamp`, `treatment_id`, `admit_id`) VALUES ('1', '2021-11-10 10:05:12', '1', '1');
INSERT INTO `hospital`.`administer_treatment` (`administer_treatment_id`, `timestamp`, `treatment_id`, `admit_id`) VALUES ('2', '2021-10-10 10:05:12', '4', '1');
INSERT INTO `hospital`.`administer_treatment` (`administer_treatment_id`, `timestamp`, `treatment_id`, `admit_id`) VALUES ('3', '2021-12-10 10:05:12', '3', '2');
INSERT INTO `hospital`.`administer_treatment` (`administer_treatment_id`, `timestamp`, `treatment_id`, `admit_id`) VALUES ('4', '2021-10-19 10:05:12', '2', '3');

INSERT INTO `hospital`.`employees_involved` (`employee_event_id`, `administer_treatment_id`, `employee_id`) VALUES ('1', '1', '3');
INSERT INTO `hospital`.`employees_involved` (`employee_event_id`, `administer_treatment_id`, `employee_id`) VALUES ('2', '1', '4');
INSERT INTO `hospital`.`employees_involved` (`employee_event_id`, `administer_treatment_id`, `employee_id`) VALUES ('3', '2', '5');
INSERT INTO `hospital`.`employees_involved` (`employee_event_id`, `administer_treatment_id`, `employee_id`) VALUES ('4', '3', '3');
INSERT INTO `hospital`.`employees_involved` (`employee_event_id`, `administer_treatment_id`, `employee_id`) VALUES ('5', '4', '6');


INSERT INTO `hospital`.`assigned_to` (`staff_assigned_id`, `admit_id`, `patient_id`, `doctor_id`, `is_primary`) VALUES ('1', '1', '1', '1', '1');
INSERT INTO `hospital`.`assigned_to` (`staff_assigned_id`, `admit_id`, `patient_id`, `doctor_id`, `is_primary`) VALUES ('2', '1', '1', '2', '0');
INSERT INTO `hospital`.`assigned_to` (`staff_assigned_id`, `admit_id`, `patient_id`, `doctor_id`, `is_primary`) VALUES ('3', '2', '2', '2', '1');
INSERT INTO `hospital`.`assigned_to` (`staff_assigned_id`, `admit_id`, `patient_id`, `doctor_id`, `is_primary`) VALUES ('4', '2', '2', '3', '0');
INSERT INTO `hospital`.`assigned_to` (`staff_assigned_id`, `admit_id`, `patient_id`, `doctor_id`, `is_primary`) VALUES ('5', '3', '3', '3', '1');

UPDATE `hospital`.`patient` SET `order_treatment_id` = '2', `administer_treatment_id` = '1' WHERE (`patient_id` = '1');
UPDATE `hospital`.`patient` SET `order_treatment_id` = '4', `administer_treatment_id` = '3' WHERE (`patient_id` = '2');
UPDATE `hospital`.`patient` SET `order_treatment_id` = '5', `administer_treatment_id` = '4' WHERE (`patient_id` = '3');

-- adding duplicate value for testing 
INSERT INTO `hospital`.`Patient_Admitted` (`admit_id`, `room_id`, `patient_id`, `timestamp`, `administrator_id`, `primary_doctor_id`, `diagnosis`, `insurance_id`) VALUES ('4', '1', '2', '2005-12-14 13:06:12', '8', '2', 'Broken Arm', '1', '2');
INSERT INTO `hospital`.`patient_discharged` (`discharge_id`, `admit_id`, `patient_id`, `timestamp`) VALUES ('3', '4', '2', '2006-06-12 10:06:13');

