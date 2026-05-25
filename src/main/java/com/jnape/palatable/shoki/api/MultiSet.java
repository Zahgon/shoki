package com.jnape.palatable.shoki.api;

import com.jnape.palatable.lambda.adt.coproduct.CoProduct2;
import com.jnape.palatable.lambda.adt.hlist.Tuple2;
import com.jnape.palatable.lambda.semigroup.Semigroup;
import com.jnape.palatable.shoki.api.Natural.NonZero;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Constantly.constantly;
import static com.jnape.palatable.lambda.functions.builtin.fn2.GTE.gte;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Into.into;
import static com.jnape.palatable.lambda.functions.builtin.fn3.FoldLeft.foldLeft;
import static com.jnape.palatable.lambda.monoid.builtin.And.and;
import static com.jnape.palatable.lambda.semigroup.builtin.Max.max;
import static com.jnape.palatable.lambda.semigroup.builtin.Min.min;
import static com.jnape.palatable.shoki.api.Natural.one;
import static com.jnape.palatable.shoki.api.Natural.zero;

/**
 * A {@link MultiSet} (also referred to as a <em>Bag</em>) is a {@link Collection} of {@link Tuple2 pairs} of contained
 * elements and their {@link NonZero non-zero} multiplicity in the {@link MultiSet}, supporting {@link RandomAccess}
 * from a possible element to its {@link Natural} multiplicity.
 *
 * @param <A> the element type
 */
public interface MultiSet<A> extends Collection<Natural, Tuple2<A, NonZero>>, RandomAccess<A, Natural> {

    /**
     * Increment the {@link MultiSet#get(Object) multiplicity} of <code>a</code> in this {@link MultiSet} by
     * <code>k</code>.
     *
     * @param a the element for which to increment the multiplicity
     * @param k the {@link NonZero non-zero} increment
     * @return the updated {@link MultiSet}
     */
    MultiSet<A> inc(A a, NonZero k);

    /**
     * Decrement the {@link MultiSet#get(Object) multiplicity} of <code>a</code> in this {@link MultiSet} by
     * <code><em>min</em>(k, {@link MultiSet#get get}(a))</code>.
     *
     * @param a the element for which to decrement the multiplicity
     * @param k the {@link NonZero non-zero} decrement
     * @return the updated {@link MultiSet}
     */
    MultiSet<A> dec(A a, NonZero k);

    /**
     * The {@link Set} of unique elements in this {@link MultiSet}
     *
     * @return the {@link Set} of unique elements
     */
    Set<Natural, A> unique();

    /**
     * The ({@link Natural possibly zero}) multiplicity (number of occurrences) of <code>a</code> in this
     * {@link MultiSet}.
     *
     * @param a the element for which to lookup the multiplicity
     * @return the multiplicity of a in this {@link MultiSet}
     */
    @Override
    Natural get(A a);

    /**
     * {@inheritDoc}
     *
     * @return this {@link MultiSet} without the {@link MultiSet#head() head} occurrence pair
     */
    @Override
    MultiSet<A> tail();

