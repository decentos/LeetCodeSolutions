WITH firstAsc AS (
    SELECT first_col, ROW_NUMBER() OVER (ORDER BY first_col) first_order FROM Data
),
secondDesc AS (
    SELECT second_col, ROW_NUMBER() OVER (ORDER BY second_col DESC) second_order FROM Data
)
SELECT first_col, second_col FROM firstAsc f
LEFT JOIN secondDesc s
ON f.first_order = s.second_order;
