package ex5;

import ex4.HashTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class HashTableTest {

    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_put_enHashTableUpdate1() {
        ex5.HashTable hashTable = new ex5.HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("12", "elemento2");
        int expectedSize = 32;
        Assertions.assertEquals(expectedSize,hashTable.size());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_put_enHashTableUpdate3() {
        ex5.HashTable hashTable = new ex5.HashTable();
        hashTable.put("1","elemento1");
        hashTable.put("12", "elemento2");
        hashTable.put("23", "elemento3");
        int expectedSize = 64;
        Assertions.assertEquals(expectedSize,hashTable.size());
    }



    @ParameterizedTest
    @CsvSource({"1, elemento1, 12 elemento2"})
    void test_drop_enHashTable2() {
        ex4.HashTable hashTable = new ex4.HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("12", "elemento2");
        hashTable.drop("1");
        Assertions.assertEquals("\n" +
                " bucket[1] = [12, elemento2]",hashTable.toString());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1, 12, elemento2"})
    void test_drop_enHashTable3() {
        ex4.HashTable hashTable = new ex4.HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("12", "elemento2");
        hashTable.drop("12");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, elemento1]",hashTable.toString());
    }



}