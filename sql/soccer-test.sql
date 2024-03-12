SHOW TABLES;

-- 001 오름차순 sort
SELECT * FROM team ORDER BY team_name ASC;

-- 002 Grouping
SELECT DISTINCT position FROM player;
SELECT position FROM player GROUP BY position;

-- 003
SELECT DISTINCT IFNULL(NULLIF(position, ''), '신입') AS '포지션' FROM player;
SELECT DISTINCT COALESCE(NULLIF(position, ''), '신입') AS '포지션' FROM player;
SELECT DISTINCT
    CASE
        WHEN position = '' then '신입'
        ELSE position
    END AS '포지션'
FROM player;

-- 004
SELECT * FROM player where POSITION = 'GK' AND team_id = 'k02';

-- 004.1
SELECT * FROM player WHERE position = 'GK'
                       AND team_id =
                           (SELECT team_id from team where region_name = '수원');
-- 004.1 using join
SELECT * FROM player JOIN team on team.team_id = player.team_id
                          where position = 'GK' AND region_name = '수원';

-- 005
SELECT * FROM player
WHERE height >= 170
  AND player_name LIKE '고%'
  AND team_id = 'k02';

-- 005.1 Sub Query
SELECT * FROM player
WHERE height >= 170
  AND player_name LIKE '고%'
  AND team_id =
      (SELECT team_id FROM team WHERE region_name = '수원');

-- 005.1 JOIN
SELECT player.* FROM player JOIN team on team.team_id = player.team_id
         WHERE player.height >= 170
           AND player.player_name LIKE '고%'
           AND team.region_name = '수원';

-- 문제 6
-- 다음 조건을 만족하는 선수명단을 출력하시오
-- 소속팀이 삼성블루윙즈이거나
-- 드래곤즈에 소속된 선수들이어야 하고,
-- 포지션이 미드필더(MF:Midfielder)이어야 한다.
-- 키는 170 센티미터 이상이고 180 이하여야 한다.
SELECT * FROM player WHERE position = 'MF'
                              AND height BETWEEN 170 AND 180
                              AND team_id IN
                                  (SELECT team_id from team WHERE team_name IN ('삼성블루윙즈', '드래곤즈'));
SELECT player.* FROM player JOIN team ON team.team_id = player.team_id
                WHERE position = 'MF'
                  AND height BETWEEN 170 AND 180
                  AND team.team_name IN ('삼성블루윙즈', '드래곤즈');


-- 문제 7-- 수원을 연고지로 하는 골키퍼는 누구인가?
SELECT * FROM player WHERE position = 'GK'
                       AND team_id =
                           (SELECT team_id FROM team WHERE region_name = '수원');

-- 문제 8-- 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오-- 키와 몸무게가 없으면 "0" 으로 표시하시오-- 키와 몸무게는 내림차순으로 정렬하시오
SELECT player_name AS '이름',
       IFNULL(NULLIF(height, ''), '0') AS '키',
       IFNULL(NULLIF(weight, ''), '0') AS '몸무게' FROM player WHERE team_id =
                                                              (SELECT team_id FROM team WHERE region_name = '서울');

-- 문제 9-- 서울팀 선수들 이름과 포지션과-- 키(cm표시)와 몸무게(kg표시)와  각 선수의 BMI지수를 출력하시오-- 단, 키와 몸무게가 없으면 "0" 표시하시오-- BMI는 "NONE" 으로 표시하시오(as bmi)-- 최종 결과는 이름내림차순으로 정렬하시오
SELECT player_name AS '이름',
       CONCAT(IFNULL(NULLIF(height, ''), '0'), 'cm') AS '키',
       IFNULL(NULLIF(weight, ''), '0') || 'cm' AS '몸무게',
       CASE
           WHEN height = '' OR weight = '' THEN 'NONE'
           ELSE CAST(weight AS DOUBLE) / POW(CONVERT(height, DOUBLE) / 100, 2)
           END AS 'BMI'
FROM player WHERE team_id =
                  (SELECT team_id FROM team WHERE region_name = '서울');

SELECT 1 FROM information_schema.tables WHERE TABLE_SCHEMA = 'erichgammadb' AND table_name = 'user';