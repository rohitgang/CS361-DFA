package fa.dfa;

import java.util.*;
import fa.State;

public class DFAState extends State {

	protected String name;
	private Set<DFAState> nextStates;
	private Hashtable<Character, DFAState> nextStateWithTransition;
	private char nextTransition;
	private Boolean isFinal;
	private Boolean isStart;

	public DFAState(String name) {
		this.name = name;
		this.nextStates = new HashSet<DFAState>();
		this.nextStateWithTransition = new Hashtable<Character, DFAState>();
		this.nextTransition = 'n';
		this.isFinal = false;
		this.isStart = false;
	}

	/**
	 * Sets the states after transition
	 * 
	 * @param nextState
	 */
	public void setNext(Set<DFAState> nextStates) {
		this.nextStates = nextStates;
	}

	/**
	 * Returns the state after transition
	 * 
	 * @return nextState : State object
	 */
	public DFAState getNext(char transition) {
		DFAState ret = null;
		for (Iterator<DFAState> it = nextStates.iterator(); it.hasNext();) {
			DFAState nextOne = it.next();
			ret = nextOne;
			if (transition == nextOne.getTransition())
				break;
		}
		return ret;
	}

	/**
	 * Returns the next state given the transition
	 * 
	 * @param transition : char representing the transition
	 * @return ret : next state if found, -1 otherwise
	 */
	public DFAState getNextWithTransition(char transition) {
		DFAState ret = nextStateWithTransition.get(transition);
		if (ret.equals(null))
			return null;
		else
			return ret;
	}

	/**
	 * Adds the next state to the nextStateWithTransition Dictionary
	 * 
	 * @param state : DFAState object to add with the corresponding transition
	 * @return transition : char representing the transition
	 */
	public int addStateWithTransition(DFAState state, char transition) {
		if (nextStateWithTransition.get(transition).equals(null)) {
			this.nextStateWithTransition.put(transition, state);
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
		nextTransition = transition;
	}

	/**
	 * Gets the transition string of the current state
	 * 
	 * @return nextTransition
	 */
	public char getTransition() {
		return nextTransition;
	}

	/**
	 * Sets the current state as the final state
	 */
	public void setFinalState() {
		isFinal = true;
	}

	/**
	 * Sets the current state as the start state
	 */
	public void setStartState() {
		isStart = true;
	}

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
}
