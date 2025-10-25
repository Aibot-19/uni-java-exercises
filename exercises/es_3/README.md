# Exercise 3 — N-Queens and supporting list utilities

Overview
--------
This exercise contains an implementation of the N-Queens problem together with a small integer list utility. The project demonstrates board modelling, backtracking/search techniques, and basic data structure support.

Files
-----
- `Queens.java` — solver for the N-Queens problem (likely contains the search/backtracking logic and a `main` method to run examples).
- `Board.java` — board representation used by the solver. Methods probably include placement checks, printing and state management.
- `IntSList.java` — integer singly-linked list utility used by the solver or helper code.
- `*.ctxt` and `package.bluej` — BlueJ project metadata.

How to compile and run
----------------------
1. Compile:

   javac *.java

2. Run (if `Queens` is the driver):

   java Queens

Typical experiments
-------------------
- Solve for different board sizes (n = 4, 8, 10). Observe number of solutions and runtime.
- Print board configurations for each solution to verify correctness.

Testing tips
------------
- Validate boundary cases: n=1, n=2 (no solution), n=3 (no solution), and classic n=8.
- Check performance for larger n to observe exponential growth of search time.

BlueJ notes
-----------
Open the folder in BlueJ to step through the backtracking algorithm and inspect `Board` state after each placement.
