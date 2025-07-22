public class VisitorCounter {
    // Static variable to count total visitors
    private static int totalVisitors = 0;
    // Non-static variable for individual session
    private int sessionVisits;
    private String visitorName;
    // Constructor
    public VisitorCounter(String name) {
        this.visitorName = name;
        this.sessionVisits = 0;
        totalVisitors++; // Increment total when new visitor is created
    }
    // Non-static method
    public void recordVisit() {
        sessionVisits++;
        System.out.println(visitorName + " visited. Session visits: " +
                sessionVisits);
    }
    // Static method
    public static void displayTotalVisitors() {
        System.out.println("Total visitors today: " + totalVisitors);
    }
    // Static method to get total (getter)
    public static int getTotalVisitors() {
        return totalVisitors;
    }
    public static void main(String[] args) {
    // Create 3 different visitors
VisitorCounter visitor1 = new VisitorCounter("Test1");
VisitorCounter visitor2 = new VisitorCounter("Test2");
VisitorCounter visitor3 = new VisitorCounter("Test3");
    // Have each visitor record some visits
    visitor1.recordVisit(); // 1 visits once
    visitor1.recordVisit(); // 1 visits again
    visitor2.recordVisit(); // 2 visits once
    visitor3.recordVisit(); // 3 visits once
    visitor3.recordVisit(); // 3 visits again
    // Display total visitors using static method
    VisitorCounter.displayTotalVisitors(); // Should show 3

    }
}
