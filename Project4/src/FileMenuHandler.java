import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
public class FileMenuHandler implements ActionListener {
    JFrame jFrame;
    public FileMenuHandler (JFrame jf) {
        jFrame = jf;
    }
    public void actionPerformed(ActionEvent event) {
        String menuName = event.getActionCommand();
        if (menuName.equals("Open")) {
            JFileChooser jfc = new JFileChooser("./"); 
            jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            jfc.showOpenDialog(null);
            File F = jfc.getSelectedFile();
            if(F != null){
                try {
                    Project4.readFile(F.getAbsolutePath());;
                } catch (FileNotFoundException e) {
                    
                    e.printStackTrace();
                }

            }

        }
        else  if (menuName.equals("Quit"))
            System.exit(0);
    }
}