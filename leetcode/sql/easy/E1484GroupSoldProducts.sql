SELECT
    a.sell_date,
    COUNT(DISTINCT a.product) as num_sold,
    GROUP_CONCAT(DISTINCT a.product ORDER BY a.product SEPARATOR ',') as products
FROM Activities a
GROUP BY a.sell_date
ORDER BY a.sell_date;