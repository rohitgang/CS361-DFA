# Project 1: Deterministic Finite Automata

* Authors: Andre Maldonado, Steven Kim, Rohit Gangurde
* Class: CS361 Section 2
* Semester: Spring 2020

## Overview

This Java program implements a deterministic finite automata from an 
input file specifying the final states, start state, additional states and valid transitions. 


## Compiling and Using

To compile, execute the following command in the project directory:

$ javac fa/dfa/DFADriver.java

Run the class with this command and input file p1tc1.txt :

$ java fa.dfa.DFADriver ./tests/p1tc1.txt

## Discussion

We had several discussions on handling the empty string. We decided to handle it two ways :
    * If the input string is only one element and it is 'e', we check if the start state is the final state.
    * If the input string has more than one element and we encounter a 'e', we skip over it.

We also discussed on the design of the program. We decided to stick with the implementation where the DFAState object would contain a hashMap with the transition that 
state would accept as the key and the state it transitions to as the value. 

## Testing
In order to test the program, we wrote three tests with very particular cases. Out first test (p1tc4.txt)
was the same as test 1 except that 'a' was both a start state and final state, while 'b' was just a state. 
This test was able to catch an error in our code where we created an extra duplicate state in set 'Q', which then threw an IndexOutOfBoundsException. Our second test was a 4-state dfa with two empty-string transitions straight from the start state to the end state. This test inevitably threw an error because we did not account for any logic for the empty-string transitions. We were able to check if empty strings exist in the languages, however. Our third test took a simple 3-state DFA with a start state and two final states. We wanted to make sure that our program could successfully account for multiple final states since the provided tests each only had one final state. 
