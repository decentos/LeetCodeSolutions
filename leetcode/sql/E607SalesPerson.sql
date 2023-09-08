SELECT p.name
FROM SalesPerson p
WHERE p.sales_id NOT IN (
    SELECT o.sales_id
    FROM Orders o
    LEFT JOIN Company c
    ON o.com_id = c.com_id
    WHERE c.name = 'RED'
);
