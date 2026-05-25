package com.jnape.palatable.shoki.api;

import com.jnape.palatable.lambda.adt.Maybe;
import com.jnape.palatable.lambda.adt.Try;
import com.jnape.palatable.lambda.adt.coproduct.CoProduct2;
import com.jnape.palatable.lambda.functions.Fn1;
import java.math.BigInteger;
import java.util.Objects;
import static com.jnape.palatable.lambda.adt.Maybe.just;
import static com.jnape.palatable.lambda.adt.Maybe.nothing;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Constantly.constantly;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Id.id;
import static com.jnape.palatable.lambda.functions.builtin.fn2.GT.gt;
import static com.jnape.palatable.lambda.functions.builtin.fn2.LT.lt;
import static com.jnape.palatable.shoki.api.EquivalenceRelation.equivalent;
import static com.jnape.palatable.shoki.api.EquivalenceRelation.objectEquals;
import static java.lang.Math.min;
import static java.math.BigInteger.ZERO;

/**
 * A {@link Number} type representing the
 * <a href="https://en.wikipedia.org/wiki/Natural_number" target="_new">natural</a> numbers - the set of non-negative
 * integers - with type-safe interfaces for dealing with the {@link CoProduct2 coproduct} of {@link Zero zero} and
 * {@link NonZero non-zero} values.
 */
public abstract class Natural extends Number implements CoProduct2<Natural.Zero, Natural.NonZero, Natural>, Comparable<Natural> {

    private Natural() {
    }

    /**
     * The non-truncated underlying integral value as a {@link java.math.BigInteger}.
     *
     * @return the value
     */
    public abstract BigInteger bigIntegerValue();

    /**
     * Addition of two {@link Natural} numbers.
     *
     * @param addend the {@link Natural} addend
     * @return the {@link Natural} sum
     */
    public abstract Natural plus(Natural addend);

    /**
     * Specialized subtraction when the subtrahend is {@link Zero}, guaranteeing a {@link Natural} difference
     * (the minuend).
     *
     * @param subtrahend the {@link Zero} subtrahend
     * @return the {@link Natural} minuend
     */
    public abstract Natural minus(Zero subtrahend);

    /**
     * Multiplication of two {@link Natural} numbers.
     *
     * @param multiplier the {@link Natural} multiplier
     * @return the {@link Natural} product
     */
    public abstract Natural times(Natural multiplier);

    /**
     * Remainder of the division of this {@link Natural} dividend by a {@link NonZero non-zero Natural} divisor.
     *
     * @param divisor the {@link NonZero non-zero} divisor
     * @return the {@link Natural} modulus
     */
    public abstract Natural modulo(NonZero divisor);

    /**
     * Specialized addition when the addend is {@link NonZero}, guaranteeing a {@link NonZero} sum.
     *
     * @param addend the {@link Natural} addend
     * @return the {@link NonZero} sum
     */
    public abstract NonZero plus(NonZero addend);

