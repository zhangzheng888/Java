import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bookcase {
    private List<Book> bookCase;

    public Bookcase() {
        bookCase = new ArrayList<>();
    }

    public int getBookCount() {
        return bookCase.size();
    }

    public Book getBookAtPosition(int pos) {
        return bookCase.get(pos);
    }

    public void addBookToBookcase(Book book) {
        bookCase.add(book);
    }

    public boolean removeBookFromBookcase(String isbn) {
        for (int i = 0; i < bookCase.size(); i++) {
            String currentISBN = bookCase.get(i).getISBN();
            if (currentISBN.equals(isbn)) {
                bookCase.remove(i);
                return true;
            }
        }
        return false;
    }

    public Book getBookByISBN(String isbn) {
        for (Book b : bookCase) {
            if (b.getISBN().equalsIgnoreCase(isbn)) {
                return b;
            }
        }
        return null;
    }

    public void readBooksFromFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split(",");
            if (fields.length >= 8) // At least one address specified.
            {
                String isbn = fields[0];
                String author = fields[1];
                String title = fields[2];
                String publisher = fields[3];

                int publicationYear = Integer.parseInt(fields[4]);
                int publicationMonth = Integer.parseInt(fields[5]);
                int publicationDay = Integer.parseInt(fields[6]);
                int pageCount = Integer.parseInt(fields[7]);


                Book currBook = new Book(isbn, author, title, publisher,
                        publicationYear, publicationMonth, publicationDay, pageCount);

                bookCase.add(currBook);

            } else {
                System.err.println("Invalid record: " + line);
            }
        }

        scanner.close();
    }

    public void writeBooksToFile() throws IOException {
        FileWriter writer = new FileWriter("output.txt");
        for (Book b : bookCase) {
            writer.write("------------------\n");
            writer.write(b.toString());
        }
        writer.close();
    }

    public void sortBookcase() {
        Collections.sort(bookCase);
    }

    public void clearBookCase() {
        bookCase.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (bookCase.isEmpty()) {
            sb.append("The Bookcase is empty");

        } else {
            for (Book b : bookCase) {
                sb.append("------------------\n");
                sb.append(b.toString());
            }
        }
        return sb.toString();
    }
}
