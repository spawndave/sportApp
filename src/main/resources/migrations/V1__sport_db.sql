CREATE TABLE role (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE user (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      username VARCHAR(50) UNIQUE NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      email VARCHAR(100) UNIQUE NOT NULL,
                      first_name VARCHAR(50) NOT NULL,
                      last_name VARCHAR(50) NOT NULL,
                      role_id BIGINT NOT NULL,
                      date_of_birth DATE,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      FOREIGN KEY (role_id) REFERENCES role(id)
);

CREATE TABLE sport (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       description TEXT,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);







CREATE TABLE training (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          description TEXT,
                          date DATETIME,
                          location VARCHAR(255),
                          coach_id BIGINT NOT NULL,
                          sport_id BIGINT,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                          FOREIGN KEY (coach_id) REFERENCES user(id),
                          FOREIGN KEY (sport_id) REFERENCES sport(id)
                      );

INSERT INTO sport (name, description)
VALUES
    ('Football', 'Team sport played with a spherical ball between two teams of eleven players'),
    ('Basketball', 'Team sport in which two teams, most commonly of five players each, opposing one another on a rectangular court'),
    ('Weightlifting', 'Physical exercises and sports in which people lift weights, often in the form of dumbbells or barbells'),
    ('Kettlebell', 'The sport consists of three main lifts: the snatch, jerk and the long cycle. Jerk and Long Cycle can be performed with one bell or two kettlebells of equal weight. Snatch: A single kettlebell is swung using one hand from between the knees to above the head in a single motion.'),
    ('Swimming', 'Individual or team sport that requires the use of one\'s entire body to move through water');



CREATE TABLE training (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          description TEXT,
                          date DATETIME,
                          location VARCHAR(255),
                          coach_id BIGINT NOT NULL,
                          sport_id BIGINT,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                          FOREIGN KEY (coach_id) REFERENCES user(id) ON DELETE SET NULL,
                          FOREIGN KEY (sport_id) REFERENCES sport(id) ON DELETE SET NULL
                      );

CREATE TABLE training_session (
                                  id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                  training_id BIGINT NOT NULL,
                                  athlete_id BIGINT NOT NULL,
                                  duration INT NOT NULL,
                                  difficulty_level INT,
                                  comments TEXT,
                                  session_date DATETIME NOT NULL,
                                  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                  FOREIGN KEY (training_id) REFERENCES training(id),
                                  FOREIGN KEY (athlete_id) REFERENCES user(id)
 );

CREATE TABLE training_participant (
                                      training_id BIGINT,
                                      athlete_id BIGINT,
                                      PRIMARY KEY (training_id, athlete_id),
                                      FOREIGN KEY (training_id) REFERENCES training(id),
                                      FOREIGN KEY (athlete_id) REFERENCES user(id)
);

CREATE TABLE competition (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             name VARCHAR(255) NOT NULL,
                             description TEXT,
                             date DATETIME NOT NULL,
                             location VARCHAR(255),
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE competition_result (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    competition_id BIGINT NOT NULL,
                                    athlete_id BIGINT NOT NULL,
                                    performance VARCHAR(255) NOT NULL,
                                    points INT,
                                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                    FOREIGN KEY (competition_id) REFERENCES competition(id) ON DELETE CASCADE,
                                    FOREIGN KEY (athlete_id) REFERENCES user(id) ON DELETE CASCADE
);

CREATE TABLE coach_athlete (
                               coach_id BIGINT NOT NULL,
                               athlete_id BIGINT NOT NULL,
                               PRIMARY KEY (coach_id, athlete_id),
                               FOREIGN KEY (coach_id) REFERENCES user(id) ,
                               FOREIGN KEY (athlete_id) REFERENCES user(id)
);

CREATE TABLE athlete_sport (
                               athlete_id BIGINT NOT NULL,
                               sport_id BIGINT NOT NULL,
                               PRIMARY KEY (athlete_id, sport_id),
                               FOREIGN KEY (athlete_id) REFERENCES user(id),
                               FOREIGN KEY (sport_id) REFERENCES sport(id)
);

CREATE TABLE coach (
                         user_id BIGINT NOT NULL PRIMARY KEY,
                         sport_id BIGINT UNIQUE,
                         FOREIGN KEY (user_id) REFERENCES user(id),
                         FOREIGN KEY (sport_id) REFERENCES sport(id)
);

