import java.util.*;

public class myproject {

  public static void calculateCGPA(Scanner sc) {

    System.out.print("Enter current cgpa till now: ");
    double currentCGPA = sc.nextDouble();
    System.out.print("Enter current credits done till now: ");
    double currentCredits = sc.nextDouble();

    System.out.print("Enter current estimated GPA of this semester: ");
    double estimateCGPA = sc.nextDouble();
    System.out.print("Enter current credits of this semester: ");
    double creditsThisSem = sc.nextDouble();
    sc.nextLine();

    System.out.printf("Your CGPA: %.2f",
        ((currentCGPA * currentCredits) + (estimateCGPA * creditsThisSem)) / (currentCredits + creditsThisSem));
    System.out.println();
  }

  public static double getMarks(Scanner sc, String examName, double weight) {
    System.out.print(examName + " done?(Y/N): ");
    if (sc.nextLine().toUpperCase().equals("Y")) {
      System.out.print("Enter your " + examName + " marks: ");
      double marks = sc.nextDouble();
      System.out.print("Enter your " + examName + " average: ");
      double avg = sc.nextDouble();
      sc.nextLine();
      System.out.println();
      return (marks - avg) * weight;
    }
    System.out.println();
    return 0.0;
  }

  public static void estimateAvg(Scanner sc) {

    System.out.print("For your ETH course enter theory composition: ");
    int th = sc.nextInt();
    System.out.print("For your ETH course enter lab composition: ");
    int lab = sc.nextInt();

    double thw = (double) th / (th + lab);
    double aboveavg = 0.0;
    sc.nextLine();
    System.out.println();

    aboveavg += getMarks(sc, "CAT1", 0.3);
    aboveavg += getMarks(sc, "CAT2", 0.3);
    aboveavg += getMarks(sc, "Quiz1", 1.0);
    aboveavg += getMarks(sc, "Quiz2", 1.0);
    aboveavg += getMarks(sc, "Quiz3", 1.0);
    aboveavg += getMarks(sc, "FAT", 0.4);

    System.out.printf("Your marks above average = %.2f", aboveavg * thw);
    System.out.println();
  }

  public static void CGPAFromGrades(Scanner sc) {
    System.out.print("Enter no. of subjects: ");
    int subjects = sc.nextInt();
    System.out.println();

    int credits[] = new int[subjects];
    String grades[] = new String[subjects];

    for (int i = 0; i < subjects; i++) {
      System.out.print("Enter no. of credits for subject " + (i + 1) + ": ");
      credits[i] = sc.nextInt();
      sc.nextLine();
      System.out.print("Enter grade for subject " + (i + 1) + ": ");
      grades[i] = sc.nextLine();
      System.out.println();
    }

    double totalval = 0.0;
    double totalcreds = 0.0;

    for (int i = 0; i < subjects; i++) {
      String currgrade = grades[i].toUpperCase();
      if (currgrade.equals("S")) {
        totalval += credits[i] * 10.0;
        totalcreds += credits[i];
      } else if (currgrade.equals("A")) {
        totalval += credits[i] * 9.0;
        totalcreds += credits[i];
      } else if (currgrade.equals("B")) {
        totalval += credits[i] * 8.0;
        totalcreds += credits[i];
      } else if (currgrade.equals("C")) {
        totalval += credits[i] * 7.0;
        totalcreds += credits[i];
      } else if (currgrade.equals("D")) {
        totalval += credits[i] * 6.0;
        totalcreds += credits[i];
      }
    }
    System.out.printf("Your CGPA based on your grades = %.2f", totalval / totalcreds);
    System.out.println();
  }

  public static void targetCGPA(Scanner sc) {
    System.out.print("Enter your current CGPA: ");
    double currentCGPA = sc.nextDouble();
    System.out.print("Enter your current no of credits done: ");
    int currentCredits = sc.nextInt();
    System.out.println();
    System.out.print("Enter your target CGPA: ");
    double target = sc.nextDouble();
    if (target < currentCGPA) {
      System.out.println("Choose a target better than your current CGPA");
      choose_fn(sc);
      return;
    }
    System.out.print("Enter next sem credits: ");
    int nextsemcredits = sc.nextInt();
    sc.nextLine();

    double fullval = target * (nextsemcredits + currentCredits);
    double requiredgpa = (fullval - (currentCGPA * currentCredits)) / (nextsemcredits);

    if (requiredgpa <= 10.0) {
      System.out.printf("Your target GPA for next sem should be: %.2f", requiredgpa);
    } else {
      System.out.println("This target is mathematically impossible");
    }
    System.out.println();
  }

  public static void choose_fn(Scanner sc) {
    System.out.println("1) Calculate CGPA");
    System.out.println("2) Estimate your average");
    System.out.println("3) CGPA from base");
    System.out.println("4) Target CGPA for next sem");
    System.out.println("5) Quit program");
    System.out.println();
    System.out.print("Choose your option: ");
    int choice = sc.nextInt();
    System.out.println();
    sc.nextLine();

    if (choice == 1) {
      calculateCGPA(sc);
    } else if (choice == 2) {
      estimateAvg(sc);
    } else if (choice == 3) {
      CGPAFromGrades(sc);
    } else if (choice == 4) {
      targetCGPA(sc);
    } else if (choice == 5) {
      System.out.print("Thanks! Hope to see you again!");
      return;
    } else {
      System.out.println("Enter valid choice.");
      choose_fn(sc);
      return;
    }

    System.out.println();
    System.out.print("Would you like to continue with the program? (Y/N): ");
    String inp = sc.nextLine().toUpperCase();
    if (inp.equals("Y")) {
      choose_fn(sc);
    } else if (inp.equals("N")) {
      System.out.println("Hope to see you again!");
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Hello user!!!");
    System.out.println();
    choose_fn(sc);
    sc.close();
  }
}