    /**
     * Subtraction of two {@link Natural} numbers. If the difference is {@link Natural}, {@link Maybe#just(Object) just}
     * return it; otherwise, the difference would be negative, so return {@link Maybe#nothing()}.
     *
     * @param subtrahend the {@link Natural} subtrahend
     * @return {@link Maybe} the {@link Natural} difference
     */
    public final Maybe<Natural> minus(Natural subtrahend) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Specialized multiplication when the multiplier is {@link Zero}, guaranteeing a {@link Zero} product.
     *
     * @param multiplier the {@link Zero} multiplier
     * @return the {@link Zero} product
     */
    @SuppressWarnings("unused")
    public final Zero times(Zero multiplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@link Natural#plus(Natural) Add} {@link Natural#one() one} to this {@link Natural}.
     *
     * @return the incremented {@link NonZero non-zero} {@link Natural}
     */
    public final NonZero inc() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@link Natural#minus(Natural) Subtract} {@link Natural#one() one} from this {@link Natural}.
     *
     * @return {@link Maybe} the decremented {@link Natural}
     */
    public final Maybe<Natural> dec() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * If the underlying value of this {@link Natural} is greater than {@link Integer#MAX_VALUE}, the result is
     * {@link Integer#MAX_VALUE}.
     */
    @Override
    public abstract int intValue();

    /**
     * {@inheritDoc}
     * If the underlying value of this {@link Natural} is greater than {@link Long#MAX_VALUE}, the result is
     * {@link Long#MAX_VALUE}.
     */
    @Override
    public abstract long longValue();

    /**
     * {@inheritDoc}
     * Since {@link Natural Naturals} are by definition integral values, this is simply the result of
     * {@link Natural#intValue()}, and subject to precision loss.
     */
    @Override
    public final float floatValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     * Since {@link Natural Naturals} are by definition integral values, this is simply the result of
     * {@link Natural#longValue()}, and subject to precision loss.
     */
    @Override
    public final double doubleValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Natural other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract Maybe<Natural> minus(NonZero subtrahend);

    /**
     * The singleton {@link Zero zero} value, the smallest {@link Natural}.
     *
     * @return the singleton {@link Zero}
     */
    public static Zero zero() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A convenience method for offering a {@link NonZero non-zero} value of <code>1</code>.
     *
     * @return the {@link NonZero non-zero} value of 1
     */
    public static NonZero one() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If <code>value</code> is non-negative, return {@link Maybe#just(Object) just} the corresponding {@link Natural};
     * otherwise, return {@link Maybe#nothing() nothing}.
     *
     * @param value the value
     * @return {@link Maybe} the corresponding {@link Natural}
     */
    public static Maybe<Natural> natural(int value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience overload of {@link Natural#natural(int)} allowing <code>long</code> values.
     *
     * @param value the value
     * @return {@link Maybe} the corresponding {@link Natural}
     * @see Natural#natural(int)
     */
    public static Maybe<Natural> natural(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience overload of {@link Natural#natural(int)} allowing {@link BigInteger} values.
     *
     * @param value the value
     * @return {@link Maybe} the corresponding {@link Natural}
     * @see Natural#natural(int)
     */
    public static Maybe<Natural> natural(BigInteger value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Return the corresponding {@link Natural} for the
     * <a href="https://en.wikipedia.org/wiki/Absolute_value" target="_new">absolute value</a> of the given
     * <code>value</code>.
     *
     * @param value the value
     * @return the {@link Natural} corresponding to the value's absolute value
     */
    public static Natural abs(int value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience overload of {@link Natural#abs(int)} allowing <code>long</code> values.
     *
     * @param value the value
     * @return the {@link Natural} corresponding to the value's absolute value
     * @see Natural#abs(int)
     */
    public static Natural abs(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience overload of {@link Natural#abs(int)} allowing {@link BigInteger} values.
     *
     * @param value the value
     * @return the {@link Natural} corresponding to the value's absolute value
     * @see Natural#abs(int)
     */
    public static Natural abs(BigInteger value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Return the corresponding {@link Natural} for the given <code>value</code>, defaulting to {@link Zero zero} if
     * <code>value</code> is negative.
     *
     * @param value the value
     * @return the {@link Natural} corresponding to the given value, or {@link Zero}
     */
    public static Natural atLeastZero(int value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience overload of {@link Natural#atLeastZero(int)} allowing <code>long</code> values.
     *
     * @param value the value
     * @return the {@link Natural} corresponding to the given value, or {@link Zero}
     * @see Natural#atLeastZero(int)
     */
    public static Natural atLeastZero(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience overload of {@link Natural#atLeastZero(int)} allowing {@link BigInteger} values.
     *
     * @param value the value
     * @return the {@link Natural} corresponding to the given value, or {@link Zero}
     * @see Natural#atLeastZero(int)
     */
    public static Natural atLeastZero(BigInteger value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Return the corresponding {@link NonZero non-zero} {@link Natural} for the given <code>value</code>, defaulting to
     * {@link Natural#one() one} if <code>value</code> is less than <code>1</code>.
     *
     * @param value the value
     * @return the {@link NonZero non-zero} {@link Natural} corresponding to the given value, or {@link Natural#one()}
     */
    public static NonZero atLeastOne(int value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience overload of {@link Natural#atLeastOne(int)} allowing <code>long</code> values.
     *
     * @param value the value
     * @return the {@link NonZero non-zero} {@link Natural} corresponding to the given value, or {@link Natural#one()}
     * @see Natural#atLeastOne(int)
     */
    public static NonZero atLeastOne(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience overload of {@link Natural#atLeastOne(int)} allowing {@link BigInteger} values.
     *
     * @param value the value
     * @return the {@link NonZero non-zero} {@link Natural} corresponding to the given value, or {@link Natural#one()}
     * @see Natural#atLeastOne(int)
     */
    public static NonZero atLeastOne(BigInteger value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <N extends Number & Comparable<N>> Maybe<Natural> natural(N value, N zero) {
        return gt(zero, value) ? just(NonZero.nonZero(value)) : lt(zero, value) ? nothing() : just(zero());
    }

    private static <N extends Number & Comparable<N>> Natural abs(N value, N zero, Fn1<? super N, ? extends N> negate) {
        return natural(value, zero).orElseGet(() -> NonZero.nonZero(negate.apply(value)));
    }

    private static <N extends Number & Comparable<N>> Natural atLeastZero(N value, N zero) {
        return natural(value, zero).orElse(zero());
    }

    private static <N extends Number & Comparable<N>> NonZero atLeastOne(N value, N zero) {
        return atLeastZero(value, zero).match(constantly(one()), id());
    }

    /**
     * The type corresponding to the {@link Natural} zero term.
     *
     * @see Natural
     * @see NonZero
     */
    public static final class Zero extends Natural {

        private static final Zero INSTANCE = new Zero();

        private Zero() {
        }

        /**
         * Specialized addition when both the augend and addend are {@link Zero}, guaranteeing a {@link Zero} sum.
         *
         * @param addend the {@link Zero} addend
         * @return {@link Zero}
         */
        public Zero plus(@SuppressWarnings("unused") Zero addend) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public NonZero plus(NonZero addend) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Natural plus(Natural addend) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Zero minus(Zero subtrahend) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Maybe<Natural> minus(NonZero subtrahend) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Zero times(Natural multiplier) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Zero modulo(NonZero divisor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public BigInteger bigIntegerValue() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int intValue() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public long longValue() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public <R> R match(Fn1<? super Zero, ? extends R> aFn, Fn1<? super NonZero, ? extends R> bFn) {
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
     * The type corresponding to all non-zero {@link Natural} terms.
     *
     * @see Natural
     * @see NonZero
     */
    public static abstract class NonZero extends Natural {

        private NonZero() {
        }

        public final NonZero times(NonZero multiplier) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        abstract Number value();

        @Override
        public abstract NonZero plus(Natural addend);

        @Override
        public final NonZero plus(NonZero addend) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public NonZero minus(Zero subtrahend) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Natural times(Natural multiplier) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public final Natural modulo(NonZero divisor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public <R> R match(Fn1<? super Zero, ? extends R> aFn, Fn1<? super NonZero, ? extends R> bFn) {
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

        private static NonZero nonZero(Number n) {
            if (n instanceof Integer) {
                return new I((int) n);
            } else if (n instanceof Long) {
                long nLong = (Long) n;
                return nLong <= Integer.MAX_VALUE ? new I((int) nLong) : new L(nLong);
            } else {
                BigInteger nBigInteger = (BigInteger) n;
                return Try.<NonZero>trying(() -> new NonZero.I(nBigInteger.intValueExact())).catchError(__ -> Try.trying(() -> new NonZero.L(nBigInteger.longValueExact()))).recover(__ -> new NonZero.B(nBigInteger));
            }
        }

        static final class I extends NonZero {

            private static final I ONE = new I(1);

            private final int value;

            I(int value) {
                this.value = value;
            }

            @Override
            public NonZero plus(Natural addend) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public Maybe<Natural> minus(NonZero subtrahend) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public BigInteger bigIntegerValue() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public byte byteValue() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public short shortValue() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public int intValue() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public long longValue() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            Integer value() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }

        static final class L extends NonZero {

            private final long value;

            L(long value) {
                this.value = value;
            }

            @Override
            public NonZero plus(Natural addend) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public Maybe<Natural> minus(NonZero subtrahend) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public BigInteger bigIntegerValue() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public byte byteValue() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public short shortValue() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public int intValue() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public long longValue() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            Long value() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }

        static final class B extends NonZero {

            private final BigInteger value;

            B(BigInteger value) {
                this.value = value;
            }

            @Override
            public NonZero.B plus(Natural addend) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public Maybe<Natural> minus(NonZero subtrahend) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public BigInteger bigIntegerValue() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public byte byteValue() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public short shortValue() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public int intValue() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public long longValue() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            BigInteger value() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }
}
