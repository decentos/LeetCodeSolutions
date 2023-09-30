SELECT
    CASE
        WHEN s.id % 2 = 0 THEN s.id - 1
        WHEN s.id % 2 = 1 AND s.id < (SELECT COUNT(*) FROM Seat) THEN s.id + 1
        ELSE s.id
    END as id,
    s.student
FROM Seat s
ORDER BY 1;