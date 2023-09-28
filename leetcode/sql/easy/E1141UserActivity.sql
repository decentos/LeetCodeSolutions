SELECT
  a.activity_date as day,
  COUNT(DISTINCT user_id) as active_users
FROM Activity a
WHERE a.activity_date BETWEEN '2019-06-28' AND '2019-07-27'
GROUP BY a.activity_date
ORDER BY a.activity_date;