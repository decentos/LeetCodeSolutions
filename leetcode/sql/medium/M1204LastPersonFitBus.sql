SELECT weight_info.person_name
FROM (
    SELECT q.person_name, SUM(q.weight) OVER (ORDER BY q.turn) as total_weight
    FROM Queue q
) weight_info
WHERE weight_info.total_weight <= 1000
ORDER BY weight_info.total_weight DESC
LIMIT 1;