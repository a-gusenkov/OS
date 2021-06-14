# OS
## Assignment 1: ##
An operating system’s pid manager is responsible for managing process identifiers. When a process is
first created, it is assigned a unique pid by the pid manager. The pid is returned to the pid manager
when the process completes execution, and the manager may later reassign this pid. Process identifiers
must be unique; no two active processes may have the same pid. The minimum PID value is 300 the maximum 
is 5000. To demonstarte the the availibility of process identifiers a value of 0 at position i indicates
that a process id of value i is available and a value of 1 indicates that the process id is currently in use.

## Assignment 2: ##
A multithreaded program that tests the solution to Assignment#1. Several threads are created – for example, 100 – and each thread will request a pid, sleep for a random period of time, and then release the pid. (Sleeping for a random period approximates the typical pid usage in which a pid is assigned to a new process, the process executes and terminates, and the pid is released on the process’ termination). 

## Assignment 3: ##
A PID manager that allocats a unique process identifier to each process. Modified solution to Assignment 2 by ensuring that the data structure used to represent the availability of process identifiers is safe from race conditions. Used Pthreads mutex locks.

## Assignment 4: ##
The program implements all of the following disk-scheduling algorithms: FCFS, SSTF, SCAN, C-SCAN, LOOK, C-LOOK.
The program services a disk drive with 5,000 cylinders numbered 0-4,999 with a starting position of 100.
