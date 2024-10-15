import org.apache.commons.lang3.ObjectUtils;

import javax.naming.InitialContext;

/** A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 */

public class IntList {

    /** The integer stored by this node. */
    public int item;
    /** The next node in this IntList. */
    public IntList next;

    /** Constructs an IntList storing ITEM and next node NEXT. */
    public IntList(int item, IntList next) {
        this.item = item;
        this.next = next;
    }

    /** Constructs an IntList storing ITEM and no next node. */
    public IntList(int item) {
        this(item, null);
    }

    /** Returns an IntList consisting of the elements in ITEMS.
     * IntList L = IntList.list(1, 2, 3);
     * System.out.println(L.toString()) // Prints 1 2 3 */
    public static IntList of(int... items) {
        /** Check for cases when we have no element given. */
        if (items.length == 0) {
            return null;
        }
        /** Create the first element. */
        IntList head = new IntList(items[0]);
        IntList last = head;
        /** Create rest of the list. */
        for (int i = 1; i < items.length; i++) {
            last.next = new IntList(items[i]);
            last = last.next;
        }
        return head;
    }

    /**
     * Returns [position]th item in this list. Throws IllegalArgumentException
     * if index out of bounds.
     *
     * @param position, the position of element.
     * @return The element at [position]
     */
    public int get(int position) {
        //TODO: YOUR CODE HERE
        if (position < 0) {
            throw new IllegalArgumentException("Out of bounds");
        }

        IntList p = this;
        for (int i = 0; i < position; i++) {
            if (p.next == null) {
                throw new IllegalArgumentException("Out of bounds");
            }
            p = p.next;
        }

        return p.item;
    }

    /**
     * Returns the string representation of the list. For the list (1, 2, 3),
     * returns "1 2 3".
     *
     * @return The String representation of the list.
     */
    public String toString() {
        //TODO: YOUR CODE HERE
        StringBuilder s = new StringBuilder();
        IntList p = this;
        while (p.next != null) {
            s.append(Integer.toString(p.item));
            s.append(' ');
            p = p.next;
        }
        s.append(Integer.toString(p.item));

        return s.toString();
    }

    /**
     * Returns whether this and the given list or object are equal.
     *
     * NOTE: A full implementation of equals requires checking if the
     * object passed in is of the correct type, as the parameter is of
     * type Object. This also requires we convert the Object to an
     * IntList, if that is legal. The operation we use to do this is called
     * casting, and it is done by specifying the desired type in
     * parentheses. An example of this is `IntList otherLst = (IntList) obj;`
     *
     * @param obj, another list (object)
     * @return Whether the two lists are equal.
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof IntList)) {
            return false;
        }
        IntList otherLst = (IntList) obj;

        //TODO: YOUR CODE HERE
        String x1 = this.toString();
        String x2 = otherLst.toString();
        return x1.equals(x2);

    }

    /**
     * Adds the given value at the end of the list.
     *
     * @param value, the int to be added.
     */
    public void add(int value) {
        //TODO: YOUR CODE HERE
        IntList p = this;
        while (p.next != null){
            p = p.next;
        }
        p.next = new IntList(value);
    }

    /**
     * Returns the smallest element in the list.
     *
     * @return smallest element in the list
     */
    public int smallest() {
        //TODO: YOUR CODE HERE
        IntList p = this;
        int min = p.item;
        while (p.next != null) {
            p = p.next;
            if (p.item < min) {
                min = p.item;
            }
        }
        return min;
    }

    /**
     * Returns the sum of squares of all elements in the list.
     *
     * @return The sum of squares of all elements.
     */
    public int squaredSum() {
        //TODO: YOUR CODE HERE
        IntList p = this;
        int sum = 0;
        while (p.next !=null) {
            sum += p.item * p.item;
            p = p.next;
        }
        sum += p.item * p.item;

        return sum;
    }

    /**
     * Destructively squares each item of the list.
     *
     * @param L list to destructively square.
     */
    public static void dSquareList(IntList L) {
        while (L != null) {
            L.item = L.item * L.item;
            L = L.next;
        }
    }

    /**
     * Returns a list equal to L with all elements squared. Non-destructive.
     *
     * @param L list to non-destructively square.
     * @return the squared list.
     */
    public static IntList squareListIterative(IntList L) {
        if (L == null) {
            return null;
        }
        IntList res = new IntList(L.item * L.item, null);
        IntList ptr = res;
        L = L.next;
        while (L != null) {
            ptr.next = new IntList(L.item * L.item, null);
            L = L.next;
            ptr = ptr.next;
        }
        return res;
    }

    /** Returns a list equal to L with all elements squared. Non-destructive.
     *
     * @param L list to non-destructively square.
     * @return the squared list.
     */
    public static IntList squareListRecursive(IntList L) {
        if (L == null) {
            return null;
        }
        return new IntList(L.item * L.item, squareListRecursive(L.next));
    }

    /**
     * Returns a new IntList consisting of A followed by B,
     * non-destructively.
     *
     * @param A list to be on the front of the new list.
     * @param B list to be on the back of the new list.
     * @return new list with A followed by B.
     */
    public static IntList catenate(IntList A, IntList B) {
        if (A == null) return copyList(B);
        if (B == null) return copyList(A);

        IntList newList = new IntList(A.item);
        IntList current = newList;
        A = A.next;

        while (A != null) {
            current.next = new IntList(A.item);
            current = current.next;
            A = A.next;
        }

        while (B != null) {
            current.next = new IntList(B.item);
            current = current.next;
            B = B.next;
        }

        return newList;
    }

    public static IntList copyList(IntList l) {
        if (l == null) {
            return null;
        }

        IntList newList;
        newList = new IntList(l.item);
        IntList current = newList;
        l = l.next;

        while (l != null) {
            current.next = new IntList(l.item);
            current = current.next;
            l = l.next;
        }

        return newList;
    }

    /**
     * Returns a new IntList consisting of A followed by B,
     * destructively.
     *
     * @param A list to be on the front of the new list.
     * @param B list to be on the back of the new list.
     * @return new list with A followed by B.
     */
    public static IntList dcatenate(IntList A, IntList B) {
        //TODO: YOUR CODE HERE
        if (A == null) return B;  // If A is null, return B as the result.
        if (B == null) return A;  // If B is null, return A as is.

        IntList current = A;      // Start from the head of A.

        // Traverse to the end of A.
        while (current.next != null) {
            current = current.next;
        }

        // Link the last node of A to the first node of B.
        current.next = B;

        return A;  // Return the modified A list, which now includes B.
    }
}
