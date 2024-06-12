-- 코드를 입력하세요
SELECT book_id, TO_CHAR(published_date, 'YYYY-MM-DD') AS published_date
FROM BOOK
WHERE TO_CHAR(published_date, 'YYYY') = '2021'
AND CATEGORY = '인문'
ORDER BY PUBLISHED_DATE




