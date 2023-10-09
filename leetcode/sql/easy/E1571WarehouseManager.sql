SELECT
    w.name as warehouse_name,
    SUM(p.Width * p.Length * p.Height * w.units) as volume
FROM Warehouse w
LEFT JOIN Products p
ON w.product_id = p.product_id
GROUP BY w.name;