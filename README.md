
# uni-java-exercises

## Project overview

This repository contains a set of small Java exercises (originally authored for BlueJ) used for learning basic algorithms, data structures and small program architecture. Each exercise is contained in its own folder under `exercises/` and is self-contained: source files, BlueJ metadata and short notes (where available).

The exercises include simple linked-list implementations, the N-Queens problem, a bottom-up LIS implementation, a 15-puzzle project, and a Huffman coding example among others. The codebase is intended for learning and experimenting, not production use.

## Repository layout

- `exercises/` — top-level folder containing numbered exercise folders (`es_1` .. `es_8`).
	- `es_1/` — simple string list (`StringSList`) and a starter driver.
	- `es_2/` — integer list (`IntSList`) and a `RoundTable` example with a test driver.
	- `es_3/` — N-Queens solver with `Board` and helper list utilities.
	- `es_4/` — another N-Queens variant and an `SList` implementation; includes a `queens/` subfolder.
	- `es_5/` — small single-file exercise (es5.java).
	- `es_6/` — `BottomUpLIS` implementation (dynamic programming example).
	- `es_7/` — 15-puzzle implementation (`puzzle15` and `View`) and generated Javadoc in `doc/`.
	- `es_8/` — Huffman coding implementation with `Node`, `NodeQueue`, `NodeStack` and sample inputs `C.txt`/`D.txt`.

Each `es_*` folder now includes a `README.md` that explains the files inside, how to compile/run them and testing tips. Open the folder and read that file for exercise-specific guidance.

## Quick start — compile & run (WSL / Linux / macOS style)

Open a terminal (WSL is fine on Windows) and change into the exercise folder you want to run. For example, to work on `es_3`:

```bash
cd exercises/es_3
```

Compile all Java files in that folder:

```bash
javac *.java
```

Run the driver (replace `MainClass` with the public class that contains `main`, usually the filename without `.java`):

```bash
java MainClass
```

Examples
- If `Queens.java` is the driver in `es_3`, run:

```bash
java Queens
```
- For the Huffman example in `es_8`, the program may accept a filename argument. Try:

```bash
cd exercises/es_8
javac *.java
java Huffman C.txt
```

If you see compilation errors about package declarations, open the `.java` files and either adjust the `package` lines to match directories or remove the `package` line for quick command-line compilation.

## BlueJ notes

These exercises were originally created in BlueJ and include `.ctxt` and `package.bluej` files. To use BlueJ:

1. Open BlueJ and choose `Open Project` → select an `es_*` folder.
2. BlueJ will show classes visually and allow running `main` methods or calling individual methods interactively.

BlueJ is convenient for stepping through small programs and inspecting object state during execution.