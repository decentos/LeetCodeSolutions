SELECT
    'Low Salary' as category,
    SUM(IF(a.income < 20000, 1, 0)) as accounts_count
FROM Accounts a

UNION

SELECT
    'Average Salary' as category,
    SUM(IF(a.income >= 20000 AND a.income <= 50000, 1, 0)) as accounts_count
FROM Accounts a

UNION

SELECT
    'High Salary' as category,
    SUM(IF(a.income > 50000, 1, 0)) as accounts_count
FROM Accounts a;