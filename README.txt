****************
* Project 2: Nondeterministic Finite Automata
* CS 361
* 3/30/26
* Damon Wargo, Alex Ramirez-Robles
**************** 


OVERVIEW:


NFA.java models a Nondeterministic Finite Automaton


INCLUDED FILES:

* fa.dfa.NFA.java          java source file
* fa.dfa.NFAState.java     java source file
* README.txt               this file


COMPILING AND RUNNING:

to compile test.dfa.NFATest on onyx from the top directory:
$ javac -cp .:/usr/share/java/junit.jar ./test/nfa/NFATest.java

to run test.dfa.NFAtest on onyx:
$ java -cp .:/usr/share/java/junit.jar:/usr/share/java/hamcrest/hamcrest.jar
org.junit.runner.JUnitCore test.dfa.NFATest

PROGRAM DESIGN AND IMPORTANT CONCEPTS:

NFA.java models a nondeterministic finite automaton containing a set of
characters that represent an alphabet, a set of states, and a map
of the transitions between states. States are tracked using 
named NFAState objects.

The start/final/intermediate states, characters, and transitions are all added 
manually using methods within NFA. Once transitions are in place, the DFA can
read strings using the accepts() method, which will determine whether the string 
is a valid for that NFA. A string representation of the NFA's 5-tuple can
be viewed with the toString() method. 

It's worth noting that out implementation has transitions tracked both within
the NFA and in NFAState objects. By storing the possible transitions within the
DFAState, it was easy to streamline the accepts() and swap() methods.

TESTING:

Aside from the included Junit tests, testing was done locally using mainly
the toString() methods for NFA and NFAState. Running a local main class with
a simple NFA was sufficient for the info needed to pass Junit tests.

example tests looked like:

NFA nfa = new NFA();

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



Alex:
 


SOURCES:

