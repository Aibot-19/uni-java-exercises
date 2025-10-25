# Exercise 8 — Huffman coding and node utilities

Overview
--------
This exercise implements Huffman coding (a lossless compression algorithm) and includes several small utility classes for nodes and queues/stacks. There are also sample input files (`C.txt`, `D.txt`) which likely contain test data or sample messages to compress/decompress.

Files
-----
- `Huffman.java` — main Huffman compressor/decompressor implementation. Look for methods to build frequency tables, construct the Huffman tree, generate codes, compress and decompress data.
- `Node.java` — node type used by the Huffman tree.
- `NodeQueue.java` / `NodeStack.java` — helper data structures used during tree construction or traversal.
- `C.txt`, `D.txt` — sample input data (text files) to test compression and decompression.
- `.ctxt`, `package.bluej`, `README.TXT` — BlueJ metadata and original README.

How to compile and run
----------------------
1. Compile:

   javac *.java

2. Run the Huffman program (replace `Huffman` with the public class if different):

   java Huffman

Typical workflow
----------------
1. Inspect `Huffman.java` to see how it expects input (stdin, file name argument, or hard-coded sample files).
2. If it reads a filename, run: `java Huffman C.txt` or `java Huffman D.txt`.
3. Check output files or console output for generated codes, compressed bitstreams or decompressed text.

Testing tips
------------
- Compare original file size vs compressed output size to validate compression.
- Verify round-trip correctness: compress then decompress and compare output to original.
- Test with simple inputs where expected Huffman codes are easy to reason about (e.g., small alphabets with different frequencies).

Edge cases
----------
- Empty input files
- Input with a single repeated symbol
- Inputs with uniform frequency (no gain expected)

BlueJ notes
-----------
Open the project in BlueJ to step through tree construction and code generation. The sample `.txt` files are useful to run quick tests from the IDE.
