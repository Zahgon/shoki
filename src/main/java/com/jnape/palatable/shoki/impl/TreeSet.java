package com.jnape.palatable.shoki.impl;

import com.jnape.palatable.lambda.adt.Maybe;
import com.jnape.palatable.lambda.adt.Unit;
import com.jnape.palatable.lambda.adt.hlist.Tuple2;
import com.jnape.palatable.shoki.api.Collection;
import com.jnape.palatable.shoki.api.Natural;
import com.jnape.palatable.shoki.api.Set;
import com.jnape.palatable.shoki.api.SizeInfo.Known;
import com.jnape.palatable.shoki.api.SortedCollection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import static com.jnape.palatable.lambda.adt.Unit.UNIT;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Into.into;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Map.map;
import static com.jnape.palatable.shoki.impl.TreeMap.treeMap;
import static java.lang.String.join;

/**
 * A {@link Set} and {@link SortedCollection} that stores elements internally in a {@link TreeMap}, supporting the same
 * time/space performance characteristics. As with {@link TreeMap}, a {@link TreeSet} can be configured upon creation
 * with a custom {@link Comparator comparison relation}.
 *
 * @param <A> the element type
 * @see TreeMap
 */
public final class TreeSet<A> implements Set<Natural, A>, SortedCollection<Natural, A, A> {

    private final TreeMap<A, Unit> map;

    private TreeSet(TreeMap<A, Unit> map) {
        this.map = map;
    }

    /**
     * The {@link Comparator} used for the elements stored in this {@link TreeSet}.
     *
     * @return the element {@link Comparator}
     */
    public Comparator<? super A> comparator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(1)</code>.
     */
    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>True</code> if <code>a</code> is a member of this {@link Set}; <code>false</code> otherwise.
     * <code>O(log2n)</code>.
     */
    @Override
    public boolean contains(A a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(log2n)</code>.
     */
    @Override
    public TreeSet<A> add(A a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(log2n)</code>.
     */
    @Override
    public TreeSet<A> remove(A a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(log2n)</code>.
     */
    @Override
    public Maybe<A> head() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(log2n)</code>.
     */
    @Override
    public TreeSet<A> tail() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(log2n * o)</code>.
     */
    @Override
    public TreeSet<A> addAll(Collection<Natural, A> collection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(log2n * o)</code>.
     */
    @Override
    public TreeSet<A> intersection(Set<Natural, A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(log2n * o)</code>.
     */
    @Override
    public TreeSet<A> union(Set<Natural, A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(log2n * o)</code>.
     */
    @Override
    public TreeSet<A> difference(Set<Natural, A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(n + o + min(n, o))</code>.
     */
    @Override
    public TreeSet<A> symmetricDifference(Set<Natural, A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(log2n)</code>.
     */
    @Override
    public Maybe<A> min() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(log2n)</code>.
     */
    @Override
    public Maybe<A> max() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(nlogn)</code>.
     */
    @Override
    public TreeSet<A> sort(Comparator<? super A> comparator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(n)</code>.
     */
    @Override
    public TreeSet<A> reverse() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * Amortized <code>O(1)</code>.
     */
    @Override
    public Known<Natural> sizeInfo() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Produce an {@link Iterator} of the elements in this {@link TreeSet} according to the
     * {@link TreeMap#iterator() iteration} of the backing {@link TreeMap}.
     *
     * @return the {@link Iterator}
     */
    @Override
    public Iterator<A> iterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Determine if <code>other</code> is a {@link TreeSet} with the same elements as this {@link TreeSet} (according
     * to the underlying {@link TreeMap}). <code>O(n * log2o)</code>.
     *
     * @param other the {@link Object} to check for equality
     * @return the equality outcome
     * @see TreeMap#equals(Object)
     */
    @Override
    public boolean equals(Object other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * Amortized <code>O(1)</code>.
     */
    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(n)</code>.
     */
    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a {@link TreeSet} for some element type <code>A</code> using the given {@link Comparator}, populated by
     * zero or more given entries. <code>O(n * log2n)</code>.
     *
     * @param comparator the ordering relation
     * @param as         the elements
     * @param <A>        the element type
     * @return the {@link TreeSet}
     */
    @SafeVarargs
    public static <A> TreeSet<A> treeSet(Comparator<? super A> comparator, A... as) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a {@link TreeSet} for some {@link Comparable} element type <code>A</code> using
     * {@link Comparator#naturalOrder() natural ordering} for its elements, populated by zero or more given entries.
     * <code>O(n * log2n)</code>.
     *
     * @param as  the elements
     * @param <A> the element type
     * @return the {@link TreeSet}
     */
    @SafeVarargs
    public static <A extends Comparable<? super A>> TreeSet<A> treeSet(A... as) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <A> TreeMap<A, Unit> backingTreeMap(TreeMap<A, Unit> treeMap, A[] as) {
        for (A a : as) treeMap = treeMap.put(a, UNIT);
        return treeMap;
    }
}
