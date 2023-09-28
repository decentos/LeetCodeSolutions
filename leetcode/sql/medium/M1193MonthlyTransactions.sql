SELECT
  DATE_FORMAT(trans_date, '%Y-%m') as month,
  country,
  COUNT(*) as trans_count,
  SUM(state = 'approved') as approved_count,
  SUM(amount) as trans_total_amount,
  SUM(IF(state = 'approved', amount, 0)) as approved_total_amount
FROM Transactions
GROUP BY month, country;