SELECT u.user_id, u.name, u.mail
FROM Users u
WHERE u.mail REGEXP '^[a-zA-Z][a-zA-Z0-9_.-]*\\@leetcode\\.com$';