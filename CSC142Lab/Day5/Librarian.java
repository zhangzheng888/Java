import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * This class loads and saves all instance data for a list of Books that will
 * be used in {@link bookshelf.Bookshelf}.
 *
 * @author Terry Weiss
 * @see bookshelf.Book
 * @see bookshelf.Bookshelf
 */
public class BookshelfFilestore {
    private static final String DEFAULT_SHELF_FILENAME = "bookshelf.bl";


    /**
     * Checks if a file by this filename exists.
     *
     * @param filename Relative path of file to be checked
     * @return <tt>true</tt> if a file by this filename exists
     * @see File#exists()
     */
    public static boolean checkFileExists(String filename) {
        return (new File(filename).exists());
    }


    /**
     * Writes all {@link bookshelf.Book}s to the specified file. The specified
     * file must already exist.
     *
     * @param filename Relative path of file to be saved to
     * @param shelf List of Books to be saved
     * @return <tt>true</tt> if any books were saved. <tt>false</tt> if the
     * file doesn't exist.
     * @throws IOException
     */
    public static boolean save(String filename, List<Book> shelf)
            throws IOException
    {
        File file = new File(filename);

        if (shelf.isEmpty() || !file.exists()) {
            return false;
        }
        else {
            PrintWriter writer = new PrintWriter(new FileWriter(file));

            for (Book book : shelf) {
                writer.write(book.getTitle() + "\n");
                writer.write(book.getPages() + "\n");
                writer.write(book.getAuthor() + "\n");
                writer.write(book.getGenre() + "\n");
                writer.write("\n");
                writer.flush();
            }

            writer.close();
            return true;
        }
    }

    /**
     * Writes all {@link bookshelf.Book}s to the specified file.
     *
     * @param shelf List of Books to be saved
     * @return <tt>true</tt> if any books were saved
     * @throws IOException
     */
    public static boolean save(List<Book> shelf) throws IOException {
        return save(DEFAULT_SHELF_FILENAME, shelf);
    }


    /**
     * Retrieves all the {@link bookshelf.Book}s from the specified file.
     *
     * @param filename Relative path of file to be read
     * @return List of Books loaded
     * @throws FileNotFoundException
     */
    public static List<Book> load(String filename)
            throws FileNotFoundException
    {
        List<Book> shelf = new ArrayList<>();
        File shelfFile = new File(filename);

        if (shelfFile.exists()) {
            Scanner fileReader = new Scanner(shelfFile);
            fileReader.useDelimiter("\n\n");

            while (fileReader.hasNext()) {
                String bookStr = fileReader.next();
                Scanner bookReader = new Scanner(bookStr);
                String title, author, genre;
                int pages;

                // For each book in the file's list
                for (int i = 0; bookReader.hasNext(); i++) {
                    title  = bookReader.nextLine();
                    pages  = Integer.parseInt(bookReader.nextLine());
                    author = bookReader.nextLine();
                    genre  = bookReader.nextLine();

                    shelf.add(new Book(title, pages, author, genre));
                }
            }
        }

        return shelf;
    }

    /**
     * Retrieves all the {@link bookshelf.Book}s from the default file.
     *
     * @return List of Books loaded
     * @throws FileNotFoundException
     */
    public static List<Book> load() throws FileNotFoundException {
        return load(DEFAULT_SHELF_FILENAME);
    }
}