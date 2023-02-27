package ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class HashTableTest {

    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_put_enHashTableVacio(String key, String value) {
        HashTable hashTable = new HashTable();
        hashTable.put(key, value);
        Assertions.assertEquals("\n bucket[1] = [1, elemento1]", hashTable.toString());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1, 2, elemento2"})
    void test_put_enHashTableVacioAmbElements(String key, String value, String key2, String value2) {
        HashTable hashTable = new HashTable();
        hashTable.put(key, value);
        hashTable.put(key2, value2);
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, elemento1]\n" +
                " bucket[2] = [2, elemento2]", hashTable.toString());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1, 1, elemento2"})
    void test_put_enHashTableNoVacioCon2Elementos(String key, String value, String key2, String value2) {
        HashTable hashTable = new HashTable();
        hashTable.put(key, value);
        hashTable.put(key2, value2);
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, elemento1] -> [1, elemento2]", hashTable.toString());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1, 1, elemento2, 1, elemento3"})
    void test_put_enHashTableNoVacioCon3Elementos(String key, String value, String key2, String value2, String key3, String value3) {
        HashTable hashTable = new HashTable();
        hashTable.put(key, value);
        hashTable.put(key2, value2);
        hashTable.put(key3, value3);
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, elemento1] -> [1, elemento2] -> [1, elemento3]", hashTable.toString());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_put_enHashTableUpdate1() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("1", "elemento2");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, elemento2]", hashTable.toString());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_put_enHashTableUpdate2() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","elemento1");
        hashTable.put("12", "elemento2");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, elemento1] -> [12, elemento2]", hashTable.toString());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_put_enHashTableUpdate3() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","elemento1");
        hashTable.put("12", "elemento2");
        hashTable.put("23", "elemento3");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, elemento1] -> [12, elemento2] -> [23, elemento3]", hashTable.toString());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_get_enHashTableVacio() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","elemento1");
        Assertions.assertEquals("elemento1", hashTable.get("1"));
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1, 12, elemento2"})
    void test_get_enHashTable2() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("12", "elemento2");
        Assertions.assertEquals("elemento1", hashTable.get("1"));
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1, 12, elemento2"})
    void test_get_enHashTable3() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("12", "elemento2");
        Assertions.assertEquals("elemento2", hashTable.get("12"));
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1, 12, elemento2, 23, elemento3"})
    void test_get_enHashTable4() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","elemento1");
        hashTable.put("12", "elemento2");
        hashTable.put("23", "elemento3");
        Assertions.assertEquals("elemento3", hashTable.get("23"));
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_get_enHashTable5() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","elemento1");
        Assertions.assertNull( hashTable.get("2"));
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_get_enHashTable6() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","elemento1");
        Assertions.assertNull( hashTable.get("12"));
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1, 12, elemento2, 23, elemento3"})
    void test_get_enHashTable7() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","elemento1");
        hashTable.put("12","elemento1");
        hashTable.put("23","elemento1");
        Assertions.assertNull( hashTable.get("34"));
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_drop_enHashTable1() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.drop("1");
        Assertions.assertEquals("",hashTable.toString());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1, 12 elemento2"})
    void test_drop_enHashTable2() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("12", "elemento2");
        hashTable.drop("1");
        Assertions.assertEquals("\n" +
                " bucket[1] = [12, elemento2]",hashTable.toString());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1, 12, elemento2"})
    void test_drop_enHashTable3() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("12", "elemento2");
        hashTable.drop("12");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, elemento1]",hashTable.toString());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1, 12, elemento2, 23, elemento3"})
    void test_drop_enHashTable4() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("12", "elemento2");
        hashTable.put("23", "elemento2");
        hashTable.drop("23");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, elemento1] -> [12, elemento2]",hashTable.toString());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_drop_enHashTable5() {
        HashTable hashTable = new HashTable();
        hashTable.drop("1");
        Assertions.assertEquals("",hashTable.toString());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_drop_enHashTable6() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.drop("13");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, elemento1]",hashTable.toString());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1, 12, elemento2, 23, elemento3"})
    void test_drop_enHashTable7() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("12", "elemento1");
        hashTable.put("23", "elemento1");
        hashTable.drop("35");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, elemento1] -> [12, elemento1] -> [23, elemento1]",hashTable.toString());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_count_put_enHashTable1() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        Assertions.assertEquals(0,hashTable.count());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1, 2, elemento2"})
    void test_count_put_enHashTable2() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("2", "elemento2");
        Assertions.assertEquals(0,hashTable.count());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1, 1, elemento2"})
    void test_count_put_enHashTable3() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("1", "elemento2");
        Assertions.assertEquals(0,hashTable.count());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1, 1, elemento2, 1, elemento3"})
    void test_count_put_enHashTable4() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("1", "elemento2");
        hashTable.put("1", "elemento3");
        Assertions.assertEquals(0,hashTable.count());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_count_put_enHashTable5() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("1", "elemento2");
        Assertions.assertEquals(0,hashTable.count());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_count_put_enHashTable6() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","elemento1");
        hashTable.put("12", "elemento2");
        Assertions.assertEquals(0,hashTable.count());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_count_put_enHashTable7() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","elemento1");
        hashTable.put("12", "elemento2");
        hashTable.put("23", "elemento3");
        Assertions.assertEquals(0,hashTable.count());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_count_drop_enHashTable1() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.drop("1");
        Assertions.assertEquals(0,hashTable.count());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1, 12 elemento2"})
    void test_count_drop_enHashTable2() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("12", "elemento2");
        hashTable.drop("1");
        Assertions.assertEquals(0,hashTable.count());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1, 12, elemento2"})
    void test_count_drop_enHashTable3() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("12", "elemento2");
        hashTable.drop("12");
        Assertions.assertEquals(0,hashTable.count());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1, 12, elemento2, 23, elemento3"})
    void test_count_drop_enHashTable4() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("12", "elemento2");
        hashTable.put("23", "elemento2");
        hashTable.drop("23");
        Assertions.assertEquals(0,hashTable.count());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_count_drop_enHashTable5() {
        HashTable hashTable = new HashTable();
        hashTable.drop("1");
        Assertions.assertEquals(0,hashTable.count());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_count_drop_enHashTable6() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.drop("13");
        Assertions.assertEquals(0,hashTable.count());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1, 12, elemento2, 23, elemento3"})
    void test_count_drop_enHashTable7() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("12", "elemento1");
        hashTable.put("23", "elemento1");
        hashTable.drop("35");
        Assertions.assertEquals(0,hashTable.count());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_size_put_enHashTable1() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        Assertions.assertEquals(16,hashTable.size());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1, 2, elemento2"})
    void test_size_put_enHashTable2() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("2", "elemento2");
        Assertions.assertEquals(16,hashTable.size());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1, 1, elemento2"})
    void test_size_put_enHashTable3() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("1", "elemento2");
        Assertions.assertEquals(16,hashTable.size());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1, 1, elemento2, 1, elemento3"})
    void test_size_put_enHashTable4() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("1", "elemento2");
        hashTable.put("1", "elemento3");

        Assertions.assertEquals(16,hashTable.size());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_size_put_enHashTable5() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("1", "elemento2");
        Assertions.assertEquals(16,hashTable.size());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_size_put_enHashTable6() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","elemento1");
        hashTable.put("12", "elemento2");
        Assertions.assertEquals(16,hashTable.size());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_size_put_enHashTable7() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","elemento1");
        hashTable.put("12", "elemento2");
        hashTable.put("23", "elemento3");
        Assertions.assertEquals(16,hashTable.size());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_size_drop_enHashTable1() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.drop("1");
        Assertions.assertEquals(16,hashTable.size());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1, 12 elemento2"})
    void test_size_drop_enHashTable2() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("12", "elemento2");
        hashTable.drop("1");
        Assertions.assertEquals(16,hashTable.size());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1, 12, elemento2"})
    void test_size_drop_enHashTable3() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("12", "elemento2");
        hashTable.drop("12");
        Assertions.assertEquals(16, hashTable.size());
    }
    @ParameterizedTest
    @CsvSource({"1, elemento1, 12, elemento2, 23, elemento3"})
    void test_size_drop_enHashTable4() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("12", "elemento2");
        hashTable.put("23", "elemento2");
        hashTable.drop("23");
        Assertions.assertEquals(16, hashTable.size());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_size_drop_enHashTable5() {
        HashTable hashTable = new HashTable();
        hashTable.drop("1");
                Assertions.assertEquals(16,hashTable.size());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1"})
    void test_size_drop_enHashTable6() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.drop("13");
        Assertions.assertEquals(16,hashTable.size());
    }

    @ParameterizedTest
    @CsvSource({"1, elemento1, 12, elemento2, 23, elemento3"})
    void test_size_drop_enHashTable7() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "elemento1");
        hashTable.put("12", "elemento1");
        hashTable.put("23", "elemento1");
        hashTable.drop("35");
        Assertions.assertEquals(16,hashTable.size());
    }


}