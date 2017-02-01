import javax.swing.*;
import java.awt.event.*;
public class DisplayMenuHandler implements ActionListener{
    JFrame jFrame;
    public DisplayMenuHandler (JFrame jf) {
        jFrame = jf;
    }
    public void actionPerformed(ActionEvent event){
        String menuName = event.getActionCommand();
        if (menuName.equals("All"))
            Project4.GUI.printAll (Project4.List);
        else if (menuName.equals("Pitchers"))
            Project4.GUI.printPitchers(Project4.List);
        else if (menuName.equals("Fielders"))
            Project4.GUI.printFielders(Project4.List);
    }

} 
