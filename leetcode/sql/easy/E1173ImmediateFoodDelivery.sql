SELECT ROUND(AVG(order_date = customer_pref_delivery_date) * 100, 2) as immediate_percentage
FROM Delivery;