    /**
     * {@link MultiSet#inc(Object, Natural.NonZero) Increment} the {@link MultiSet#get(Object) multiplicity} of
     * <code>a</code> in this {@link MultiSet} by {@link Natural#one() one}.
     *
     * @param a the element for which to increment the multiplicity
     * @return the updated {@link MultiSet}
     * @see MultiSet#inc(Object, Natural.NonZero)
     */
    default MultiSet<A> inc(A a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@link MultiSet#dec(Object, Natural.NonZero) Decrement} the {@link MultiSet#get(Object) multiplicity} of
     * <code>a</code> in this {@link MultiSet} by <code><em>min</em>({@link Natural#one() one},
     * {@link MultiSet#get get}(a))</code>.
     *
     * @param a the element for which to decrement the multiplicity
     * @return the updated {@link MultiSet}
     * @see MultiSet#dec(Object, Natural.NonZero)
     */
    default MultiSet<A> dec(A a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@link MultiSet#dec(Object, Natural.NonZero) Remove} all occurrences of <code>a</code> from this
     * {@link MultiSet}, such that subsequent invocations of <code>{@link MultiSet#get(Object) get}(a)</code> return
     * {@link Natural#zero() zero}.
     * <p>
     * By default, this method simply {@link MultiSet#dec(Object, Natural.NonZero) decrements} the
     * {@link MultiSet#get(Object) multiplicity} of <code>a</code> from the {@link MultiSet}, although specific
     * implementations may be able to perform this operation more directly and efficiently.
     *
     * @param a the element to remove
     * @return the updated {@link MultiSet}
     * @see MultiSet#dec(Object, Natural.NonZero)
     */
    default MultiSet<A> remove(A a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Determine if some value <code>k</code> <code>a</code>s are elements of this {@link MultiSet}.
     * Equivalent to <code>get(a) &gt;= k</code>
     *
     * @param a the value
     * @param k the amount of a
     * @return true if there are k <code>a</code>s in this {@link MultiSet}; false otherwise
     */
    default boolean contains(A a, NonZero k) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Determine if another {@link MultiSet} is a subset of this {@link MultiSet}. A {@link MultiSet} <code>x</code> is
     * a subset of <code>y</code> if, for every element in <code>x</code>, the multiplicity of the element in
     * <code>x</code> is less than or equal to the multiplicity of that element in <code>y</code>.
     *
     * @param other the {@link MultiSet} to test for inclusion in this {@link MultiSet}
     * @return true if other is included in this {@link MultiSet}; false, otherwise
     */
    default boolean inclusion(MultiSet<A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The intersection of two {@link MultiSet MultiSets} <code>xs</code> and <code>ys</code> is the {@link MultiSet}
     * of those elements present in both <code>xs</code> and <code>ys</code> with a multiplicity corresponding to the
     * minimum multiplicity of the element between the two {@link MultiSet MultiSets}.
     *
     * @param other the {@link MultiSet} to intersect with this {@link MultiSet}
     * @return the intersected {@link MultiSet}
     * @see MultiSet#merge
     */
    default MultiSet<A> intersection(MultiSet<A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The union of two {@link MultiSet MultiSets} <code>xs</code> and <code>ys</code> is the {@link MultiSet} of those
     * elements present in either <code>xs</code> or <code>ys</code> with a multiplicity corresponding to the maximum
     * multiplicity of the element between the two {@link MultiSet MultiSets}.
     *
     * @param other the {@link MultiSet} to union with this {@link MultiSet}
     * @return the union {@link MultiSet}
     * @see MultiSet#merge
     */
    default MultiSet<A> union(MultiSet<A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@link MultiSet#inc Increment} the {@link MultiSet#get(Object) multiplicity} of each element in
     * this {@link MultiSet} by the corresponding element's {@link MultiSet#get(Object) multiplicity} in
     * <code>other</code>.
     *
     * @param other the {@link MultiSet} from which to {@link MultiSet#inc(Object, Natural.NonZero) increment}
     *              multiplicities
     * @return the updated {@link MultiSet}
     * @see MultiSet#merge
     */
    default MultiSet<A> sum(MultiSet<A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The <a href="https://en.wikipedia.org/wiki/Complement_(set_theory)#Relative_complement"
     * target="_new">difference</a> (also known as "relative complement") of two {@link MultiSet MultiSets}
     * <code>xs</code> and <code>ys</code> is the {@link MultiSet} of <code>xs</code> after subtracting the
     * corresponding element multiplicities in <code>ys</code>.
     *
     * @param other the {@link MultiSet} to subtract from this {@link MultiSet}
     * @return the difference {@link MultiSet}
     * @see MultiSet#merge
     */
    default MultiSet<A> difference(MultiSet<A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The symmetric difference of two {@link MultiSet MultiSets} <code>xs</code> and <code>ys</code> is the
     * {@link MultiSet} of the occurrence pairs present in either <code>xs</code> or <code>ys</code> but not present in
     * both.
     *
     * @param other the {@link MultiSet} to symmetrically subtract from this {@link MultiSet}
     * @return the {@link MultiSet} containing the symmetric difference
     * @see MultiSet#difference(MultiSet)
     */
    default MultiSet<A> symmetricDifference(MultiSet<A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Combine {@link MultiSet}s using a {@link Semigroup} to combine the multiplicities of the relevant elements.
     *
     * @param other     the other {@link MultiSet}
     * @param semigroup the {@link Semigroup}
     * @return the merged {@link MultiSet}
     */
    default MultiSet<A> merge(MultiSet<A> other, Semigroup<Natural> semigroup) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * Amortized <code>O(1)</code>.
     */
    @Override
    default boolean contains(A a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Common {@link EquivalenceRelation}s between {@link MultiSet MultiSets}.
     */
    final class EquivalenceRelations {

        private EquivalenceRelations() {
        }

        /**
         * An {@link EquivalenceRelation} between two {@link MultiSet}s that holds if, and only if, both
         * {@link MultiSet MultiSets} have the same elements with the same multiplicity. <code>O(n)</code>.
         *
         * @param <A> the element type
         * @param <S> the {@link MultiSet} subtype of the arguments
         * @return the {@link EquivalenceRelation}
         */
        public static <A, S extends MultiSet<A>> EquivalenceRelation<S> elementMultiplicity() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
