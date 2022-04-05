// Problem 3
// @author Nicholas Grokhowsky

// The loop is infinite because it continuously adds a new index to the ArrayList, and ArrayLists do not have a limit on how many indexes that can be added.
// A simple correction to this is to traverse the ArrayList backwards.  By traversing the ArrayList backwards a threshold is set, and once the loop reaches this 
// threshold the loop will quit