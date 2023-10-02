SELECT ROUND(SUM(i.tiv_2016), 2) as tiv_2016
FROM Insurance i
WHERE i.tiv_2015 IN(
    SELECT i2.tiv_2015
    FROM Insurance i2
    GROUP BY i2.tiv_2015
    HAVING COUNT(*) > 1
) AND i.pid IN(
    SELECT i.pid
    FROM Insurance i
    GROUP BY i.lat, i.lon
    HAVING COUNT(*) = 1
);