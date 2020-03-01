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


## Testing
In order to test the program, I wrote three tests with very particular cases. My first test (p1tc4.txt)
was the same as test 1 except that 'a' was both a start state and final state, while 'b' was just a state. 
This test was able to catch an error in our code where we created an extra duplicate state in set 'Q', which then threw an IndexOutOfBoundsException. My second test was 
