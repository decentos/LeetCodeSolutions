SELECT
    u.user_id,
    CONCAT(UPPER(SUBSTRING(u.name, 1, 1)), LOWER(SUBSTRING(u.name, 2))) as name
FROM Users u
ORDER BY u.user_id;