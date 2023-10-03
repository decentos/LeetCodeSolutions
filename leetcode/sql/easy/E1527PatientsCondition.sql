SELECT p.patient_id, p.patient_name, p.conditions
FROM Patients p
WHERE p.conditions LIKE 'DIAB1%' OR p.conditions LIKE '% DIAB1%';

===============================

SELECT p.patient_id, p.patient_name, p.conditions
FROM Patients p
WHERE p.conditions REGEXP '\\bDIAB1.*';