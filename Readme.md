# Gym Membership Management System

## Overview
The Gym Management System is a console-based application developed in Java to manage gym members, trainers, and class schedules. This application uses MySQL for data storage and JDBC for database interactions.

## Functionalities
1. **Member Management:**
    - Add a new member
    - View member details
    - Update member information
    - Delete a member

2. **Trainer Management:**
    - Add a new trainer
    - View trainer details
    - Update trainer information
    - Delete a trainer

3. **Class Schedule Management:**
    - Create new class schedules
    - View class Schedules
    - Update class information
    - Cancel Classes

## Database Schema

The application uses three main tables: Member, Trainer, and ClassSchedule.

**Member Table - ( member_id (Primary Key), name, contact_number, email, membership_type )**

**Trainer Table - ( trainer_id (Primary Key), name, contact_number, email, speciality )**

**Class Schedule Table - ( schedule_id (Primary Key), class_name, trainer_id (Foreign Key references Trainer Table), day_of_week, start_time, end_time )**


## Requirements
1. Java Development Kit (JDK) 8 or higher
2. MySQL Database
3. JDBC Driver for MySQL

## Project Setup
1. Clone the repository or download the project files.
2. Open the project in your preferred Java IDE.
3. Add the JDBC driver to the project's build path.
4. Update the DatabaseUtil.java file with your MySQL database credentials: