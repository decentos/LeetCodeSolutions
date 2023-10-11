SELECT DISTINCT c.title
FROM Content c
INNER JOIN TVProgram t
ON c.content_id = t.content_id
WHERE YEAR(t.program_date) = 2020 AND MONTH(t.program_date) = 6
    AND c.Kids_content = 'Y' AND c.content_type = 'Movies';