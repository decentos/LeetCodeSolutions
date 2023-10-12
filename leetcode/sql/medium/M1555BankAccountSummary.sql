SELECT
    u.user_id,
    u.user_name,
    u.credit + IFNULL(SUM(IF(u.user_id = t.paid_to, amount, -amount)), 0) as credit,
    IF(u.credit + IFNULL(SUM(IF(u.user_id = t.paid_to, amount, -amount)), 0) < 0, 'Yes', 'No') as credit_limit_breached
FROM Users u
LEFT JOIN Transactions t
ON u.user_id IN (paid_by, paid_to)
GROUP BY u.user_name;