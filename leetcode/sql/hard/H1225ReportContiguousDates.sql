WITH Period AS(
    SELECT 'failed' as period_state, f.fail_date as task_date
    FROM Failed f
    UNION ALL
    SELECT 'succeeded' as period_state, s.success_date as task_date
    FROM Succeeded s
),
Seq AS(
    SELECT
        p.task_date,
        p.period_state,
        ROW_NUMBER() OVER (ORDER BY p.period_state, p.task_date) as seq
    FROM Period p
    WHERE p.task_date BETWEEN '2019-01-01' AND '2019-12-31'
)
SELECT
    s.period_state,
    MIN(s.task_date) as start_date,
    MAX(s.task_date) as end_date
FROM Seq s
GROUP BY DATE_SUB(s.task_date, INTERVAL s.seq DAY), s.period_state
ORDER BY start_date;