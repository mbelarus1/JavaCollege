/************************************************************************
 * Name: Nikita Siniauski                                         CSC 156
 * Date: June 18, 2021                                              LAB 1
 ************************************************************************
 * Statement:
 * Specifications:
 *
 * Input:
 * title, rating(3), running time
 * Output:
 * movie title, running time, average website rating, average focus group rating,
 * average movie critic rating, overall movie rating
 *************************************************************************/

import java.util.Scanner;

class MovieRating
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    String title = "";
    int runningTime = 0, siteRating1 = 0, siteRating2 = 0, siteRating3 = 0;

    Double focusRating1 = 0.0, focusRating2 = 0.0, avgCriticsRating = 0.0,
          avgSiteRating = 0.0, avgFocRating = 0.0, overallRating = 0.0;
    // 1) Ask user for :
    //    a) film title
    System.out.println("Please enter the movie name.");
    title = input.nextLine();
    //    b) running time (in minutes)
    System.out.println("Please enter the running time in minutes.");
    runningTime = input.nextInt();
    //    c) 3 ratings from a movie review website (all ints)
    System.out.println("Please enter ratings from the movie review website.");
    siteRating1 = input.nextInt();
    siteRating2 = input.nextInt();
    siteRating3 = input.nextInt();
    //    d) 2  ratings from a focus group(double)
    System.out.println("Please enter ratings from the focus group");
    focusRating1 = input.nextDouble();
    focusRating2 = input.nextDouble();
    //    e) 1 average rating from professional movie critics (double)
    System.out.println("Please enter the average movie critic rating");
    avgCriticsRating = input.nextDouble();
    // 2) Print out the following:
    //    a) movie title
    System.out.println("Title: " + title);
    //    b) movie running time in hours and minutes
    System.out.println("Running time: " + (runningTime / 60) + "hr" + (runningTime % 60));
    //    c) average website rating
    avgSiteRating = ((siteRating1 + siteRating2 + siteRating3) / 3.0);
    System.out.println("Average website rating: " + avgSiteRating);
    //    d) average focus group rating
    avgFocRating = (focusRating1 + focusRating2) / 2;
    System.out.println("Average focus group rating: " + avgFocRating);
    //    e) average movie critic rating(as 50% of overall rating) - rounded
    System.out.println("Average movie critic rating: " + avgCriticsRating );
    //    f) overall movie rating (int)
    overallRating = (((double)avgSiteRating * 0.2)) +
                    (((double)avgFocRating * 0.3)) + ((double)avgCriticsRating * 0.50);
    System.out.println("Overall movie rating: " + (int)(Math.ceil(overallRating)) );




  } //end of main
} //end of class

