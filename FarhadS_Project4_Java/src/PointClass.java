
public class PointClass {

   private int x_Coor;
   private int y_Coor;
   private int clusterID;
   private double distance;
   
   PointClass() {
      x_Coor = 0;
      y_Coor = 0;
      clusterID = -1;
      distance = -9999.0;
   }
   
   // getter and setter methods for the private variables
   
   public int getX_Coor() {
      return x_Coor;
   }
   
   public int getY_Coor() {
      return y_Coor;
   }
   
   public int getClusterID() {
      return clusterID;
   }
   
   public double getDistance() {
      return distance;
   }
   
   public void setX_Coor(int x) {
      x_Coor = x;
   }
   
   public void setY_Coor(int y) {
      y_Coor = y;
   }
   
   public void setClusterID(int ID) {
      clusterID = ID;
   }
   
   public void setDistance(double dist) {
      distance = dist;
   }
   
   // Print every point in this format
   public String printPoint() {
      return x_Coor + " " + y_Coor + " " + clusterID;
   }
}