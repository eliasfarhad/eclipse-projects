/*
 * Project: K-means clustering problem
 * Problem: Given a list of 2-D points in x-y coordinates, and a cluster number, K,
 * the task is to partition the input point set to K subsets such that
 * points in each subset have the minimum distances to the centroid of their own subset then all other subsets' centroids.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) {

      try {
         FileReader fReader = new FileReader(args[0]);
         PrintWriter pWriter1 = new PrintWriter(args[1]);
         PrintWriter pWriter2 = new PrintWriter(args[2]);
         Scanner scan = new Scanner(fReader);
         
         // read the first four inputs in the text file. They represent the number of clusters, number of data points and the number
         // of rows and columns.
         int kl = scan.nextInt();
         int pts = scan.nextInt();
         int rows = scan.nextInt();
         int cols = scan.nextInt();
         
         KMeanClass kmean = new KMeanClass(kl, pts, rows, cols, args[0]);

         kmean.loadPointSet();
         kmean.assignLabel();    
         kmean.mapPoint2Image();
         kmean.displayImage(pWriter2);
         
         kmean.startClustering(pWriter2); 
         kmean.printPointSet(pWriter1);
         
         scan.close();
         fReader.close();
         pWriter1.close();
         pWriter2.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

}
