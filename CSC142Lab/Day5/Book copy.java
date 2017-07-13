import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class contains instance data for a book that will be used in {@link Bookshelf}, including
 * the title, author, genre, and number of pages.
 *
 * @author Terry Weiss
 * @see    Bookshelf
 * @see    Librarian
 */
public class Book implements Comparable<Book> {
    private static final String DEFAULT_AUTHOR = "Unknown";
    private static final String DEFAULT_GENRE  = "General";

    private static int untitledBooks = 0; //Total count of all untitled books to uniquely name them
    private String title;
    private String author;
    private String genre;
    private int pages;


    /**
     *  Creates a new Book with everything specified.
     *
     *  @param title  The title of the Book
     *  @param pages  The number of pages in the Book
     *  @param author The author of the Book
     *  @param genre  The Book's genre
     */
    public Book(String title, int pages, String author, String genre) {
        setTitle(title);
        setPages(pages);
        setAuthor(author);
        setGenre(genre);
    }

    /**
     * Creates a new Book using the default genre name.
     *
     * @param title  The title of the Book
     * @param pages  The number of pages in the Book
     * @param author The author of the Book
     */
    Book(String title, int pages, String author) {
        setTitle(title);
        setPages(pages);
        setAuthor(author);
        setGenre(DEFAULT_GENRE);
    }

    /**
     * Creates a new Book using the default author and genre names.
     *
     * @param title The title of the Book
     * @param pages The number of pages in the Book
     */
    Book(String title, int pages) {
        setTitle(title);
        setPages(pages);
        setAuthor(DEFAULT_AUTHOR);
        setGenre(DEFAULT_GENRE);
    }


    /*
     * Internally sets the Book's title in Title Case. If no title is specified, the title will be
     * uniquely named by using "Untitled #<next_book_number>" format.
     *
     * @param title New title to be used
     * @return Book's new title name
     * // @see #titleCase
     */
    private String setTitle(String title) {
        if (title.length() == 0) {
            untitledBooks++;
            title = "Untitled #" + untitledBooks;
        }
        else {
            title = titleCase(title);
        }

        return (this.title = title);
    }

    /*
     * Sets the book's number of pages.
     *
     * @param pages Number of pages in the book
     * @return New number of pages
     */
    private int setPages(int pages) {
        if (pages < 1) {
            pages = 1;
        }

        return (this.pages = pages);
    }

    /*
     * Sets the book's author in Capital Case.
     *
     * @param author Name of the book's author
     * @return New author's name
     */
    private String setAuthor(String author) {
        String fullName = "";
        String[] names = author.split(" ");

        for (int currentName = 0; currentName < names.length - 1; currentName++) {
            fullName += capitalize(names[currentName]) + " ";
        }

        fullName += capitalize(names[names.length - 1]);

        return (this.author = fullName);
    }

    /*
     * Sets the book's genre in Capital Case.
     *
     * @param genre Name of the book's genre
     * @return New genre
     */
    private String setGenre(String genre) {
        if (genre.length() == 0) {
            genre = DEFAULT_GENRE;
        }
        else {
            genre = capitalize(genre);
        }

        return (this.genre = genre);
    }


    /**
     * Provides the Book's title.
     *
     * @return Book's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Provides the number of pages in the book.
     *
     * @return Number of pages in the Book
     */
    public int getPages() {
        return pages;
    }

    /**
     * Provides the Book's author.
     *
     * @return Book's author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Provides the Book's genre.
     *
     * @return Book's genre
     */
    public String getGenre() {
        return genre;
    }


    /**
     * Provides a table of the Book's details.
     *
     * @return Book's Title, Author, Genre and number of Pages
     */
    public String displayDetails() {
        String details = "Title:  " + title  + "\n"
                       + "Author: " + author + "\n"
                       + "Genre:  " + genre  + "\n"
                       + "Pages:  " + pages;

        return details;
    }


