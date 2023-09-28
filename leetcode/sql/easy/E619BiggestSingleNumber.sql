SELECT (
    SELECT n.num
    FROM MyNumbers n
    GROUP BY n.num
    HAVING COUNT(*) = 1
    ORDER BY n.num DESC
    LIMIT 1
) as num;

SELECT MAX(num) as num
FROM (
    (SELECT n.num
    FROM MyNumbers n
    GROUP BY n.num
    HAVING COUNT(*) = 1)
) as temp;