package fa.nfa;

import fa.State;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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

        if (!states.contains(from)) {
            throw new IllegalArgumentException("State not found: " + from);
        }

        //Retrieve Transitions Available From 'from'
        Map<Character, Set<NFAState>> transitions = from.getTransitions();

        //Retrieve Possible Transitions
        Set<NFAState> result = transitions.get(onSymb);

        if (result == null) {
            return Set.of();
        }

        return result;
    }

    @Override
    public Set<NFAState> eClosure(NFAState s) {

        //State doesnt exist
        if (!states.contains(s)) {
            throw new IllegalArgumentException("State not found: " + s);
        }

        //Instantiate stack
        Stack<NFAState> stack = new Stack<>();
        stack.push(s);

        //Instantiate eClosure
        Set<NFAState> result = new HashSet<>();

        Set<NFAState> explored = new HashSet<>();
        while  (!stack.isEmpty()) {

            NFAState current = stack.pop();
            result.add(current);
            explored.add(current);

            //Explore Set Of States Reachable From Current
            for (NFAState next : getToState(current, 'e')) {

                //Add Unexplored States To The Stack
                if (!explored.contains(next)) {
                    stack.push(next);
                }
            }

        }
        return result;
    }

    @Override
    public int maxCopies(String s) {
        return 0;
    }

    @Override
    public boolean addTransition(String fromState, Set<String> toStates, char onSymb) {

        //If character doesn't exist in alphabet
        if (!sigma.contains(onSymb) && onSymb != 'e') {
            return false;
        }

        NFAState fState = null;

        //Get fromState
        for (NFAState state : states) {
            if (state.getName().equals(fromState)) {
                fState = state;
                break;
            }
        }
        if (fState == null) {
            return false;
        }

        //Search For State Name In states
        for (String name : toStates) {

            NFAState to = null;
            for (NFAState s : states) {
                if (s.getName().equals(name)) {
                    to = s;
                    break;
                }
            }
            if (to == null) {
                return false;
            }

            // Add the transition
            fState.addTransition(onSymb, to);
        }

        return true;
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
                return true;
            }
        }

        // state doesn't exist
        return false;
    }

    @Override
    public void addSigma(char symbol) {
        if (symbol != 'e') {
            sigma.add(symbol);
        }
    }

    @Override
    public boolean accepts(String s) {

        if (sigma.isEmpty()) {
            return false;
        }

        if (sigma.contains(s)) {
            return true;
        }

        return false;
    }

    @Override
    public Set<Character> getSigma() {
        return sigma;
    }

    @Override
    public NFAState getState(String name) {

        for (NFAState s : states) {
            if (s.getName().equals(name)) {
                return s;
            }
        }

        return null;
    }

    @Override
    public boolean isFinal(String name) {

        //Loop Through
        for (NFAState s : finalStates) {
            if (name.equals(s.getName())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isStart(String name) {

        if (startState == null) {
            return false;
        }

        if (name.equals(startState.getName())) {
            return true;
        }
        return false;
    }
}
