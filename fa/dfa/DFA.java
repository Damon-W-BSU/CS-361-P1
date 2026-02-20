package fa.dfa;

import fa.State;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFA implements DFAInterface {

    //Storing States
    final private Set<State> states;
    final private Set<Character> sigma;
    private State startState;
    final private Set<State> finalStates;
    final private Map<State, Map<Character, State>> transitions;

    public DFA() { // Alex
        states = new HashSet<>();
        sigma = new HashSet<>();
        startState = null;
        finalStates = new HashSet<>();
        transitions = new HashMap<>();
    }

    @Override // Alex
    public boolean addState(String name) {

        //Verify It Doesnt Already Exist
        for (State s : states){
            if (s.getName().equals(name)){
                return false;
            }
        }

        //Add New State
        State newState = new DFAState(name);
        states.add(newState);
        //Add Transition
        transitions.put(newState, new HashMap<>());
        return true;
    }

    @Override // Alex
    public boolean setFinal(String name) {

        //Verify State Exists
        for (State s : states){
            if (s.getName().equals(name)){
                //Set End State
                finalStates.add(s);
                return true;
            }
        }

        return false;
    }

    @Override // Alex
    public boolean setStart(String name) {

        //Verify State Exists
        for (State s : states){
            if (s.getName().equals(name)){
                //Set Start State
                startState = s;
                return true;
            }
        }

        return false;
    }

    @Override // Alex
    public void addSigma(char symbol) {
        sigma.add(symbol);
    }

    @Override // Damon
    public boolean accepts(String s) {

        // begin at start state
        State currentState = startState;

        for (int i = 0; i < s.length() - 1; i++) {

            char currentChar = s.charAt(i);

            // checks for valid char
            if (!sigma.contains(currentChar)) {
                return false;
            }

            // find transition for current char
            Map <Character, State> stateTransitions = transitions.get(currentState);
            if (stateTransitions == null) {
                return false;
            }
            State nextState = stateTransitions.get(currentChar);

            // check for valid transition
            if (nextState != null) {
                currentState = nextState;
            } else {
                return false;
            }

        }

        // check for final state>
        return finalStates.contains(currentState);

    }

    @Override
    public Set<Character> getSigma() {

        return sigma;
    }

    @Override
    public State getState(String name) {

        //Look For State
        for (State s : states){
            if (s.getName().equals(name)){
                return s;
            }
        }

        return null;
    }

    @Override // Damon
    public boolean isFinal(String name) {

        State s =  new DFAState(name);
        return finalStates.contains(s);

    }

    @Override // Damon
    public boolean isStart(String name) {

        State s = new DFAState(name);
        return startState.getName().equals(s.getName());

    }

    //AI Used HERE
    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) {

        State from = getState(fromState);
        State to = getState(toState);

        if (from == null || to == null) return false;
        if (!sigma.contains(onSymb)) return false;

        Map<Character, State> stateTransitions = transitions.get(from);

        if (stateTransitions.containsKey(onSymb)) return false;

        stateTransitions.put(onSymb, to);
        return true;
    }

    @Override // Damon
    public DFA swap(char symb1, char symb2) {
        // TODO: implement
        return null;
    }

    @Override // Damon
    public String toString() {

        StringBuilder sb = new StringBuilder();

        // print states
        sb.append("Q = { ");
        for (State s : states) {
            sb.append(s.getName());
            sb.append(" ");
        }
        sb.append("}\n");

        // print alphabet
        sb.append("Sigma = { ");
        for (char c : sigma) {
            sb.append(c);
            sb.append(" ");
        }
        sb.append("}\n");

        // TODO print delta 

        // print start state and final states
        sb.append("q0 = ");
        sb.append(startState.getName());
        sb.append("\nF = { ");
        for (State s : finalStates) {
            sb.append(s.getName());
            sb.append(" ");
        }
        sb.append("}\n");
        return sb.toString();


    }
}