    /*
     *  Converts a string into Title Case. Certain words aren't capitalized per
     *  Chicago Manual of Style.
     *
     *  @param str Title to be converted
     *  @return Title converted to Title Case
     *  @see #capitalize
     *  @see #isTitleWord
     */
    private static String titleCase(String str) {
        String[] words = str.split(" ");
        String ret;
        int currentWord;

        //Always capitalize first and last words, with other words in Title Case as needed
        ret = capitalize(words[0]) + " ";

        for (currentWord = 1; currentWord < (words.length - 1); currentWord++) {
            String word = words[currentWord];

            if (isTitleWord(word)) {
                ret += capitalize(word) + " ";
            }
            else {
                ret += word.toLowerCase() + " ";
            }
        }

        if (words.length > 1) {
            ret += capitalize(words[currentWord]);
        }

        return ret.trim();
    }

    /*
     * Converts every word into Capital Case.
     *
     * @param word Word to be converted to Capital Case
     * @return Capitalized word
     */
    private static String capitalize(String word) {
        return (word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase());
    }

    /*
     * Determines if a word should be capitalized when it's in a title,
     * per Chicago Manual of Style.
     *
     * @param word Word to be checked
     * @return <tt>true</tt> if it should be capitalized
     */
    private static boolean isTitleWord(String word) {
        boolean isCapitalized;
        word = word.toLowerCase();

        //All articles, coordinate conjunctions, and prepositions are lower case in titles,
        //per Chicago Manual of Style
        switch (word) {
            //Articles:
            case "a":       case "an":      case "the":
            //Coordinate conjunctions:
            case "and":     case "but":     case "for":     case "nor":     case "or":
            case "so":      case "yet":
            //Most common single-word English prepositions:
            case "at":      case "by":      case "in":      case "into":    case "near":
            case "of":      case "on":      case "to":      case "than":    case "via":
                isCapitalized = false;
                break;

            default:
                isCapitalized = true;
        }

        return isCapitalized;
    }


    /**
     *  Represents the class as a String, currently using the book's Title.
     *
     *  @return Book's title
     */
    @Override
    public String toString() {
        return getTitle();
    }

    /**
     *  Allows Book objects to be sorted by their size based on the number of pages.
     *
     *  @param book2 The second Book object being compared against
     *  @return The number of pages more than the book being compared against
     */
    @Override
    public int compareTo(Book book2) {
        return (this.getPages() - book2.getPages());
    }

    /**
     *  Rule to compare books by their titles in ascending order (case insensitive, ignoring a 
     *  leading "the").
     */
    public static Comparator<Book> sortByTitle = (Book book1, Book book2) -> {
        String bookTitle1 = book1.getTitle().toLowerCase();
        if (bookTitle1.startsWith("the ")) {
            bookTitle1 = bookTitle1.substring(4, bookTitle1.length());
        }

        String bookTitle2 = book2.getTitle().toLowerCase();
        if (bookTitle2.startsWith("the ")) {
            bookTitle2 = bookTitle2.substring(4, bookTitle2.length());
        }

        return bookTitle1.compareTo(bookTitle2);
    };

    /**
     *  Rule to compare books by their authors in ascending order (case insensitive).
     *  Sort is by last names first, followed by first name, etc.
     */
    public static Comparator<Book> sortByAuthor = (Book book1, Book book2) -> {
        String bookAuthor1 = book1.getAuthor().toLowerCase();
        String bookAuthor2 = book2.getAuthor().toLowerCase();

        // Sort by last name first
        String[] author1 = bookAuthor1.split(" ");
        bookAuthor1 = author1[author1.length - 1];
        for (int i = 0; i < author1.length - 2; i++) {
            bookAuthor1 += author1[i] + " ";
        }

        String[] author2 = bookAuthor2.split(" ");
        bookAuthor2 = author2[author2.length - 1];
        for (int i = 0; i < author2.length - 2; i++) {
            bookAuthor2 += author2[i] + " ";
        }

        return bookAuthor1.compareTo(bookAuthor2);
    };

    /**
     *  Rule to compare books by their genre in ascending order (case insensitive).
     */
    public static Comparator<Book> sortByGenre = (Book book1, Book book2) -> {
        String bookGenre1 = book1.getGenre().toLowerCase();
        String bookGenre2 = book2.getGenre().toLowerCase();

        return bookGenre1.compareTo(bookGenre2);
    };
}