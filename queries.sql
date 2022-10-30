-- 1.1
SELECT r.room_num AS "Room Number", p.name AS "Patient Name", pa.timestamp AS "Admitted Date & Time"
FROM ROOM r
LEFT JOIN patient_admitted pa
ON r.room_id = pa.room_id
LEFT JOIN patient p
ON p.patient_id = pa.patient_id;

-- 1.2
SELECT room_num AS "Unoccupied Rooms"
FROM room r
WHERE r.occupied=0;
 
-- 1.3
SELECT r.room_num AS "Room Number", p.name AS "Patient Name", pa.timestamp AS "Admitted Date & Time"
FROM ROOM r
LEFT JOIN patient_admitted pa
ON r.room_id = pa.room_id AND r.occupied=1
LEFT JOIN patient p
ON p.patient_id = pa.patient_id;

-- 2.1
SELECT p.name as "Patient Name", e.name as "Emergency Contact Name", e.phone_number as "Emergency Contact Phone", e.relationship as "Emergency Contact Relationship"
FROM patient p
LEFT JOIN Emergency_Contact e
ON p.emergency_contact_id = e.emergency_contact_id;

-- 2.2
SELECT p.name as "Currently Admitted Patient Name", p.patient_id as "Patient ID"
FROM ROOM r
INNER JOIN patient_admitted pa
ON r.room_id = pa.room_id AND r.occupied=1
LEFT JOIN patient p
ON p.patient_id = pa.patient_id;

-- 2.3
SELECT p.patient_id AS "Patient ID", p.name AS "Patient Name"
FROM Patient_Discharged pd
LEFT JOIN Patient p 
ON pd.patient_id = p.patient_id
-- GIVEN DATE RANGE 
WHERE pd.timestamp BETWEEN '2022-02-01 00:00:00' AND '2022-10-01 00:00:00';

-- 2.4
SELECT p.patient_id AS "Patient ID", p.name AS "Patient Name"
FROM Patient_Admitted pd
LEFT JOIN Patient p 
ON pd.patient_id = p.patient_id
-- GIVEN DATE RANGE 
WHERE pd.timestamp BETWEEN '2011-01-01 00:00:00' AND '2015-01-01 00:00:00';

-- 2.5
SELECT pa.timestamp as "Admitted Timestamp", pa.diagnosis as "Diagnosis" 
FROM Patient_Admitted pa
-- GIVEN PATIENT ID or NAME 
WHERE pa.patient_id = 1;


-- Fixing SQL Mode
SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
-- 2.6 
SELECT * 
FROM administer_treatment t
LEFT JOIN Patient_Admitted pa
ON t.admit_id = pa.admit_id
WHERE pa.patient_id = 1
-- GROUP BY pa.admit_id
ORDER BY t.admit_id DESC, t.treatment_id ASC;


-- 2.7 

-- 2.8 

-- 3.1
-- NOTE: I did not use diagnosis ID number in my tables, so I did not provide this ID
SELECT pa.admit_id, pa.diagnosis as "Diagnosis Name", count(pa.diagnosis) as "Times Occured"
FROM Patient_Admitted pa
WHERE pa.admit_id NOT IN (SELECT admit_id FROM Patient_Discharged)
GROUP BY diagnosis
ORDER BY count(diagnosis) DESC;

-- 3.2
-- NOTE: I did not use diagnosis ID number in my tables, so I did not provide this ID
SELECT pa.admit_id, pa.diagnosis as "Diagnosis Name", count(pa.diagnosis) as "Times Occured"
FROM Patient_Admitted pa
GROUP BY diagnosis
ORDER BY count(diagnosis) DESC

-- 3.3

-- 3.4

-- 3.5

-- 4.1

-- 4.2

-- 4.3

-- 4.4

-- 4.5



