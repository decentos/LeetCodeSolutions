SELECT
    p.product_id,
    'store1' as store,
    p.store1 as price
FROM Products p
WHERE p.store1 IS NOT NULL

UNION ALL

SELECT
    p.product_id,
    'store2' as store,
    p.store2 as price
FROM Products p
WHERE p.store2 IS NOT NULL

UNION ALL

SELECT
    p.product_id,
    'store3' as store,
    p.store3 as price
FROM Products p
WHERE p.store3 IS NOT NULL