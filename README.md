# tests

My assumptions:
1. You are testing that I can solve simple problems quickly and don't want to see extensive JUnit / pytests.
2. You will be testing this on some flavor of Linux.
3. You have access to Java 8 / Python 2.7

Additional Information:

Tests 1 and 2:
- Java source is in 'src/', class files are compiled to 'bin/'.
- You can modify the graph being tested by editing 'src/test/TestData.java'.

Test 3:
- Python source is in 'py/test_3.py'.
- You can modify the data file by editing 'py/test_data.txt'.
- For the purposes of this test, words are any string of characters delimited by whitespace ('\n' '\t', ' ').

Steps to run:
```
> git clone git@github.com:htryppcook/tests.git .
> cd tests/
> ./run_all
```

Expected output:
```
====
Test 1
Graph: 
A
├─B
│ ├─E
│ └─F
├─C
│ ├─G
│ ├─H
│ └─I
└─D
│ └─J
walkGraph(A) = (A, B, E, F, C, G, H, I, D, J)
=====
Test 2
Graph: 
A
├─B
│ ├─E
│ └─F
├─C
│ ├─G
│ ├─H
│ └─I
└─D
│ └─J
paths(A) = ( (A, B, E) (A, B, F) (A, C, G) (A, C, H) (A, C, I) (A, D, J)  )
=====
Test 3
17 a
8 that
9 of
8 energy
6 to
2 com
9 in
14 the
6 come
8 you
=====
```

Individual test scripts are also available:
```
> ./run_1
> ./run_2
> ./run_3
```
