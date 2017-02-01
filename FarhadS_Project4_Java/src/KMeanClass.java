import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class AverageCenter {
   double x = 0.0;
   double y = 0.0;
}

public class KMeanClass {

   private boolean labelChecker = false;
   
   private int k;
   private AverageCenter[] kCentroids;
   private int numPts;
   private PointClass[] pointSet;
   private int numRow;
   private int numCol;
   private int[][] imageArray;
   
   private String inputFile;
   private FileReader fReader;
   
   // initiate the instance variables in the constructor
   KMeanClass (int k, int numPts, int numRow, int numCol, String s1) {
      this.k = k;
      this.numPts = numPts;
      this.numRow = numRow;
      this.numCol = numCol;
      
      kCentroids = new AverageCenter[k];
      for (int i=0; i<k; i++)
         kCentroids[i] = new AverageCenter();
      
      pointSet = new PointClass[numPts];
      for (int i=0; i < pointSet.length; i++)
         pointSet[i] = new PointClass();
      
      imageArray = new int[numRow][numCol];
      
      inputFile = s1;
   }
   
   // Load all the data points in the 2-d array
   public void loadPointSet() {
      try {
         fReader = new FileReader(inputFile);
      
         Scanner scan = new Scanner(fReader);
         scan.nextInt();
         scan.nextInt();
         scan.nextInt();
         scan.nextInt();
         
         for (int i=0; i < pointSet.length; i++) {                           //scan.hasNextInt()
            pointSet[i].setX_Coor(scan.nextInt());
            pointSet[i].setY_Coor(scan.nextInt());
         }
         
         scan.close();
         fReader.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   // assign a cluster ID to each data point
   public void assignLabel() {
      for (int i=0; i < numPts; i++) {
         pointSet[i].setClusterID((i % 4) + 1);;
      }
   }
   
   // map (draw/place) the data points like an image
   public void mapPoint2Image() {
      for (int i=0; i < numPts; i++) {
         imageArray[pointSet[i].getX_Coor()][pointSet[i].getY_Coor()] = pointSet[i].getClusterID();
      }
   }
   
   // Cluster the data points based on the algorithm and the formulas
   public void startClustering(PrintWriter pWriter2) {     
      labelChecker = true;

      while (labelChecker) {
         labelChecker = false;
         computeCenter();
         computeDistance();
         mapPoint2Image();
         displayImage(pWriter2);
      }
   }
   
   // compute the center of a cluster
   public void computeCenter() {
      for (int i=0; i < k; i++) {
         kCentroids[i].x = avgCenterX(i+1);
         kCentroids[i].y = avgCenterY(i+1);
      }
   }
   
   // compute the average center in the X-coordinate
   public double avgCenterX(int label) {
      int sumOfX = 0;
      int numOfPts = 0;
      double result = 0;
      
      for (int i=0; i < pointSet.length; i++) {
         if (pointSet[i].getClusterID() == label) {
            sumOfX = sumOfX + pointSet[i].getX_Coor();
            numOfPts++;
         }
      }
      result = (double) sumOfX/numOfPts;
      return result;
   }
   
   // compute the average center in the Y-coordinate
   public double avgCenterY(int label) {
      int sumOfY = 0;
      int numOfPts = 0;
      double result = 0;
      
      for (int i=0; i < pointSet.length; i++) {
         if (pointSet[i].getClusterID() == label) {
            sumOfY = sumOfY + pointSet[i].getY_Coor();
            numOfPts++;
         }
      }
      result = (double) sumOfY/numOfPts;
      return result;
   }
   
   // Compute the distances from a data point to the four clusters. Whichever cluster is closer to the data point will be the 
   // new cluster ID for this data point.
   public void computeDistance() {
      for (int i=0; i < pointSet.length; i++) {
         double x1 = pointSet[i].getX_Coor();
         double x2 = kCentroids[pointSet[i].getClusterID() - 1].x;
         double y1 = pointSet[i].getY_Coor();
         double y2 = kCentroids[pointSet[i].getClusterID() - 1].y;
         double distance = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
         pointSet[i].setDistance(distance);
      }
      
      double distance = 0.0;

      for (int i=0; i < pointSet.length; i++) {
         double minDistance = pointSet[i].getDistance();
         
         for (int j=0; j < k; j++) {
            distance = Math.sqrt( Math.pow( (double)(pointSet[i].getX_Coor() - kCentroids[j].x), 2) + Math.pow( (double) (pointSet[i].getY_Coor() - kCentroids[j].y), 2));

            if (distance < minDistance) {
               minDistance = distance;
               pointSet[i].setClusterID(j + 1);
               pointSet[i].setDistance(distance);
               labelChecker = true;
            }
         }
      }
   }
   
   // Print all the data points with their unique cluster ID in a list format
   public void printPointSet(PrintWriter pWriter1) {
         pWriter1.println(k);
         pWriter1.println(numPts);
         pWriter1.println(numRow + " " + numCol);
         
         for (int i=0; i< pointSet.length; i++) {
            pWriter1.println(pointSet[i].printPoint());
         }
   }
   
   // Print (display) the data points like an image. This method will be executed every time we start a new clustering
   public void displayImage(PrintWriter pWriter2) {
         for (int i=0; i < numRow; i++) {
            for (int j=0; j < numCol; j++) {
               if (imageArray[i][j] != 0)
                  pWriter2.print(imageArray[i][j]);
               else
                  pWriter2.print(" ");
            }
            pWriter2.println();
         }
   }  
}