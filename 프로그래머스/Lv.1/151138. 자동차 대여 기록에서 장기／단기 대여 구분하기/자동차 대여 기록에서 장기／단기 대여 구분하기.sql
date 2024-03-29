-- 코드를 입력하세요
SELECT HISTORY_ID,
CAR_ID,
date_format(start_date,'%Y-%m-%d') as START_DATE,
date_format(end_date,'%Y-%m-%d') as END_DATE,
case when DATEDIFF(end_date, start_date) + 1 >= 30 # 기존 컬럼을 이용해서 새로운 내용을 나타낼 때
then "장기 대여"
else "단기 대여"
end as RENT_TYPE
from car_rental_company_rental_history
where start_date between '2022-09-01' and '2022-09-30'
order by HISTORY_ID desc;