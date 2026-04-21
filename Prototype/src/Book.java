public class Book implements Prototype {
    private final String author;
    private final String title;
    private final Genre genre;

    public Book(String author, String title, Genre genre) {
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    @Override
    public Prototype clone() {
        return new Book(this.author, this.title, this.genre);
    }

    @Override
    public String toString(){
        return "  Book: " + this.title + "\n" +
                "  Author: " +  this.author + "\n" +
                "  Genre: " + this.genre;
    }
}
