import java.util.Objects;

public class Book {
    private String name;
    private String author;
    private Genre genre;
    private boolean isLoaned;
    private double loanedNumber;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                ", isLoaned=" + isLoaned +
                ", loanedNumber=" + loanedNumber +
                '}';
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isLoaned == book.isLoaned &&
                loanedNumber == book.loanedNumber &&
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, genre, isLoaned, loanedNumber);
    }

    public double getLoanedNumber() {
        return loanedNumber;
    }

    public void setLoanedNumber( int loanedNumber ) {
        this.loanedNumber = loanedNumber;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor( String author ) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre( Genre genre ) {
        this.genre = genre;
    }

    public boolean isLoaned() {
        return isLoaned;
    }

    public void setLoaned( boolean loaned ) {
        isLoaned = loaned;
    }

    public Book( String name, String author, Genre genre, boolean isLoaned, double loanedNumber ) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.isLoaned = isLoaned;
        this.loanedNumber = loanedNumber;
    }
}
