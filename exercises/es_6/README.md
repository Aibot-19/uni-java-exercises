# Exercise 6 — Bottom-up Longest Increasing Subsequence (LIS)

Overview
--------
This exercise contains an implementation named `BottomUpLIS.java` which suggests a dynamic programming (bottom-up) approach to compute the Longest Increasing Subsequence of a sequence of numbers. The code is useful for learning DP tabulation and sequence processing in Java.

Files
-----
- `BottomUpLIS.java` — contains the bottom-up DP implementation. Look for a `main` method or helper methods that compute the LIS length and/or reconstruct a subsequence.
- `package.bluej`, `README.TXT` — BlueJ metadata and original README.

How to compile and run
----------------------
1. Compile:

   javac BottomUpLIS.java

2. Run (if the class with `main` is `BottomUpLIS`):

   java BottomUpLIS

What to test
-----------
- Provide arrays of integers: increasing sequences, decreasing sequences, sequences with repeated values.
- Verify output: LIS length should match expected values (e.g., [1,2,3] -> 3; [3,2,1] -> 1; [1,3,2,4] -> 3).

Performance
-----------
- Bottom-up LIS typically runs in O(n^2) time for the classical DP method. If the implementation uses a patience-sorting / binary-search approach, it may be O(n log n). Inspect the code to confirm which approach is used.

BlueJ notes
-----------
Use BlueJ to run small input cases step-by-step and inspect intermediate DP tables.
