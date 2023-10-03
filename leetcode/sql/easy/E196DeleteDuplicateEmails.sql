DELETE p2
FROM Person p1, Person p2
WHERE p1.email = p2.email AND p1.id < p2.id;

===============================

DELETE FROM Person p1
WHERE p1.id NOT IN(
    SELECT p2.id
    FROM(
        SELECT MIN(p3.id) as id
        FROM Person p3
        GROUP BY p3.email
    ) as p2
);