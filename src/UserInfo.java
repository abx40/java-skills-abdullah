public class UserInfo {
    // Create these variables with proper access modifiers
    private String name;
    private int age;
    private String email;
    private boolean isActive;
    // Create constructor that takes all parameters
    public UserInfo(String name, int age, String email, boolean isActive) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }
    // Create getter and setter methods for all variables
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    // Create a method that displays user info nicely formatted
    public void displayInfo() {
        // Print user information in a nice format
        System.out.println("User Information:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        if (isActive) {
            System.out.println("Status: Active");
        } else {
            System.out.println("Status: Inactive");
        }
    }
    // Main method for testing
    public static void main(String[] args) {
        // Create 3 different users
        UserInfo user1 = new UserInfo("User1",10, "test1@test.com", true);
        UserInfo user2 = new UserInfo("User2",20, "test2@test.com", false);
        UserInfo user3 = new UserInfo("User3",30, "test3@test.com", true);

        // Display their information
        user1.displayInfo();

        user2.displayInfo();

        user3.displayInfo();

        // Test your getters and setters
        user1.setName("UpdatedUser1");
        System.out.println(user1.getName());

        user2.setAge(25);
        System.out.println(user2.getAge());

        user3.setEmail("updated3@test.com");
        System.out.println(user3.getEmail());

        user1.setActive(false);
        System.out.println("User1 Active Status: " + user1.isActive());
    }


}