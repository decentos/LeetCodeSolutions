SELECT
    ROUND(
        SUM(IF(DATEDIFF(a.event_date, first_login.first_login_date) = 1, 1, 0)) / (SELECT COUNT(DISTINCT player_id) FROM Activity)
        , 2) as fraction
FROM Activity a
LEFT JOIN (
    SELECT player_id, MIN(event_date) as first_login_date
    FROM Activity
    GROUP BY player_id
) first_login
ON a.player_id = first_login.player_id;

===============================

SELECT
    ROUND(
        COUNT(*) / (SELECT COUNT(DISTINCT player_id) FROM Activity)
        , 2) as fraction
FROM Activity a
WHERE (a.player_id, DATE_SUB(a.event_date, INTERVAL 1 DAY)) IN (
    SELECT player_id, MIN(event_date)
    FROM Activity
    GROUP BY player_id
);

===============================

WITH first_login AS (
    SELECT a.player_id, MIN(a.event_date) as first_login
    FROM Activity a
    GROUP BY a.player_id
),
seq_login AS (
    SELECT COUNT(*) as seq_login_count
    FROM first_login f
    INNER JOIN Activity a
    ON f.player_id = a.player_id AND DATEDIFF(a.event_date, f.first_login) = 1
)
SELECT ROUND(
    (SELECT s.seq_login_count FROM seq_login s) / (SELECT COUNT(*) FROM first_login)
    , 2) as fraction;