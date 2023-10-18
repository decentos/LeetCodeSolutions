SELECT t.transaction_id
FROM(
    SELECT
        t.transaction_id,
        RANK() OVER (PARTITION BY t.day ORDER BY t.amount DESC) as rnk
    FROM Transactions t
) t
WHERE t.rnk = 1
ORDER BY t.transaction_id;