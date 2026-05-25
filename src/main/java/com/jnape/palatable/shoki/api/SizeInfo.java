package com.jnape.palatable.shoki.api;

import com.jnape.palatable.lambda.adt.coproduct.CoProduct2;
import com.jnape.palatable.lambda.functions.Fn1;
import java.util.Objects;
import static com.jnape.palatable.shoki.api.EquivalenceRelation.equivalent;
import static com.jnape.palatable.shoki.api.EquivalenceRelation.objectEquals;

/**
 * Algebraic data type representing the possible constructions of a {@link SizeInfo}.
 *
 * @see Sizable
 */
public abstract class SizeInfo implements CoProduct2<SizeInfo.Known<?>, SizeInfo.Unknown, SizeInfo> {

    private SizeInfo() {
    }

    /**
     * Construct a {@link SizeInfo} with a known numeric size of type <code>A</code>.
     *
     * @param a   the known size
     * @param <A> the numeric type
     * @return the known {@link SizeInfo}
     */
    public static <A extends Number> Known<A> known(A a) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct a {@link SizeInfo} that contains no assumptions about the representative size of the referenced object.
     *
     * @return the unknown {@link SizeInfo}
     */
    public static Unknown unknown() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A {@link SizeInfo} representing a known numeric size of some value.
     *
     * @param <Size> the numeric size type
     */
    public static final class Known<Size extends Number> extends SizeInfo {

        private final Size size;

        private Known(Size size) {
            this.size = size;
        }

        /**
         * Retrieve the known numeric size value
         *
         * @return the known size
         */
        public Size getSize() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public <R> R match(Fn1<? super Known<?>, ? extends R> aFn, Fn1<? super Unknown, ? extends R> bFn) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(Object other) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A {@link SizeInfo} that implies no assumptions about the representative size of some value.
     */
    public static final class Unknown extends SizeInfo {

        private static final Unknown INSTANCE = new Unknown();

        private Unknown() {
        }

        @Override
        public <R> R match(Fn1<? super Known<?>, ? extends R> aFn, Fn1<? super Unknown, ? extends R> bFn) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
