import java.util.*;
public class StudentGrade {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int numStudent = sc.nextInt();

        String[] students = new String[numStudent];
        int[] grades = new int[numStudent];

        int stepOneCounter = 1;
        for (int studentCounter = 0; studentCounter < numStudent; studentCounter++) {
            System.out.print("Enter the name of the student " + stepOneCounter + ": ");
            students[studentCounter] = sc.next();
            System.out.print("Enter the grade of the student " + students[studentCounter] + ": ");
            grades[studentCounter] = sc.nextInt();
            System.out.println();
            stepOneCounter++;
        }
        System.out.println("----------------------------------------");
        System.out.println("You have the following 5 options: ");

        int optionInput;
        do {
            System.out.println("Press 1: Show names & grades of students");
            System.out.println("Press 2: Show grade ranking of students");
            System.out.println("Press 3: Show student who are failing");
            System.out.println("Press 4: Edit grade of a student");
            System.out.println("Press 5: Exit");
            System.out.print("Please choose an option between 1 to 5: ");
            optionInput = sc.nextInt();
            System.out.println();

            if (optionInput == 1) {
                int optionOneCounter = 1;
                System.out.println("----------Display student's name & grade----------");
                for (int printStudent = 0; printStudent < students.length; printStudent++) {
                    System.out.println(optionOneCounter + ": " + students[printStudent] + " has grade of " + grades[printStudent]);
                    optionOneCounter++;
                }
                System.out.println("-----------------------------------");
            }

            else if (optionInput == 2) {
                int rankingCounter = 1;
                System.out.println("----------Student's Grade Ranking----------");
                for (int pos = 0; pos < grades.length; pos++) {

                    for (int sPos = pos + 1; sPos < grades.length; sPos++) {
                        if (grades[pos] < grades[sPos]) {
                            int temp = grades[pos];
                            String temp2 = students[pos];
                            grades[pos] = grades[sPos];
                            students[pos] = students[sPos];
                            grades[sPos] = temp;
                            students[sPos] = temp2;
                        }
                    }
                    System.out.println(rankingCounter + ": " + grades[pos] + " by " + students[pos]);
                    rankingCounter++;
                }
                System.out.println("-----------------------------------");
            }

            else if (optionInput == 3) {
                System.out.println("----------List of failing students----------");
                for (int failingCount = 0; failingCount < grades.length; failingCount++) {
                    if (grades[failingCount] < 60) {
                        System.out.println("Failing student: " + students[failingCount] + " | Grade: " + grades[failingCount]);
                    }
                }
                System.out.println("-----------------------------------");
            }

            else if (optionInput == 4) {
                System.out.println("----------Edit student's grade----------");
                int optionFourCounter = 1;
                for (int editCount = 0; editCount < grades.length; editCount++) {
                    System.out.println(optionFourCounter + " : Name: " + students[editCount] + " | Grade: " + grades[editCount]);
                    optionFourCounter++;
                }

                System.out.print("Enter whose grade you want to edit (Press between 1 and " + numStudent + ") : ");
                int editGradeInput = sc.nextInt();
                System.out.print("Enter the new grade of " + students[editGradeInput - 1] + ": ");
                int editGrade = sc.nextInt();

                System.out.print("Do you really want to change the grade of " + students[editGradeInput - 1] + "? (Press y or n)");
                String confirmInput = sc.next();

                if (confirmInput.equalsIgnoreCase("y") || confirmInput.equalsIgnoreCase("yes")) {
                    grades[editGradeInput - 1] = editGrade;
                    System.out.println("The grade of " + students[editGradeInput - 1] + " has been changed to " + editGrade + ".");
                }
            }


        } while (optionInput == 1 || optionInput == 2 || optionInput == 3 || optionInput == 4);

        System.out.println("Thank you! ");

    }
}