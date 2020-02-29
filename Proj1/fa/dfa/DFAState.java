package fa.dfa;
import java.util.* ;

public class DFAState extends fa.State {

    protected String name;
    private Set<DFAState> nextStates;
    private String nextTransition;
    private Boolean isFinal;
    private Boolean isStart;

    public DFAState(String name){
        this.name = name;
        this.nextStates = new HashSet<DFAState>();
        this.nextTransition = 'N/A';
        this.isFinal = False;
        this.isStart = False;
    }
    /**
     * Sets the states after transition
     * @param nextState
     */
    public void setNext(Set<DFAState> nextStates){ this.nextStates = nestStates; }

    /**
     * Returns the state after transition
     * @return nextState : State object
     */
    public State getNext(String transition){
        DFAState ret = null;
        for(Iterator<DFAState> it = DFAState.iterator(); it.hasNext();){
            DFAState nextOne = it.next();
            ret = nextOne;
            if (transition == nextOne.getTransition()) break;
        }
        return ret;
    }

    /**
     * Sets the transition of the current state
     * @param transition
     */
    public String setTransition(String transition){ nextTransition = transition; }

    /**
     * Gets the transition string of the current state
     * @return nextTransition
     */
    public String getTransition(){ return nextTransition; }

    /**
     * Sets the current state as the final state
     */
    public void setFinalState(){ isFinal = True; }

    /**
     * Sets the current state as the start state
     */
    public void setStartState(){ isStart = True; }

    /**
     * Returns a string representation of the state
     * @return
     */
    public String toString(){ return name; }
}