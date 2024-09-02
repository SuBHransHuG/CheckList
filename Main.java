
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CodeReview {
    private String code;
    private String author;
    private List<String> feedback;
    private Map<String, Boolean> checklist;

    public CodeReview(String code, String author) {
        this.code = code;
        this.author = author;
        this.feedback = new ArrayList<>();
        this.checklist = new HashMap<>();
        this.checklist.put("Functionality", false);
        this.checklist.put("Readability", false);
        this.checklist.put("Security", false);
        this.checklist.put("Performance", false);
        this.checklist.put("Documentation", false);
    }

    public void reviewCode() {
        System.out.println("Reviewing code submitted by " + this.author + "...\n");

        // Example checklist-based review
        checkFunctionality();
        checkReadability();
        checkSecurity();
        checkPerformance();
        checkDocumentation();

        System.out.println("\nReview Summary:");
        for (Map.Entry<String, Boolean> entry : checklist.entrySet()) {
            String status = entry.getValue() ? "Passed" : "Needs Improvement";
            System.out.println("- " + entry.getKey() + ": " + status);
        }

        if (!feedback.isEmpty()) {
            System.out.println("\nFeedback:");
            for (String comment : feedback) {
                System.out.println("- " + comment);
            }
        } else {
            System.out.println("\nNo additional feedback.");
        }
    }

    private void checkFunctionality() {
        // Simulated check for functionality
        if (code.contains("public") && code.contains("return")) {
            checklist.put("Functionality", true);
        } else {
            checklist.put("Functionality", false);
            feedback.add("Ensure all methods are correctly implemented with return statements.");
        }
    }

    private void checkReadability() {
        // Simulated check for readability
        if (code.length() < 1000 && code.contains("    ")) {
            checklist.put("Readability", true);
        } else {
            checklist.put("Readability", false);
            feedback.add("Improve code readability by using consistent indentation and avoiding long lines of code.");
        }
    }

    private void checkSecurity() {
        // Simulated check for security
        if (!code.contains("Scanner") && !code.contains("input")) {
            checklist.put("Security", true);
        } else {
            checklist.put("Security", false);
            feedback.add("Avoid using direct input from users without validation.");
        }
    }

    private void checkPerformance() {
        // Simulated check for performance
        if (code.contains("for") && code.contains("ArrayList")) {
            checklist.put("Performance", true);
        } else {
            checklist.put("Performance", false);
            feedback.add("Optimize loops for better performance.");
        }
    }

    private void checkDocumentation() {
        // Simulated check for documentation
        if (code.contains("//") || code.contains("/*")) {
            checklist.put("Documentation", true);
        } else {
            checklist.put("Documentation", false);
            feedback.add("Ensure all methods and critical sections are well-documented.");
        }
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        String sampleCode = """
                public class Calculator {
                    // This method returns the sum of two numbers
                    public int calculateSum(int a, int b) {
                        return a + b;
                    }
                    
                    public static void main(String[] args) {
                        Calculator calc = new Calculator();
                        int result = calc.calculateSum(5, 10);
                        System.out.println("The sum is: " + result);
                    }
                }
                """;

        // Create a code review instance
        CodeReview review = new CodeReview(sampleCode, "John Doe");

        // Perform the review
        review.reviewCode();
    }
}
