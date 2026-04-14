package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * IntegerSet represents a mathematical set of integers.
 * Duplicate values are not allowed.
 */
public class IntegerSet {
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default constructor.
     */
    public IntegerSet() {
    }

    /**
     * Clears the internal representation of the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the length of the set.
     *
     * @return number of elements in the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns true if the two sets are equal.
     * Order does not matter.
     *
     * @param b another IntegerSet
     * @return true if sets contain the same elements
     */
    public boolean equals(IntegerSet b) {
        if (b == null) {
            return false;
        }

        if (this.length() != b.length()) {
            return false;
        }

        for (int value : this.set) {
            if (!b.contains(value)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns true if the set contains the value.
     *
     * @param value integer to check
     * @return true if value exists in set
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest item in the set.
     *
     * @return largest integer
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest item in the set.
     *
     * @return smallest integer
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if it is not already there.
     *
     * @param item integer to add
     */
    public void add(int item) {
        if (!contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it exists.
     *
     * @param item integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Performs union operation with another set.
     * Adds all elements from b that are not already in this set.
     *
     * @param b another IntegerSet
     */
    public void union(IntegerSet b) {
        if (b == null) {
            return;
        }

        for (int value : b.set) {
            if (!this.contains(value)) {
                this.add(value);
            }
        }
    }

    /**
     * Performs intersection operation with another set.
     * Keeps only elements common to both sets.
     *
     * @param b another IntegerSet
     */
    public void intersect(IntegerSet b) {
        if (b == null) {
            this.clear();
            return;
        }

        List<Integer> result = new ArrayList<Integer>();

        for (int value : this.set) {
            if (b.contains(value)) {
                result.add(value);
            }
        }

        this.set = result;
    }

    /**
     * Performs difference operation with another set.
     * Keeps elements in this set that are not in b.
     *
     * @param b another IntegerSet
     */
    public void diff(IntegerSet b) {
        if (b == null) {
            return;
        }

        List<Integer> result = new ArrayList<Integer>();

        for (int value : this.set) {
            if (!b.contains(value)) {
                result.add(value);
            }
        }

        this.set = result;
    }

    /**
     * Performs complement operation with another set.
     * Keeps elements that are in b but not in this set.
     *
     * @param b another IntegerSet
     */
    public void complement(IntegerSet b) {
        if (b == null) {
            this.clear();
            return;
        }

        List<Integer> result = new ArrayList<Integer>();

        for (int value : b.set) {
            if (!this.contains(value)) {
                result.add(value);
            }
        }

        this.set = result;
    }

    /**
     * Returns true if the set is empty.
     *
     * @return true if set has no elements
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns string representation of the set.
     * Format must be exactly like: [1, 2, 3]
     *
     * @return string version of set
     */
    public String toString() {
        return set.toString();
    }
}