# Exercise 4 — N-Queens variant and SList

Overview
--------
This folder appears to contain another implementation of the N-Queens problem and a generic singly-linked list (`SList`). It may be a variant or a refactor of the solver in `es_3` and is useful to compare implementations.

Files
-----
- `Queens.java` — N-Queens solver (variant). Inspect this file to find the driver `main` and differences vs `es_3`.
- `Board.java` — board representation used by this solver.
- `SList.java` — a generic or differently-named singly-linked list implementation.
- `queens/` — a subfolder that may contain helper classes or additional versions of the solver.

How to compile and run
----------------------
1. Compile everything in the folder tree:

   javac *.java queens/*.java

2. Run (replace `Queens` with actual driver class if different):

   java Queens

What to explore
----------------
- Compare the `SList` implementation with the `IntSList` from `es_3` to see differences in API and error handling.
- If `queens/` contains multiple solver variants, try each and compare performance on the same `n`.

BlueJ notes
-----------
As before, this folder contains BlueJ metadata. Use BlueJ to run and step through code interactively.
