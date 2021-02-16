package project5;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JList;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Add_Item extends JFrame{
        private JFrame add_item;
        private JMenuBar menuBar;
        private JMenu file, edit, tools, help;
        private JButton [] jb;
        private JPanel jp1, jp2;
        private JScrollPane jsp;
       private TextArea previewArea = new TextField(4, 60);
        //pprivate TextField First_name = new TextField(14);
       // private TextField Last_name = new TextField(14);
        protected JList list;
        private ActionListener e;
        private Customer cust;
        private Movie[] movie_array;
        private  DVD dvds[ ] = new DVD[ 3 ];
        private Game [] game_array;
        private Concert [] concert_array;
        public Add_Item(String name)
        {
        	//call super class construtors
        	super(name);
        	//set flow layout
        	setLayout(new FlowLayout(FlowLayout.CENTER, 10, 60));
        	//define menu object
        
        	add(previewArea);
        add_item = new JFrame("Rental Items");
        /**
         * Adding menu bar to JavaFlix Frame
         */
          menuBar = new JMenuBar();
          add_item.setJMenuBar(menuBar);
          //adding menu files
           file = new JMenu("File");
           edit = new JMenu("Edit");
           tools = new JMenu("Tools");
           help = new JMenu("Help");

           menuBar.add(file);
           menuBar.add(edit);
           menuBar.add(tools);
           menuBar.add(help);
            setMenuBar(bar);
            add(textArea)
            
           /**
            * adding Mnemonics for menu items
            */
            file.setMnemonic('F');
            file.setMnemonic('E');
            file.setMnemonic('T');
            file.setMnemonic('H');

           file.add(new JMenuItem("New Customer")).setMnemonic('N');
           file.add(new JMenuItem("Open")).setMnemonic('O');
           file.addSeparator();
           file.add(new JMenuItem("Print")).setMnemonic('P');
           file.addSeparator();
           file.add(new JMenuItem("Exit")).setMnemonic('x');
  jb = new JButton[4];
  jb[0]  = new JButton("Add Movie");
  jb[0].setMnemonic('M');
  jb[1]  = new JButton("Add Game");
  jb[1].setMnemonic('G');
  jb[2]  = new JButton("Add Concert");
  jb[2].setMnemonic('C');



  jp1 = new JPanel(new BorderLayout(1,2));
  jp2 = new JPanel(new BorderLayout(1,3));
  jp1.add( jb[0] );  jp1.add( jb[1] );

  add_item.add(jp1, BorderLayout.NORTH);
  add_item.add(jp2, BorderLayout.SOUTH);

list = new JList(movie_array);
list = new JList(game_array);
list = new JList(concert_array);

 jsp = new JScrollPane(list);
 jb[0].addActionListener(e);
 jb[0].addActionListener(e);
 this.getContentPane().add(list, BorderLayout.CENTER);
 this.getContentPane().add(jp1, BorderLayout.SOUTH);
 this.getContentPane().add(jp2, BorderLayout.SOUTH);

 /**
  * Setting Jframe attributes
  */
 add_item.setSize( 800, 700 );
 add_item.setVisible(true);
 add_item.setDefaultCloseOperation( add_item.DISPOSE_ON_CLOSE );
 }



}//end
