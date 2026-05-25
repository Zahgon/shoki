package com.jnape.palatable.shoki.impl;

import com.jnape.palatable.lambda.adt.Maybe;
import com.jnape.palatable.shoki.api.Collection;
import com.jnape.palatable.shoki.api.Natural;
import com.jnape.palatable.shoki.api.SizeInfo;
import com.jnape.palatable.shoki.api.SizeInfo.Known;
import com.jnape.palatable.shoki.api.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static com.jnape.palatable.lambda.adt.Maybe.just;
import static com.jnape.palatable.lambda.adt.Maybe.nothing;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Downcast.downcast;
import static com.jnape.palatable.lambda.functions.builtin.fn3.FoldLeft.foldLeft;
import static com.jnape.palatable.shoki.api.EquivalenceRelation.equivalent;
import static com.jnape.palatable.shoki.api.EquivalenceRelation.objectEquals;
import static com.jnape.palatable.shoki.api.HashingAlgorithm.hash;
import static com.jnape.palatable.shoki.api.HashingAlgorithm.objectHashCode;
import static com.jnape.palatable.shoki.api.Natural.zero;
import static com.jnape.palatable.shoki.api.OrderedCollection.EquivalenceRelations.elementsInOrder;
import static com.jnape.palatable.shoki.api.OrderedCollection.HashingAlgorithms.elementsInOrder;
import static com.jnape.palatable.shoki.api.SizeInfo.known;

/**
 * A strictly-evaluated {@link Stack}.
 *
 * @param <A> the element type
 * @see StrictQueue
 */
public abstract class StrictStack<A> implements Stack<Natural, A> {

    private StrictStack() {
    }

    /**
     * Produce a new {@link StrictStack} instance with <code>a</code> added to the front. <code>O(1)</code>.
     *
     * @param a the element
     * @return the new {@link StrictStack}
     */
    @Override
    public final StrictStack<A> cons(A a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The remaining elements after removing the head of this {@link StrictStack}, or an empty {@link StrictStack} if
     * there is no head. <code>O(1)</code>.
     *
     * @return the tail of this {@link StrictStack}
     */
    @Override
    public abstract StrictStack<A> tail();

    /**
     * Reverse this {@link StrictStack}. <code>O(n)</code>.
     *
     * @return this {@link StrictStack}, reversed
     */
    @Override
    public StrictStack<A> reverse() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If this {@link StrictStack} is not empty, return the head element wrapped in {@link Maybe}. Otherwise, return
     * {@link Maybe#nothing()}. <code>O(1)</code>.
     *
     * @return {@link Maybe} the head element of this {@link StrictStack}
     */
    @Override
    public abstract Maybe<A> head();

    /**
     * The {@link SizeInfo} of this {@link StrictStack}. Amortized <code>O(1)</code>.
     */
    @Override
    public abstract Known<Natural> sizeInfo();

    /**
     * Returns true if this {@link StrictStack} is empty; otherwise, returns false. <code>O(1)</code>.
     *
     * @return whether or not this {@link StrictStack} is empty
     */
    @Override
    public abstract boolean isEmpty();

    /**
     * {@inheritDoc}
     * <code>O(o)</code>.
     */
    @Override
    public StrictStack<A> consAll(Collection<Natural, A> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns true if <code>other</code> is an {@link StrictStack} with exactly the same elements in the same order
     * as this {@link StrictStack}; otherwise, returns false. <code>O(n)</code>.
     *
     * @param other the reference object with which to compare
     * @return true if the compared to a value-equal {@link StrictStack}
     */
    @Override
    public final boolean equals(Object other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Iterator<A> iterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * Amortized <code>O(1)</code>.
     *
     * @return the hash code
     */
    @Override
    public abstract int hashCode();

    /**
     * Provide a debug-friendly string representation of this {@link StrictStack}. <code>O(n)</code>
     *
     * @return the string representation of this {@link StrictStack}
     */
    @Override
    public final String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a {@link StrictStack} of zero or more elements, with the elements queued for removal from left to right.
     * <code>O(n)</code>.
     *
     * @param as  the elements to {@link StrictStack#cons(Object) cons} from back to front
     * @param <A> the element type
     * @return the {@link StrictStack}
     */
    @SafeVarargs
    public static <A> StrictStack<A> strictStack(A... as) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final class Head<A> extends StrictStack<A> {

        private final A head;

        private final StrictStack<A> tail;

        private volatile Natural size;

        private volatile Integer hashCode;

        private Head(A head, StrictStack<A> tail) {
            this.head = head;
            this.tail = tail;
        }

        @Override
        public boolean isEmpty() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Maybe<A> head() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public StrictStack<A> tail() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        @SuppressWarnings("DuplicatedCode")
        public Known<Natural> sizeInfo() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class Empty<A> extends StrictStack<A> {

        private static final Empty<?> INSTANCE = new Empty<>();

        private Empty() {
        }

        @Override
        public boolean isEmpty() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Maybe<A> head() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public StrictStack<A> tail() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Known<Natural> sizeInfo() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
