-- Soccer JPA Ver.
CREATE TABLE stadium(
                        id INT NOT NULL AUTO_INCREMENT,
                        stadium_name VARCHAR(40),
                        hometeam_id VARCHAR(10),
                        seat_count INT,
                        address VARCHAR(60),
                        ddd VARCHAR(10),
                        tel VARCHAR(10),
                        PRIMARY KEY (id)
)DEFAULT CHARSET=utf8;

CREATE TABLE schedule(
                         id INT NOT NULL AUTO_INCREMENT,
                         stadium_id INT,
                         gubun VARCHAR(10),
                         hometeam_id VARCHAR(10),
                         awayteam_id VARCHAR(10),
                         home_score INT,
                         away_score INT,
                         PRIMARY KEY (id),
                         FOREIGN KEY (stadium_id) REFERENCES stadium(id)
)DEFAULT CHARSET=utf8;

CREATE TABLE team(
                     id INT NOT NULL AUTO_INCREMENT,
                     region_name VARCHAR(10) ,
                     team_name VARCHAR(40) ,
                     e_team_name VARCHAR(50) ,
                     orig_yyyy VARCHAR(10) ,
                     zip_code1 VARCHAR(10) ,
                     zip_code2 VARCHAR(10) ,
                     address VARCHAR(80) ,
                     ddd VARCHAR(10) ,
                     tel VARCHAR(10) ,
                     fax VARCHAR(10) ,
                     homepage VARCHAR(50) ,
                     owner VARCHAR(10) ,
                     stadium_id INT ,
                     PRIMARY KEY (id),
                     FOREIGN KEY (stadium_id) REFERENCES stadium(id)
)DEFAULT CHARSET=utf8;

CREATE TABLE player(
                       id INT NOT NULL AUTO_INCREMENT,
                       player_name VARCHAR(20),
                       e_player_name VARCHAR(40),
                       nickname VARCHAR(30),
                       join_yyyy VARCHAR(10),
                       position VARCHAR(10),
                       back_no INT,
                       nation VARCHAR(20),
                       brith_date DATE,
                       solar VARCHAR(10),
                       height INT,
                       weight INT,
                       team_id INT,
                       PRIMARY KEY (id),
                       FOREIGN KEY (team_id) REFERENCES team(id)
)DEFAULT CHARSET=utf8;