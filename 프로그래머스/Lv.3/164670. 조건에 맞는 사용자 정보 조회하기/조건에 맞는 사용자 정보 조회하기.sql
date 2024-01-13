-- 코드를 입력하세요
SELECT  USED_GOODS_BOARD.writer_id as USER_ID, USED_GOODS_USER.nickname as NICKNAME, concat(USED_GOODS_USER.city ,' ',USED_GOODS_USER.street_address1,' ',USED_GOODS_USER.street_address2) as 전체주소,
concat(substring(tlno,1,3),'-',substring(tlno,4,4),'-',substring(tlno,8,4)) as 전화번호
from USED_GOODS_BOARD
left join USED_GOODS_USER
on USED_GOODS_BOARD.writer_id = USED_GOODS_USER.user_id
group by USED_GOODS_BOARD.writer_id # writer_id가 동일한 행을 그룹으로 묶음 group by에 조건주려면 having
having count(*) >= 3
order by USED_GOODS_BOARD.writer_id desc;

