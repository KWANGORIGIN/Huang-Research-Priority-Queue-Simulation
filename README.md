# Interactive Evaluations for Enhanced Priority Queues Process

## Team Members:

**Kevin Wang (kvw5270@psu.edu)**
- Software Engineering, Mathematics
- Senior @ Penn State Behrend

## Overall Description
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;This program was developed for Dr. Yuan-Han Huang, of Penn State Behrend, for his research project: ‘Interactive Evaluations for Priority Queues Process’. This program is a simulation of a course scheduling system for a school. The program is simulating a system that implements a priority queue, where students with higher priority than other students can enroll in courses before the lower priority students. Examples of high priority students include athletes, fourth year / senior students, and honor students.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Because high priority students will be able to jump ahead in a queue, lower priority students may have to deal with longer queue times when signing up for a course. However, queue data can be presented to these low priority students in several different ways. For this program, the experiment organizer can select three ways to present queue data to a user: estimated time remaining, the position in a queue, or no information provided. All three ways are set up as timers that need to be set up before the experiment can be run. This is further elaborated in Step 1.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;There are a couple items of note, the first being that the timer is not activated to run until the user attempts to sign up for a third course. Finally, the position in a queue is the same unit of time as a minute. This means that when the user is in position five of the queue, the user has an estimated five minutes remaining before the course can be added to the Shopping Cart.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The courses that are available for the user to select from are hard coded into the system. There are five available to choose from and the user must select a section from all five before they can finish enrolling. The five courses are as follows:
1.	KINES 82: Actions Methods for Stress Management
2.	MATSE 259: Properties and Processing of Engineering Materials
3.	ENGL 202C: Effective Writing: Technical Writing
4.	IE 405: Deterministic Models in Operations Research
5.	CMPSC 121: Introduction to Programming Techniques

Additional Notes:\
•	Code documentation can be found in the apidocs folder by clicking index.html.\
•	Java 8 and above is required to run the jar file
