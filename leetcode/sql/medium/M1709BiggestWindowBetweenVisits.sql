SELECT
    diff.user_id,
    MAX(DATEDIFF(diff.curr, diff.prev)) as biggest_window
FROM(
    SELECT
        u1.user_id,
        u1.visit_date as prev,
        IFNULL(u2.visit_date, '2021-1-1') as curr,
        RANK() OVER (PARTITION BY u1.user_id, u1.visit_date ORDER BY u2.visit_date) as rnk
    FROM UserVisits u1
    LEFT JOIN UserVisits u2
    ON u1.user_id = u2.user_id AND u2.visit_date > u1.visit_date
) diff
WHERE diff.rnk = 1
GROUP BY user_id
ORDER BY user_id;

===============================

SELECT d.user_id, MAX(d.diff) as biggest_window
FROM(
    SELECT
        u.user_id,
        DATEDIFF(IFNULL(LEAD(u.visit_date) OVER (PARTITION BY u.user_id ORDER BY u.visit_date), '2021-1-1'), u.visit_date) as diff
    FROM UserVisits u
) d
GROUP BY d.user_id
ORDER BY d.user_id;