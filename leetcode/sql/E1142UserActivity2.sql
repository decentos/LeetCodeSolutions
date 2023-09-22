SELECT IFNULL(ROUND(COUNT(DISTINCT session_id) / COUNT(DISTINCT a.user_id), 2), 0) as average_sessions_per_user
FROM Activity a
WHERE a.activity_date BETWEEN '2019-06-28' AND '2019-07-27';