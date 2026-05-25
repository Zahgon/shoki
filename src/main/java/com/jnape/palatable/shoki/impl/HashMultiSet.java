package com.jnape.palatable.shoki.impl;

import com.jnape.palatable.lambda.adt.Maybe;
import com.jnape.palatable.lambda.adt.hlist.Tuple2;
import com.jnape.palatable.lambda.semigroup.Semigroup;
import com.jnape.palatable.shoki.api.EquivalenceRelation;
import com.jnape.palatable.shoki.api.HashingAlgorithm;
import com.jnape.palatable.shoki.api.MultiSet;
import com.jnape.palatable.shoki.api.Natural;
import com.jnape.palatable.shoki.api.Natural.NonZero;
import com.jnape.palatable.shoki.api.SizeInfo.Known;
import java.util.Iterator;
import java.util.Objects;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Constantly.constantly;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Id.id;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Into.into;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Map.map;
import static com.jnape.palatable.lambda.functions.builtin.fn3.FoldLeft.foldLeft;
import static com.jnape.palatable.shoki.api.Natural.zero;
import static com.jnape.palatable.shoki.api.SizeInfo.known;
import static com.jnape.palatable.shoki.impl.HashMap.hashMap;
import static java.lang.String.format;
import static java.lang.String.join;

/**
 * A {@link MultiSet} that stores elements internally in a {@link HashMap}, supporting the same time/space performance
 * characteristics. As with {@link HashMap}, a {@link HashMultiSet} can be configured upon creation with custom
 * {@link EquivalenceRelation equality} and {@link HashingAlgorithm hashing} semantics.
 *
 * @param <A> the element type
 */
public final class HashMultiSet<A> implements MultiSet<A> {

    private static final HashMultiSet<?> EMPTY_OBJECT_DEFAULTS = new HashMultiSet<>(hashMap());

    private final HashMap<A, NonZero> multiplicityMap;

    private volatile Natural size;

    private HashMultiSet(HashMap<A, NonZero> multiplicityMap) {
        this.multiplicityMap = multiplicityMap;
    }

    /**
     * {@inheritDoc}
     * <code>O(o)</code>.
     */
    @Override
    public HashMultiSet<A> sum(MultiSet<A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(n)</code>.
     */
    @Override
    public HashSet<A> unique() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * Amortized <code>O(1)</code>.
     */
    @Override
    public HashMultiSet<A> inc(A a, NonZero k) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * Amortized <code>O(1)</code>.
     */
    @Override
    public HashMultiSet<A> dec(A a, NonZero k) {
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
    public HashMultiSet<A> remove(A a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * Amortized <code>O(1)</code>.
     */
    @Override
    public HashMultiSet<A> inc(A a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * Amortized <code>O(1)</code>.
     */
    @Override
    public HashMultiSet<A> dec(A a) {
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
    public HashMultiSet<A> tail() {
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
    public HashMultiSet<A> intersection(MultiSet<A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(n + o)</code>.
     */
    @Override
    public HashMultiSet<A> union(MultiSet<A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(n + o)</code>.
     */
    @Override
    public HashMultiSet<A> difference(MultiSet<A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(n + o)</code>.
     */
    @Override
    public HashMultiSet<A> symmetricDifference(MultiSet<A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * <code>O(n + o)</code>.
     */
    @Override
    public HashMultiSet<A> merge(MultiSet<A> other, Semigroup<Natural> semigroup) {
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
     * Returns <code>true</code> if <code>other</code> is a {@link HashMultiSet} and
     * {@link EquivalenceRelation equivalent} to this {@link HashMultiSet} according to the underlying
     * {@link HashMap HashMaps}; <code>false</code> otherwise. <code>O(n)</code>.
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
     * Compute the corresponding {@link Object#hashCode() hash code} for this {@link HashMultiSet}.
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
     * Create a {@link HashMultiSet} using the given {@link EquivalenceRelation} and {@link HashingAlgorithm},
     * populated by zero or more given entries. <code>O(n)</code>.
     *
     * @param equivalenceRelation the {@link EquivalenceRelation}
     * @param hashingAlgorithm    the {@link HashingAlgorithm}
     * @param as                  the elements
     * @param <A>                 the element type
     * @return the {@link HashMultiSet}
     */
    @SafeVarargs
    public static <A> HashMultiSet<A> hashMultiSet(EquivalenceRelation<? super A> equivalenceRelation, HashingAlgorithm<? super A> hashingAlgorithm, A... as) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <A> HashMultiSet<A> hashMultiSet(HashMultiSet<A> hashMultiSet, A[] as) {
        for (A a : as) hashMultiSet = hashMultiSet.inc(a);
        return hashMultiSet;
    }

    /**
     * Create a {@link HashMultiSet} using {@link Objects#equals(Object, Object) Object equality} and
     * {@link Objects#hashCode(Object) Object hashCode} as the {@link EquivalenceRelation} and {@link HashingAlgorithm},
     * respectively, populated by zero or more given entries. <code>O(n)</code>.
     *
     * @param as  the elements
     * @param <A> the element type
     * @return the {@link HashMultiSet}
     */
    @SafeVarargs
    public static <A> HashMultiSet<A> hashMultiSet(A... as) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
