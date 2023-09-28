WITH first_login AS (
    SELECT a.player_id, MIN(a.event_date) as first_login
    FROM Activity a
    GROUP BY a.player_id
),
seq_login AS (
    SELECT
        f.player_id,
        f.first_login,
        IF(a.player_id IS NULL, 0, 1) as seq_login
    FROM first_login f
    LEFT JOIN Activity a
    ON f.player_id = a.player_id AND DATEDIFF(a.event_date, f.first_login) = 1
)
SELECT
    s.first_login as install_dt,
    COUNT(*) as installs,
    ROUND(SUM(seq_login) / COUNT(*), 2) as Day1_retention
FROM seq_login s
GROUP BY s.first_login;