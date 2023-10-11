SELECT o.customer_id, c.name
FROM Orders o
LEFT JOIN Customers c
ON o.customer_id = c.customer_id
LEFT JOIN Product p
ON o.product_id = p.product_id
WHERE YEAR(o.order_date) = 2020 AND (MONTH(o.order_date) = 6 OR MONTH(o.order_date) = 7)
GROUP BY o.customer_id
HAVING SUM(IF(MONTH(o.order_date) = 6, p.price * o.quantity, 0)) >= 100
    AND SUM(IF(MONTH(o.order_date) = 7, p.price * o.quantity, 0)) >= 100