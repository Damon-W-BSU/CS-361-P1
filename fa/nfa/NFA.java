package fa.nfa;

import fa.State;
import fa.dfa.DFAState;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NFA implements NFAInterface {

    //Storing States
    final private Set<NFAState> states;
    final private Set<Character> sigma;
    private NFAState startState;
    final private Set<NFAState> finalStates;

    public NFA() {
        startState = null;
        states = new HashSet<>();
        sigma = new HashSet<>();
        finalStates = new HashSet<>();
    }


    @Override
    public Set<NFAState> getToState(NFAState from, char onSymb) {
        return Set.of();
    }

    @Override
    public Set<NFAState> eClosure(NFAState s) {
        return Set.of();
    }

    @Override
    public int maxCopies(String s) {
        return 0;
    }

    @Override
    public boolean addTransition(String fromState, Set<String> toStates, char onSymb) {
        return false;
    }

    @Override
    public boolean isDFA() {
        return false;
    }

    @Override
    public boolean addState(String name) {

        // check if state exists
        for (State s : states) {
            if (s.getName().equals(name)) {
                return false;
            }
        }
        
        // add new state
        NFAState newState = new NFAState(name);
        states.add(newState);
        return true;
    }

    @Override
    public boolean setFinal(String name) {

        // search for state
        for (NFAState s : states) {
            if (s.getName().equals(name)) {

                // add to final states
                finalStates.add(s);
                return true;
            }
        }

        // state doesn't exist
        return false;
    }

    @Override
    public boolean setStart(String name) {

        // find state and set to start
        for (NFAState s : states) {
            if (s.getName().equals(name)) {
                startState = s;
            }
        }

        // state doesn't exist
        return false;
    }

    @Override
    public void addSigma(char symbol) {
        sigma.add(symbol);
    }

    @Override
    public boolean accepts(String s) {
        return false;
    }

    @Override
    public Set<Character> getSigma() {
        return sigma;
    }

    @Override
    public State getState(String name) {
        return null;
    }

    @Override
    public boolean isFinal(String name) {
        return false;
    }

    @Override
    public boolean isStart(String name) {
        return false;
    }
}
