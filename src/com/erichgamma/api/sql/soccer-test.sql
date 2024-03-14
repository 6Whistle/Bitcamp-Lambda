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
       CONCAT(IFNULL(NULLIF(weight, ''), '0'), 'cm') AS '몸무게',
       CASE
           WHEN height = '' OR weight = '' THEN 'NONE'
           ELSE CAST(weight AS DOUBLE) / POW(CONVERT(height, DOUBLE) / 100, 2)
           END AS 'BMI'
FROM player WHERE team_id =
                  (SELECT team_id FROM team WHERE region_name = '서울');

SELECT COUNT(*) AS '개수'
FROM stadium s
    JOIN team t on t.stadium_id = s.stadium_id
    JOIN player p on p.team_id = t.team_id
    JOIN schedule sch on sch.stadium_id = s.stadium_id
;

-- 문제 10
-- 수원팀(K02) 과 대전팀(K10) 선수들 중 포지션이 골키퍼(GK) 인
-- 선수를 출력하시오
-- 단 , 팀명, 선수명 오름차순 정렬하시오
SELECT * FROM player
WHERE position = 'GK'
AND team_id IN ('K02', 'K10')
ORDER BY
    (SELECT team_name
     FROM team
     WHERE team.team_id = player.team_id),
    player_name;

-- 문제 11
-- 팀과 연고지를 연결해서 출력하시오
-- [팀 명]             [홈구장]
-- 수원[ ]삼성블루윙즈 수원월드컵경기장
select * from team;
SELECT
    CONCAT(region_name,
           ' ',
           team_name
    ) '팀명',
    stadium_name '홈구장'
FROM stadium s
    JOIN team t ON t.stadium_id = s.stadium_id;

-- 문제 12
-- 수원팀(K02) 과 대전팀(K10) 선수들 중
-- 키가 180 이상 183 이하인 선수들
-- 키, 팀명, 사람명 오름차순
SELECT p.*
FROM team t
    JOIN player p ON p.team_id = t.team_id
WHERE height BETWEEN 180 AND 183
ORDER BY height, team_name, player_name;

-- 문제 13
-- 모든 선수들 중 포지션을 배정 받지 못한 선수들의
-- 팀명과 선수이름 출력 둘다 오름차순
SELECT team.team_name, player.player_name
FROM team
    JOIN player ON team.team_id = player.team_id
WHERE player.position = ''
ORDER BY team.team_name, player.player_name;

-- 문제 14
-- 팀과 스타디움, 스케줄을 조인하여
-- 2012년 3월 17일에 열린 각 경기의
-- 팀이름, 스타디움, 어웨이팀 이름 출력
-- 다중테이블 join 을 찾아서 해결하시오.

-- home team, stadium, schedule, away team -> join
SELECT home.team_name home_team,
       stadium.stadium_name stadium,
       away.team_name away_team
FROM stadium
    JOIN team home on stadium.stadium_id = home.stadium_id
    JOIN schedule sch on stadium.stadium_id = sch.stadium_id
    JOIN team away on sch.awayteam_id = away.team_id
WHERE sch.sche_date = '20120317';

-- home team, stadium, schedule -> join
-- away 팀은 SELECT 문을 통해 접근
SELECT t.team_name home_team,
       s.stadium_name stadium,
       (SELECT team.team_name
        FROM team
        WHERE team.team_id = sch.awayteam_id) away
FROM stadium s
         JOIN team t ON s.stadium_id = t.stadium_id
         JOIN schedule sch on s.stadium_id = sch.stadium_id
WHERE sch.sche_date = '20120317';

-- home team과 away team은 내부에서 Select를 통해 접근
-- stadium과 schedule만 join
SELECT (SELECT team_name
        FROM team t
        WHERE t.team_id = sch.hometeam_id) home,
       s.stadium_name stadium,
       (SELECT team_name
        FROM team t
        WHERE t.team_id = sch.awayteam_id) away
FROM stadium s
         JOIN schedule sch on s.stadium_id = sch.stadium_id
WHERE sch.sche_date = '20120317';

-- 문제 15
-- 2012년 3월 17일 경기에
-- 포항 스틸러스 소속 골키퍼(GK)
-- 선수, 포지션,팀명 (연고지포함),
-- 스타디움, 경기날짜를 구하시오
-- 연고지와 팀이름은 간격을 띄우시오(수원[]삼성블루윙즈)
SELECT p.player_name '이름',
       p.position '포지션',
       CONCAT(t.region_name, ' ', t.team_name) '팀명',
       s.stadium_name '스타디움',
       sch.sche_date '경기날짜'
FROM stadium s
    JOIN schedule sch ON sch.stadium_id = s.stadium_id
    JOIN team t ON s.stadium_id = t.stadium_id
    JOIN player p ON t.team_id = p.team_id
WHERE
    p.position = 'GK'
  AND t.team_name = '스틸러스'
  AND sch.sche_date = '20120317';

