import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);


// Done by :
        /*

            ABDULAZIZ ABDULRAHMAN SEDRATI
            202306676
            SECTION 01

            FATEMA JEHAD
            202105712
            SECTION 01

        */










        //                          MENU                        //

        int choice;
        do {
            System.out.println("\n*******************************************************************************************************");
            System.out.println("\n\nWelcome to The Readers Palace Library!\n\nWe're more than ready to serve our readers & students\n\n");
            System.out.println("Enter a number to choose an option from the menu:\n");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Add Member");
            System.out.println("4. Delete Member");
            System.out.println("5. Search Book");
            System.out.println("6. Search Member");
            System.out.println("7. Issue Book");
            System.out.println("8. Return Book");
            System.out.println("9. Print Books Issued to a Member");
            System.out.println("10. Check if a Book is Issued");
            System.out.println("11. Display All Books");
            System.out.println("12. Display All Members");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Book
                    System.out.println("Enter book details:");
                    scanner.nextLine(); // consume newline
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author 1: ");
                    String author1 = scanner.nextLine();
                    System.out.print("Author 2: ");
                    String author2 = scanner.nextLine();
                    System.out.print("Publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Year of Publication: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("ISBN (13 digits): ");
                    String isbn = scanner.nextLine();
                    long accessionNum = 1000 + librarySystem.sizeBooksList(); // Example accession number
                    Book newBook = new Book(title, author1, author2, publisher, year, isbn);
                    if (librarySystem.addBook(newBook)) {
                        System.out.println("Book added successfully.");
                    } else {
                        System.out.println("Book already exists.");
                    }
                    break;
                case 2:
                    // Delete Book
                    System.out.print("Enter the accession number of the book to delete: ");
                    long accessionNumDelete = scanner.nextLong();
                    if (librarySystem.deleteBook(accessionNumDelete)) {
                        System.out.println("Book deleted successfully.");
                    } else {
                        System.out.println("Unable to delete book (maybe it's issued).");
                    }
                    break;
                case 3:
                    // Add Member
                    System.out.println("Enter member details:");
                    scanner.nextLine(); // consume newline
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Gender (M/F): ");
                    char gender = scanner.next().charAt(0);
                    System.out.print("CPR Number: ");
                    long cprNum = scanner.nextLong();
                    scanner.nextLine(); // consume newline
                    System.out.print("Phone Number: ");
                    String phoneNum = scanner.nextLine();
                    LibMember newMember = new LibMember(firstName, lastName, gender, cprNum, phoneNum);
                    if (librarySystem.addMember(newMember)) {
                        System.out.println("Member added successfully.");
                    } else {
                        System.out.println("Member already exists.");
                    }
                    break;
                case 4:
                    // Delete Member
                    System.out.print("Enter CPR number of the member to delete: ");
                    long cprNumDelete = scanner.nextLong();
                    if (librarySystem.deleteMember(cprNumDelete)) {
                        System.out.println("Member deleted successfully.");
                    } else {
                        System.out.println("Unable to delete member (maybe they have books issued).");
                    }
                    break;
                case 5:
                    // Search Book
                    System.out.print("Enter accession number of the book to search: ");
                    long accessionNumSearch = scanner.nextLong();
                    int bookIndex = librarySystem.searchBook(accessionNumSearch);
                    if (bookIndex != -1) {
                        System.out.println("Book found at index: " + bookIndex);
                        System.out.println(librarySystem.booksList.get(bookIndex));
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 6:
                    // Search Member
                    System.out.print("Enter CPR number of the member to search: ");
                    long cprNumSearch = scanner.nextLong();
                    int memberIndex = librarySystem.searchMember(cprNumSearch);
                    if (memberIndex != -1) {
                        System.out.println("Member found at index: " + memberIndex);
                        System.out.println(librarySystem.membersList.get(memberIndex));
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;
                case 7:
                    // Issue Book
                    System.out.print("Enter accession number of the book to issue: ");
                    long accessionNumIssue = scanner.nextLong();
                    System.out.print("Enter CPR number of the member: ");
                    long cprNumIssue = scanner.nextLong();
                    if (librarySystem.issueBook(accessionNumIssue, cprNumIssue)) {
                        System.out.println("Book issued successfully.");
                    } else {
                        System.out.println("Unable to issue book.");
                    }
                    break;
                case 8:
                    // Return Book
                    System.out.print("Enter accession number of the book to return: ");
                    long accessionNumReturn = scanner.nextLong();
                    if (librarySystem.returnBook(accessionNumReturn)) {
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Unable to return book.");
                    }
                    break;
                case 9:
                    // Print Books Issued to a Member
                    System.out.print("Enter CPR number of the member to view issued books: ");
                    long cprNumIssued = scanner.nextLong();
                    librarySystem.printBooksIssued(cprNumIssued);
                    break;
                case 10:
                    // Check if a Book is Issued
                    System.out.print("Enter accession number of the book to check if issued: ");
                    long accessionNumCheck = scanner.nextLong();
                    if (librarySystem.isBookIssued(accessionNumCheck)) {
                        System.out.println("The book is issued.");
                    } else {
                        System.out.println("The book is not issued.");
                    }
                    break;
                case 11:
                    // Display All Books
                    System.out.println("All Books in the Library:");
                    for (Book book : librarySystem.booksList) {
                        System.out.println(book);
                    }
                    break;
                case 12:
                    // Display All Members
                    System.out.println("All Members in the Library:");
                    for (LibMember member : librarySystem.membersList) {
                        System.out.println(member);
                    }
                    break;
                case 0:
                    // Exit the program
                    System.out.println("Exiting Library System...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0); // Continue until the user exits

        scanner.close();
    }
}
