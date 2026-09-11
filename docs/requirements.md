# School Management System --- Requirements Document

**Project Name:** School Management System\
**Document:** Software Requirements Specification (SRS) --- Starter
Version\
**Status:** Initial\
**Repository:** `school-management-system`

------------------------------------------------------------------------

## 1. Project Overview

The School Management System is a centralized application designed to
digitize and simplify common school-management activities.

The system will consist of:

-   An Android application for users.
-   A Spring Boot backend that provides business logic and REST APIs.
-   A relational database for storing school data.
-   Project documentation and database design maintained in the
    repository.

The system is intended to provide a single, organized platform for
managing students, teachers, attendance, academics, fees, notices, and
other school-related information.

------------------------------------------------------------------------

## 2. Problem Statement

Many schools still depend on paper records, spreadsheets, messaging
applications, or multiple disconnected systems to manage daily academic
and administrative activities.

This can lead to:

-   Duplicate or inconsistent data.
-   Difficulty maintaining student records.
-   Manual attendance management.
-   Slow communication between the school and students/parents.
-   Difficulty tracking fees and academic performance.
-   Limited access to information.
-   Increased administrative workload.

The proposed system will provide a centralized digital platform where
authorized users can access and manage school information according to
their roles.

------------------------------------------------------------------------

## 3. Project Goals

The primary goals are:

1.  Centralize school information in one system.
2.  Reduce manual administrative work.
3.  Provide reliable student records.
4.  Digitize attendance and academic records.
5.  Improve communication between the school and students/parents.
6.  Provide secure, role-based access to information.
7.  Build a maintainable backend and Android application.
8.  Keep the initial system practical and affordable to operate.

------------------------------------------------------------------------

## 4. Target Users

The system is expected to support the following roles:

### 4.1 Administrator

The administrator manages the overall school system.

Responsibilities may include:

-   Managing students.
-   Managing teachers and staff.
-   Managing classes and sections.
-   Managing subjects.
-   Managing school-wide notices.
-   Managing fees.
-   Managing academic information.
-   Managing user access and permissions.

### 4.2 Teacher

Teachers use the system for academic and classroom activities.

Responsibilities may include:

-   Viewing assigned classes.
-   Viewing student information relevant to their classes.
-   Recording attendance.
-   Entering marks/results.
-   Viewing academic information.
-   Sending or viewing relevant notices.

### 4.3 Student / Parent Account

The project will use a combined student-facing account rather than
maintaining a completely separate parent account.

This is intended to support situations where a younger student may not
have their own phone. The student's account can therefore be used by the
student and/or parent/guardian.

Possible capabilities include:

-   Viewing student information.
-   Viewing attendance.
-   Viewing marks/results.
-   Viewing notices.
-   Viewing fee information.
-   Receiving school communication.

Access to information must still be controlled by permissions and
authentication.

------------------------------------------------------------------------

## 5. Functional Requirements

### FR-01: Authentication

The system shall provide secure authentication for authorized users.

The system should support:

-   Login.
-   Logout/session handling.
-   Password or credential management.
-   Role-based authorization.
-   Protection of authenticated APIs.

------------------------------------------------------------------------

### FR-02: Student Management

Authorized users shall be able to manage student records.

Student information may include:

-   Student ID.
-   Name.
-   Date of birth.
-   Gender.
-   Contact information.
-   Address.
-   Admission information.
-   Class.
-   Section.
-   Academic status.
-   Other required school information.

The system should prevent duplicate student identifiers.

------------------------------------------------------------------------

### FR-03: Teacher and Staff Management

Authorized administrators shall be able to manage teacher/staff records.

Information may include:

-   Employee/teacher ID.
-   Name.
-   Contact information.
-   Assigned subjects.
-   Assigned classes/sections.
-   Employment-related information required by the school.

------------------------------------------------------------------------

### FR-04: Class and Section Management

The system shall support management of:

-   Classes/grades.
-   Sections.
-   Academic sessions/years.
-   Student-to-class assignments.
-   Teacher-to-class assignments.

------------------------------------------------------------------------

### FR-05: Subject Management

The system shall support:

-   Creating subjects.
-   Updating subjects.
-   Assigning subjects to classes.
-   Assigning teachers to subjects where required.

