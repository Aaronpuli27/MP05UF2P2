package ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import original.HashTable;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void count() {
    }

    @Test
    void size() {
    }

    @Test
    void put() {
    }

    @Test
    void get() {
    }

    @Test
    void drop() {
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_put_enHashTableVacio(String key, String value) {
        original.HashTable hashTable = new HashTable();
        hashTable.put(key, value);
        Assertions.assertEquals("\n bucket[1] = [1, elemento1]", hashTable.toString());
    }
}