package it.unibo.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int START = 1000;
    private static final int END = 2000;
    private static final int ELEMENTS = 100_000;
    private static final int SEARCHING_TIMES = 1000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = START; i < END; i++) {
            arrayList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int temp = arrayList.size();
        arrayList.set(0, arrayList.get(temp-1));
        arrayList.set(temp-1, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for(int i=0; i<ELEMENTS; i++) {
            arrayList.addFirst(i);
        }
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Adding "
                + ELEMENTS
                + " elements as first element of the collection ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        for(int i=0; i<ELEMENTS; i++) {
            linkedList.addFirst(i);
        }
        time = System.nanoTime() - time;
        final var milliis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Adding "
                + ELEMENTS
                + " elements as first element of the collection LinkedList took "
                + time
                + "ns ("
                + milliis
                + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        for(int i=0; i<SEARCHING_TIMES; i++) {
            arrayList.get(arrayList.size()/2);
        }
        time = System.nanoTime() - time;
        final var mills = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Getting "
                + SEARCHING_TIMES
                + " elements in the middle of the collection arrayList took "
                + time
                + "ns ("
                + mills
                + "ms)"
        );

        time = System.nanoTime();
        for(int i=0; i<SEARCHING_TIMES; i++) {
            linkedList.get(arrayList.size()/2);
        }
        time = System.nanoTime() - time;
        final var milliss = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Getting "
                + SEARCHING_TIMES
                + " elements in the middle of the collection linkedList took "
                + time
                + "ns ("
                + milliss
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
    }
}
