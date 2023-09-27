SELECT p1.product_id, 10 as price
FROM Products p1
GROUP BY p1.product_id
HAVING MIN(p1.change_date) > '2019-08-16'

UNION ALL

SELECT p2.product_id, p2.new_price as price
FROM Products p2
WHERE (p2.product_id, p2.change_date) IN (
    SELECT p3.product_id, MAX(p3.change_date) as change_date
    FROM Products p3
    WHERE p3.change_date <= '2019-08-16'
    GROUP BY p3.product_id
);
