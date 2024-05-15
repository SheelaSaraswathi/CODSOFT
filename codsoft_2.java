import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Number of subjects
            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();

            // Array to store marks of each subject
            int[] marks = new int[numSubjects];

            // Input marks for each subject
            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter marks obtained in subject " + (i + 1) + ": ");
                marks[i] = scanner.nextInt();
            }

            // Calculate total marks
            int totalMarks = 0;
            for (int mark : marks) {
                totalMarks += mark;
            }

            // Calculate average percentage
            float averagePercentage = (float) totalMarks / numSubjects;

            // Round off average percentage to two decimal places
            String formattedAveragePercentage = String.format("%.2f", averagePercentage);

            // Assign grades
            char grade;
            if (averagePercentage >= 90) 
                grade = 'O';
            else if (averagePercentage >= 80) 
                grade = 'A';
            else if (averagePercentage >= 70) 
                grade = 'B';
            else if (averagePercentage >= 60) 
                grade = 'C';
            else if (averagePercentage >= 50) 
                grade = 'D';
            else if (averagePercentage >= 40) 
                grade = 'E';
            else
                grade = 'F';
   
            // Display results
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Average Percentage: " + formattedAveragePercentage + "%");
            System.out.println("Grade: " + grade);
        }
    }
}
