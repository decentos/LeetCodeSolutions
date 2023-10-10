SELECT
    s.sale_date,
    SUM(IF(s.fruit = 'apples', s.sold_num, -s.sold_num)) as diff
FROM Sales s
GROUP BY s.sale_date
ORDER BY s.sale_date;