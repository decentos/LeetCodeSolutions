SELECT p.product_name, p.product_id, o1.order_id, o1.order_date
FROM Orders o1
INNER JOIN Products p
ON o1.product_id = p.product_id
WHERE (o1.product_id, o1.order_date) IN(
    SELECT o2.product_id, MAX(o2.order_date) as order_date
    FROM Orders o2
    GROUP BY o2.product_id
)
ORDER BY p.product_name, p.product_id, o1.order_id;

===============================

SELECT p.product_name, p.product_id, o.order_id, o.order_date
FROM Products p
INNER JOIN(
    SELECT
        o.order_id,
        o.product_id,
        o.order_date,
        RANK() OVER (PARTITION BY o.product_id ORDER BY o.order_date DESC) as rnk
    FROM Orders o
) o
ON p.product_id = o.product_id
WHERE o.rnk = 1
ORDER BY p.product_name, p.product_id, o.order_id;
