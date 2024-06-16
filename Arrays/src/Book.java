public class Book {

    private String title;
    private String isbn;
    private String author;

    public Book (String title, String isbn, String author){

        if (isbn.length() < 12){
            throw new IllegalArgumentException();
        }
        else {
            this.isbn = isbn;
        }
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getIsbn(){
        return isbn;
    }

    public void setIsbn(){
        this.isbn = isbn;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(){
        this.author = author;
    }


}