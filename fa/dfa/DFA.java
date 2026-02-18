package fa.dfa;

import fa.State;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class DFA implements DFAInterface {

    //Storing States
    final private Set<State> states;
    final private Set<Character> sigma;
    private State startState;
    final private Set<State> finalStates;
    private Map<State, Map<Character, State>> transitions;

    public DFA() {
        states = new HashSet<State>();
        sigma = new HashSet<>();
        startState = null;
        finalStates = new HashSet<State>();
        transitions = new HashMap<>();
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
    public void addSigma(char symbol) {
        sigma.add(symbol);
    }

    @Override
    public boolean accepts(String s) {
        // TODO: implement
        return false;
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

    @Override
    public boolean isFinal(String name) {
        // TODO: implement
        return false;
    }

    @Override
    public boolean isStart(String name) {
        // TODO: implement
        return false;
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

    @Override
    public DFA swap(char symb1, char symb2) {
        // TODO: implement
        return null;
    }

    @Override
    public String toString() {
        // TODO: implement
        return null;
    }
}
