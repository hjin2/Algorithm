-- 코드를 입력하세요
-- SELECT A.SHIPMENT_ID, A.FLAVOR, SUM(A.TOTAL_ORDER)
-- FROM FIRST_HALF A, JULY B
-- WHERE A.SHIPMENT_ID = B.SHIPMENT_ID(+)
-- GROUP BY A.SHIPMENT_ID, A.FLAVOR, A.TOTAL_ORDER;

SELECT FLAVOR
FROM (
    SELECT A.FLAVOR, SUM(A.TOTAL_ORDER) AS TOTAL_ORDER_SUM
    FROM (
        SELECT *
        FROM FIRST_HALF
        UNION ALL
        SELECT *
        FROM JULY
    ) A
    GROUP BY A.FLAVOR
    ORDER BY SUM(A.TOTAL_ORDER) DESC
) 
WHERE ROWNUM <= 3;



-- 

SELECT FLAVOR
FROM (SELECT A.FLAVOR, (A.TOTAL_ORDER + B.TOTAL_ORDER) AS TOTAL_ORDER
        FROM FIRST_HALF A
      INNER JOIN (
            SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_ORDER
              FROM JULY
            GROUP BY FLAVOR
            ) B 
       ON A.FLAVOR = B.FLAVOR
      ORDER BY TOTAL_ORDER DESC
)
WHERE ROWNUM <= 3;
