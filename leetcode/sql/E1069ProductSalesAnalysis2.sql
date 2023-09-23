SELECT s.product_id, SUM(s.quantity) as total_quantity
FROM Sales s
GROUP BY product_id;