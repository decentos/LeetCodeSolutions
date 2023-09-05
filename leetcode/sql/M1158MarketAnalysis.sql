SELECT u.user_id as buyer_id, u.join_date, COUNT(o.order_id) as orders_in_2019
FROM Users u
         LEFT JOIN Orders o
                   ON o.buyer_id = u.user_id AND o.order_date BETWEEN '2019-01-01' AND '2019-12-31'
GROUP BY u.user_id;