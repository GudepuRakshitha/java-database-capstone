# Database Schema Design

### Table: Users
- id (INT, PK, AI)
- username (VARCHAR)
- password (VARCHAR)
- role (ENUM: 'ADMIN', 'DOCTOR', 'PATIENT')

### Table: Doctors
- id (INT, PK)
- name (VARCHAR)
- specialty (VARCHAR)
- email (VARCHAR)

### Table: Patients
- id (INT, PK)
- name (VARCHAR)
- dob (DATE)
- phone (VARCHAR)

### Table: Appointments
- id (INT, PK)
- doctor_id (FK)
- patient_id (FK)
- appointment_time (DATETIME)
- status (VARCHAR)