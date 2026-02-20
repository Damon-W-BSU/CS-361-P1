package fa.dfa;

import fa.State;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DFA implements DFAInterface {

    //Storing States
    final private Set<DFAState> states;
    final private Set<Character> sigma;
    private DFAState startState;
    final private Set<DFAState> finalStates;
    final private Map<State, Map<Character, DFAState>> transitions;

    public DFA() { // Alex
        states = new LinkedHashSet<>();
        sigma = new LinkedHashSet<>();
        startState = null;
        finalStates = new LinkedHashSet<>();
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
        sb.append("Q = {");
        // AI used for following line combining set elements
        sb.append(states.stream().map(State::getName).collect(Collectors.joining(" ")));
        sb.append("}\n");


        // print alphabet
        sb.append("Sigma = {");
        sb.append(sigma.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        sb.append("}\n");

        // print delta
        sb.append("delta = \n ");
        for (char c : sigma) {
            sb.append("\t").append(c);
        }
        sb.append("\n");
        for (DFAState s : states) {
            sb.append(s.getName());
            for (char c : sigma) {
                sb.append("\t").append(s.transitionFor(c).getName());
            }
            sb.append("\n");
        }

        // print start state and final states
        sb.append("q0 = ").append(startState.getName()).append("\n");
        sb.append("F = {");
        sb.append(finalStates.stream().map(State::getName).collect(Collectors.joining(" ")));
        sb.append("}\n");
        return sb.toString();



    }
}
