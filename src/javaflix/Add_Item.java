package javaflix;

// Rental items window: lists the store inventory, adds new movies / games / concerts,
// and (when opened from a "Select a ..." button) picks an item for a customer.
//
// Rebuilt from the original (which did not compile), keeping its Add Movie / Add Game /
// Add Concert buttons and item list.

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Add_Item extends JFrame {

    private final List<DVD> inventory;
    private final Class<? extends DVD> filter;
    private final DefaultListModel<DVD> model = new DefaultListModel<>();
    private final JList<DVD> list = new JList<>(model);

    /**
     * @param name     window title
     * @param inventory the store inventory (shared with JavaFlix)
     * @param filter   only show this kind of item (null = everything)
     * @param onChoose called with the chosen item (null = browse/add only)
     */
    public Add_Item(String name, List<DVD> inventory, Class<? extends DVD> filter, Consumer<DVD> onChoose) {
        super(name);
        this.inventory = inventory;
        this.filter = filter;
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        refresh();

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton addMovie = new JButton("Add Movie");
        addMovie.setMnemonic('M');
        addMovie.addActionListener(e -> addMovie(false));
        JButton addGame = new JButton("Add Game");
        addGame.setMnemonic('G');
        addGame.addActionListener(e -> addGame());
        JButton addConcert = new JButton("Add Concert");
        addConcert.setMnemonic('C');
        addConcert.addActionListener(e -> addMovie(true));
        buttons.add(addMovie);
        buttons.add(addGame);
        buttons.add(addConcert);
        if (onChoose != null) {
            JButton choose = new JButton("Choose");
            choose.setMnemonic('h');
            choose.addActionListener(e -> {
                DVD item = list.getSelectedValue();
                if (item == null) {
                    return;
                }
                if (!item.isAvailable()) {
                    JOptionPane.showMessageDialog(this, "That item is out of stock.");
                    return;
                }
                onChoose.accept(item);
                dispose();
            });
            buttons.add(choose);
        }

        setLayout(new BorderLayout());
        add(new JScrollPane(list), BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        setSize(700, 450);
        setLocationByPlatform(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void refresh() {
        model.clear();
        for (DVD d : inventory) {
            if (filter == null || filter.isInstance(d)) {
                model.addElement(d);
            }
        }
    }

    private void addMovie(boolean concert) {
        String title = JOptionPane.showInputDialog(this, "Title");
        if (title == null || title.isBlank()) {
            return;
        }
        String director = JOptionPane.showInputDialog(this, "Director");
        String band = concert ? JOptionPane.showInputDialog(this, "Band") : null;
        int year = askInt("Year");
        int minutes = askInt("Minutes");
        DVD item = concert
                ? new Concert(band == null ? "" : band, title, director == null ? "" : director, year, minutes)
                : new Movie(title, director == null ? "" : director, Movie.NR, year, minutes);
        inventory.add(item);
        refresh();
    }

    private void addGame() {
        String title = JOptionPane.showInputDialog(this, "Title");
        if (title == null || title.isBlank()) {
            return;
        }
        String[] platforms = {"PS1", "DC", "PS2", "XBOX", "CUBE", "PS3", "X360", "WII"};
        int p = JOptionPane.showOptionDialog(this, "Platform", "Add Game", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, platforms, platforms[0]);
        inventory.add(new Game(title, p + 1, askInt("Year")));
        refresh();
    }

    private int askInt(String what) {
        String s = JOptionPane.showInputDialog(this, what);
        try {
            return s == null ? 0 : Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
