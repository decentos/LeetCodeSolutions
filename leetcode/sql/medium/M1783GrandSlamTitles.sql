SELECT
    p.player_id,
    p.player_name,
    SUM(c.Wimbledon = p.player_id) + SUM(c.Fr_open = p.player_id)
        + SUM(c.US_open = p.player_id) + SUM(c.Au_open = p.player_id) as grand_slams_count
FROM Players p
INNER JOIN Championships c
ON p.player_id = c.Wimbledon OR p.player_id = c.Fr_open
    OR p.player_id = c.US_open OR p.player_id = c.Au_open
GROUP BY p.player_id;