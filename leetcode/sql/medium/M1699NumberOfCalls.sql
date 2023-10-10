SELECT
    LEAST(c.to_id, c.from_id) as person1,
    GREATEST(c.to_id, c.from_id) as person2,
    COUNT(*) as call_count,
    SUM(c.duration) as total_duration
FROM Calls c
GROUP BY person1, person2;