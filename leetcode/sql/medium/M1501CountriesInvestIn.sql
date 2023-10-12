SELECT co.name as country
FROM Person p
INNER JOIN Calls c
ON p.id IN (c.caller_id, c.callee_id)
INNER JOIN Country co
ON LEFT(p.phone_number, 3) = co.country_code
GROUP BY co.name
HAVING AVG(c.duration) > (SELECT AVG(duration) FROM Calls);