------------------------------------------------------------------------

### FR-06: Attendance Management

Authorized teachers shall be able to record student attendance.

The system should support:

-   Daily attendance.
-   Present/absent status.
-   Attendance history.
-   Attendance summaries.
-   Viewing attendance by student.
-   Viewing attendance for a class/section.

Students/parents should be able to view permitted attendance
information.

------------------------------------------------------------------------

### FR-07: Examination and Marks Management

The system shall support academic assessment information.

Possible functionality includes:

-   Creating examinations.
-   Defining subjects for an examination.
-   Entering marks.
-   Updating marks.
-   Viewing student results.
-   Calculating totals/percentages where applicable.
-   Maintaining examination history.

------------------------------------------------------------------------

### FR-08: Fee Management

The system shall support school fee information.

Possible functionality includes:

-   Defining fee types.
-   Recording fees assigned to students.
-   Recording payments.
-   Tracking pending amounts.
-   Viewing payment history.
-   Generating fee summaries.

------------------------------------------------------------------------

### FR-09: Notice and Announcement Management

Authorized users shall be able to publish school notices.

Notices may include:

-   Title.
-   Description.
-   Date/time.
-   Target audience.
-   Optional attachment/reference.

Users should only receive or view notices relevant to their permissions.

------------------------------------------------------------------------

### FR-10: Student Information Access

Students/parents shall be able to view information they are authorized
to access, such as:

-   Profile information.
-   Class and section.
-   Attendance.
-   Marks/results.
-   Fee status.
-   Notices.

------------------------------------------------------------------------

### FR-11: Search and Filtering

Where appropriate, administrators and teachers should be able to search
and filter records.

Examples:

-   Search student by ID/name.
-   Filter students by class/section.
-   Filter attendance by date.
-   Filter results by examination.

------------------------------------------------------------------------

### FR-12: Data Validation

The backend shall validate incoming data before storing it.

Examples include:

-   Required fields.
-   Valid identifiers.
-   Valid dates.
-   Valid numeric values.
-   Valid relationships between records.

Invalid requests should return clear error responses.

------------------------------------------------------------------------

### FR-13: Authorization

The system shall enforce role-based permissions.

For example:

-   A teacher should not be able to perform administrator-only
    operations.
-   A student/parent account should not be able to modify protected
    school records.
-   Users should only access data permitted for their role and
    relationships.

Authorization must be enforced on the backend, not only in the Android
application.

------------------------------------------------------------------------

## 6. Non-Functional Requirements

### NFR-01: Security

The system should:

-   Protect user credentials.
-   Use secure authentication.
-   Enforce authorization on protected endpoints.
-   Validate and sanitize incoming data.
-   Avoid exposing sensitive information unnecessarily.

------------------------------------------------------------------------

### NFR-02: Performance

The system should provide reasonable response times for normal school
operations and should be designed so that performance can scale as the
number of students and users increases.

------------------------------------------------------------------------

### NFR-03: Reliability

The backend should handle invalid requests and expected failures
gracefully without crashing the application.

------------------------------------------------------------------------

### NFR-04: Maintainability

The backend should follow a clear layered architecture.

The planned Spring Boot structure will separate responsibilities such
as:

-   Controller.
-   Service.
-   Repository.
-   Entity/model.

The Android application should similarly use a maintainable
architecture.

------------------------------------------------------------------------

### NFR-05: Scalability

The system should be designed so that it can support more students,
teachers, classes, and schools in the future without requiring a
complete rewrite.

------------------------------------------------------------------------

### NFR-06: Usability

The Android application should provide a simple interface suitable for
users with different levels of technical experience.

------------------------------------------------------------------------

### NFR-07: Availability

The backend should be deployable to a server/cloud environment so that
authorized users can access the system through the Android application.

------------------------------------------------------------------------

### NFR-08: Data Integrity

Relationships between students, classes, teachers, subjects, attendance,
examinations, marks, and fees must be maintained using appropriate
database constraints and backend validation.

------------------------------------------------------------------------

## 7. Technology Requirements

### Backend

