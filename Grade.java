
import java.util.*;

public class Grade
{
    public static void main(String[] args) 
    {
        Scanner obj = new Scanner(System.in);
        // We don't know how many subjects the student has, so get the input from the student.
        System.out.println("Enter Number of Subjects:");
        int total_subjects = obj.nextInt();
        obj.nextLine();
        Map<String, Integer> subjects = new HashMap<>();

        System.out.println("Enter Your Subjects Name and Marks:");
        for (int i = 0; i < total_subjects; i++) 
        {
            System.out.println((i + 1) + " Subject Name:");
            String key = obj.nextLine().toUpperCase();

            System.out.println((i + 1) + " Subject Mark:");
            int value = obj.nextInt();
            obj.nextLine();

            subjects.put(key, value);
        }
        transationProcess(subjects, total_subjects);
    }

    // transationProcessing block
    public static void transationProcess(Map<String, Integer> subjects, int total) 
    {
        int flag = 1;

        for (Map.Entry<String, Integer> num : subjects.entrySet()) 
        {
            if (num.getValue() < 35) 
            {
                if (flag == 1) 
                {
                    System.out.println("********************************Result***********************************");
                }
                System.out.println("You Are Failed in " + num.getKey());
                flag = 0;
            }
        }

        if (flag == 0) 
        {
            System.out.println("************************Better Luck Next Time********************************");
        } else 
        {
            sum_average_grade(subjects, total);
        }
    }

    // Calculate sum, average, and grade
    public static void sum_average_grade(Map<String, Integer> subjects, int total) 
    {
        float sum = 0;
        for (Map.Entry<String, Integer> num : subjects.entrySet()) 
        {
            sum = sum + num.getValue();
        }
        float average = sum / total;
        String grade = "";

        if (average >= 90) 
        {
            grade = "A+";
        } else if (average >= 80 && average < 90) 
        {
            grade = "A";
        } else if (average >= 70 && average < 80) 
        {
            grade = "B+";
        } else if (average >= 60 && average < 70) 
        {
            grade = "B";
        } else if (average >= 50 && average < 60) 
        {
            grade = "C+";
        } else if (average >= 40 && average < 50) 
        {
            grade = "C";
        } else {
            grade = "D";
        }
        display(subjects, sum, average, grade);
    }

    // Display the result
    public static void display(Map<String, Integer> subjects, float sum, float average, String grade) 
    {
        System.out.println("********************************Result***********************************");
        for (Map.Entry<String, Integer> num : subjects.entrySet()) 
        {
            System.out.println(num.getKey() + " : " + num.getValue());
        }
        System.out.println("GRADE : " + grade);
        System.out.println("Grand Total is : " + sum);
        System.out.println("Percentage is : " + average);

        System.out.println("********************************Congratulation***********************************");
    }
}
