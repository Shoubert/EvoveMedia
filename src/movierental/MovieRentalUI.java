package movierental;

// Swing front end for the Assignment 08 movie rental: add and remove rentals, set the
// number of days late, and see each movie's late fee and the total update as you go.
//
// Run: java -cp out movierental.MovieRentalUI

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

public class MovieRentalUI extends JPanel {

    private static final String[] GENRES = {"Action", "Comedy", "Drama"};
    private static final String[] RATINGS = {"G", "PG", "PG-13", "R", "NC-17"};

    private final RentalTableModel rentals = new RentalTableModel();
    private final JTable table = new JTable(rentals);
    private final JSpinner daysLate = new JSpinner(new SpinnerNumberModel(0, 0, 365, 1));
    private final JLabel total = new JLabel();

    // add-movie form
    private final JTextField title = new JTextField(18);
    private final JComboBox<String> rating = new JComboBox<>(RATINGS);
    private final JTextField id = new JTextField(9);
    private final JSpinner rentTime = new JSpinner(new SpinnerNumberModel(3, 1, 30, 1));
    private final JComboBox<String> genre = new JComboBox<>(GENRES);

    public MovieRentalUI() {
        super(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        rentals.add(new Comedy("Men In Black", "PG-13", 123456789, 5));
        rentals.add(new Action("Lord of the Rings: Return of the King", "R", 223456790, 4));
        rentals.add(new Drama("Despicable Me", "G", 243534, 7));

        add(buildForm(), BorderLayout.NORTH);
        add(buildTable(), BorderLayout.CENTER);
        add(buildFooter(), BorderLayout.SOUTH);
        refresh();
    }

    private JPanel buildForm() {
        JPanel form = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 4));
        form.setBorder(BorderFactory.createTitledBorder("Rent a movie"));
        form.add(new JLabel("Title")); form.add(title);
        form.add(new JLabel("Rating")); form.add(rating);
        form.add(new JLabel("ID")); form.add(id);
        form.add(new JLabel("Rent days")); form.add(rentTime);
        form.add(new JLabel("Genre")); form.add(genre);
        JButton add = new JButton("Add");
        add.addActionListener(e -> addMovie());
        form.add(add);
        return form;
    }

    private JScrollPane buildTable() {
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(22);
        table.getColumnModel().getColumn(0).setPreferredWidth(260);
        return new JScrollPane(table);
    }

    private JPanel buildFooter() {
        JPanel footer = new JPanel(new BorderLayout());
        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
        left.add(new JLabel("Days late:"));
        left.add(daysLate);
        JButton remove = new JButton("Return selected");
        remove.addActionListener(e -> removeSelected());
        left.add(remove);
        daysLate.addChangeListener(e -> refresh());
        total.setFont(total.getFont().deriveFont(Font.BOLD, 14f));
        footer.add(left, BorderLayout.WEST);
        footer.add(total, BorderLayout.EAST);
        return footer;
    }

    private void addMovie() {
        String name = title.getText().trim();
        int movieId;
        try {
            movieId = Integer.parseInt(id.getText().trim());
        } catch (NumberFormatException ex) {
            movieId = 0;
        }
        if (name.isEmpty() || movieId <= 0) {
            JOptionPane.showMessageDialog(this, "Enter a title and a positive numeric ID.",
                    "Missing details", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String r = (String) rating.getSelectedItem();
        int days = (Integer) rentTime.getValue();
        Movie movie;
        switch ((String) genre.getSelectedItem()) {
            case "Action": movie = new Action(name, r, movieId, days); break;
            case "Comedy": movie = new Comedy(name, r, movieId, days); break;
            default:       movie = new Drama(name, r, movieId, days); break;
        }
        if (!rentals.add(movie)) {
            JOptionPane.showMessageDialog(this, "A movie with ID " + movieId + " is already rented.",
                    "Duplicate ID", JOptionPane.WARNING_MESSAGE);
            return;
        }
        title.setText("");
        id.setText("");
        refresh();
    }

    private void removeSelected() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            rentals.remove(table.convertRowIndexToModel(row));
            refresh();
        }
    }

    private void refresh() {
        rentals.setDaysLate((Integer) daysLate.getValue());
        total.setText(String.format("Total late fees: $%.2f", rentals.totalFees()));
    }

    /** Rows are the rented movies; the late fee column depends on the days-late spinner. */
    static final class RentalTableModel extends AbstractTableModel {
        private static final String[] COLUMNS = {"Title", "Rating", "Genre", "ID", "Rent days", "Fee/day", "Late fee"};
        private final List<Movie> movies = new ArrayList<>();
        private int daysLate;

        boolean add(Movie m) {
            if (movies.contains(m)) return false;
            movies.add(m);
            fireTableRowsInserted(movies.size() - 1, movies.size() - 1);
            return true;
        }

        void remove(int row) {
            movies.remove(row);
            fireTableRowsDeleted(row, row);
        }

        void setDaysLate(int days) {
            daysLate = days;
            fireTableDataChanged();
        }

        double totalFees() {
            double sum = 0;
            for (Movie m : movies) sum += m.calcLateFees(daysLate);
            return sum;
        }

        @Override public int getRowCount() { return movies.size(); }
        @Override public int getColumnCount() { return COLUMNS.length; }
        @Override public String getColumnName(int c) { return COLUMNS[c]; }

        @Override
        public Object getValueAt(int r, int c) {
            Movie m = movies.get(r);
            switch (c) {
                case 0: return m.getTitle();
                case 1: return m.getRating();
                case 2: return m.getGenre();
                case 3: return m.getID();
                case 4: return m.getRentTime();
                case 5: return String.format("$%.2f", m.getLateFeePerDay());
                default: return String.format("$%.2f", m.calcLateFees(daysLate));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Movie Rental");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new MovieRentalUI());
            frame.setSize(900, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