-   Java
-   Spring Boot
-   Spring Web / REST API
-   Spring Data JPA
-   Hibernate
-   Spring Security
-   Maven

### Database

-   MySQL
-   Relational database design
-   JPA/Hibernate for object-relational mapping

### Android

-   Android application
-   Java/Kotlin as selected for the Android implementation
-   REST API communication with the Spring Boot backend

### Development & Version Control

-   Git
-   GitHub
-   IDEs such as IntelliJ IDEA / Android Studio

------------------------------------------------------------------------

## 8. System Architecture

The initial architecture will follow this general flow:

``` text
Android Application
        |
        | HTTP/HTTPS REST API
        v
Spring Boot Backend
        |
        +-- Controller
        |
        +-- Service
        |
        +-- Repository
        |
        v
     MySQL Database
```

The Android application should not connect directly to the MySQL
database.

All business operations and database access should go through the
backend.

------------------------------------------------------------------------

## 9. Data Management Requirements

The database is expected to contain entities for areas such as:

-   Students.
-   Users/accounts.
-   Teachers/staff.
-   Classes.
-   Sections.
-   Subjects.
-   Attendance.
-   Examinations.
-   Marks/results.
-   Fees.
-   Payments.
-   Notices.

The exact entities and relationships will be finalized in the database
design and ER diagram.

------------------------------------------------------------------------

## 10. API Requirements

The backend will expose REST APIs for the Android application.

API requirements include:

-   Consistent URL structure.
-   Appropriate HTTP methods.
-   JSON request/response format.
-   Authentication for protected operations.
-   Authorization based on user role.
-   Input validation.
-   Consistent error responses.
-   Appropriate HTTP status codes.

Detailed endpoints will be documented in `api-documentation.md` as
development progresses.

------------------------------------------------------------------------

## 11. Security and Privacy Principles

Because the system will contain student and school information:

1.  Only authorized users should access protected data.
2.  Passwords must never be stored in plain text.
3.  Sensitive information should not be unnecessarily returned by APIs.
4.  Authorization checks must be performed server-side.
5.  Database credentials and secrets must not be committed to Git.
6.  Production communication should use HTTPS.
7.  Access to student records should follow the user's role and
    permissions.

------------------------------------------------------------------------

## 12. Project Scope

### Included in the Initial Scope

-   User authentication and authorization.
-   Student management.
-   Teacher/staff management.
-   Class and section management.
-   Subject management.
-   Attendance.
-   Examinations and marks.
-   Fee information.
-   Notices/announcements.
-   Android client.
-   Spring Boot REST backend.
-   MySQL database.

### Future / Optional Features

These may be added after the core system is stable:

-   Push notifications.
-   Online fee payments.
-   Homework/assignments.
-   Timetable management.
-   Report-card generation.
-   Digital documents.
-   Transport management.
-   Library management.
-   Advanced analytics.
-   Multiple-school/tenant support.

------------------------------------------------------------------------

## 13. Development Priorities

Development should proceed in the following order:

1.  Project and repository setup.
2.  Database design and ER diagram.
3.  Spring Boot project configuration.
4.  Database connection.
5.  User and authentication system.
6.  Student management.
7.  Class/section/subject management.
8.  Attendance.
9.  Examinations and marks.
10. Fees.
11. Notices.
12. Android integration.
13. Testing.
14. Deployment.

The exact order may be adjusted as implementation reveals dependencies.

------------------------------------------------------------------------

## 14. Acceptance Criteria for the Initial System

The initial system will be considered functional when:

-   The Spring Boot backend starts successfully.
-   The backend connects to MySQL.
-   Database entities can be persisted and retrieved.
-   Authentication works for supported users.
-   Role-based authorization prevents unauthorized operations.
-   Core student/class/teacher data can be managed through APIs.
-   Attendance and academic records can be stored and retrieved.
-   Fee and notice information can be managed.
-   The Android application can communicate with the backend.
-   Invalid requests produce appropriate error responses.
-   The project can be cloned and set up using the documented
    instructions.

------------------------------------------------------------------------

## 15. Document Status

This is the **starter requirements document**. It is intentionally
designed to evolve during development.

When a major feature or design decision changes, this document should be
updated so that the repository remains the source of truth for project
requirements.
