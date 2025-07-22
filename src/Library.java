public class Library {
    public static void main(String[] args) {
    // Create 2 regular books
Book book1 = new Book("Book1", "TestAuthor1", 100);
Book book2 = new Book("Book2", "TestAuthor2", 200);
    // Create 1 textbook
Textbook textbook1 = new Textbook("TestBook3", "TestAuthor3", 300, "TestSubject", 1);
    // Test borrowing and returning    // Test borrowing and returning
    book1.borrowBook(); // Should succeed
    book1.borrowBook(); // Should fail (already borrowed)
    book1.returnBook(); // Should succeed
    book1.returnBook(); // Should succeed (already returned)
    textbook1.borrowBook(); // Should succeed
    textbook1.returnBook(); // Should succeed
    // Display information for all books
    book1.displayInfo();
    book2.displayInfo();
    textbook1.displayInfo();

    }
}
