SELECT
    order_date,
    ROUND(AVG(order_date = customer_pref_delivery_date) * 100, 2) as immediate_percentage
FROM Delivery
GROUP BY order_date
ORDER BY order_date;