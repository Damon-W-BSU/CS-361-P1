****************
* Project 1: Deterministic Finite Automata
* CS 361
* 2/20/26
* Damon Wargo, Alex Ramirez-Robles
**************** 


OVERVIEW:


DFA.java models a Deterministic Finite Automatan


INCLUDED FILES:

* fa.dfa.DFA.java          java source file
* fa.dfa.DFAState.java     java source file
* README.txt               this file


COMPILING AND RUNNING:

to compile test.dfa.DFATest on onyx from the top directory:
$ javac -cp .:/usr/share/java/junit.jar ./test/dfa/DFATest.java

to run test.dfa.DFAtest on onyx:
$ java -cp .:/usr/share/java/junit.jar:/usr/share/java/hamcrest/hamcrest.jar
org.junit.runner.JUnitCore test.dfa.DFATest

PROGRAM DESIGN AND IMPORTANT CONCEPTS:

DFA.java models a deterministic finite automatan containing a set of 
characters that represent an alphabet, a set of states, and a map
of the transitions between states. States are tracked using 
named DFAState objects. 

The start/final/intermediate states, characters, and transitions are all added 
manually using methods within DFA. Once transitions are in place, the DFA can 
read strings using the accepts() method, which will determine whether the string 
is a valid for that DFA. A string representation of the DFA's 5-tuple can
be viewed with the toString() method. 

It's worth noting that out implementation has transitions tracked both within
the DFA and in DFAState objects. By storing the possible transitions within the
DFAState, it was easy to streamline the accepts() and swap() methods.

TESTING:

Aside from the included Junit tests, testing was done locally using mainly
the toString() methods for DFA and DFAState. Running a local main class with
a simple DFA was sufficient for the info needed to pass Junit tests. 

example tests looked like:

DFA dfa = new DFA();

        dfa.addSigma('0');
        dfa.addSigma('1');

        dfa.addState("a");
        dfa.addState("b");

        dfa.setStart("a");
        dfa.setFinal("b");
        
        dfa.addTransition("a", "b", '1');
        dfa.addTransition("a", "a", '0');
        dfa.addTransition("b", "a", '0');
        dfa.addTransition("b", "b", '1');

        System.out.println(dfa.getState("a").toString());
        System.out.println(dfa.getState("b").toString());
        System.out.println();
        System.out.println(dfa.toString());
        System.out.println(dfa.swap('0', '1').toString());

DISCUSSION:
 
Damon:

I was responsible for DFAState.java, swap(), accepts(), and toString().
I had some struggles with tracking transitions between states for the
accepts() and swap() methods, but I was able to solve my issues by
storing transition information within DFAStates and writing helper methods
within the class. Otherwise I had no major issues. 

Alex:
 
*
*
*
*
*


SOURCES:

Damon: Gemini was used to help format the toString() method for DFA.java

Alex: *