# PDC Lab Task 6

Name: Muhammad Arqam
Registration Number: 247107
Course: Parallel and Distributed Computing Lab
Course Code: CS-465L

This lab demonstrates HashMap, synchronizedMap, and ConcurrentHashMap.
## Question 1: HashMap

StudentMarks.java stores five students and their marks. It displays all
records, updates one student's marks, retrieves a specific student's marks,
and displays the total number of students.

## Question 2: Synchronized Map

SynchronizedStudentMap.java wraps a HashMap using
Collections.synchronizedMap(). Three tasks insert 100 unique records each.
shutdown() stops new submissions, and awaitTermination() waits for completion.
Expected and actual entries should both be 300.

## Question 3: ConcurrentHashMap

ConcurrentStudentMap.java uses five tasks to insert 1,000 unique records each.
It retrieves and verifies all 5,000 records and measures execution time in
milliseconds. ConcurrentHashMap supports concurrent reads and updates.

## Running the programs

javac Q1/StudentMarks.java
java -cp Q1 StudentMarks

javac Q2/SynchronizedStudentMap.java
java -cp Q2 SynchronizedStudentMap

javac Q3/ConcurrentStudentMap.java
java -cp Q3 ConcurrentStudentMap

## Timing

Q3 measures executor creation, task submission, insertion, waiting, and
retrieval/verification. Console printing is outside the measured interval.
Results vary with hardware, operating system scheduling, background work,
and JVM behaviour.

## Branches

main: initial project setup
lab-task-6: complete integrated lab
q1-student-marks: Question 1 implementation
q2-synchronized-map: Question 2 implementation
q3-concurrent-map: Question 3 implementation