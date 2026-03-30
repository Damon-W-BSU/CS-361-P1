package fa.nfa;

import java.util.HashMap;
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
    boolean addTransition(char  onSymb, NFAState nextState) {

        if (transitions.containsKey(onSymb)) {
            return false;
        }

        transitions.put(onSymb, nextState);
        return true;
    }
}
