import java.util.LinkedList;

public class LibrarySystem {
    private LinkedList<Book> booksList;
    private LinkedList<LibMember> membersList;
    private int booksListSize;
    private int membersListSize;

    // Constructor without any parameters
    public LibrarySystem() {
        booksList = new LinkedList<>();
        membersList = new LinkedList<>();
        booksListSize = 0;
        membersListSize = 0;
    }

    // addBook: inserts a new Book object at the end of the booksList
    public boolean addBook(Book book) {
        if (!booksList.contains(book)) {
            booksList.add(book);
            booksListSize++;
            return true;
        }
        return false;
    }

    // deleteBook: deletes a Book object from booksList
    public boolean deleteBook(long accessionNum) {
        for (Book book : booksList) {
            if (book.getAccessionNum() == accessionNum && book.getIssuedTo() == null) {
                booksList.remove(book);
                booksListSize--;
                return true;
            }
        }
        return false;
    }

    // addMember: inserts a new LibMember object at the end of the membersList
    public boolean addMember(LibMember member) {
        if (!membersList.contains(member)) {
            membersList.add(member);
            membersListSize++;
            return true;
        }
        return false;
    }

    // deleteMember: deletes a LibMember object from membersList
    public boolean deleteMember(long cprNum) {
        for (LibMember member : membersList) {
            if (member.getCprNum() == cprNum) {
                if (member.numBooksIssued == 0) {
                    membersList.remove(member);
                    membersListSize--;
                    return true;
                }
            }
        }
        return false;
    }

    // searchBook: searches the booksList by accessionNum
    public int searchBook(long accessionNum) {
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getAccessionNum() == accessionNum) {
                return i; // Return the index where the book is found
            }
        }
        return -1; // Book not found
    }

    // searchMember: searches the membersList by cprNum
    public int searchMember(long cprNum) {
        for (int i = 0; i < membersList.size(); i++) {
            if (membersList.get(i).getCprNum() == cprNum) {
                return i; // Return the index where the member is found
            }
        }
        return -1; // Member not found
    }

    // isEmptyBooksList: returns true if the booksList is empty
    public boolean isEmptyBooksList() {
        return booksList.isEmpty();
    }

    // isEmptyMembersList: returns true if the membersList is empty
    public boolean isEmptyMembersList() {
        return membersList.isEmpty();
    }

    // sizeBooksList: returns the size of booksList
    public int sizeBooksList() {
        return booksListSize;
    }

    // sizeMembersList: returns the size of membersList
    public int sizeMembersList() {
        return membersListSize;
    }

    // issueBook: issues a book to a member if all conditions are met
    public boolean issueBook(long accessionNum, long cprNum) {
        int bookIndex = searchBook(accessionNum);
        int memberIndex = searchMember(cprNum);

        if (bookIndex == -1 || memberIndex == -1) {
            return false; // Book or member not found
        }

        Book book = booksList.get(bookIndex);
        LibMember member = membersList.get(memberIndex);

        // Check if the book is already issued
        if (book.getIssuedTo() != null) {
            return false;
        }

        // Check if the member has less than 10 books
        if (member.numBooksIssued >= 10) {
            return false;
        }

        // Issue the book to the member
        book.setIssuedTo(member);
        member.booksIssued[member.numBooksIssued] = book;
        member.numBooksIssued++;

        return true;
    }

    // returnBook: accepts accession number of a Book and returns it
    public boolean returnBook(long accessionNum) {
        int bookIndex = searchBook(accessionNum);
        if (bookIndex == -1) {
            return false; // Book not found
        }

        Book book = booksList.get(bookIndex);
        LibMember member = book.getIssuedTo();

        if (member == null) {
            return false; // Book is not issued to any member
        }

        // Return the book
        for (int i = 0; i < member.numBooksIssued; i++) {
            if (member.booksIssued[i] == book) {
                member.booksIssued[i] = null;
                member.numBooksIssued--;
                break;
            }
        }

        book.setIssuedTo(null); // Mark book as not issued
        return true;
    }

    // printBooksIssued: prints details of all books issued to a member
    public void printBooksIssued(long cprNum) {
        int memberIndex = searchMember(cprNum);
        if (memberIndex == -1) {
            System.out.println("Member not found.");
            return;
        }

        LibMember member = membersList.get(memberIndex);
        System.out.println("Books issued to " + member.getFirstName() + " " + member.getLastName() + ":");
        for (int i = 0; i < member.numBooksIssued; i++) {
            if (member.booksIssued[i] != null) {
                System.out.println(member.booksIssued[i].toString());
            }
        }
    }

    // isBookIssued: checks if a book is issued
    public boolean isBookIssued(long accessionNum) {
        int bookIndex = searchBook(accessionNum);
        if (bookIndex == -1) {
            return false; // Book not found
        }
        Book book = booksList.get(bookIndex);
        return book.getIssuedTo() != null;
    }
}
