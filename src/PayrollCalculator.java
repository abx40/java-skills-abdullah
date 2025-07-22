public class PayrollCalculator {
    // Method to calculate weekly pay based on employee type and hours
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        // Use a switch case for the different rules:
        // "FULL TIME": Regular pay for 40 hours, overtime (1.5x) for hours > 40
        // "PART TIME": Regular pay, no overtime, max 25 hours
        // "CONTRACTOR": Flat rate, no overtime rules
        // "INTERN": 20% discount from hourly rate, max 20 hours
        // Handle invalid employee types and negative values
        if (employeeType == null || hourlyRate < 0 || hoursWorked < 0) {
            throw new IllegalArgumentException("Invalid input values.");
        }
        switch (employeeType) {
            case "FULL_TIME":
                if (hoursWorked <= 40) {
                    return hoursWorked * hourlyRate;
                } else {
                    double regularPay = 40 * hourlyRate;
                    double overtimePay = (hoursWorked - 40) * hourlyRate * 1.5;
                    return regularPay + overtimePay;
                }
            case "PART_TIME":
                if (hoursWorked > 25) {
                    throw new IllegalArgumentException("Part-time employees cannot work more than 25 hours.");
                }
                return hoursWorked * hourlyRate;
            case "CONTRACTOR":
                return hoursWorked * hourlyRate; // Flat rate, no overtime
            case "INTERN":
                if (hoursWorked > 20) {
                    throw new IllegalArgumentException("Interns cannot work more than 20 hours.");
                }
                return hoursWorked * (hourlyRate * 0.8); // 20% discount
            default:
                throw new IllegalArgumentException("Invalid employee type.");
        }

    }
    // Method to calculate tax deduction based on pay brackets
    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        // Use nested if-else for tax brackets:
        // $0-500: 10% tax
        // $501-1000: 15% tax
        // $1001-2000: 20% tax
        // Above $2000: 25% tax
        // If hasHealthInsurance is true, reduce tax by $50
        if (grossPay < 0) {
            throw new IllegalArgumentException("Gross pay cannot be negative.");
        }
        double taxRate;
        if (grossPay <= 500) {
            taxRate = 0.10;
        } else if (grossPay <= 1000) {
            taxRate = 0.15;
        } else if (grossPay <= 2000) {
            taxRate = 0.20;
        } else {
            taxRate = 0.25;
        }
        double taxDeduction = grossPay * taxRate;
        if (hasHealthInsurance) {
            taxDeduction -= 50;
        }
        return taxDeduction;
    }

    // Method to process multiple employees and find statistics
    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        // Calculate pay for each employee
        // Find: highest paid employee, lowest paid employee, average pay
        // Count how many employees worked overtime (>40 hours)
        // Display results in a formatted table
        // Handle arrays of different lengths gracefully
        if (employeeTypes.length != hours.length || employeeTypes.length != rates.length || employeeTypes.length != names.length) {
            throw new IllegalArgumentException("Error: different array lengths.");
        }
        double totalPay = 0;
        double highestPay = Double.MIN_VALUE;
        double lowestPay = Double.MAX_VALUE;
        String highestPaidEmployee = "";
        String lowestPaidEmployee = "";
        int overtimeCount = 0;

        System.out.printf("%-20s %-15s %-10s %-10s %-10s%n", "Name", "Type", "Hours", "Rate", "Weekly Pay");


        // find highest and lowest paid employees, total pay, average pay, and count of overtime
        for (int i = 0; i < employeeTypes.length; i++) {
            double weeklyPay = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            totalPay += weeklyPay;

            if (weeklyPay > highestPay) {
                highestPay = weeklyPay;
                highestPaidEmployee = names[i];
            }
            if (weeklyPay < lowestPay) {
                lowestPay = weeklyPay;
                lowestPaidEmployee = names[i];
            }
            if (hours[i] > 40) {
                overtimeCount++;
            }

            System.out.printf("%-20s %-15s %-10.2f %-10.2f $%-10.2f%n", names[i], employeeTypes[i], hours[i], rates[i], weeklyPay);
        }

        double averagePay = totalPay / employeeTypes.length;

        System.out.println("\nPayroll Summary:");
        System.out.printf("Total Pay: $%.2f%n", totalPay);
        System.out.printf("Avg Pay: $%.2f%n", averagePay);
        System.out.printf("Highest Pay: %s with $%.2f%n", highestPaidEmployee, highestPay);
        System.out.printf("Lowest Pay: %s with $%.2f%n", lowestPaidEmployee, lowestPay);
        System.out.printf("Overtime Employees: %d%n", overtimeCount);
    }
    public static void main(String[] args) {
        // Test data:
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN",
                "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
        boolean[] hasHealthInsurance = {true, false, true, false, true};


    // Test individual calculations first



        for (int i = 0; i < names.length; i++) {
            try {
                double weeklyPay = calculateWeeklyPay(types[i], hours[i], rates[i]);
                System.out.printf("Weekly pay for %s (%s, %.2f hours, $%.2f rate): $%.2f%n",
                        names[i], types[i], hours[i], rates[i], weeklyPay);
                double taxDeduction = calculateTaxDeduction(weeklyPay, hasHealthInsurance[i]);
                System.out.printf("Tax deduction for %s: $%.2f%n", names[i], taxDeduction);


            } catch (IllegalArgumentException e) {
                System.out.println("Error for " + names[i] + ": " + e.getMessage());
            }
        }
    // Then process the entire payroll
        try {
            processPayroll(types, hours, rates, names);
        } catch (IllegalArgumentException e) {
            System.out.println("Error processing payroll: " + e.getMessage());
        }
    // Show all results clearly

    }

    }