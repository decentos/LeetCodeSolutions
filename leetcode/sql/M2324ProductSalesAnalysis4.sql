SELECT user_id, product_id
FROM (
    SELECT
        s.user_id,
        s.product_id,
        DENSE_RANK() OVER (PARTITION BY s.user_id ORDER BY SUM(s.quantity * p.price) DESC) as rnk
    FROM Sales s
    INNER JOIN Product p
    ON s.product_id = p.product_id
    GROUP BY s.product_id, s.user_id
) temp
WHERE rnk = 1;
