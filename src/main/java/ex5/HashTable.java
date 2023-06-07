package ex5;

import java.util.ArrayList;

/**
 * Implementación de una tabla de hash sin colisiones.
 */
public class HashTable {
    private int SIZE = 16;
    private int ITEMS = 0;
    private HashEntry[] entries = new HashEntry[SIZE];

    public int count() {
        return this.ITEMS;
    }

    public int size() {
        return this.SIZE;
    }

    public void put(Object key, Object value) {
        int hash = getHash(key);
        HashEntry entry = new HashEntry(key, value);

        if (entries[hash] == null) {
            entries[hash] = entry;
            ITEMS++;
        } else {
            rehashAndPut(key, value);
        }
    }

    public Object get(Object key) {
        int hash = getHash(key);
        if (entries[hash] != null && entries[hash].key.equals(key)) {
            return entries[hash].value;
        }
        return null;
    }

    public void drop(Object key) {
        int hash = getHash(key);
        if (entries[hash] != null && entries[hash].key.equals(key)) {
            entries[hash] = null;
            ITEMS--;
        }
    }

    private void rehashAndPut(Object key, Object value) {
        HashEntry[] tempEntries = entries;
        SIZE *= 2;
        ITEMS = 0;
        entries = new HashEntry[SIZE];

        for (HashEntry entry : tempEntries) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }

        put(key, value);
    }

    private int getHash(Object key) {
        return key.hashCode() % SIZE;
    }

    private class HashEntry {
        Object key;
        Object value;

        public HashEntry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public String toString() {
        StringBuilder hashTableStr = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            if (entries[i] != null) {
                hashTableStr.append("bucket[").append(i).append("] = ").append(entries[i].toString()).append("\n");
            }
        }
        return hashTableStr.toString();
    }

    public String getCollisionsForKey(String key) {
        return getCollisionsForKey(key, 1).get(0);
    }

    public ArrayList<String> getCollisionsForKey(String key, int quantity) {
        final char[] alphabet = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        ArrayList<Integer> newKey = new ArrayList<>();
        ArrayList<String> foundKeys = new ArrayList<>();

        newKey.add(0);
        int collision = getHash(key);
        int current = newKey.size() - 1;

        while (foundKeys.size() < quantity) {
            String currentKey = "";
            for (int i = 0; i < newKey.size(); i++) {
                currentKey += alphabet[newKey.get(i)];
            }

            if (!currentKey.equals(key) && getHash(currentKey) == collision) {
                foundKeys.add(currentKey);
            }

            newKey.set(current, newKey.get(current) + 1);

            if (newKey.get(current) == alphabet.length) {
                int previous = current;
                do {
                    previous--;
                    if (previous >= 0) {
                        newKey.set(previous, newKey.get(previous) + 1);
                    }
                } while (previous >= 0 && newKey.get(previous) == alphabet.length);

                for (int i = previous + 1; i < newKey.size(); i++) {
                    newKey.set(i, 0);
                }

                if (previous < 0) {
                    newKey.add(0);
                }

                current = newKey.size() - 1;
            }
        }

        return foundKeys;
    }
}