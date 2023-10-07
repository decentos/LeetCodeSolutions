SELECT
    e.left_operand,
    e.operator,
    e.right_operand,
    CASE
        WHEN e.operator = '=' AND l.value = r.value THEN 'true'
        WHEN e.operator = '>' AND l.value > r.value THEN 'true'
        WHEN e.operator = '<' AND l.value < r.value THEN 'true'
        ELSE 'false'
    END as value
FROM Expressions e
LEFT JOIN Variables l
ON e.left_operand = l.name
LEFT JOIN Variables r
ON e.right_operand = r.name;