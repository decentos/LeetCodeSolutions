SELECT u.name, IFNULL(SUM(r.distance), 0) as travelled_distance
FROM Users u
LEFT JOIN Rides r
ON u.id = r.user_id
GROUP BY user_id
ORDER BY travelled_distance DESC, u.name;