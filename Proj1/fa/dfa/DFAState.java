package fa.dfa;

import java.util.*;
import fa.State;

/**
 * DFAState class inherits State class. Contains all the attributes of a state class.
 * @author Rohit Gangurde,
 */
public class DFAState extends fa.State {

	protected String name;
	private Hashtable<Character, DFAState> stateMap;
	private char transition;
	private Boolean isFinal;
	private Boolean isStart;

    /**
     * Constructor to initialize the instance variables
     * @param name : label of the state
     */
	public DFAState(String name) {
		this.name = name;
		this.stateMap= new Hashtable<Character, DFAState>();
		this.transition = 'n';
		this.isFinal = false;
		this.isStart = false;
	}

	/**
	 * Returns the next state provided the transition
	 * @param transition : char representing the transition
	 * @return ret : next state if found, null otherwise
	 */
	public DFAState getNextWithTransition(char transition) {
		DFAState ret = stateMap.get(transition);
		if (ret == null)
			return null;
		else
			return ret;
	}

	/**
	 * Adds the next state to the stateMap Dictionary
	 * 
	 * @param state : DFAState object to add with the corresponding transition
	 * @return transition : char representing the transition
	 */
	public int addStateWithTransition(DFAState state, char transition) {
		if (stateMap.get(transition)== (null)) {
			this.stateMap.put(transition, state);
			return 1;
		} else
			return -1;
	}

	/**
	 * Sets the transition of the current state
	 * 
	 * @param transition
	 */
	public void setTransition(char transition) {
		this.transition = transition;
	}

	/**
	 * Gets the transition string of the current state
	 * 
	 * @return trtransition
	 */
	public char getTransition() {
		return this.transition;
	}

	/**
	 * Sets the current state as the start state
	 */
	public void setStartState(boolean bool) {
		isStart = bool;
	}
	/**
	 * Returns if the state is Final
	 * @return isFinal
	 */
	public boolean isFinal() {
		return isFinal;
	}
	/**
	 * Sets the current state's isFinal variable as bool
	 * @param bool
	 */
	public void setFinalState(boolean bool) {
		isFinal = bool;
	}
	/**
	 * Returns the label of the state
	 */
	public String getName() {
		return name;
	}
	/**
	 * Returns a string representation of the state
	 * 
	 * @return
	 */
	public String toString() {
		return name;
	}
	/**
	 * Creates a deepcopy of the current state object and returns it
	 * @return state : deep copy DFAState
	 */
	public DFAState deepCopy(){
		DFAState state = new DFAState(this.name);
		state.isFinal = this.isFinal;
		state.isStart = this.isStart;
		state.transition = this.transition;
		Set<Character> keys = this.stateMap.keySet();
		for(Character key : keys){
			state.stateMap.put(key, this.stateMap.get(key));
		}
		return state;
	}
}