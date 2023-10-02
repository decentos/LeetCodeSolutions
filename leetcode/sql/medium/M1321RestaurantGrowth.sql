WITH day_info AS(
    SELECT c.visited_on, SUM(c.amount) as day_amount
    FROM Customer c
    GROUP BY c.visited_on
)
SELECT
    a.visited_on,
    SUM(b.day_amount) as amount,
    ROUND(SUM(b.day_amount) / 7, 2) as average_amount
FROM day_info a, day_info b
WHERE DATEDIFF(a.visited_on, b.visited_on) BETWEEN 0 AND 6
GROUP BY a.visited_on
HAVING a.visited_on - (SELECT MIN(c.visited_on) FROM Customer c) >= 6
ORDER BY a.visited_on;