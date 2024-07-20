CREATE DATABASE gym_management;

USE gym_management;

CREATE TABLE Member (
    member_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    contact_number VARCHAR(15),
    email VARCHAR(50),
    membership_type VARCHAR(20)
);

CREATE TABLE Trainer (
    trainer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    contact_number VARCHAR(15),
    email VARCHAR(50),
    speciality VARCHAR(50)
);

CREATE TABLE ClassSchedule (
    schedule_id INT AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(50),
    trainer_id INT,
    day_of_week VARCHAR(10),
    start_time TIME,
    end_time TIME,
    FOREIGN KEY (trainer_id) REFERENCES Trainer(trainer_id)
);
