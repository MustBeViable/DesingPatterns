import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Prototype {
    private String targetAudience;
    private List<Book> bookList;

    public Recommendation(String targetAudience, List<Book> listOfBook) {
        this.targetAudience = targetAudience;
        this.bookList = listOfBook;
    }

    public void setTargetAudience(String audience) {
        this.targetAudience = audience;
    }

    public List<Book> getBookList() {
        return this.bookList;
    }

    public void addBook(Book book) {
        this.bookList.add(book);
    }

    public void removeBook(Book book) {
        this.bookList.remove(book);
    }

    @Override
    public Prototype clone() {
        List<Book> clonedBooks = new ArrayList<>();
        for (Book book : this.bookList) {
            clonedBooks.add((Book) book.clone());
        }
        return new Recommendation(this.targetAudience, clonedBooks);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Target audience: ").append(targetAudience).append("\n");
        stringBuilder.append("Books:\n");

        if (bookList.isEmpty()) {
            stringBuilder.append("  No books in this list.\n");
        } else {
            for (int i = 0; i < bookList.size(); i++) {
                stringBuilder.append("Book ").append(i + 1).append(":\n");
                stringBuilder.append(bookList.get(i)).append("\n");
            }
        }

        return stringBuilder.toString();
    }
}