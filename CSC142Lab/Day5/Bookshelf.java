import java.util.ArrayList;
import java.util.Collections;


/**
 * Contains instance data for a bookshelf that holds {@link Book}s. It allows the User to store a
 * Book, browse the list of Books, view the details of a particular Book and take a Book off
 * the Bookshelf.
 *
 * @author Terry Weiss
 * @see    Book
 * @see    Librarian
 */
public class Bookshelf {
    private final String DEFAULT_NAME = "Bookshelf";

    /*
     *  Holds all {@link Book}s, genres and authors. Genres and authors are saved here to be
     *  quickly referenced when browsing by category.
     */
    private ArrayList<Book>   bookList   = new ArrayList<>();
    private ArrayList<String> genreList  = new ArrayList<>();
    private ArrayList<String> authorList = new ArrayList<>();
    private final String name;


    /**
     * Constructs a new Bookshelf instance using the default name
     */
    public Bookshelf() {
        name = DEFAULT_NAME;
    }

    /**
     * Constructs a new Bookshelf instance using the name provided
     *
     * @param name Name of the bookshelf
     */
    public Bookshelf(String name) {
        this.name = name;
    }


    /**
     * Provides current number of {@link Book}s on the shelf
     *
     * @return Number of Books
     */
    public int getNumberOfBooks() {
        return bookList.size();
    }

    /**
     * Provides the name of the bookshelf.
     *
     * @return Bookshelf's name
     */
    public String getName() {
        return name;
    }


    /**
     * Adds a pre-created {@link Book} to the Bookshelf.
     *
     * @param book Book object to be added
     * @return Book object that was added
     */
    public Book addBook(Book book) {
        bookList.add(book);

        String genre = book.getGenre();
        if (!genreList.contains(genre)) {
            genreList.add(genre);
        }

        String author = book.getAuthor();
        if (!authorList.contains(author)) {
            authorList.add(author);
        }

        return book;
    }

