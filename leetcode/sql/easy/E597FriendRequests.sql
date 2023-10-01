WITH friend_info AS(
    SELECT COUNT(*) as req_count
    FROM (
        SELECT COUNT(*)
        FROM FriendRequest f
        GROUP BY f.sender_id, f.send_to_id
    ) fr
),
accepted_info AS(
    SELECT COUNT(*) as accept_count
    FROM (
        SELECT COUNT(*)
        FROM RequestAccepted a
        GROUP BY a.requester_id, a.accepter_id
    ) ra
)
SELECT IFNULL(ROUND(a.accept_count / f.req_count, 2), 0) as accept_rate
FROM friend_info f, accepted_info a;
