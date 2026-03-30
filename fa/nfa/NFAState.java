package fa.nfa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NFAState extends fa.State{

    //Set Of Transitions
    final private Map<Character, Set<NFAState>> transitions;

    //Constructor
    public NFAState(String name) {
        super(name);
        transitions = new HashMap<>();
    }

    /**
     * adds a new transition out of this state
     *
     * @param nextState
     * @param onSymb
     * @return true if new transition added
     */
    void addTransition(char onSymb, NFAState nextState) {

        Set<NFAState> stateSet;
        stateSet = transitions.get(onSymb);

        // instantiate if char not in map
        if(stateSet == null) {
            stateSet = new HashSet<>();
            transitions.put(onSymb, stateSet);
        } 
        stateSet.add(nextState);
    }
}
