package fa.dfa;

import java.util.HashMap;
import java.util.Map;

public class DFAState extends fa.State {

    final private Map<Character, DFAState> transitions;

    public DFAState(String name) {
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
    public boolean addTransition(char onSymb, DFAState nextState) {

        if (transitions.containsKey(onSymb)) {
            return false;
        }

        transitions.put(onSymb, nextState);
        return true;
    }

    /**
     * returns the transition for
     * the onSymb char, or NULL
     * if one doesn't exist
     * 
     * @param onSymb
     * @return 
     */
    public DFAState transitionFor(char onSymb) {
        return transitions.get(onSymb);
    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append(getName());

        transitions.forEach(((onSymb, state) -> {

            String next = "\t" + onSymb + " " + state.getName() + "\n";
            sb.append(next);

        }));

        return sb.toString();
    }

}
    