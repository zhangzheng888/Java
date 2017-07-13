
public class Book implements Quotable, Comparable<Book> {
    private String isbn;
    private String author;
    private String title;
    private String publisher;

    private int publicationYear;
    private int publicationMonth;
    private int publicationDay;
    private int pageCount;

    public Book(String isbn, String author, String title, String publisher,
                int publicationYear, int publicationMonth, int publicationDay, int pageCount) {

        if (publicationYear < 0 ||
                (publicationMonth > 12 || publicationMonth < 1) ||
                (publicationDay > 31 || publicationDay < 1)) {
            throw new IllegalArgumentException("Please enter valid date units");
        }

        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.publisher = publisher;

        this.publicationYear = publicationYear;
        this.publicationMonth = publicationMonth;
        this.publicationDay = publicationDay;
        this.pageCount = pageCount;

    }

    @Override
    public String getISBN() {
        return isbn;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getPublisher() {
        return publisher;
    }

    @Override
    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public int getPublicationMonth() {
        return publicationMonth;
    }

    @Override
    public int getPublicationDay() {
        return publicationDay;
    }

    @Override
    public int getPageCount() {
        return pageCount;
    }

    @Override
    public int compareTo(Book o) {
        return isbn.compareTo(o.getISBN());
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + "\n" +
                "Pages: " + pageCount + "\n" +
                "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Publisher: " + publisher + "\n" +
                "Publication Date: " + publicationMonth +
                "\\" + publicationDay +
                "\\" + publicationYear + "\n";
    }
}
