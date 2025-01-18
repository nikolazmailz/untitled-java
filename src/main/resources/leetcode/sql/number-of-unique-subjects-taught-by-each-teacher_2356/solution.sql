-- 2356. Number of Unique Subjects Taught by Each Teacher

-- (subject_id, dept_id) is the primary key (combinations of columns with unique values) of this table.
-- Each row in this table indicates that the teacher with teacher_id
-- teaches the subject subject_id in the department dept_id.

-- Write your MySQL query statement below

select teacher_id, count(DISTINCT subject_id) as cnt from Teacher group by teacher_id