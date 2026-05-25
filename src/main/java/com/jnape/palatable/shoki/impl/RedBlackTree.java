package com.jnape.palatable.shoki.impl;

import com.jnape.palatable.lambda.adt.hlist.Tuple2;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import static com.jnape.palatable.lambda.adt.hlist.HList.tuple;
import static com.jnape.palatable.shoki.impl.RedBlackTree.Color.B;
import static com.jnape.palatable.shoki.impl.RedBlackTree.Color.BB;
import static com.jnape.palatable.shoki.impl.RedBlackTree.Color.NB;
import static com.jnape.palatable.shoki.impl.RedBlackTree.Color.R;
import static com.jnape.palatable.shoki.impl.StrictStack.strictStack;
import static java.util.Collections.emptyIterator;

interface RedBlackTree<K, V> extends Iterable<Tuple2<K, V>> {

    boolean isEmpty();

    V get(K k, Comparator<? super K> comparator);

    Tuple2<K, V> min();

    Tuple2<K, V> max();

    RedBlackTree<K, V> reverse();

    RedBlackTree<K, V> insert(K k, V v, Comparator<? super K> comparator);

    RedBlackTree<K, V> delete(K k, Comparator<? super K> comparator);

    RedBlackTree<K, V> deleteMin();

    static <K, V> RedBlackTree<K, V> empty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    enum Color {

        NB, R, B, BB;

        private static final Color[] VALUES = Color.values();

        public Color redder() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Color blacker() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    abstract class Spine<K, V> implements RedBlackTree<K, V> {

        final Color c;

        private Spine(Color c) {
            this.c = c;
        }

        abstract Spine<K, V> blacken();

        abstract Spine<K, V> redder();

        abstract Spine<K, V> ins(K newK, V newV, Comparator<? super K> comparator);

        abstract Spine<K, V> del(K k, Comparator<? super K> comparator);

        abstract Spine<K, V> removeMin();

        abstract Spine<K, V> removeMax();

        @Override
        public abstract Spine<K, V> reverse();

        @Override
        public final RedBlackTree<K, V> insert(K k, V v, Comparator<? super K> comparator) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public final RedBlackTree<K, V> delete(K k, Comparator<? super K> comparator) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public final RedBlackTree<K, V> deleteMin() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @SuppressWarnings("unchecked")
        static <K, V> Spine<K, V> b() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @SuppressWarnings("unchecked")
        static <K, V> Spine<K, V> bb() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        static final class Node<K, V> extends Spine<K, V> {

            private final Spine<K, V> l;

            private final K k;

            private final V v;

            private final Spine<K, V> r;

            Node(Color c, Spine<K, V> l, K k, V v, Spine<K, V> r) {
                super(c);
                this.l = l;
                this.k = k;
                this.v = v;
                this.r = r;
            }

            @Override
            public Node<K, V> reverse() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            Node<K, V> blacken() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            Node<K, V> redder() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            Spine<K, V> ins(K newK, V newV, Comparator<? super K> comparator) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            Spine<K, V> del(K k, Comparator<? super K> comparator) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            Spine<K, V> removeMin() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            Spine<K, V> removeMax() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public boolean isEmpty() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public V get(K k, Comparator<? super K> comparator) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public Tuple2<K, V> min() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public Tuple2<K, V> max() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public Iterator<Tuple2<K, V>> iterator() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public boolean equals(Object o) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            Spine<K, V> remove() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            Spine<K, V> bubble() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            Spine<K, V> balance() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            private Node<K, V> redden() {
                return c == R ? this : new Node<>(R, l, k, v, r);
            }

            private Spine<K, V> balance0() {
                return balance0(c, l, k, v, r);
            }

            private static <K, V> Spine<K, V> balance0(Color rootColor, Spine<K, V> left, K k, V v, Spine<K, V> right) {
                if (!left.isEmpty()) {
                    Node<K, V> l = (Node<K, V>) left;
                    if (l.c == R) {
                        if (!l.l.isEmpty()) {
                            Node<K, V> ll = (Node<K, V>) l.l;
                            if (ll.c == R) {
                                return new Node<>(rootColor, ll.blacken(), l.k, l.v, new Node<>(B, l.r, k, v, right));
                            }
                        }
                        if (!l.r.isEmpty()) {
                            Node<K, V> lr = (Node<K, V>) l.r;
                            if (lr.c == R) {
                                return new Node<>(rootColor, new Node<>(B, l.l, l.k, l.v, lr.l), lr.k, lr.v, new Node<>(B, lr.r, k, v, right));
                            }
                        }
                    }
                }
                if (!right.isEmpty()) {
                    Node<K, V> r = (Node<K, V>) right;
                    if (r.c == R) {
                        if (!r.l.isEmpty()) {
                            Node<K, V> rl = (Node<K, V>) r.l;
                            if (rl.c == R) {
                                return new Node<>(rootColor, new Node<>(B, left, k, v, rl.l), rl.k, rl.v, new Node<>(B, rl.r, r.k, r.v, r.r));
                            }
                        }
                        if (!r.r.isEmpty()) {
                            Node<K, V> rr = (Node<K, V>) r.r;
                            if (rr.c == R) {
                                return new Node<>(rootColor, new Node<>(B, left, k, v, r.l), r.k, r.v, rr.blacken());
                            }
                        }
                    }
                }
                return null;
            }
        }

        static final class E<K, V> extends Spine<K, V> {

            static final E<?, ?> B = new E<>(Color.B);

            static final E<?, ?> BB = new E<>(Color.BB);

            private E(Color c) {
                super(c);
            }

            @Override
            public Spine<K, V> reverse() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            Spine<K, V> blacken() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            Spine<K, V> redder() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            Spine<K, V> ins(K k, V v, Comparator<? super K> comparator) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            Spine<K, V> del(K k, Comparator<? super K> comparator) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            Spine<K, V> removeMin() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            Spine<K, V> removeMax() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public boolean isEmpty() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public V get(K k, Comparator<? super K> comparator) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public Tuple2<K, V> min() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public Tuple2<K, V> max() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public Iterator<Tuple2<K, V>> iterator() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }
}
