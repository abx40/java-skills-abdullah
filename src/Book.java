public class Book {
    // Protected variables (so child classes can access them)
    protected String title;
    protected String author;
    protected int pages;
    protected boolean isAvailable;
    // Constructor
    public Book(String title, String author, int pages) {
    // Initialize all variables
    // Set isAvailable to true by default
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isAvailable = true;
    }
    // Basic methods
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }
    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Available: " + isAvailable);
    }
    // Getters (create all of them)
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPages() { return pages; }
    public boolean isAvailable() { return isAvailable; }



}
