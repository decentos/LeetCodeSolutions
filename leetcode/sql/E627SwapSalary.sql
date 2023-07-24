# UPDATE Salary
# SET sex = CASE sex
#         WHEN 'f' then 'm'
#         ELSE 'f'
#     END;

UPDATE Salary
SET sex = if(sex = 'f', 'm', 'f');