SELECT p.player_name '이름',
       p.position '포지션',
       CONCAT(t.region_name, ' ', t.team_name) '팀명',
       s.stadium_name '스타디움',
       sch.sche_date '경기날짜'
FROM stadium s
         JOIN schedule sch ON sch.stadium_id = s.stadium_id
         JOIN team t ON s.stadium_id = t.stadium_id
         JOIN player p ON t.team_id = p.team_id
WHERE
    p.position = 'GK'
  AND t.team_name = '스틸러스'
  AND sch.sche_date = '20120317';

-- 문제 16
-- 홈팀이 3점이상 차이로 승리한 경기의
-- 경기장 이름, 경기 일정
-- 홈팀 이름과 원정팀 이름을
-- 구하시오
SELECT (SELECT s.stadium_name
        FROM stadium s
        WHERE s.stadium_id = sch.stadium_id) stadium,
       sch.sche_date,
       (SELECT t.team_name
        FROM team t
        WHERE t.team_id = sch.hometeam_id) home,
       (SELECT t.team_name
        FROM team t
        WHERE t.team_id = sch.awayteam_id) home
FROM schedule sch
WHERE (sch.home_score - sch.away_score) >= 3;

SELECT s.stadium_name,
       sch.sche_date,
       home.team_name,
       away.team_name
FROM stadium s
    JOIN schedule sch USING (stadium_id)
    JOIN team home ON home.team_id = sch.hometeam_id
    JOIN team away ON away.team_id = sch.awayteam_id
WHERE (sch.home_score - sch.away_score) >= 3;





-- 문제 17
-- STADIUM 에 등록된 운동장 중에서
-- 홈팀이 없는 경기장까지 전부 나오도록
-- 카운트 값은 19
-- 힌트 : LEFT JOIN 사용해야함
SELECT st.stadium_name,
       (SELECT t.team_name FROM team t WHERE t.stadium_id = st.stadium_id)
FROM stadium st;

SELECT s.stadium_name,
       (SELECT t.team_name
        FROM team t
        WHERE t.stadium_id = s.stadium_id)
FROM stadium s LEFT JOIN team t USING (stadium_id);


-- 문제 18 플레이어 테이블에서 최상단 5개 로우를 출력
SELECT * FROM player LIMIT 5;

-- 문제 19 (그룹바이: 집계함수 - 딱 5개 min, max, count, sum, avg)
-- 평균키가 인천 유나이티스팀('K04')의 평균키  보다 작은 팀의
-- 팀ID, 팀명, 평균키 추출
-- 인천 유나이티스팀의 평균키 -- 176.59
-- 키와 몸무게가 없는 칸은 0 값으로 처리한 후 평균값에
-- 포함되지 않도록 하세요.
SELECT t.team_id AS '팀ID',
       t.team_name AS '팀명',
       t_avg.avg AS '평균'
FROM team t
JOIN(SELECT p.team_id, ROUND(AVG(p.height), 2) avg
     FROM player p
     WHERE p.height != ''
     GROUP BY p.team_id) t_avg USING(team_id)
WHERE t_avg.avg < 176.59
;

-- 문제 20
-- 포지션이 MF 인 선수들의 소속팀명 및  선수명, 백넘버 출력
SELECT (SELECT t.team_name
        FROM team t
        WHERE t.team_id = p.team_id) '소속팀',
    p.player_name '선수명',
    p.back_no '등번호'
FROM player p
WHERE p.position = 'MF';

-- 문제 21
-- 가장 키큰 선수 5명 소속팀명 및  선수명, 백넘버 출력,
-- 단 키  값이 없으면 제외
SELECT (SELECT t.team_name
        FROM team t
        WHERE t.team_id = p.team_id),
    p.player_name,
    p.back_no
FROM player p
ORDER BY p.height
LIMIT 5;


-- 문제 22
-- 선수 자신이 속한 팀의 평균키보다 작은  선수 정보 출력
-- (select round(avg(height),2) from player)
SELECT p.*
FROM player p
WHERE p.height < (SELECT ROUND(AVG(tp.height), 2)
                  FROM player tp
                  WHERE p.team_id = tp.team_id);

SELECT p.*
FROM player p
JOIN (SELECT p2.team_id, ROUND(AVG(p2.height), 2) avg
      FROM player p2
      where p2.height != ''
      GROUP BY p2.team_id) tavg USING (team_id)
WHERE p.height != ''
  AND p.height < tavg.avg;

-- 문제 23
-- 2012년 5월 한달간 경기가 있는 경기장  조회
SELECT DISTINCT (SELECT s.stadium_name
        FROM stadium s
        WHERE s.stadium_id = sch.stadium_id) '경기장'
FROM schedule sch
WHERE YEAR(sch.sche_date) = 2012
    AND MONTH(sch.sche_date) = 5