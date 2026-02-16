package fa.dfa;

import fa.FAInterface;
import fa.State;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFA implements DFAInterface {

    //Different State Types
    enum StateType {
        START,
        INTERMEDIATE,
        FINAL
    }

    //Storing States
    Map<String, StateType> StateMap = new HashMap<String, StateType>();

    //Storing Sigma
    HashSet<Character> Sigma = new HashSet<>();

    @Override
    public boolean addState(String name) {
        if (StateMap.containsKey(name)) {
            return false;
        }

        //Default State Type Is Intermediate
        StateMap.put(name, StateType.INTERMEDIATE);
        return true;
    }

    @Override
    public boolean setFinal(String name) {

        //If State Is Found It Will Be Updated To Final
        if (StateMap.containsKey(name)) {
            StateMap.put(name, StateType.FINAL);
            return true;
        }

        return false;
    }

    @Override
    public boolean setStart(String name) {

        //If State Is Found It Will Be Updated To Start
        if (StateMap.containsKey(name)) {
            StateMap.put(name, StateType.START);
            return true;
        }
        return false;
    }

    @Override
    public void addSigma(char symbol) {
        Sigma.add(symbol);
    }

    @Override
    public boolean accepts(String s) {
        // TODO: implement
        return false;
    }

    @Override
    public Set<Character> getSigma() {

        //If Sigma Contains Elements Then Return Alphabet
        if (!Sigma.isEmpty()){
            return Sigma;
        }

        return null;
    }

    @Override
    public State getState(String name) {

        //If State Exists Then Return State
//        if (StateMap.containsKey(name)) {
//            StateType State = StateMap.get(name);
//            return State;
//        }
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
