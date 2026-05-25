package com.jnape.palatable.shoki.impl;

import com.jnape.palatable.lambda.adt.Maybe;
import com.jnape.palatable.lambda.adt.hlist.Tuple2;
import com.jnape.palatable.lambda.semigroup.Semigroup;
import com.jnape.palatable.shoki.api.EquivalenceRelation;
import com.jnape.palatable.shoki.api.MultiSet;
import com.jnape.palatable.shoki.api.Natural;
import com.jnape.palatable.shoki.api.Natural.NonZero;
import com.jnape.palatable.shoki.api.SizeInfo.Known;
import com.jnape.palatable.shoki.api.SortedCollection;
import java.util.Comparator;
import java.util.Iterator;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Constantly.constantly;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Id.id;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Into.into;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Map.map;
import static com.jnape.palatable.lambda.functions.builtin.fn3.FoldLeft.foldLeft;
import static com.jnape.palatable.shoki.api.Natural.zero;
import static com.jnape.palatable.shoki.api.SizeInfo.known;
import static com.jnape.palatable.shoki.impl.TreeMap.treeMap;
import static java.lang.String.format;
import static java.lang.String.join;
import static java.util.Comparator.naturalOrder;

/**
 * A {@link MultiSet} and {@link SortedCollection} that stores elements internally in a {@link TreeMap}, supporting the
 * same time/space performance characteristics. As with {@link TreeMap}, a {@link TreeMultiSet} can be configured upon
 * creation with a custom {@link Comparator comparison relation}.
 *
 * @param <A> the element type
 */
public final class TreeMultiSet<A> implements MultiSet<A>, SortedCollection<Natural, Tuple2<A, NonZero>, A> {

    private final TreeMap<A, NonZero> multiplicityMap;

    private volatile Natural size;

    private TreeMultiSet(TreeMap<A, NonZero> multiplicityMap) {
        this.multiplicityMap = multiplicityMap;
    }

    /**
     * The {@link Comparator} used for the elements stored in this {@link TreeMultiSet}.
     *
     * @return the element {@link Comparator}
     */
    public Comparator<? super A> comparator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * Amortized <code>O(1)</code>.
     */
    @Override
    public TreeMultiSet<A> inc(A a, NonZero k) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * Amortized <code>O(1)</code>.
     */
    @Override
    public TreeMultiSet<A> dec(A a, NonZero k) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(n)</code>.
     */
    @Override
    public TreeSet<A> unique() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(o)</code>.
     */
    @Override
    public TreeMultiSet<A> sum(MultiSet<A> other) {
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
     * Amortized <code>O(1)</code>.
     */
    @Override
    public TreeMultiSet<A> remove(A a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * Amortized <code>O(1)</code>.
     */
    @Override
    public TreeMultiSet<A> inc(A a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * Amortized <code>O(1)</code>.
     */
    @Override
    public TreeMultiSet<A> dec(A a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * Amortized <code>O(1)</code>.
     */
    @Override
    public Natural get(A a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(log2n)</code>.
     */
    @Override
    public Maybe<Tuple2<A, NonZero>> min() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(log2n)</code>.
     */
    @Override
    public Maybe<Tuple2<A, NonZero>> max() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(nlogn)</code>.
     */
    @Override
    public TreeMultiSet<A> sort(Comparator<? super A> comparator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(n)</code>.
     */
    @Override
    public TreeMultiSet<A> reverse() {
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
     * {@inheritDoc}
     * <code>O(1)</code>.
     */
    @Override
    public TreeMultiSet<A> tail() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(1)</code>.
     */
    @Override
    public Maybe<Tuple2<A, NonZero>> head() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(n + o)</code>.
     */
    @Override
    public TreeMultiSet<A> intersection(MultiSet<A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(n + o)</code>.
     */
    @Override
    public TreeMultiSet<A> union(MultiSet<A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(n + o)</code>.
     */
    @Override
    public TreeMultiSet<A> difference(MultiSet<A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(n + o)</code>.
     */
    @Override
    public TreeMultiSet<A> symmetricDifference(MultiSet<A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(n + o)</code>.
     */
    @Override
    public TreeMultiSet<A> merge(MultiSet<A> other, Semigroup<Natural> semigroup) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<Tuple2<A, NonZero>> iterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns <code>true</code> if <code>other</code> is a {@link TreeMultiSet} and
     * {@link EquivalenceRelation equivalent} to this {@link TreeMultiSet} according to the underlying
     * {@link TreeMap}; <code>false</code> otherwise. <code>O(n * log2o)</code>.
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
     * Compute the corresponding {@link Object#hashCode() hash code} for this {@link TreeMultiSet}.
     * Amortized <code>O(1)</code>.
     *
     * @return the hash code
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
     * Create a {@link TreeMultiSet} for some element type <code>A</code> using the given {@link Comparator}, populated
     * by zero or more given entries. <code>O(n * log2n)</code>.
     *
     * @param comparator the {@link Comparator}
     * @param as         the elements
     * @param <A>        the element type
     * @return the {@link TreeMultiSet}
     */
    @SafeVarargs
    public static <A> TreeMultiSet<A> treeMultiSet(Comparator<? super A> comparator, A... as) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a {@link TreeMultiSet} for some {@link Comparable} element type <code>A</code> using
     * {@link Comparator#naturalOrder() natural ordering} for its elements, populated by zero or more given entries.
     * <code>O(n * log2n)</code>.
     *
     * @param as  the elements
     * @param <A> the element type
     * @return the {@link TreeMultiSet}
     */
    @SafeVarargs
    public static <A extends Comparable<? super A>> TreeMultiSet<A> treeMultiSet(A... as) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <A> TreeMultiSet<A> treeMultiSet(TreeMultiSet<A> treeMultiSet, A[] as) {
        for (A a : as) treeMultiSet = treeMultiSet.inc(a);
        return treeMultiSet;
    }
}
