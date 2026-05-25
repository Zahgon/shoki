package com.jnape.palatable.shoki.impl;

import com.jnape.palatable.lambda.adt.Maybe;
import com.jnape.palatable.lambda.adt.Unit;
import com.jnape.palatable.lambda.adt.hlist.Tuple2;
import com.jnape.palatable.shoki.api.Collection;
import com.jnape.palatable.shoki.api.EquivalenceRelation;
import com.jnape.palatable.shoki.api.HashingAlgorithm;
import com.jnape.palatable.shoki.api.Natural;
import com.jnape.palatable.shoki.api.Set;
import com.jnape.palatable.shoki.api.SizeInfo.Known;
import java.util.Iterator;
import java.util.Objects;
import static com.jnape.palatable.lambda.adt.Unit.UNIT;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Into.into;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Map.map;
import static com.jnape.palatable.shoki.impl.HashMap.hashMap;
import static java.lang.String.join;

/**
 * A {@link Set} that stores elements internally in a {@link HashMap}, supporting the same time/space performance
 * characteristics. As with {@link HashMap}, a {@link HashSet} can be configured upon creation with custom
 * {@link EquivalenceRelation equality} and {@link HashingAlgorithm hashing} semantics.
 *
 * @param <A> the element type
 * @see HashMap
 */
public final class HashSet<A> implements Set<Natural, A> {

    private static final HashSet<?> EMPTY_OBJECT_DEFAULTS = new HashSet<>(hashMap());

    private final HashMap<A, Unit> map;

    private HashSet(HashMap<A, Unit> map) {
        this.map = map;
    }

    /**
     * {@inheritDoc}
     * Amortized <code>O(1)</code>.
     */
    @Override
    public HashSet<A> add(A a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * Amortized <code>O(1)</code>.
     */
    @Override
    public HashSet<A> remove(A a) {
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
    public Maybe<A> head() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(1)</code>.
     */
    @Override
    public HashSet<A> tail() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>True</code> if <code>a</code> is a member of this {@link Set}; <code>false</code> otherwise. Amortized
     * <code>O(1)</code>.
     */
    @Override
    public boolean contains(A a) {
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
     * <code>O(o)</code>.
     */
    @Override
    public HashSet<A> addAll(Collection<Natural, A> collection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(o)</code>.
     */
    @Override
    public HashSet<A> intersection(Set<Natural, A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(o)</code>.
     */
    @Override
    public HashSet<A> union(Set<Natural, A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(o)</code>.
     */
    @Override
    public HashSet<A> difference(Set<Natural, A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(n + o + min(n, o))</code>.
     */
    @Override
    public HashSet<A> symmetricDifference(Set<Natural, A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<A> iterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Determine if <code>other</code> is a {@link HashSet} with the same elements as this {@link HashSet} (according to
     * the underlying {@link HashMap}). <code>O(n)</code>
     *
     * @param other the {@link Object} to check for equality
     * @return the equality outcome
     * @see HashMap#equals(Object)
     */
    @Override
    public boolean equals(Object other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Compute the corresponding {@link Object#hashCode() hash code} for this {@link HashSet}.
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
     * Create a {@link HashSet} using the given {@link EquivalenceRelation} and {@link HashingAlgorithm}, populated by
     * zero or more given entries. <code>O(n)</code>.
     *
     * @param equivalenceRelation the {@link EquivalenceRelation}
     * @param hashingAlgorithm    the {@link HashingAlgorithm}
     * @param as                  the elements
     * @param <A>                 the element type
     * @return the {@link HashSet}
     */
    @SafeVarargs
    public static <A> HashSet<A> hashSet(EquivalenceRelation<? super A> equivalenceRelation, HashingAlgorithm<? super A> hashingAlgorithm, A... as) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a {@link HashSet} using {@link Objects#equals(Object, Object) Object equality} and
     * {@link Objects#hashCode(Object) Object hashCode} as the {@link EquivalenceRelation} and {@link HashingAlgorithm},
     * respectively, populated by zero or more given entries. <code>O(n)</code>.
     *
     * @param as  the elements
     * @param <A> the element type
     * @return the {@link HashSet}
     */
    @SafeVarargs
    public static <A> HashSet<A> hashSet(A... as) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <A> HashMap<A, Unit> backingHashMap(HashMap<A, Unit> hashMap, A[] as) {
        for (A a : as) hashMap = hashMap.put(a, UNIT);
        return hashMap;
    }
}
