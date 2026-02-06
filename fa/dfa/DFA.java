package fa.dfa;

import fa.FAInterface;
import fa.State;

import java.util.Set;

public class DFA implements DFAInterface {

    @Override
    public boolean addState(String name) {
        // TODO: implement
        return false;
    }

    @Override
    public boolean setFinal(String name) {
        // TODO: implement
        return false;
    }

    @Override
    public boolean setStart(String name) {
        // TODO: implement
        return false;
    }

    @Override
    public void addSigma(char symbol) {
        // TODO: implement
    }

    @Override
    public boolean accepts(String s) {
        // TODO: implement
        return false;
    }

    @Override
    public Set<Character> getSigma() {
        // TODO: implement
        return null;
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
