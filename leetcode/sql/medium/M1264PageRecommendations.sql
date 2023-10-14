SELECT DISTINCT l.page_id as recommended_page
FROM Friendship f
INNER JOIN Likes l
ON f.user1_id = l.user_id OR f.user2_id = l.user_id
WHERE (f.user1_id = 1 OR f.user2_id = 1)
    AND l.page_id NOT IN(
        SELECT l2.page_id
        FROM Likes l2
        WHERE l2.user_id = 1
    );