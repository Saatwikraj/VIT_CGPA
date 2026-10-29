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

    System.out.printf("Your CGPA: %.2f",
        ((currentCGPA * currentCredits) + (estimateCGPA * creditsThisSem)) / (currentCredits + creditsThisSem));
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

    System.out.print("CAT1 done?(Y/N): ");
    String i1 = sc.nextLine();
    double mycat1 = 0.0;
    double cat1avg = 0.0;
    if (i1.toUpperCase().equals("Y")) {
      System.out.print("Enter your CAT1 marks: ");
      mycat1 = sc.nextDouble();
      System.out.print("Enter your CAT1 average: ");
      cat1avg = sc.nextDouble();
      sc.nextLine();
    }
    double diff1 = mycat1 - cat1avg;
    aboveavg += diff1 * 0.3;
    System.out.println();

    System.out.print("CAT2 done?(Y/N): ");
    String i2 = sc.nextLine();
    double mycat2 = 0.0;
    double cat2avg = 0.0;
    if (i2.toUpperCase().equals("Y")) {
      System.out.print("Enter your CAT2 marks: ");
      mycat2 = sc.nextDouble();
      System.out.print("Enter your CAT2 average: ");
      cat2avg = sc.nextDouble();
      sc.nextLine();
    }
    double diff2 = mycat2 - cat2avg;
    aboveavg += diff2 * 0.3;
    System.out.println();

    System.out.print("Quiz1 done?(Y/N): ");
    String i3 = sc.nextLine();
    double myquiz1 = 0.0;
    double quiz1avg = 0.0;
    if (i3.toUpperCase().equals("Y")) {
      System.out.print("Enter your Quiz1 marks: ");
      myquiz1 = sc.nextDouble();
      System.out.print("Enter your Quiz1 average: ");
      quiz1avg = sc.nextDouble();
      sc.nextLine();
    }
    double diff3 = myquiz1 - quiz1avg;
    aboveavg += diff3;
    System.out.println();

    System.out.print("Quiz2 done?(Y/N): ");
    String i4 = sc.nextLine();
    double myquiz2 = 0.0;
    double quiz2avg = 0.0;
    if (i4.toUpperCase().equals("Y")) {
      System.out.print("Enter your Quiz2 marks: ");
      myquiz2 = sc.nextDouble();
      System.out.print("Enter your Quiz2 average: ");
      quiz2avg = sc.nextDouble();
      sc.nextLine();
    }
    double diff4 = myquiz2 - quiz2avg;
    aboveavg += diff4;
    System.out.println();

    System.out.print("Quiz3 done?(Y/N): ");
    String i5 = sc.nextLine();
    double myquiz3 = 0.0;
    double quiz3avg = 0.0;
    if (i5.toUpperCase().equals("Y")) {
      System.out.print("Enter your Quiz3 marks: ");
      myquiz3 = sc.nextDouble();
      System.out.print("Enter your Quiz3 average: ");
      quiz3avg = sc.nextDouble();
      sc.nextLine();
    }
    double diff5 = myquiz3 - quiz3avg;
    aboveavg += diff5;
    System.out.println();

    System.out.print("FAT done?(Y/N): ");
    String i6 = sc.nextLine();
    double myfat = 0.0;
    double fatavg = 0.0;
    if (i6.toUpperCase().equals("Y")) {
      System.out.print("Enter your FAT marks: ");
      myfat = sc.nextDouble();
      System.out.print("Enter your FAT average: ");
      fatavg = sc.nextDouble();
      sc.nextLine();
    }
    double diff6 = myfat - fatavg;
    aboveavg += diff6 * 0.4;
    System.out.println();
    System.out.printf("Your marks above average = %.2f", aboveavg * thw);
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
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Hello user!!!");
    System.out.println();
    System.out.println("1) Calculate CGPA");
    System.out.println("2) Estimate your average");
    System.out.println("3) CGPA from base");
    System.out.println();
    System.out.print("Choose your option: ");
    int choice = sc.nextInt();
    System.out.println();

    if (choice == 1) {
      calculateCGPA(sc);
    } else if (choice == 2) {
      estimateAvg(sc);
    } else if (choice == 3) {
      CGPAFromGrades(sc);
    } else {
      System.out.println("Enter valid choice.");
    }
    sc.close();
  }
}