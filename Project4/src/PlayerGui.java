import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PlayerGui extends JFrame {
    private TextArea textArea;
    JMenuBar menuBar;
   
    public void printAll(BaseballPlayerLinkedList List) {
        setTitle("All Players");
        textArea.setText("");
        BaseballPlayerListIterator Iterator = new BaseballPlayerListIterator(List);
        BaseballPlayer BPlayer = null;
        
        while ((BPlayer = Iterator.Iterate())!= null) {
            textArea.append(BPlayer.toString() + "\n");
        }
    } //printALl

    public void printPitchers(BaseballPlayerLinkedList List) {
        setTitle("Pitchers");
        textArea.setText("");
        BaseballPlayerListIterator Iterator = new BaseballPlayerListIterator(List);
        BaseballPlayer BPlayer = null;
        while ((BPlayer = Iterator.Iterate())!= null) {
            if (BPlayer instanceof Pitcher)
                textArea.append(BPlayer.toString() + "\n");
        }
    } //printPitchers
    public void printFielders(BaseballPlayerLinkedList List) {
        setTitle("Fielders");
        textArea.setText("");
        BaseballPlayerListIterator Iterator = new BaseballPlayerListIterator(List);
        BaseballPlayer BPlayer = null;
        while ((BPlayer = Iterator.Iterate())!= null) {
            if (BPlayer instanceof Fielder)
                textArea.append(BPlayer.toString() + "\n");

        }
    } //printFielders

    public void writeToTextArea(String s){

        textArea.append(s);
    }

    /**
     * We set up the JFrame.
     * JFrame is given its size and location,
     * and where to add new items.
     */
    
    public PlayerGui(){
        setTitle("Project 4");
        setSize(600,600);
        setLocation  (150,150);
        createMenus();
        textArea = new TextArea();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cPane = getContentPane();
        cPane.add(textArea);
        setVisible(true);
    }
    private void createMenus() {
        JMenuItem   item;
        JMenuBar    menuBar  = new JMenuBar();
        JMenu       fileMenu = new JMenu("File");
        FileMenuHandler fmh  = new FileMenuHandler(this);
        
        item = new JMenuItem("Open");
        item.addActionListener( fmh );
        fileMenu.add( item );
        fileMenu.addSeparator();
        
        item = new JMenuItem("Quit");
        item.addActionListener( fmh );
        fileMenu.add( item );
        
        JMenu displayMenu = new JMenu("Display");
        DisplayMenuHandler dmh  = new DisplayMenuHandler(this);
        
        item = new JMenuItem("All");
        item.addActionListener(dmh);
        displayMenu.add(item);
        displayMenu.addSeparator();
        
        item = new JMenuItem("Fielders");
        item.addActionListener(dmh);
        displayMenu.add(item);
        displayMenu.addSeparator();
        
        item = new JMenuItem("Pitchers");
        item.addActionListener(dmh);
        displayMenu.add(item);
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(displayMenu);

    } //createMenu
} //class
