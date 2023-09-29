SELECT DISTINCT temp.num as ConsecutiveNums
FROM (
    SELECT
        l.num,
        LAG(l.num) OVER(ORDER BY l.id) as prev,
        LEAD(l.num) OVER(ORDER BY l.id) as next
    FROM Logs l
) temp
WHERE temp.num = temp.prev AND temp.num = temp.next;
