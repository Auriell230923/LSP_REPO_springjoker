package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * IntegerSet models a mathematical set of integers.
 * A set cannot have duplicates and supports common set operations.
 */
public class IntegerSet {

    // this is where we store all the numbers in the set
    // using ArrayList because it's easy to use built-in methods
    private ArrayList<Integer> set;

    /**
     * Default constructor - creates an empty set
     */
    public IntegerSet() {
        set = new ArrayList<Integer>(); // start with empty list
    }

    /**
     * Clears the entire set
     */
    public void clear() {
        // removes everything from the list
        set.clear();
    }

    /**
     * Returns number of elements in the set
     */
    public int length() {
        // size() gives how many elements are in the list
        return set.size();
    }

    /**
     * Checks if two sets are equal (same elements, order doesn't matter)
     */
    public boolean equals(IntegerSet b) {
        // if sizes are different, they can't be equal
        if (this.length() != b.length()) {
            return false;
        }

        // check if every item in this set exists in b
        for (int i : set) {
            if (!b.contains(i)) {
                return false;
            }
        }

        return true; // all elements matched
    }

    /**
     * Checks if a value exists in the set
     */
    public boolean contains(int value) {
        // built-in method makes this easy
        return set.contains(value);
    }

    /**
     * Returns largest value in the set
     */
    public int largest() {
        // can't find largest if empty
        if (set.isEmpty()) {
            throw new IllegalArgumentException("Set is empty");
        }

        // Collections.max finds the biggest number
        return Collections.max(set);
    }

    /**
     * Returns smallest value in the set
     */
    public int smallest() {
        // same idea as largest
        if (set.isEmpty()) {
            throw new IllegalArgumentException("Set is empty");
        }

        return Collections.min(set);
    }

    /**
     * Adds a number to the set (no duplicates allowed)
     */
    public void add(int item) {
        // only add if it's NOT already in the set
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes a number from the set
     */
    public void remove(int item) {
        // important: remove the VALUE, not index
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new set with all elements from both sets
     * Does NOT change the original sets
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        // add everything from current set
        for (int i : this.set) {
            result.add(i);
        }

        // add everything from second set (duplicates automatically ignored)
        for (int i : intSetb.set) {
            result.add(i);
        }

        return result;
    }

    /**
     * Returns elements that are in BOTH sets
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        // only add values that exist in both sets
        for (int i : this.set) {
            if (intSetb.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * Returns elements in this set but NOT in the other set
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        // keep only values that are NOT in intSetb
        for (int i : this.set) {
            if (!intSetb.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * Returns elements in intSetb but NOT in this set
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        // reverse of diff: check elements from intSetb
        for (int i : intSetb.set) {
            if (!this.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * Checks if the set is empty
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns the set as a string in sorted order
     * Format: [1, 2, 3]
     */
    @Override
    public String toString() {
        // make a copy so we don't mess up the original order
        ArrayList<Integer> sortedSet = new ArrayList<Integer>(set);

        // sort numbers from smallest to largest
        Collections.sort(sortedSet);

        // ArrayList already prints in correct format: [1, 2, 3]
        return sortedSet.toString();
    }
}