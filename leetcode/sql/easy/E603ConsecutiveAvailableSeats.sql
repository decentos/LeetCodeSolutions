SELECT seq.seat_id
FROM(
    SELECT
        c.seat_id,
        c.free,
        LAG(c.free) OVER (ORDER BY c.seat_id) as prev,
        LEAD(c.free) OVER (ORDER BY c.seat_id) as next
    FROM Cinema c
) seq
WHERE seq.free = 1 AND (seq.prev = 1 OR seq.next = 1)
ORDER BY seq.seat_id;

===============================

SELECT DISTINCT c1.seat_id
FROM Cinema c1
INNER JOIN Cinema c2
ON ABS(c1.seat_id - c2.seat_id) = 1
WHERE c1.free = 1 AND c2.free = 1
ORDER BY c1.seat_id;