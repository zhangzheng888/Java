import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BookcaseUI {

    private static Bookcase bookcase;
    private static Scanner scanner;

    public static void main(String[] args) {
        bookcase = new Bookcase();
        scanner = new Scanner(System.in);
        System.out.println("Welcome to the Book case:");
        System.out.println();
        printHelp();
        System.out.println("You can always access this list at any time by typing \'help\' in the console");
        System.out.println();
        String input;
        do {
            System.out.print("Please Enter a command: ");
            input = scanner.next();
            manageBookcase(input);
        } while (!input.equalsIgnoreCase("exit"));

        scanner.close();
        System.out.println("Thanks for using the Bookcase.");
    }

    /*
     * This is the main driver for the bookshelf application
     */
    private static void manageBookcase(String state) {
        if (state.equalsIgnoreCase("help")) {
            printHelp();
        } else if (state.equalsIgnoreCase("add")) {
            addBook();
        } else if (state.equalsIgnoreCase("display")) {
            System.out.println(bookcase.toString());
        } else if (state.equalsIgnoreCase("delete")) {
            removeBook();
        } else if (state.equalsIgnoreCase("sort")) {
            bookcase.sortBookcase();
        } else if (state.equalsIgnoreCase("dump")) {
            writeToFile();
        } else if (state.equalsIgnoreCase("read")) {
            readFromFile();
        }

    }

    /*
     * The read module, this reads in books from the file
     */
    private static void readFromFile() {
        System.out.println("Please enter a path to the file: ");
        String path = scanner.next();
        try {
            bookcase.readBooksFromFile(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file, please make sure you have a valid path");
        }
    }

    /*
     * This is the write module, it outputs the bookcase to output.txt
     */
    private static void writeToFile() {
        try {
            bookcase.writeBooksToFile();
            System.out.println("Successfully written to output.txt");
        } catch (IOException e) {
            System.out.println("Could not find the file to write to");
        }
    }

    /*
     * The remove book module, this steps the user through removing a book via ISBN
     */
    private static void removeBook() {
        System.out.println("Please enter the ISBN of the book you want to remove: ");
        String isbn = scanner.next();

        if (bookcase.removeBookFromBookcase(isbn)) {
            System.out.println("Book Successfully removed");
        } else {
            System.out.println("Could not find that book on the bookshelf");
        }
    }

    /*
     * The add book module, this steps the user through adding a book to the bookcase.
     */
    private static void addBook() {
        System.out.print("Please enter an ISBN: ");
        String isbn = scanner.next();

        System.out.print("Please enter an Author: ");
        String author = scanner.next();

        System.out.print("Please enter an Title: ");
        String title = scanner.next();

        System.out.print("Please enter an Publisher: ");
        String publisher = scanner.next();

        System.out.print("Please enter the Publication Year: ");
        int publicationYear = readInt();

        while (publicationYear < 0) {
            System.out.println("Please enter a non negative year: ");
            publicationYear = readInt();
        }

        System.out.print("Please enter the Publication Month: ");
        int publicationMonth = readInt();

        while (publicationMonth > 12 || publicationMonth < 1) {
            System.out.println("Please enter a number from 1-12: ");
            publicationMonth = readInt();
        }

        System.out.print("Please enter the Publication Day: ");
        int publicationDay = readInt();

        while (publicationDay > 31 || publicationDay < 1) {
            System.out.print("Please enter a number from 1-31: ");
            publicationDay = readInt();
        }

        System.out.print("Please enter the Page Count: ");
        int pageCount = readInt();


        bookcase.addBookToBookcase(new Book(isbn, author, title, publisher,
                publicationYear, publicationMonth, publicationDay, pageCount));

        System.out.println("Successfully added book to bookcase!");
    }

    /*
     * The help module, Prints the help screen
     */
    private static void printHelp() {
        System.out.println("The current commands are: ");
        System.out.println("add - Adds a book to the bookshelf");
        System.out.println("delete - deletes a book from the book shelf");
        System.out.println("display - Displays all the books on the bookshelf");
        System.out.println("dump - Writes the current contents of the bookcase to outputs.txt");
        System.out.println("read - Adds books from a file to the book case");
        System.out.println("sort - Sorts the books on the book case by isbn");
        System.out.println();
        System.out.println("Program related commands: ");
        System.out.println("exit - exits the program");
        System.out.println();
        System.out.println("Please note that you only need to type the action you want to perform " +
                "additional information will be asked in each module");
    }

    /*
     * This is a helper method that takes in a users
     * integer value or keeps asking them if they don't input an int
     * Scanner.nextInt will throw an error if the user does not input an int
     * this will not throw an error
     *
     * @return the integer value typed in by the user
     */
    private static int readInt() {
        int intInputValue;
        while (true) {
            String input = scanner.next();
            try {
                intInputValue = Integer.parseInt(input);
                return intInputValue;
            } catch (NumberFormatException ne) {
                System.out.println("Input is not a number, please enter a number: ");
            }
        }
    }
}
