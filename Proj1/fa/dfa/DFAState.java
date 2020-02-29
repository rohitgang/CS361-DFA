package fa.dfa;
import java.util.* ;

public class DFAState extends fa.State {

    protected String name;
    private Set<DFAState> nextStates;
    private char nextTransition;
    private Boolean isFinal;
    private Boolean isStart;

    public DFAState(String name){
        this.name = name;
        this.nextStates = new HashSet<DFAState>();
        this.nextTransition = 'n';
        this.isFinal = false;
        this.isStart = false;
    }
    /**
     * Sets the states after transition
     * @param nextState
     */
    public void setNext(Set<DFAState> nextStates){ this.nextStates = nextStates; }

    /**
     * Returns the state after transition
     * @return nextState : State object
     */
    public DFAState getNext(String transition){
        DFAState ret = null;
        for(Iterator<DFAState> it = nextStates.iterator(); it.hasNext();){
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
    public void setTransition(char transition){ nextTransition = transition; }

    /**
     * Gets the transition string of the current state
     * @return nextTransition
     */
    public char getTransition(){ return nextTransition; }

    /**
     * Sets the current state as the final state
     */
    public void setFinalState(){ isFinal = true; }

    /**
     * Sets the current state as the start state
     */
    public void setStartState(){ isStart = true; }

    public String getName(){ return name; }
    /**
     * Returns a string representation of the state
     * @return
     */
    public String toString(){ return name; }
}