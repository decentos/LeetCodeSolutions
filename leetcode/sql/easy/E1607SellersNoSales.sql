SELECT s.seller_name
FROM Seller s
WHERE s.seller_id NOT IN(
    SELECT o.seller_id
    FROM Orders o
    WHERE YEAR(o.sale_date) = 2020
    GROUP BY o.seller_id
)
ORDER BY s.seller_name;