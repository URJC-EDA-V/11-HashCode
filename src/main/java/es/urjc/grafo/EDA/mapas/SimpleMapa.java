package es.urjc.grafo.EDA.mapas;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

/**
 * ADVERTENCIA:
 * Este "mapa" implementa una tabla hash sin resolver colisiones.
 * En caso de colisión, reemplaza la entrada previa con la nueva.
 * Esto NO debería hacerse así. Esta es una clase sin gestión de
 * colisiones cuya única finalidad es trabajar algunos de los
 * primeros conceptos de mapas.
 * Además, tiene un tamaño fijo y no se redimensiona.
 *
 * @param <K> las claves
 * @param <V> los valores
 */
public class SimpleMapa<K, V> extends AbstractMapa<K, V> {

    private final AbstractMapa.MapEntry<K, V>[] table;

    public SimpleMapa() {
        super();
        table = new AbstractMapa.MapEntry[CAPACITY];
    }

    /**
     * Hash function applying MAD method to default hash code.
     *
     * @param key Key
     * @return
     */
    protected int hashValue(K key) {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public V get(K key) {
        int j = hashValue(key);
        if (table[j] == null) return null;
        return table[j].getValue();
    }

    /**
     * Associates the specified value with the specified key in this map
     * (optional operation).  If the map previously contained a mapping for
     * the key, the old value is replaced by the specified value.  (A map
     * {@code m} is said to contain a mapping for a key {@code k} if and only
     * if {@link #containsKey(Object) m.containsKey(k)} would return
     * {@code true}.)
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with {@code key}, or
     * {@code null} if there was no mapping for {@code key}.
     * (A {@code null} return can also indicate that the map
     * previously associated {@code null} with {@code key},
     * if the implementation supports {@code null} values.)
     */
    public V put(K key, V value) {
        int j = hashValue(key);
        V oldValue = null;
        if (table[j] != null) {
            oldValue = table[j].getValue();
        }
        this.table[j] = new AbstractMapa.MapEntry<>(key, value);
        size++;
        return oldValue;
    }

    public V remove(K key) {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterable<Entry<K, V>> entries() {
        return new EntryIterable();
    }

    /**
     * Returns {@code true} if this map contains a mapping for the specified
     * key.  More formally, returns {@code true} if and only if
     * this map contains a mapping for a key {@code k} such that
     * {@code Objects.equals(key, k)}.  (There can be
     * at most one such mapping.)
     *
     * @param key key whose presence in this map is to be tested
     * @return {@code true} if this map contains a mapping for the specified
     * key
     */
    public boolean containsKey(K key) {
        int j = hashValue(key);
        if (table[j] == null) return false;
        return table[j].getKey().equals(key);
    }

    public boolean containsValue(V value) {
        for (V v : this.values()) {
            if (v.equals(value)) return true;
        }
        return false;
    }

    private class EntryIterator implements Iterator<Entry<K, V>> {

        public EntryIterator() {
            // TODO
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public boolean hasNext() {
            // TODO
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Entry<K, V> next() {
            // TODO
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }

    private class EntryIterable implements Iterable<Entry<K, V>> {

        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }

    }
}
