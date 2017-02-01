import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JFrame;

public class simpleGUI extends JFrame {
    
     JFrame doubleFrame;
     TextArea original, sort, sort2;
     Container JPane;
    
    public simpleGUI() {
        initialize();
    }
    
    
    private void initialize() {
        original = new TextArea();
        sort = new TextArea();
        sort2 = new TextArea();
        doubleFrame = new JFrame();
        doubleFrame.setSize(700,300);
        doubleFrame.setLocation(700,400);
        doubleFrame.setTitle("Farhad Project3");
        doubleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        doubleFrame.setLayout(new GridLayout(1,3));
        doubleFrame.setVisible(true);
        JPane = doubleFrame.getContentPane();
        JPane.add(original); 
        JPane.add(sort);
        JPane.add(sort2);
    }//initialize
    
    
    public void printlist(Baseplayer[] a, int size){
        original.append("Original data:\n\n");
        for(int k=0;k<size;k++){
            if(a[k]!=null){
                original.append(a[k].toString());
         }
      }
    }//printlist
    
    
    
    public void printsort(Baseplayer[] b, int size){
        sort.append("Fielder information:\n\n");
        sort2.append("Pitcher information:\n\n");
        for(int k=0;k<size;k++){
            if(b[k]!=null){
              if(b[k].toString().charAt(0)=='F'){
                if(b[k]!=null){
                 sort.append(b[k].toString());
                }
              }
              else 
                if(b[k]!=null){
                    sort2.append(b[k].toString());
            }
         }//if (b[k]!= null)
      }//for
    }//printsort
    
}//simpleGUI
