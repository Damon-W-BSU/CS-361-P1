package fa.dfa;

import fa.State;

import java.util.HashSet;
import java.util.Set;

public class DFA implements DFAInterface {

    //Storing States
    final private Set<State> states;
    final private Set<Character> sigma;
    private State startState;
    final private Set<State> finalStates;

    public DFA() {
        states = new HashSet<State>();
        sigma = new HashSet<>();
        startState = null;
        finalStates = new HashSet<State>();

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
        states.add(new DFAState(name));
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
        // TODO: implement
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

    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) {
        // TODO: implement
        return false;
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
