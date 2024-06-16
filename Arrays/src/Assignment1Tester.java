import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Assignment1Tester {

    Book book1 = new Book("THIS", "1234567891234", "author1");
    Book book2 = new Book("IS", "2345678912345", "author2");
    Book book3 = new Book("THE", "9999999999999", "author3");
    Book book4 = new Book("TITLE", "9999999999999", "author4");
    Book book5 = new Book("OF", "9999999999999", "author1");
    Book book6 = new Book("OF", "9999999999999", "author5");
    Book book7 = new Book("OF", "9999999999999", "author5");

    @Test
    public void addBookTest() {
        // THE CAPACITY EQUALS NUMBER OF BOOKS ADDED IN
        LibraryDataBase lb = new LibraryDataBase(2);
        lb.add(book2);
        lb.add(book1);
        assertArrayEquals(new Book[] {book1, book2}, lb.toArray());

        // THE CAPACITY LESS THAN NUMBER OF BOOKS ADDED IN
        LibraryDataBase lb1 = new LibraryDataBase(2);
        lb1.add(book2);
        lb1.add(book1);
        lb1.add(book3);
        assertArrayEquals(new Book[] {book1, book2, book3}, lb1.toArray());

        // THE CAPACITY IS MORE THAN NUMBER OF BOOKS ADDED IN
        LibraryDataBase lb2 = new LibraryDataBase(5);
        lb2.add(book2);
        lb2.add(book1);
        lb2.add(book3);
        assertArrayEquals(new Book[] {book1, book2, book3, null, null}, lb2.toArray());

        // THE CAPACITY IS 0
        LibraryDataBase lb3 = new LibraryDataBase(4);
        lb3.add(book2);
        assertArrayEquals(new Book[] {book2, null, null, null}, lb3.toArray());
    }

    @Test
    public void removeBookTest(){
        // TWO BOOKS AND REMOVE ONE
        LibraryDataBase lb = new LibraryDataBase(2);
        lb.add(book1);
        lb.add(book2);
        assertEquals(book1, lb.remove("1234567891234"));

        // THREE BOOKS AND REMOVE ONE
        LibraryDataBase lb1 = new LibraryDataBase(2);
        lb1.add(book2);
        lb1.add(book1);
        lb1.add(book3);
        lb1.remove("9999999999999");
        assertEquals(book3, lb1.remove("9999999999999"));
    }

    @Test
    public void sizeMethodTest(){
        // SIZE BOOKS OF 3 => RETURN SIZE OF 3
        LibraryDataBase lb = new LibraryDataBase(2);
        lb.add(book1);
        lb.add(book2);
        lb.add(book3);
        assertEquals(3, lb.size());

        // SIZE BOOKS OF 0
        LibraryDataBase lb1 = new LibraryDataBase(3);
        assertEquals(0, lb1.size());
    }

    @Test
    public void randomSelectionTest(){
        // 3 BOOKS RANDOMLY AND CHOOSE A RANDOM BOOK
        LibraryDataBase lb = new LibraryDataBase(5);
        lb.add(book1);
        lb.add(book2);
        lb.add(book3);
        assertEquals(book3, lb.randomSelection());
    }

    @Test
    public void findByTitleTest(){
        // TITLE THIS, WHICH MATCHES WITH BOOK1
        LibraryDataBase lb = new LibraryDataBase(3);
        lb.add(book1);
        lb.add(book2);
        lb.add(book3);
        assertEquals(book1, lb.findByTitle("THIS"));

        // THERE ISN'T A TITLE, SO RETURN NULL
        LibraryDataBase lb1 = new LibraryDataBase(3);
        lb1.add(book1);
        lb1.add(book2);
        lb1.add(book3);
        assertEquals(null, lb1.findByTitle("NOT AVAILABLE"));

        // THERE ISN'T ANY BOOK IN THE DATABASE
        LibraryDataBase lb2 = new LibraryDataBase(3);
        assertEquals(null, lb2.findByTitle("THIS"));
    }

    @Test
    public void findByISBNTest(){
        // THERE IS AN ISBN MATCHES IN THE DATABASE
        LibraryDataBase lb = new LibraryDataBase(3);
        lb.add(book1);
        lb.add(book2);
        lb.add(book3);
        assertEquals(book1, lb.findByISBN("1234567891234"));

        // THERE ISN'T AN ISBN MATCHES IN THE DATABASE, SO RETURN NULL
        LibraryDataBase lb1 = new LibraryDataBase(3);
        lb1.add(book1);
        lb1.add(book2);
        lb1.add(book3);
        assertEquals(null, lb1.findByISBN("1000"));

        // THERE ISN'T ANY BOOK IN THE DATABASE
        LibraryDataBase lb2 = new LibraryDataBase(3);
        assertEquals(null, lb2.findByISBN("10000000"));
    }

    @Test
    public void getAllByAuthorTest(){
        // THERE ARE TWO BOOKS IN THE DATABASE WITH THE SAME AUTHOR (BOOK1 & BOOK5)
        LibraryDataBase lb = new LibraryDataBase(5);
        lb.add(book1);
        lb.add(book2);
        lb.add(book3);
        lb.add(book4);
        lb.add(book5);
        assertArrayEquals(new Book[] {book1, book5}, lb.getAllByAuthor("author1"));

        // THERE ARE NONE IN THE DATABASE WITH THE SAME AUTHOR
        LibraryDataBase lb1 = new LibraryDataBase(5);
        lb1.add(book1);
        lb1.add(book2);
        lb1.add(book3);
        lb1.add(book4);
        lb1.add(book5);
        assertArrayEquals(new Book[] {}, lb.getAllByAuthor("author none"));
    }

    @Test
    public void removeDuplicateTest(){
        LibraryDataBase lb = new LibraryDataBase(6);

        lb.add(book1);
        lb.add(book2);
        lb.add(book3);
        lb.add(book4);
        lb.add(book5);
        lb.add(book6);
        lb.add(book7);
        lb.removeDuplicates();
    }









}


