package fa.dfa;

import fa.State;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFA implements DFAInterface {

    //Storing States
    final private Set<DFAState> states;
    final private Set<Character> sigma;
    private DFAState startState;
    final private Set<DFAState> finalStates;
    final private Map<State, Map<Character, DFAState>> transitions;

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
        DFAState newState = new DFAState(name);
        states.add(newState);
        //Add Transition
        transitions.put(newState, new HashMap<>());
        return true;
    }

    @Override // Alex
    public boolean setFinal(String name) {

        //Verify State Exists
        for (DFAState s : states){
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
        for (DFAState s : states){
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
        DFAState currentState = startState;
        DFAState next;

        for (int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);

            // checks for valid char
            if (!sigma.contains(currentChar)) {
                return false;
            }

            next = currentState.transitionFor(currentChar);
            if (next == null) {
                return false;
            }

            currentState = next;

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

        for (DFAState s : states) {
            if (s.getName().equals(name) && finalStates.contains(s)) {
                return true;
            }
        }

        return false;

    }

    @Override // Damon
    public boolean isStart(String name) {

        for (DFAState s : states) {
            if (s.getName().equals(name) && startState == s) {
                return true;
            }
        }

        return false;

    }

    //AI Used HERE
    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) {

        DFAState from = (DFAState)getState(fromState);
        DFAState to = (DFAState)getState(toState);

        if (from == null || to == null) return false;
        if (!sigma.contains(onSymb)) return false;

        Map<Character, DFAState> stateTransitions = transitions.get(from);
        if (stateTransitions.containsKey(onSymb)) return false;

        // track transition on state
        from.addTransition(onSymb, to);
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
        sb.append("Delta = \n\t \t\n");

        for (State s : states) {

            
        }

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
