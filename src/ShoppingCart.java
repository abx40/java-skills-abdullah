public class ShoppingCart {
    // Calculate total price with discounts
    public static double calculateTotal(double[] prices, String customerType)
    {
        double total = 0;
    // First, calculate sum of all prices using a loop
    // Then apply discount based on customer type using switch:
    // "REGULAR": no discount
    // "PREMIUM": 10% discount
    // "VIP": 20% discount
        for (double price : prices) {
            total += price;
        }
        switch (customerType.toUpperCase()) {
            case "PREMIUM":
                total *= 0.9; // 10% discount
                break;
            case "VIP":
                total *= 0.8; // 20% discount
                break;
            case "REGULAR":
            default:
                break;
        }

        return total;
    }

    // Find most expensive item
    public static double findMostExpensive(double[] prices) {
    // Use loop to find highest price
    // Handle empty array
        if (prices == null || prices.length == 0) {
            return 0; // Return 0 for empty array
        }
        double maxPrice = prices[0];
        for (double price : prices) {
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        return maxPrice;
    }
    // Count items above a certain price
    public static int countExpensiveItems(double[] prices, double threshold)
    {
    // Count how many items cost more than threshold
        int count = 0;
        for (double price : prices) {
            if (price > threshold) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        double[] cart = {25.99, 45.50, 12.99, 89.99, 15.75};
        // Test with different customer types
        // Find most expensive item
        double mostExpensive = findMostExpensive(cart);
        System.out.println("Most expensive item: $" + mostExpensive);
        // Count items over $30
        int expensiveCount = countExpensiveItems(cart, 30);
        System.out.println("Items over $30: " + expensiveCount);


        System.out.println("Regular customer total: $" + calculateTotal(cart,
                "REGULAR"));
        System.out.println("Premium customer total: $" + calculateTotal(cart,
                "PREMIUM"));
        System.out.println("VIP customer total: $" + calculateTotal(cart,
                "VIP"));
    }
}

