package fa.dfa;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Damon Wargo, Alex Ramirez-Robles
 */
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
    protected boolean addTransition(char onSymb, DFAState nextState) {

        if (transitions.containsKey(onSymb)) {
            return false;
        }

        transitions.put(onSymb, nextState);
        return true;
    }

    /**
     * swaps the transitions of two chars
     * in the DFAState
     * 
     * @param symb1
     * @param symb2
     * @return
     */
    protected boolean swapTransition(char symb1, char symb2) {

        if (!(transitions.containsKey(symb1) && transitions.containsKey(symb2))) {
            return false;
        }

        DFAState temp = transitionFor(symb1);
        transitions.replace(symb1, transitions.get(symb2));
        transitions.replace(symb2, temp);
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
    protected DFAState transitionFor(char onSymb) {
        return transitions.get(onSymb);
    }

    /**
     * Returns a formatted String
     * of this state
     */
    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append(getName());

        transitions.forEach((onSymb, state) -> {

            String next = " " + onSymb + " " + state.getName() + "\n";
            sb.append(next);

        });

        return sb.toString();
    }

}
    