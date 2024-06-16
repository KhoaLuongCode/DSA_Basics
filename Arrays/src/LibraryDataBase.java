public class LibraryDataBase {


    private Book[] setOfBooks;
    private int capacity;
    private int numBooks;

    public LibraryDataBase(int capacity){

        // if the capacity is less than 0 => throw illegal argument exception
        if (capacity < 0){
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        setOfBooks = new Book[capacity];
    }

    public void add(Book book) {

        // if the capacity is full, numBooks equal to capacity, then call method add more capacity
        if (numBooks == capacity) {
            addMoreCapacity();
        }

        int indexToInsert = 0;
        boolean theRightPlace = false;

        // if there isn't any books, then set the first element of the set of books to book and increase the numBook
        if (setOfBooks[0] == null){
            setOfBooks[0] = book;
            numBooks ++;
        }
        else {
            // find the right index in order to insert
            for (int i = 0; i < numBooks; i++) {
                if (!theRightPlace && (book.getIsbn().compareTo(setOfBooks[i].getIsbn())) < 0) {
                    theRightPlace = true;
                    indexToInsert = i;
                }
            }

            // started shifting the elements forward
            if (theRightPlace) {
                for (int i = numBooks - 1; i >= indexToInsert; i--) {
                    setOfBooks[i + 1] = setOfBooks[i];
                    setOfBooks[indexToInsert] = book;
                    numBooks++;
                }
            }

            // If the isbn number of the book is larger than every book, insert the book at the last
            if (!theRightPlace) {
                setOfBooks[numBooks] = book;
                numBooks++;
            }
        }

    }


    public Book remove(String isbn){

        // if the set of books is not null
        if (setOfBooks[0] != null) {
            // loop through the different books
            for (int i = 0; i < numBooks; i++) {
                //
                if (setOfBooks[i].getIsbn() == isbn) {
                    return setOfBooks[i];
                }
            }
        }
        return null;
    }

    public int size() {
        return numBooks;
    }

    public Book randomSelection(){

      // if the set of books length equal to 0 => return null
      if (setOfBooks.length == 0){
          return null;
      }

      // generate a random index using math random
      int randomIndex = (int) (Math.random()  * (numBooks));
      return setOfBooks[randomIndex];
  }


    public Book findByTitle(String title){
        // if the first element is null return null
        if (setOfBooks[0] != null) {
            // loop through the books
            for (int i = 0; i < numBooks; i++) {
                // when title matches then return
                if (setOfBooks[i].getTitle().equals(title)) {
                    return setOfBooks[i];
                }
            }
        }
        return null;
    }

    public Book findByISBN(String ISBN){
        // if the first element is null return null
        if (setOfBooks[0] != null) {
            // loop through the books
            for (int i = 0; i < numBooks; i++) {
                // when isbn matches then return
                if (setOfBooks[i].getIsbn().equals(ISBN)) {
                    return setOfBooks[i];
                }
            }
        }
        return null;
    }

    public Book[] getAllByAuthor(String author){

        int count = 0;
        int j = 0;

        // loop through all the num books, and increase count when author matches
        for (int i = 0; i < numBooks; i++){
            if (setOfBooks[i].getAuthor().equals(author)){
                count++;
            }
        }
        // create a new array with the size of count
        Book[] newSetOfBooks = new Book[count];

        // started transferring books
        for (int i = 0; i < numBooks; i++){
            if (setOfBooks[i].getAuthor().equals(author)){
                newSetOfBooks[j] = setOfBooks[i];
                j++;
            }
        }

        return newSetOfBooks;
    }

    public void removeDuplicates(){

        Book temp = setOfBooks[0];

        // loop through the length of the book
        for (int i = 0; i < setOfBooks.length; i++){
            if (setOfBooks[i].getIsbn().equals(temp.getIsbn())){
                setOfBooks[i] = null;
            }
            else{
                temp = setOfBooks[i];
            }
        }

        int index = 0;
        int pointer = 0;
        // loop through the books
        while (pointer < numBooks){
            // when the pointer is not null
            if (setOfBooks[pointer] != null){
                // set the index to pointer
                setOfBooks[index] = setOfBooks[pointer];
                // if index is not equal to pointer
                if (index != pointer){
                    setOfBooks[index] = null;
                }
                index++;
            }
            pointer++;
        }
        numBooks = index;
    }


    public Book[] toArray() {
        return setOfBooks;
    }

    /*
    A helper method that adds more capacity if there isn't enough capacity
     */
    public void addMoreCapacity(){
        Book[] newSetOfBooks = new Book[setOfBooks.length + 1];
        for (int i = 0; i < setOfBooks.length; i++){
            newSetOfBooks[i] = setOfBooks[i];
        }
        setOfBooks = newSetOfBooks;
    }


}
