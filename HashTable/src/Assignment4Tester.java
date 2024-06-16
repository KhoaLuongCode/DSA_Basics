import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.io.IOException;
import java.util.ArrayList;

public class Assignment4Tester {

    public Assignment4Tester() throws IOException {
    }

    // TOKENIZER CLASS
    @Test
    public void normalizeTest() throws IOException {
            Tokenizer tk = new Tokenizer("testingNormalize");
            // CASE 1: Normal Text
            assertEquals("helloworld", tk.normalize("Hello World!"));
            // CASE 2: Empty
            assertEquals("", tk.normalize(""));
            // CASE 3: Numbers
            assertEquals("0123456789", tk.normalize("0123456789"));
            // CASE 4: Capitalized letters
            assertEquals("khoaaa", tk.normalize("kHoaAa"));

        }

    @Test
    public void constructorTokenizerFileTest() throws IOException {
        Tokenizer tk = new Tokenizer("testingNormalize");
        // CASE 1: Normal cases, and normalized
        ArrayList<String> compare = new ArrayList<>();
        compare.add("this");
        compare.add("is");
        compare.add("khoa");
        System.out.println(compare);
        assertEquals(compare, tk.getWordList());
        // CASE 2: Single word and normalized
        ArrayList<String> compare1 = new ArrayList<>();
        compare1.add("khoa");
        Tokenizer tk1 = new Tokenizer("testingNormalizeSingleWord");
        assertEquals(compare1, tk1.getWordList());
    }

    @Test
    public void constructorTokenizerTextTest() throws IOException{
        // CASE 1: Normal cases, and normalized
        String[] st = {"Khoa", "Minh", "Luong"};
        Tokenizer tk = new Tokenizer(st);
        assertEquals("khoaminhluong", String.join("", tk.getWordList()));
        // CASE 2: With numbers
        String[] st1 = {"Khoa", "Minh", "Luong", "123", "456"};
        Tokenizer tk1 = new Tokenizer(st1);
        assertEquals("khoaminhluong123456", String.join("", tk1.getWordList()));
        // CASE 3:
        String[] st2 = {"I’m", "going", "to", "eat", "twenty-five", "pancakes."};
        Tokenizer tk2 = new Tokenizer(st2);
        assertEquals("imgoingtoeattwentyfivepancakes", String.join("", tk2.getWordList()));
    }

    // HASH TABLE CLASS

    @Test
    public void putTest() {
        HashTable table = new HashTable();
        // CASE 1: Add normal entries and retrieve
        table.put("Khoa", 1);
        assertEquals(1, table.get("Khoa"));
        // CASE 2: Add entries with the same value
        table.put("Cut", 12);
        assertEquals(12, table.get("Cut"));
        // CASE 3: Add a value with same key and it updates
        table.put("Khoa", 24);
        assertEquals(25, table.get("Khoa"));
    }

    @Test
    public void getTest(){
        HashTable table = new HashTable();
        // CASE 1: Add normal entries and retrieve
        table.put("Khoa", 1);
        assertEquals(true, table.get("Khoa").equals(1));
        // CASE
    }

    @Test
    public void getEntriesTest() {
        HashTable table = new HashTable();
        table.put("a", 1);
        table.put("b", 2);
        table.put("c", 3);
        assertEquals(3, table.getEntries().size());
    }

    @Test
    public void testRehash() {
        // Create a hash table with a capacity of 4
        HashTable<Integer> table = new HashTable<>(4);

        // Add some key-value pairs
        table.put("A", 1);
        table.put("B", 2);
        table.put("C", 3);
        table.put("D", 4);
        table.put("E", 5);
        table.put("F", 6);

        // Check that all key-value pairs are present
        assertEquals(6, table.size());
        assertEquals(Integer.valueOf(1), table.get("A"));
        assertEquals(Integer.valueOf(2), table.get("B"));
        assertEquals(Integer.valueOf(3), table.get("C"));
        assertEquals(Integer.valueOf(4), table.get("D"));
        assertEquals(Integer.valueOf(5), table.get("E"));
    }

    @Test
    public void sizeTest() {
        HashTable table = new HashTable();
        // CASE 1: No size yet
        assertEquals(0, table.size());
        // CASE 2: After add 1 entry, size table increases
        table.put("Khoa", 12);
        assertEquals(1, table.size());
        // CASE 3: After add another entry, size table increases to 2
        table.put("Khoa L", 2);
        assertEquals(2, table.size());
    }

    @Test
    public void removeTest(){
        HashTable table = new HashTable();
        // CASE 1: put and then remove
        table.put("Khoa", 1);
        table.put("Case", 3);
        table.remove("Khoa");
        assertEquals(null, table.get("Khoa"));
        assertEquals(3, table.get("Case"));
    }

    @Test
    public void containKeysTest(){
        HashTable table = new HashTable();
        table.put("Khoa", 1);
        assertEquals(true, table.containKeys("Khoa"));
        assertEquals(false, table.containKeys("Unavaiable"));
    }


    // WORD STAT CLASS

    @Test
    public void wordCountTest() throws IOException {
        WordStat ws = new WordStat("testingWordStatCount");
        assertEquals(1, ws.wordCount("khoa"));
        assertEquals(2, ws.wordCount("case"));
        assertEquals(1, ws.wordCount("western"));
        assertEquals(3, ws.wordCount("reserve"));
    }

    @Test
    public void wordRank() throws IOException {
        WordStat ws = new WordStat("testingWordRankCount");
        assertEquals(1, ws.wordRank("khoa"));
        assertEquals(2, ws.wordRank("case"));
        assertEquals(2, ws.wordRank("western"));
    }

    @Test
    public void kMostCommonWordsTest() throws IOException {
        WordStat ws = new WordStat("testingMostCommonWords");
        assertEquals(new String[]{"case", "khoa"}, ws.KMostCommonWords(2));
    }

    @Test
    public void kLeastCommonWords() throws IOException {
        WordStat ws = new WordStat("testingLeastCommonWords");
        assertEquals(new String[]{"university", "world", "the"}, ws.KLeastCommonWords(3));
    }

}
