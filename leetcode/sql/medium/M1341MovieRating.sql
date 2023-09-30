(SELECT u.name as results
FROM MovieRating r
INNER JOIN Users u
ON r.user_id = u.user_id
GROUP BY r.user_id
ORDER BY COUNT(*) DESC, u.name
LIMIT 1)

UNION ALL

(SELECT m.title as results
FROM MovieRating r
INNER JOIN Movies m
ON r.movie_id = m.movie_id
WHERE r.created_at BETWEEN '2020-02-01' AND '2020-02-29'
GROUP BY r.movie_id
ORDER BY AVG(r.rating) DESC, m.title
LIMIT 1);
