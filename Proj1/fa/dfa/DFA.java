package fa.dfa;

import java.util.*;



import fa.State;
import fa.dfa.DFAInterface;

/**
 * CS361 Project 1
 * Implementation of a DFA by extending
 * given interfaces 
 * @author Andre Maldonado, Steven Kim, Rohit Gangurde
 */
public class DFA implements DFAInterface {
    Set<DFAState> Q;
    Set<Character> Sigma;
    Set<Character> Transition;
    DFAState Start;
    Set<DFAState> Final;

    // Set<DFAState> Q, Set<Character> Sigma, Set<Character> Transition, DFAState
    // Start, Set<DFAState> Final
    public DFA() {
        // this.Q = Q;
        // this.Sigma = Sigma;
        // this.Transition = Transition;
        // this.Start = Start;
        // this.Final = Final;
        Q = new HashSet<DFAState>();
        Sigma = new HashSet<Character>();
        Transition = new HashSet<Character>();
        Final = new HashSet<DFAState>();
    }

    public String toString() {

        String states = "Q = {" + Q.toString() + " }";
        String alphabet = "sigma= {" + Sigma.toString() + "}";
        String transitions = "delta= \n\t\t" + printTable();
        String strt = "q0 = " + Start.toString() + "}";
        String fin = "F = {" + Final.toString() + "}";

        // while
        return states + "\n" + alphabet + "\n" + transitions + "\n" + strt + "\n" + fin;
    }
	
	/**
 	* Prints the Transition Table
 	* @return str
 	*/ 
	public String printTable(){
		String str = "\t\t";
		for(char lang: Sigma){
			str += lang+"\t\t"; 
		}
		str += "\n\t\t";
		for(DFAState targetState: Q){
			str += targetState.getName()+"\t\t";
			for (char lang: Sigma){
				str += targetState.getNextWithTransition(lang).getName()+"\t\t";
			}
			str += "\n";
		}
		return str;
	}

    /**
     * Simulates a DFA on input s to determine whether the DFA accepts s.
     * 
     * @param s - the input string
     * @return true if s in the language of the DFA and false otherwise
     */
    public boolean accepts(String s) {

        return false;
    }

    /**
     * Uses transition function delta of FA
     * 
     * @param from   the source state
     * @param onSymb the label of the transition
     * @return the sink state.
     */
    public DFAState getToState(DFAState from, char onSymb) {
        return from.getNextWithTransition(onSymb);
    }

    public void addStartState(String name) {
        Start = new DFAState(name);
        Q.add(Start);
        Start.setStartState();
    }

    /**
     * Adds a non-final, not initial state to the DFA instance
     * 
     * @param name is the label of the state
     */
    public void addState(String name) {
        DFAState newState = new DFAState(name);
        Q.add(newState);
    }

    /**
     * Adds a final state to the DFA
     * 
     * @param name is the label of the state
     */
    public void addFinalState(String name) {
        DFAState FinalS = new DFAState(name);
        Final.add(FinalS);
        FinalS.setFinalState();
        Q.add(FinalS);
    }

    /**
     * Adds the transition to the DFA's delta data structure
     * 
     * @param fromState is the label of the state where the transition starts
     * @param onSymb    is the symbol from the DFA's alphabet.
     * @param toState   is the label of the state where the transition ends
     */
    public void addTransition(String fromState, char onSymb, String toState) {
        for (DFAState state : Q) {
            DFAState nextOne = state.getNextWithTransition(onSymb);
            if (nextOne.equals(null) || !nextOne.getName().equals(toState)) {
                state.addStateWithTransition(new DFAState(toState), onSymb);
                break;
            }
        }
    }

    /**
     * Getter for Q
     * 
     * @return a set of states that FA has
     */
    public Set<? extends DFAState> getStates() {
        return Q;
    }

    /**
     * Getter for F
     * 
     * @return a set of final states that FA has
     */
    public Set<? extends DFAState> getFinalStates() {
        return Final;
    }

    /**
     * Getter for q0
     * 
     * @return the start state of FA
     */
    public DFAState getStartState() {
        return Start;
    }

    /**
     * Getter for Sigma
     * 
     * @return the alphabet of FA
     */
    public Set<Character> getABC() {
        return Sigma;
    }

    /**
     * Computes a copy of this DFA which language is the complement of this DFA's
     * language.
     * 
     * @return a copy of this DFA
     */
    public DFA complement() {
        return null;
    }
}
