import java.util.*;

public class NumberGame{
 
    //main block
    public static void main(String[] args) 
    {
        Scanner obj = new Scanner(System.in);
        int random_num = (int)(Math.random() * 100 + 1);
        int score = 0;
        int j = 1;
        int attempt=5;

        System.out.println("------------------GUESS THE CORRECT NUMBER----------------");
        System.out.println("You have 5 Attempts");
        for (int i = 0; i < attempt; i++)
        {
            System.out.println("Level " + j + " You have " + (attempt - i) + " Attempt Remeining");
            System.out.println("Enter a Number between 1 to 100.");
            System.out.print("Your Guess : ");
            int guess_num = obj.nextInt();
            if (guess_num <= 100 && guess_num >= 1)
            {
                if (random_num == guess_num)
                {
                    System.out.println("You are Correct");
                    score = score + 10;
                    System.out.println("SCORE: " + score);
                    i = -1;
                    random_num = (int)(Math.random() * 100 + 1);
                    j++;
                    System.out.println("***************************Level " + j + "*******************************");
                }
                else 
                {
                    transationProcess(guess_num, random_num);
                }
            }
            else
            {
                System.out.println(" Please Enter Number between 1 to 100.");
            }
        }
   
        System.out.println("You Lose ");
        System.out.println("SCORE: " + score);
    }

    //transationProcessing block
    public static void transationProcess(int guess_num, int random_num)
    {
        if (guess_num > random_num + 10)
        {
            System.out.println("Too high");
        }
        else if (guess_num < random_num - 10)
        {
            System.out.println("Too Low");
        }
        else if (guess_num <= random_num + 10 && random_num < guess_num)
        {
            System.out.println("High");
        }
        else if (guess_num >= random_num - 10 && guess_num < random_num)
        {
            System.out.println("Low");
        }
    }
}