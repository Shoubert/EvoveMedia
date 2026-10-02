package javaflix;

// Inventory control: this GUI lets JavaFlix employees serve their customers and manage
// their inventory of DVDs: movies, concerts and games.
//
// Rebuilt from the 2007 version (which did not compile) keeping its layout and intent:
// File / Edit / Tools / Help menus, "Select a ..." buttons on the left, a customer form,
// and a customer list.

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class JavaFlix extends JFrame {

    private final DefaultListModel<Customer> customers = new DefaultListModel<>();
    private final JList<Customer> customerList = new JList<>(customers);
    private final List<DVD> inventory = new ArrayList<>();
    private final Map<Customer, FlixQueue> queues = new HashMap<>();
    private final JTextArea details = new JTextArea(8, 40);

    // customer form
    private final JTextField firstName = new JTextField(14);
    private final JTextField middleInitial = new JTextField(2);
    private final JTextField lastName = new JTextField(14);
    private final JTextField streetNumber = new JTextField(5);
    private final JTextField street = new JTextField(20);
    private final JTextField city = new JTextField(14);
    private final JTextField state = new JTextField(2);
    private final JTextField zip = new JTextField(5);

    public JavaFlix(String name) {
        super(name);
        seedData();
        setJMenuBar(buildMenus());
        setLayout(new BorderLayout(10, 10));
        add(buildButtons(), BorderLayout.WEST);
        add(buildCustomerForm(), BorderLayout.NORTH);

        customerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        customerList.addListSelectionListener(e -> showSelected());
        details.setEditable(false);
        details.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JPanel center = new JPanel(new GridLayout(1, 2, 10, 10));
        center.add(new JScrollPane(customerList));
        center.add(new JScrollPane(details));
        center.setBorder(BorderFactory.createTitledBorder("Customers"));
        add(center, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JMenuBar buildMenus() {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        file.setMnemonic('F');
        JMenu edit = new JMenu("Edit");
        edit.setMnemonic('E');
        JMenu tools = new JMenu("Tools");
        tools.setMnemonic('T');
        JMenu help = new JMenu("Help");
        help.setMnemonic('H');

        JMenuItem newCustomer = file.add(new JMenuItem("New Customer"));
        newCustomer.setMnemonic('N');
        newCustomer.addActionListener(e -> clearForm());
        file.addSeparator();
        JMenuItem exit = file.add(new JMenuItem("Exit"));
        exit.setMnemonic('x');
        exit.addActionListener(e -> dispose());

        JMenuItem inventoryItem = tools.add(new JMenuItem("Inventory"));
        inventoryItem.setMnemonic('I');
        inventoryItem.addActionListener(e -> new Add_Item("Rental Items", inventory, null, null).setVisible(true));

        JMenuItem about = help.add(new JMenuItem("About JavaFlix"));
        about.setMnemonic('b');
        about.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "JavaFlix Inventory Control\nRentals of movies, concerts and games.", "About", JOptionPane.INFORMATION_MESSAGE));
        help.addSeparator();
        JMenuItem tips = help.add(new JMenuItem("Tips"));
        tips.setMnemonic('i');
        tips.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Select a customer, then use a Select button to queue an item to rent.", "Tips", JOptionPane.INFORMATION_MESSAGE));

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(tools);
        menuBar.add(help);
        return menuBar;
    }

    private JPanel buildButtons() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Rent"));
        addSelectButton(panel, "Select A Movie", 'M', Movie.class);
        addSelectButton(panel, "Select A Concert", 'C', Concert.class);
        addSelectButton(panel, "Select A Game", 'G', Game.class);
        addSelectButton(panel, "Select A DVD", 'D', DVD.class);
        JButton rent = new JButton("Rent Next in Queue");
        rent.setMnemonic('R');
        rent.addActionListener(e -> rentNext());
        panel.add(rent);
        return panel;
    }

    private void addSelectButton(JPanel panel, String label, char mnemonic, Class<? extends DVD> type) {
        JButton b = new JButton(label);
        b.setMnemonic(mnemonic);
        b.addActionListener(e -> {
            Customer c = customerList.getSelectedValue();
            if (c == null) {
                JOptionPane.showMessageDialog(this, "Select a customer first.");
                return;
            }
            new Add_Item(label.replace("Select A ", "Choose a "), inventory, type, item -> queue(c, item)).setVisible(true);
        });
        panel.add(b);
    }

    private JPanel buildCustomerForm() {
        JPanel form = new JPanel(new GridLayout(2, 8, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("New customer"));
        addField(form, "First Name", firstName);
        addField(form, "Middle Initial", middleInitial);
        addField(form, "Last Name", lastName);
        addField(form, "Street #", streetNumber);
        addField(form, "Street", street);
        addField(form, "City", city);
        addField(form, "State", state);
        addField(form, "Zip", zip);
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(form, BorderLayout.CENTER);
        JButton add = new JButton("Add Customer");
        add.setMnemonic('A');
        add.addActionListener(e -> addCustomer());
        wrapper.add(add, BorderLayout.EAST);
        return wrapper;
    }

    private static void addField(JPanel form, String label, JTextField field) {
        JLabel l = new JLabel(label);
        l.setFont(new Font("Verdana", Font.BOLD, 10));
        l.setForeground(Color.red);
        l.setLabelFor(field);
        form.add(l);
        form.add(field);
    }

    private void addCustomer() {
        int number;
        try {
            number = streetNumber.getText().isBlank() ? 0 : Integer.parseInt(streetNumber.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Street # must be a number.");
            return;
        }
        Address addr = new Address(number, street.getText(), city.getText(), state.getText(), zip.getText());
        String mi = middleInitial.getText().trim();
        Customer c = new Customer(firstName.getText(), mi.isEmpty() ? '\0' : mi.charAt(0), lastName.getText(), addr);
        if (firstName.getText().isBlank() || lastName.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "First and last name are required.");
            return;
        }
        customers.addElement(c);
        customerList.setSelectedValue(c, true);
        clearForm();
    }

    private void clearForm() {
        for (JTextField f : new JTextField[]{firstName, middleInitial, lastName, streetNumber, street, city, state, zip}) {
            f.setText("");
        }
        firstName.requestFocusInWindow();
    }

    private void queue(Customer c, DVD item) {
        if (!(item instanceof Movie)) {
            JOptionPane.showMessageDialog(this, "Only movies and concerts can be queued; games are rented directly.");
            if (item.isAvailable()) {
                item.setAvailable(false);
            }
        } else if (!queues.computeIfAbsent(c, k -> new FlixQueue()).add((Movie) item)) {
            JOptionPane.showMessageDialog(this, "Queue is full (" + FlixQueue.MAX_QUEUE + " movies).");
        }
        showSelected();
    }

    private void rentNext() {
        Customer c = customerList.getSelectedValue();
        if (c == null) {
            return;
        }
        Movie m = queues.computeIfAbsent(c, k -> new FlixQueue()).rent();
        JOptionPane.showMessageDialog(this, m == null ? "Nothing in the queue is in stock." : "Rented: " + m.getTitle());
        showSelected();
    }

    private void showSelected() {
        Customer c = customerList.getSelectedValue();
        details.setText(c == null ? "" : c + "\n\n" + queues.getOrDefault(c, new FlixQueue()));
    }

    /** Sample data (the original seeded five customers). */
    private void seedData() {
        String[] first = {"Shubert", "Marie", "Sylvie", "Peggy", "James"};
        for (String f : first) {
            customers.addElement(new Customer(f, "Charlotin"));
        }
        inventory.add(new Movie("The Matrix", "Wachowski", Movie.R, 1999, 136));
        inventory.add(new Movie("Toy Story", "John Lasseter", Movie.G, 1995, 81));
        inventory.add(new Movie("Casablanca", "Michael Curtiz", Movie.PG, 1942, 102));
        inventory.add(new Concert("Live Aid", "Live Aid 1985", "Various", 1985, 600));
        inventory.add(new Game("Halo 3", Game.X360, 2007));
        inventory.add(new Game("Super Mario Galaxy", Game.WII, 2007));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JavaFlix javaflix = new JavaFlix("JavaFlix Inventory Control");
            javaflix.setSize(900, 600);
            javaflix.setLocationRelativeTo(null);
            javaflix.setVisible(true);
        });
    }
}
