# Exercise 1 — Simple lists and starter program

Overview
--------
This exercise contains a small starter program and a simple singly-linked list implementation for strings. It is intended to introduce basic Java programming, BlueJ project layout, and working with minimal data structures.

Files
-----
- `es_1.java` — main/exercise driver (exercise entry point). Compile and run this file to execute the example program.
- `StringSList.java` — simple singly-linked list implementation for `String` values. Typical methods: insert, delete, traversal/print.
- `es_1.ctxt`, `StringSList.ctxt`, `package.bluej` — BlueJ project/context files useful when opening the project in BlueJ.

How to compile and run (command-line)
------------------------------------
1. Open a terminal in this folder.
2. Compile:

   javac *.java

3. Run (replace `es_1` with the public class containing `main` if different):

   java es_1

BlueJ notes
-----------
Open the folder in BlueJ if you want the interactive environment. The `.ctxt` and `package.bluej` files restore the original BlueJ layout.

Testing tips
------------
- Test list operations on empty lists, single-element lists and lists with multiple elements.
- Print the list after each modification to verify correct behaviour.

Edge cases to check
-------------------
- Removing from an empty list
- Inserting null or empty strings (if code allows)
- Proper handling of head/tail when list size changes
