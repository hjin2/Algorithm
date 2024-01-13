# *****[자동차 대여 기록에서 장기/단기 대여 구분하기](https://school.programmers.co.kr/learn/courses/30/lessons/151138)*****

```sql
SELECT HISTORY_ID,
			 CAR_ID,
			 date_format(start_date,'%Y-%m-%d') as START_DATE, # date_format(날짜, 형식)
			 date_format(end_date,'%Y-%m-%d') as END_DATE,
# 기존 컬럼을 이용해서 새로운 내용을 나타낼 때 : case wehn 조건1 then 조건1을 만족할때 값 else 조건모두 만족안할때 값 end as 컬럼명
case when DATEDIFF(end_date, start_date) + 1 >= 30 
		 then "장기 대여"
else "단기 대여"
end as RENT_TYPE
from car_rental_company_rental_history
where start_date >= '2022-09-01' and start_date <= '2022-09-30' # 대여 시작일이 9월에 속할 때 where start_date between '2022-09-01' and '2022-09-30' 도 가능
order by HISTORY_ID desc; # id를 기준으로 내림차순
```

# *****[특정 옵션이 포함된 자동차 리스트 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/157343)*****

```sql
SELECT * 
from car_rental_company_car
where options like '%네비게이션%' # where options in ('네비게이션')은 완전히 일치하는지 확인
order by car_id desc;
```

# *****[조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기](https://school.programmers.co.kr/learn/courses/30/lessons/164671)*****

```sql
# 각 행의 내용들을 합쳐서 하나의 행을 만들때 : CONCAT('hi','bye')
# 첨부파일 경로 CONCAT으로 만들기
SELECT CONCAT("/home/grep/src/", BOARD_ID, "/",FILE_ID,FILE_NAME,FILE_EXT) AS FILE_PATH
FROM USED_GOODS_FILE
WHERE BOARD_ID = ( # 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일이니까 서브쿼리로 조회수 가장 높은 게시물 번호 찾기
SELECT BOARD_ID FROM USED_GOODS_BOARD ORDER BY VIEWS DESC LIMIT 1) # ==아니고 =임 ! 제일 큰 값 찾고 싶을때는 LIMIT 1 !!
ORDER BY FILE_ID DESC; # 이거 안해서 틀렸었음, 첨부파일 경로는 FILE ID를 기준으로 내림차순 정렬!
```

JOIN으로 푼 풀이도 있음

나는 서브쿼리 썼어

# *****[조건에 맞는 사용자 정보 조회하기](https://school.programmers.co.kr/learn/courses/30/lessons/164670)*****

```sql
SELECT  USED_GOODS_BOARD.writer_id as USER_ID, USED_GOODS_USER.nickname as NICKNAME, concat(USED_GOODS_USER.city ,' ',USED_GOODS_USER.street_address1,' ',USED_GOODS_USER.street_address2) as 전체주소,
# 01012345678 -> 010-1234-5678로 바꾸려면? concat과 substring(문자열,n번째 시작,k개 가져오기) mysql에서는 첫번째가 찐으로 첫번째다
concat(substring(tlno,1,3),'-',substring(tlno,4,4),'-',substring(tlno,8,4)) as 전화번호
from USED_GOODS_BOARD
left join USED_GOODS_USER
on USED_GOODS_BOARD.writer_id = USED_GOODS_USER.user_id
group by USED_GOODS_BOARD.writer_id # writer_id가 동일한 행을 그룹으로 묶음, group by에 조건을 주려면 having
having count(*) >= 3
order by USED_GOODS_BOARD.writer_id desc;
```

디테일에 주의
