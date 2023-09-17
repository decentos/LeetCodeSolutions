SELECT
    r.contest_id,
    ROUND(COUNT(r.user_id) * 100 / (SELECT COUNT(u.user_id) FROM Users u), 2) as percentage
FROM Register r
GROUP BY r.contest_id
ORDER BY percentage DESC, r.contest_id;