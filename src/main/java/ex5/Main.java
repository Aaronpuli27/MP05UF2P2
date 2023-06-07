package ex5;

import ex4.HashTable;

import static java.rmi.server.LogStream.log;

public class Main {
    public static void main(String[] args) {
        ex4.HashTable hashTable = new HashTable();

        // Put some key values.
        for(int i=0; i<30; i++) {
            final String key = String.valueOf(i);
            hashTable.put(key, key);
        }

        // Print the HashTable structure
        log("****   HashTable  ***");
        log(hashTable.toString());
        log("\nValue for key(20) : " + hashTable.get("20") );
    }
}
