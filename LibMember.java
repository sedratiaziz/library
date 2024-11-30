public class LibMember {
    private String firstName;
    private String lastName;
    private char gender;
    private long cprNum;
    private String teleNum;
    private Book[] booksIssued; // Array to store books issued to this member
    private int numBooksIssued; // Counter for the number of books issued

    // Default Constructor
    public LibMember() {
        this.firstName = "";
        this.lastName = "";
        this.gender = 'M'; // Default gender, assume male
        this.cprNum = 0;
        this.teleNum = "";
        this.booksIssued = new Book[10]; // Maximum 10 books
        this.numBooksIssued = 0;
    }

    // Constructor with parameters
    public LibMember(String firstName, String lastName, char gender, long cprNum, String teleNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.cprNum = cprNum;
        this.teleNum = teleNum;
        this.booksIssued = new Book[10]; // Maximum 10 books
        this.numBooksIssued = 0;
    }

    // Getter and setter methods for all attributes
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = gender; }
    public long getCprNum() { return cprNum; }
    public void setCprNum(long cprNum) { this.cprNum = cprNum; }
    public String getTeleNum() { return teleNum; }
    public void setTeleNum(String teleNum) { this.teleNum = teleNum; }

    // equals method to compare library members
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LibMember) {
            LibMember otherMember = (LibMember) obj;
            return this.cprNum == otherMember.cprNum;
        }
        return false;
    }

    // toString method to return details of the library member as a string
    @Override
    public String toString() {
        return "LibMember{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", cprNum=" + cprNum +
                ", teleNum='" + teleNum + '\'' +
                ", numBooksIssued=" + numBooksIssued +
                '}';
    }
}
