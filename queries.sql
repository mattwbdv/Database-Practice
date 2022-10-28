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
WHERE pd.timestamp BETWEEN '2022-02-01 00:00:00' AND '2022-10-01 00:00:00';

-- 2.4
SELECT p.patient_id AS "Patient ID", p.name AS "Patient Name"
FROM Patient_Admitted pd
LEFT JOIN Patient p 
ON pd.patient_id = p.patient_id
WHERE pd.timestamp BETWEEN '2011-01-01 00:00:00' AND '2015-01-01 00:00:00';

-- 2.5




