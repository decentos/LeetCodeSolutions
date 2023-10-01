SELECT id, COUNT(id) as num FROM (
    SELECT r.requester_id as id
    FROM RequestAccepted r

    UNION ALL

    SELECT r.accepter_id as id
    FROM RequestAccepted r
) count_info
GROUP BY id
ORDER BY num DESC
LIMIT 1;

===============================

WITH count_info AS(
    SELECT req_info.id, COUNT(req_info.id) as num FROM (
        SELECT r.requester_id as id
        FROM RequestAccepted r

        UNION ALL

        SELECT r.accepter_id as id
        FROM RequestAccepted r
    ) req_info
    GROUP BY req_info.id
),
max_num AS(
    SELECT MAX(c.num) as 'max'
    FROM count_info c
)
SELECT c.id, c.num
FROM count_info c, max_num m
WHERE c.num = m.max;