SELECT c.customer_id
FROM Customer c
GROUP BY c.customer_id
HAVING COUNT(DISTINCT c.product_key) = (
    SELECT COUNT(*) as product_count
    FROM Product p
);