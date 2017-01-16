drop TABLE books;
CREATE TABLE books
  (
    book_id   INTEGER NOT NULL,
    book_name VARCHAR2(20),
    CONSTRAINT books_pk PRIMARY KEY(book_id)
  );
  
drop table courses;
CREATE TABLE courses
  (
    course_id   NUMBER(10),
    course_name VARCHAR2(20),
    CONSTRAINT course_pk PRIMARY KEY(course_id)
  );
  
create table teachers(
teacher_id number(10),
CONSTRAINT teacher_pk PRIMARY KEY(teacher_id)
);