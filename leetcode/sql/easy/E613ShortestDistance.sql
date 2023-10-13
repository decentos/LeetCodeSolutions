SELECT MIN(p1.x - p2.x) as shortest
FROM Point p1
INNER JOIN Point p2
ON p1.x > p2.x;