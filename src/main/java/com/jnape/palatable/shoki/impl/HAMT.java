package com.jnape.palatable.shoki.impl;

import com.jnape.palatable.lambda.adt.hlist.Tuple2;
import com.jnape.palatable.lambda.adt.product.Product2;
import com.jnape.palatable.shoki.api.EquivalenceRelation;
import com.jnape.palatable.shoki.api.HashingAlgorithm;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import static com.jnape.palatable.lambda.adt.hlist.HList.tuple;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Flatten.flatten;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Eq.eq;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Find.find;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Map.map;
import static com.jnape.palatable.lambda.functions.builtin.fn3.FoldLeft.foldLeft;
import static com.jnape.palatable.shoki.api.Natural.one;
import static com.jnape.palatable.shoki.impl.Bitmap32.bitIsSet;
import static com.jnape.palatable.shoki.impl.Bitmap32.lowerBits;
import static com.jnape.palatable.shoki.impl.Bitmap32.setBit;
import static com.jnape.palatable.shoki.impl.Bitmap32.unsetBit;
import static com.jnape.palatable.shoki.impl.StrictStack.strictStack;
import static java.lang.Integer.bitCount;
import static java.util.Arrays.asList;
import static java.util.Collections.singleton;

interface HAMT<K, V> extends Iterable<Tuple2<K, V>> {

    int LEVEL_SIZE = 5;

    HAMT<K, V> put(K key, V value, int keyHash, EquivalenceRelation<? super K> keyEqRel, HashingAlgorithm<? super K> keyHashAlg, int shift);

    V get(K key, int keyHash, EquivalenceRelation<? super K> keyEqRel, int shift);

    HAMT<K, V> remove(K key, int keyHash, EquivalenceRelation<? super K> keyEqRel, int shift);

    final class Node<K, V> implements HAMT<K, V> {

        private static final Node<?, ?> ROOT = new Node<>(0, new Object[0]);

        private final int bitmap;

        private final Object[] table;

        public Node(int bitmap, Object[] table) {
            this.bitmap = bitmap;
            this.table = table;
        }

        @Override
        public V get(K key, int keyHash, EquivalenceRelation<? super K> keyEqRel, int shift) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Node<K, V> put(K key, V value, int keyHash, EquivalenceRelation<? super K> keyEqRel, HashingAlgorithm<? super K> keyHashAlg, int shift) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Iterator<Tuple2<K, V>> iterator() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public HAMT<K, V> remove(K key, int keyHash, EquivalenceRelation<? super K> keyEqRel, int shift) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(Object other) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private int tableIndex(int bitmapIndex) {
            return bitCount(lowerBits(bitmap, bitmapIndex));
        }

        @SuppressWarnings("unchecked")
        private HAMT<K, V> valueAtIndex(int tableIndex) {
            return (HAMT<K, V>) table[tableIndex];
        }

        private Node<K, V> insertAt(int tableIndex, int bitmapIndex, HAMT<K, V> valueForSlot) {
            return new Node<>(setBit(bitmap, bitmapIndex), Arrays.insertAt(tableIndex, table, valueForSlot));
        }

        private Node<K, V> overrideAt(int tableIndex, HAMT<K, V> valueForSlot) {
            return new Node<>(bitmap, Arrays.overrideAt(tableIndex, table, valueForSlot));
        }

        private Node<K, V> deleteAt(int bitmapIndex, int tableIndex) {
            return new Node<>(unsetBit(bitmap, bitmapIndex), Arrays.deleteAt(tableIndex, table));
        }

        @SuppressWarnings("unchecked")
        static <K, V> HAMT<K, V> rootNode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private static int bitmapIndex(int keyHash, int shift) {
            return (keyHash >>> shift) & 31;
        }
    }

    final class Entry<K, V> implements HAMT<K, V>, Product2<K, V> {

        private final K k;

        private final V v;

        Entry(K k, V v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public K _1() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public V _2() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public HAMT<K, V> put(K newKey, V newValue, int keyHash, EquivalenceRelation<? super K> keyEqRel, HashingAlgorithm<? super K> keyHashAlg, int shift) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Iterator<Tuple2<K, V>> iterator() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public V get(K key, int keyHash, EquivalenceRelation<? super K> keyEqRel, int shift) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public HAMT<K, V> remove(K key, int keyHash, EquivalenceRelation<? super K> keyEqRel, int shift) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(Object other) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    final class Collision<K, V> implements HAMT<K, V> {

        private final int keyHash;

        private final StrictStack<Entry<K, V>> kvPairs;

        Collision(int keyHash, StrictStack<Entry<K, V>> kvPairs) {
            this.keyHash = keyHash;
            this.kvPairs = kvPairs;
        }

        @Override
        public HAMT<K, V> put(K key, V value, int keyHash, EquivalenceRelation<? super K> keyEqRel, HashingAlgorithm<? super K> keyHashAlg, int shift) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Iterator<Tuple2<K, V>> iterator() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public V get(K key, int keyHash, EquivalenceRelation<? super K> keyEqRel, int shift) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public HAMT<K, V> remove(K key, int keyHash, EquivalenceRelation<? super K> keyEqRel, int shift) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(Object other) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
