SELECT MIN(d.log_id) as start_id, MAX(d.log_id) as end_id
FROM(
    SELECT l.log_id, l.log_id - ROW_NUMBER() OVER (ORDER BY l.log_id) as diff
    FROM Logs l
) d
GROUP BY d.diff;