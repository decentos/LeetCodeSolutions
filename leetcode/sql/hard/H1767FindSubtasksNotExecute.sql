WITH RECURSIVE Subtasks AS (
    SELECT t.task_id, t.subtasks_count
    FROM Tasks t
    UNION ALL
    SELECT s.task_id, s.subtasks_count - 1
    FROM Subtasks s
    WHERE s.subtasks_count > 1
)
SELECT s.task_id, s.subtasks_count as subtask_id
FROM Subtasks s
WHERE (s.task_id, s.subtasks_count) NOT IN(
    SELECT e.task_id, e.subtask_id
    FROM Executed e
);