WITH order_rank AS(
    SELECT
        o.customer_id,
        p.product_id,
        p.product_name,
        RANK() OVER (PARTITION BY o.customer_id ORDER BY COUNT(*) DESC) as order_rank
    FROM Orders o
    INNER JOIN Products p
    ON o.product_id = p.product_id
    GROUP BY o.customer_id, p.product_id
)
SELECT r.customer_id, r.product_id, r.product_name
FROM order_rank r
WHERE r.order_rank = 1;