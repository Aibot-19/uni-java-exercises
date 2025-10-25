# Exercise 7 — 15-Puzzle (puzzle15) and UI view

Overview
--------
This exercise contains a 15-puzzle implementation and a `View` class. The presence of a `doc/` directory indicates documentation was generated (Javadoc) and there may be an interactive GUI or console-based view.

Files
-----
- `puzzle15.java` — core logic for the 15-puzzle sliding-tile game (game state, moves, solver or shuffle routines).
- `View.java` — user interface or display helper (likely constructs the visual board or console output).
- `doc/` — generated Javadoc and supplemental documentation (HTML files). Useful to inspect API documentation offline.
- BlueJ metadata files are also present.

How to compile and run
----------------------
1. Compile all java files:

   javac *.java

2. Run the driver: (replace `puzzle15` with the public class containing `main` if different)

   java puzzle15

Notes about `doc/`
------------------
Open `doc/index.html` or `doc/puzzle15.html` in a browser to view the Javadoc generated for the project. This contains class summaries, method signatures, and other helpful hints.

Testing and usage
-----------------
- If the project contains an interactive UI, try moving tiles with the keyboard or mouse and use shuffle/solve commands if implemented.
- If only a solver is present, test with different scrambled boards and verify solution sequences.

BlueJ notes
-----------
Open the folder in BlueJ to visually run `View` and step through UI code. The `doc/` folder can help to explore class-level details.
