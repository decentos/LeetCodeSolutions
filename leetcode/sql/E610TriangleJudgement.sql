SELECT
    t.x, t.y, t.z,
    IF(t.x + t.y > t.z AND t.x + t.z > t.y AND t.y + t.z > t.x, 'Yes', 'No') as triangle
FROM Triangle t;