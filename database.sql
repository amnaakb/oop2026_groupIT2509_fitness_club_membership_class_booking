-- MEMBERS TABLE
CREATE TABLE members (
                         id SERIAL PRIMARY KEY,
                         full_name VARCHAR(100) NOT NULL,
                         email VARCHAR(100) UNIQUE NOT NULL,
                         phone VARCHAR(30),
                         membership_type VARCHAR(50),
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- TRAINERS TABLE
CREATE TABLE trainers (
                          id SERIAL PRIMARY KEY,
                          full_name VARCHAR(100) NOT NULL,
                          specialization VARCHAR(100),
                          email VARCHAR(100),
                          phone VARCHAR(30)
);

-- FITNESS CLASSES TABLE
CREATE TABLE fitness_classes (
                                 id SERIAL PRIMARY KEY,
                                 class_name VARCHAR(100) NOT NULL,
                                 description TEXT,
                                 schedule_time TIMESTAMP,
                                 trainer_id INT,
                                 FOREIGN KEY (trainer_id) REFERENCES trainers(id)
);

-- BOOKINGS TABLE
CREATE TABLE bookings (
                          id SERIAL PRIMARY KEY,
                          member_id INT NOT NULL,
                          class_id INT NOT NULL,
                          booking_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          status VARCHAR(50),
                          FOREIGN KEY (member_id) REFERENCES members(id),
                          FOREIGN KEY (class_id) REFERENCES fitness_classes(id)
);
#