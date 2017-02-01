import java.util.TreeMap;

public class TreeOperation {
    
    public void printAll(TreeMap <String, Student> treeMap, String str){
        
        System.out.println(str+ " yes");
        
        for(String key: treeMap.keySet()){
            Student temp = treeMap.get(key);
            
            System.out.println();
            System.out.print("Student's name & id : ");
            System.out.print(temp.getLastName() + ", " + temp.getFirstName());
            
            if (temp.getId() != null) {
                System.out.println(", " + temp.getId());
                //p.println(", " + temp.getId());
            
            } 
            else{
                System.out.println(", " + temp.getgeneratedId());
                //p.println(", " + sArray[k].getgeneratedId());
                
            }       
            
            System.out.println("Total credits       : " + temp.getTotalCredits());
            //p.println("Total credits       : " + sArray[k].getTotalCredits());
            
            System.out.println("Gpa (calculated)    : " + temp.getGPA());
            //p.println("Gpa (calculated)    : " + sArray[k].getGPA());
                    
            System.out.println("Course info :");
            //p.println("Course info :");
            
            for (int j = 0; j < temp.courseList.size(); j++) {

                System.out.println(temp.courseList.get(j).getCourseNumber() + "  "
                        + temp.courseList.get(j).getGradeRecieved());
                
                //p.println(sArray[k].courseList.get(j).getCourseNumber() + "    "
                //      + sArray[k].courseList.get(j).getGradeRecieved());
            }
            System.out.println();
            //p.println();
            
            
        }
        
        
    }
    
    public void printSpecific (TreeMap <String, Student> treeMap, String lastName){
        boolean flag = false;
        
        for(String key: treeMap.keySet()){
            
            if (key.compareToIgnoreCase(lastName) == 0)
                flag =true;
        }
        
        if (flag== false){
            System.out.println("Sorry, student isn't in the database.");
            return;
        }
        String word1 = lastName.toLowerCase();
        
        
        Student temp = treeMap.get(lastName);
        
        System.out.println("Here's that studen's info:");
        System.out.println();
        
        System.out.print("Student's name & id : ");
        System.out.println("hi");
        System.out.print(temp.getLastName() + ", " + temp.getFirstName());
        
        if (temp.getId() != null) {
            System.out.println(", " + temp.getId());
            //p.println(", " + temp.getId());
        
        } 
        else{
            System.out.println(", " + temp.getgeneratedId());
            //p.println(", " + sArray[k].getgeneratedId());
            
        }       
        
        System.out.println("Total credits       : " + temp.getTotalCredits());
        //p.println("Total credits       : " + sArray[k].getTotalCredits());
        
        System.out.println("Gpa (calculated)    : " + temp.getGPA());
        //p.println("Gpa (calculated)    : " + sArray[k].getGPA());
                
        System.out.println("Course info :");
        //p.println("Course info :");
        
        for (int j = 0; j < temp.courseList.size(); j++) {

            System.out.println(temp.courseList.get(j).getCourseNumber() + "  "
                    + temp.courseList.get(j).getGradeRecieved());
            
            //p.println(sArray[k].courseList.get(j).getCourseNumber() + "    "
            //      + sArray[k].courseList.get(j).getGradeRecieved());
        }
        System.out.println();
        
            
    }
    
    
    
    
}
