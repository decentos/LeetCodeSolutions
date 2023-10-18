SELECT c.name as customer_name, c.customer_id, o.order_id, o.order_date
FROM Customers c
INNER JOIN(
    SELECT
        o.order_id,
        o.order_date,
        o.customer_id,
        RANK() OVER (PARTITION BY o.customer_id ORDER BY o.order_date DESC) as rnk
    FROM Orders o
) o
ON c.customer_id = o.customer_id
WHERE o.rnk <= 3
ORDER BY customer_name, customer_id, order_date DESC;