    /**
     * Removes a specific {@link Book} object from the Bookshelf.
     *
     * @param book Book instance to be removed
     * @return <tt>true</tt> if the Book was successfully removed
     */
    public boolean removeBookBook book) {
        // If it's the only book of that genre or author, remove the genre/author from its list
        String genre = book.getGenre();
        if (numBooksWithGenre(genre) == 1) {
            genreList.remove(genre);
        }

        String author = book.getAuthor();
        if (numBooksWithAuthor(author) == 1) {
            authorList.remove(author);
        }

        return bookList.remove(book);
    }

    /**
     * Removes {@link Book} from the Bookshelf. Replaced by
     * {@link #removeBook(java.lang.String)}. Only use if the book being removed must be saved,
     * or if the Book's title isn't unique, since the positions change with each sort.
     *
     * @param position Position of the Book in the list
     * @return Book instance being removed
     */
    public Book removeBook(int position) {
        String genre = bookList.get(position).getGenre();
        if (numBooksWithGenre(genre) == 1) {
            genreList.remove(genre);
        }

        String author = bookList.get(position).getAuthor();
        if (numBooksWithGenre(genre) == 1) {
            authorList.remove(author);
        }

        return bookList.remove(position);
    }

    /**
     * Removes {@link Book} from the Bookshelf using its title.
     *
     * @param title Title of the Book to be removed
     * @return <tt>true</tt> if the Book was successfully removed
     */
    public boolean removeBook(String title) {
        if (numBooksWithTitle(title) == 1) {
            removeBook(findBook(title));
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * Provides details of a specific {@link Book} from the Bookshelf, or if the Book doesn't
     * exist. Only use in cases where you want only one version of a book that has a non-unique
     * title, since the positions change with each sort.
     *
     * @param position Position of Book to be viewed
     * @deprecated Replaced by {@link #viewBook(java.lang.String)}
     * @return String holding the details of the book if it exists
     */
    public String viewBook(int position) {
        String ret;

        if (position < 0 || position >= bookList.size()) {
            ret = "That book isn't on the shelf.";
        }
        else {
            ret = bookList.get(position).displayDetails();
        }

        return ret;
    }

    /**
     * Provides details of a specific {@link Book} from the Bookshelf, or if the Book doesn't
     * exist. In cases where the title isn't unique, all Books by this title are provided and
     * separated by an empty line.
     *
     * @param title Title of the book (case insensitive)
     * @return String holding the details of the Books by that title
     */
    public String viewBook(String title) {
        String details = "";

        for (Book currentBook : bookList) {
            if (currentBook.getTitle().equalsIgnoreCase(title)) {
                //Separate each entry by a blank line in cases of duplicate titles
                if (details.length() > 0) {
                    details += "\n\n";
                }

                details += currentBook.displayDetails();
            }
        }

        if (details.length() == 0) {
            details = title + " isn't on the shelf.";
        }

        return details;
    }


    /**
     * Sorts all {@link Book}s in ascending alphabetical order by title.
     *
     * @see Book#sortByTitle
     */
    public void sortBooksByTitle() {
        Collections.sort(bookList, Book.sortByTitle);
    }

    /**
     * Sorts all {@link Book}s in ascending alphabetical by Author first and then by Title.
     *
     * @see Book#sortByAuthor
     */
    public void sortBooksByAuthor() {
        //Sorts must be done in reverse order to get benefit of sorting by Title while not
        //overriding the sort by author.
        sortBooksByTitle();
        Collections.sort(bookList, Book.sortByAuthor);
    }

    /**
     * Sorts all {@link Book}s in ascending alphabetical by Genre first and then by Title.
     *
     * @see Book#sortByGenre
     */
    public void sortBooksByGenre() {
        sortBooksByTitle();
        Collections.sort(bookList, Book.sortByGenre);
    }

    /**
     * Sorts all {@link Book}s in ascending numerical order by size first and then by Title
     * in cases where two books are the same size.
     */
    public void sortBooksBySize() {
        sortBooksByTitle();
        Collections.sort(bookList);
    }


    /**
     * Returns the index of the first occurrence of the {@link Book} in this list, or -1 if
     * this list does not contain the Book.
     *
     * @param book Book object to search for
     * @return Index of the first Book, or <tt>-1</tt> if it's not there
     */
    public int findBook(Book book) {
        return bookList.indexOf(book);
    }

    /**
     * Returns the index of the first occurrence of the {@link Book} with the same title in this
     * list, or -1 if this list does not contain the Book.
     *
     * @param title Title of the book to search for
     * @return Index of the first Book, or <tt>-1</tt> if it's not there
     */
    public int findBook(String title) {
        for (int currentBook = 0; currentBook < bookList.size(); currentBook++) {
            String currentTitle = bookList.get(currentBook).getTitle();
            if (currentTitle.equalsIgnoreCase(title)) {
                return currentBook;
            }
        }

        return -1;
    }


    /**
     * Provides the number of {@link Book}s of a specified genre.
     *
     * @param genre Name of the genre
     * @return Number of Books of the provided genre
     */
    public int numBooksWithGenre(String genre) {
        int books = 0;

        for (Book book : bookList) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                books++;
            }
        }

        return books;
    }

    /**
     * Provides the number of {@link Book}s written by a specified author.
     *
     * @param author Name of the author
     * @return Number of Books by the provided author
     */
    public int numBooksWithAuthor(String author) {
        int books = 0;

        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                books++;
            }
        }

        return books;
    }

    /**
     * Provides the number of {@link Book}s with a specified title.
     *
     * @param title Title to be searched for
     * @return Number of Books of the same title
     */
    public int numBooksWithTitle(String title) {
        int books = 0;

        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books++;
            }
        }

        return books;
    }


    /**
     * Provides a String of all {@link Book}s on the Bookshelf using their String
     * representation.
     *
     * @return List of all Books on the Bookshelf
     */
    public String browse() {
        String list = "";

        for (Book currentBook : bookList) {
            list += currentBook + "\n";
        }

        return list;
    }

    /**
     * Provides a String of all {@link Book}s on the Bookshelf using their String
     * representation. Books are resorted by title.
     *
     * @return List of all Books on the Bookshelf, sorted by title
     * @see #sortBooksByTitle
     */
    public String browseByTitle() {
        sortBooksByTitle();
        return browse();
    }

    /**
     * Provides a String of all {@link Book}s on the Bookshelf using their String
     * representation and author's full name. Books are resorted by author's last name first,
     * followed by first name, etc. Books are then sorted by title.
     *
     * @return List of all Books on the Bookshelf, sorted by author
     * @see #sortBooksByAuthor
     */
    public String browseByAuthor() {
        sortBooksByAuthor();
        String list = "";

        for (Book currentBook : bookList) {
            list += String.format("%-20s    %s\n", currentBook, currentBook.getAuthor());
        }

        return list;
    }

    /**
     * Provides a String of all {@link Book}s on the Bookshelf using their String
     * representation and genre. Books are resorted by genre, then title.
     *
     * @return List of all Books on the Bookshelf, sorted by genre
     * @see #sortBooksByGenre
     */
    public String browseByGenre() {
        sortBooksByGenre();
        String list = "";

        for (Book currentBook : bookList) {
            list += String.format("%-20s    %s\n", currentBook, currentBook.getGenre());
        }

        return list;
    }

    /**
     * Provides a String of all {@link Book}s on the Bookshelf using their String
     * representation and number of pages. Books are resorted by size, then title.
     *
     * @return List of all Books on the Bookshelf, sorted by size
     * @see #sortBooksBySize
     */
    public String browseBySize() {
        sortBooksBySize();
        String list = "";

        for (Book currentBook : bookList) {
            list += String.format("%-20s    %s\n", currentBook, currentBook.getPages());
        }

        return list;
    }

    /**
     * Provides a String of all {@link Book}s on the Bookshelf in a specific genre, or if
     * no books in that genre exist. Books are sorted by title.
     *
     * @param genre Genre to be listed
     * @return List of Books in the given genre
     */
    public String browseBooksOfGenre(String genre) {
        String list = "";

        // Make the genre Capitalized to match format of genres and be case-insensitive
        genre = genre.substring(0, 1).toUpperCase() + genre.substring(1).toLowerCase();

        if (genreList.indexOf(genre) == -1) {
            list = "There are no books of that genre.\n";
        }
        else {
            sortBooksByGenre();
            int i = 0;

            // Find first book with the specified genre
            while (!bookList.get(i).getGenre().equalsIgnoreCase(genre)) {
                i++;
            }

            // Display all books until the genre changes or until it's the last book of the shelf
            while (i < bookList.size() && bookList.get(i).getGenre().equalsIgnoreCase(genre)) {
                list += bookList.get(i) + "\n";
                i++;
            }
        }

        return list;
    }

    /**
     * Provides a String of all {@link Book}s on the Bookshelf by a specific author, or if
     * no books by that author exist. Books are sorted by title.
     *
     * @param author Author to be listed
     * @return List of Books by the given author
     */
    public String browseBooksOfAuthor(String author) {
        String list = "";

        // Make the author's name Capitalized to match format of genres and be case-insensitive
        String capitalizedAuthor = "";
        for (String name : author.split(" ")) {
            capitalizedAuthor += name.substring(0, 1).toUpperCase()
                                    + name.substring(1).toLowerCase() + " ";
        }
        capitalizedAuthor = capitalizedAuthor.trim();

        if (authorList.indexOf(capitalizedAuthor) == -1) {
            list = "There are no books by that author.\n";
        }
        else {
            sortBooksByAuthor();
            int i = 0;

            // Find first book by the author
            while (!bookList.get(i).getAuthor().equalsIgnoreCase(capitalizedAuthor)) {
                i++;
            }

            // Display all books until the author changes or until it's the last book of the shelf
            while (i < bookList.size() && bookList.get(i).getAuthor()
                                                            .equalsIgnoreCase(capitalizedAuthor)) {
                list += bookList.get(i) + "\n";
                i++;
            }
        }

        return list;
    }

    /**
     * Provides a String of all {@link Book}s on the Bookshelf in a specific category, or if
     * no books in that category exist. Books are sorted by title. Currently, the only supported
     * categories are <tt>"author"</tt> and <tt>"genre"</tt>.
     *
     * @param category Category to be used
     * @return List of Books in the given category
     */
    public String browseByCategory(String category) {
        String list = "";

        if (category.equalsIgnoreCase("author") || category.equalsIgnoreCase("authors")) {
            for (String author : authorList) {
                list += author + ":\n"
                      + browseBooksOfAuthor(author) + "\n";
            }
        }
        else if (category.equalsIgnoreCase("genre") || category.equalsIgnoreCase("genres")) {
            for (String genre : genreList) {
                list += genre + ":\n"
                      + browseBooksOfGenre(genre) + "\n";
            }
        }
        else {
            list = "No such category.\n";
        }

        return list;
    }


    /**
     * String representation of the Bookshelf
     *
     * @return Bookshelf's name
     */
    @Override
    public String toString() {
        return getName();
    }
}