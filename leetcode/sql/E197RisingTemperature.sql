SELECT w1.id
FROM Weather w1, Weather w2
WHERE w1.temperature > w2.temperature AND DATEDIFF(w1.recordDate, w2.recordDate) = 1;

===============================

SELECT w1.id
FROM Weather w1
INNER JOIN Weather w2
ON w1.temperature > w2.temperature AND DATEDIFF(w1.recordDate, w2.recordDate) = 1;