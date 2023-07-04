/**
 * Main.java
 * @author Ricky Leung
 * This class makes a library management gui
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.*;
import java.util.List;

public class Main extends JFrame
{
    private static ArrayList<Books> library = new ArrayList<Books>();
    private static ArrayList<Books> libraryIssued = new ArrayList<Books>();
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel status;
    private static JButton availableBooks;
    private static JTable bookTable;
    private static JComboBox selectStyle;
    private static JButton addBooks;
    private static JButton removeBooks;
    private static JButton issueBookButton;
    private static JTable issueBookTable;
    private static JButton addIssueBook;
    private static JButton removeIssueBook;

    private static JLabel bookNameLabel;
    private static JTextField bookName;
    private static JLabel bookAuthorLabel;
    private static JTextField bookAuthor;
    private static JLabel bookGenreLabel;
    private static JTextField bookGenre;
    private static JLabel bookCountLabel;
    private static JTextField bookCount;
    private static JLabel addStatus;
    private static JButton confirm;
    private static JButton cancel;

    private static JLabel bookNameLabel2;
    private static JTextField bookName2;
    private static JLabel bookAuthorLabel2;
    private static JTextField bookAuthor2;
    private static JLabel bookGenreLabel2;
    private static JTextField bookGenre2;
    private static JLabel bookCountLabel2;
    private static JTextField bookCount2;
    private static JLabel removeStatus;
    private static JButton confirm2;
    private static JButton cancel2;

    private static JLabel bookNameLabel3;
    private static JTextField bookName3;
    private static JLabel bookAuthorLabel3;
    private static JTextField bookAuthor3;
    private static JLabel bookGenreLabel3;
    private static JTextField bookGenre3;
    private static JLabel bookCountLabel3;
    private static JTextField bookCount3;
    private static JLabel dateLabel3;
    private static JLabel dateExample;
    private static JTextField date3;
    private static JLabel issueStatus;
    private static JButton confirm3;
    private static JButton cancel3;

    private static JLabel bookNameLabel4;
    private static JTextField bookName4;
    private static JLabel bookAuthorLabel4;
    private static JTextField bookAuthor4;
    private static JLabel bookGenreLabel4;
    private static JTextField bookGenre4;
    private static JLabel bookCountLabel4;
    private static JTextField bookCount4;
    private static JLabel dateLabel4;
    private static JLabel dateExample2;
    private static JTextField date4;
    private static JLabel removeIssueStatus;
    private static JButton confirm4;
    private static JButton cancel4;

    public static int getRows() {
        return Shelf.getRows();
    } 
    public static void printBooksName(ArrayList<Books> x) {
        for (Books b: x) {
            System.out.println(b.getName());
        }
    }
    public static void main(String[] args)
    {
        int i = 1;
        int[] arr = {i++};
        System.out.println(Arrays.toString(arr));
        System.out.println(i);
        List<List<String>> parent = new ArrayList<>();

        // Initialize child array
        // parent.add(new ArrayList<>(Arrays.asList("one", "two")));
        List<String> child = new ArrayList<>();
        child.add("one");
        child.add("two");
        parent.add(child);
        System.out.println(parent);
        library.add(new Books("Fifty Shades of Grey", "E.L. James", "Romance", 5));
        library.add(new Books("Twilight", "Stephenie Meyer", "Young adult fiction", 7));
        library.add(new Books("Wonder", "R.J. Palacio", "Children's Fiction", 6));
        library.add(new Books("The Hobbit", "J.R.R. Tolkien", "Fantasy", 2));
        library.add(new Books("The Da Vinci Code", "Dan Brown", "Mystery thriller", 3));
        library.add(new Books("Charlotte's Web", "E. B. White", "Children's fiction", 3));
        library.add(new Books("To Kill a Mockingbird", "Harper Lee", "Southern Gothic", 9));
        library.add(new Books("The Hunger Games", "Suzanne Collins", "Young adult fiction", 5));
        library.add(new Books("Black Beauty", "Anna Sewell", "Children's literature", 4));
        library.add(new Books("How to Win Friends and Influence People", "Dale Carnegie", "Self-Help", 3));
        JFrame addFrame = new JFrame("Add Books");
        JPanel addPanel = new JPanel();
        addFrame.add(addPanel);
        addPanel.setLayout(null);
        addFrame.setSize(500, 281);
        bookNameLabel = new JLabel("Book name:"); // Book name label and textfield
        bookNameLabel.setBounds(80, 50, 80, 25);
        addPanel.add(bookNameLabel);
        bookName = new JTextField(10);
        bookName.setBounds(150, 50, 150, 25);
        addPanel.add(bookName);
        bookAuthorLabel = new JLabel("Author:"); // Book author label and textfield
        bookAuthorLabel.setBounds(100, 75, 80, 25);
        addPanel.add(bookAuthorLabel);
        bookAuthor = new JTextField(10);
        bookAuthor.setBounds(150, 75, 150, 25);
        addPanel.add(bookAuthor);
        bookGenreLabel = new JLabel("Genre:"); // Book genre label and textfield
        bookGenreLabel.setBounds(100, 100, 80, 25);
        addPanel.add(bookGenreLabel);
        bookGenre = new JTextField(10);
        bookGenre.setBounds(150, 100, 150, 25);
        addPanel.add(bookGenre);
        bookCountLabel = new JLabel("Count:"); // Book count label and textfield
        bookCountLabel.setBounds(100, 125, 80, 25);
        addPanel.add(bookCountLabel);
        bookCount = new JTextField(10);
        bookCount.setBounds(150, 125, 150, 25);
        addPanel.add(bookCount);
        addStatus = new JLabel(""); // Changes if invalid
        addStatus.setBounds(125, 150, 150, 25);
        addPanel.add(addStatus);
        confirm = new JButton(new AbstractAction("Confirm") { // Add confirm button
            public void actionPerformed(ActionEvent c) {
                String name = bookName.getText();
                String author = bookAuthor.getText();
                String genre = bookGenre.getText();
                String count = bookCount.getText();
                try {
                    Books b = new Books(name, author, genre, Integer.parseInt(count));
                    if (Integer.parseInt(count) > 0) {
                        if (library.size() > 0) {
                            for (int n = 0; n < library.size(); n++) {
                                Books i = library.get(n);
                                if (b.getName().equalsIgnoreCase(i.getName()) && b.getAuthor().equalsIgnoreCase(i.getAuthor()) && b.getGenre().equalsIgnoreCase(i.getGenre())) {
                                    library.get(n).addCount(b.getCount());
                                    break;
                                }
                                else if (n == library.size() - 1 && !(b.getName().equalsIgnoreCase(i.getName()) && b.getAuthor().equalsIgnoreCase(i.getAuthor()) && b.getGenre().equalsIgnoreCase(i.getGenre()))) {
                                    library.add(b);
                                    break;
                                }
                            }
                        }
                        else {
                            library.add(b);
                        }
                        addFrame.dispose();
                        bookName.setText("");
                        bookAuthor.setText("");
                        bookGenre.setText("");
                        bookCount.setText("");
                        addStatus.setText("");
                    }
                    else {
                        addStatus.setText("Invalid number of books");
                    }
                } catch (NumberFormatException e) {
                    addStatus.setText("Invalid number of books");
                }
            }
        });
        confirm.setBounds(125, 200, 80, 25);
        addPanel.add(confirm);
        cancel = new JButton(new AbstractAction("Cancel") { // Add cancel button
            public void actionPerformed(ActionEvent c) {
                addFrame.dispose();
                bookName.setText("");
                bookAuthor.setText("");
                bookGenre.setText("");
                bookCount.setText("");
                addStatus.setText("");
            }
        });
        cancel.setBounds(225, 200, 80, 25);
        addPanel.add(cancel);

        JFrame removeFrame = new JFrame("Remove Books");
        JPanel removePanel = new JPanel();
        removeFrame.add(removePanel);
        removePanel.setLayout(null);
        removeFrame.setSize(500, 281);
        bookNameLabel2 = new JLabel("Book name:"); // Book name label and textfield
        bookNameLabel2.setBounds(80, 50, 80, 25);
        removePanel.add(bookNameLabel2);
        bookName2 = new JTextField(10);
        bookName2.setBounds(150, 50, 150, 25);
        removePanel.add(bookName2);
        bookAuthorLabel2 = new JLabel("Author:"); // Book author label and textfield
        bookAuthorLabel2.setBounds(100, 75, 80, 25);
        removePanel.add(bookAuthorLabel2);
        bookAuthor2 = new JTextField(10);
        bookAuthor2.setBounds(150, 75, 150, 25);
        removePanel.add(bookAuthor2);
        bookGenreLabel2 = new JLabel("Genre:"); // Book genre label and textfield
        bookGenreLabel2.setBounds(100, 100, 80, 25);
        removePanel.add(bookGenreLabel2);
        bookGenre2 = new JTextField(10);
        bookGenre2.setBounds(150, 100, 150, 25);
        removePanel.add(bookGenre2);
        bookCountLabel2 = new JLabel("Count:"); // Book count label and textfield
        bookCountLabel2.setBounds(100, 125, 80, 25);
        removePanel.add(bookCountLabel2);
        bookCount2 = new JTextField(10);
        bookCount2.setBounds(150, 125, 150, 25);
        removePanel.add(bookCount2);
        removeStatus = new JLabel(""); // Changes if invalid
        removeStatus.setBounds(125, 150, 200, 25);
        removePanel.add(removeStatus);
        confirm2 = new JButton(new AbstractAction("Confirm") { // Add confirm button
            public void actionPerformed(ActionEvent c) {
                String name = bookName2.getText();
                String author = bookAuthor2.getText();
                String genre = bookGenre2.getText();
                try {
                    int count = Integer.parseInt(bookCount2.getText());
                    if (count > 0) {
                        for (int i = 0; i < library.size(); i++) {
                            Books book = library.get(i);
                            int difference = book.getCount() - count;
                            if (name.equalsIgnoreCase(book.getName()) && author.equalsIgnoreCase(book.getAuthor()) && genre.equalsIgnoreCase(book.getGenre())) {
                                if (difference > -1) {
                                    library.get(i).removeCount(count);
                                    bookName2.setText("");
                                    bookAuthor2.setText("");
                                    bookGenre2.setText("");
                                    bookCount2.setText("");
                                    removeStatus.setText("");
                                    removeFrame.dispose();
                                    break;
                                }
                                else {
                                    removeStatus.setText("Not enough books available");
                                }
                            }
                            if (i == library.size() - 1 && !(name.equalsIgnoreCase(book.getName()) && author.equalsIgnoreCase(book.getAuthor()) && genre.equalsIgnoreCase(book.getGenre()))) {
                                removeStatus.setText("Book not available");
                            }
                        }
                        if (library.size() == 0) {
                            removeStatus.setText("Book not available");
                        }
                    }
                    else {
                        removeStatus.setText("Invalid number of books");
                    }
                }
                catch (NumberFormatException e) {
                    removeStatus.setText("Invalid number of books");
                }
            }
        });
        confirm2.setBounds(125, 200, 80, 25);
        removePanel.add(confirm2);
        cancel2 = new JButton(new AbstractAction("Cancel") { // Add cancel button
            public void actionPerformed(ActionEvent c) {
                bookName2.setText("");
                bookAuthor2.setText("");
                bookGenre2.setText("");
                bookCount2.setText("");
                removeStatus.setText("");
                removeFrame.dispose();
            }
        });
        cancel2.setBounds(225, 200, 80, 25);
        removePanel.add(cancel2);

        frame = new JFrame("Library");
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        frame.setSize(1020, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        status = new JLabel("");
        status.setBounds(422, 400, 200, 25);
        status.setForeground(Color.WHITE);
        panel.add(status);
        addBooks = new JButton(new AbstractAction("Add Books") { // Add Books Button
            public void actionPerformed(ActionEvent c) {
                addFrame.setVisible(true);
            }
        });
        addBooks.setBounds(400, 100, 200, 75);
        panel.add(addBooks);
        removeBooks = new JButton(new AbstractAction("Remove Books") {
            public void actionPerformed(ActionEvent c) {
                removeFrame.setVisible(true);
            }
        });
        removeBooks.setBounds(700, 100, 200, 75);
        panel.setBackground(Color.DARK_GRAY);
        panel.add(removeBooks);


        String[] style = {"First Added", "Name Alphabetical", "Author Alphabetical", "Genre Alphabetical", "Count least to greatest", "Count greatest to least"};
        selectStyle = new JComboBox(style);
        selectStyle.setBounds(100, 175, 140, 25);
        panel.add(selectStyle);
        availableBooks = new JButton(new AbstractAction("Available Books") {
            public void actionPerformed(ActionEvent c) {
                if (library.size() == 0) {
                    status.setText("No books available to view");
                }
                else {
                    status.setText("");
                    String[] columnNames = new String[4];
                    columnNames[0] = "Name";
                    columnNames[1] = "Author";
                    columnNames[2] = "Genre";
                    columnNames[3] = "Count";
                    String[][] data = new String[library.size()][4];
                    if (selectStyle.getSelectedItem().equals("First Added")) {
                        for (int r = 0; r < data.length; r++) {
                            data[r][0] = library.get(r).getName();
                            data[r][1] = library.get(r).getAuthor();
                            data[r][2] = library.get(r).getGenre();
                            data[r][3] = Integer.toString(library.get(r).getCount());
                        }
                    }
                    else if (selectStyle.getSelectedItem().equals("Name Alphabetical")) {
                        ArrayList<Books> library2 = new ArrayList<Books>();
                        for (int i = 0; i < library.size(); i++) {
                            library2.add(library.get(i));
                        }
                        Collections.sort(library2, Books.bookNameComparator);
                        for (int r = 0; r < data.length; r++) {
                            data[r][0] = library2.get(r).getName();
                            data[r][1] = library2.get(r).getAuthor();
                            data[r][2] = library2.get(r).getGenre();
                            data[r][3] = Integer.toString(library2.get(r).getCount());
                        }
                    }
                    else if (selectStyle.getSelectedItem().equals("Author Alphabetical")) {
                        ArrayList<Books> library2 = new ArrayList<Books>();
                        int i = 0;
                        while (i < library.size()) {
                            library2.add(library.get(i));
                            i++;
                        }
                        Collections.sort(library2, Books.bookAuthorComparator);
                        for (int r = 0; r < data.length; r++) {
                            data[r][0] = library2.get(r).getName();
                            data[r][1] = library2.get(r).getAuthor();
                            data[r][2] = library2.get(r).getGenre();
                            data[r][3] = Integer.toString(library2.get(r).getCount());
                        }
                    }
                    else if (selectStyle.getSelectedItem().equals("Genre Alphabetical")) {
                        ArrayList<Books> library2 = new ArrayList<Books>();
                        for (int i = 0; i < library.size(); i++) {
                            library2.add(library.get(i));
                        }
                        Collections.sort(library2, Books.bookGenreComparator);
                        for (int r = 0; r < data.length; r++) {
                            data[r][0] = library2.get(r).getName();
                            data[r][1] = library2.get(r).getAuthor();
                            data[r][2] = library2.get(r).getGenre();
                            data[r][3] = Integer.toString(library2.get(r).getCount());
                        }
                    }
                    else if (selectStyle.getSelectedItem().equals("Count least to greatest")) {
                        ArrayList<Books> library2 = new ArrayList<Books>();
                        for (int i = 0; i < library.size(); i++) {
                            library2.add(library.get(i));
                        }
                        Collections.sort(library2, Books.bookGreatestLeast);
                        for (int r = 0; r < data.length; r++) {
                            data[r][0] = library2.get(r).getName();
                            data[r][1] = library2.get(r).getAuthor();
                            data[r][2] = library2.get(r).getGenre();
                            data[r][3] = Integer.toString(library2.get(r).getCount());
                        }
                    }
                    else if (selectStyle.getSelectedItem().equals("Count greatest to least")) {
                        ArrayList<Books> library2 = new ArrayList<Books>();
                        for (int i = 0; i < library.size(); i++) {
                            library2.add(library.get(i));
                        }
                        Collections.sort(library2, Books.bookLeastGreatest);
                        for (int r = 0; r < data.length; r++) {
                            data[r][0] = library2.get(r).getName();
                            data[r][1] = library2.get(r).getAuthor();
                            data[r][2] = library2.get(r).getGenre();
                            data[r][3] = Integer.toString(library2.get(r).getCount());
                        }
                    }
                    bookTable = new JTable(data, columnNames) {
                        @Override
                        public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex) {
                            JComponent component = (JComponent) super.prepareRenderer(renderer, rowIndex, columnIndex);  

                            if(getValueAt(rowIndex, 3).equals("0") || getValueAt(rowIndex, 3).equals("1") || getValueAt(rowIndex, 3).equals("2") || getValueAt(rowIndex, 3).equals("3")) {
                                component.setBackground(Color.RED);
                            }
                            else if(getValueAt(rowIndex, 3).equals("4") || getValueAt(rowIndex, 3).equals("5") || getValueAt(rowIndex, 3).equals("6")){
                                component.setBackground(Color.YELLOW);
                            }
                            else {
                                component.setBackground(Color.GREEN);
                            }

                            return component;
                        }
                    };
                    bookTable.setRowHeight(30);
                    DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
                    cellRenderer.setHorizontalAlignment(JLabel.CENTER);
                    for (int i = 0; i < columnNames.length; i++) {
                        bookTable.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
                    }
                    bookTable.setFont(new Font("Dialog", Font.PLAIN, 20));
                    JScrollPane scrollPane = new JScrollPane(bookTable);
                    JFrame availableBooksFrame = new JFrame("Books");
                    availableBooksFrame.setSize(900, 400);
                    availableBooksFrame.add(scrollPane);
                    availableBooksFrame.setLocationRelativeTo(null);
                    availableBooksFrame.setVisible(true);
                }
            }
        });
        availableBooks.setBounds(100, 100, 200, 75);
        panel.add(availableBooks);



        JFrame issueFrame = new JFrame("Issue Book");
        JPanel issuePanel = new JPanel();
        issueFrame.add(issuePanel);
        issuePanel.setLayout(null);
        issueFrame.setSize(500, 281);
        bookNameLabel3 = new JLabel("Book name:"); // Book name label and textfield
        bookNameLabel3.setBounds(80, 30, 80, 25);
        issuePanel.add(bookNameLabel3);
        bookName3 = new JTextField(10);
        bookName3.setBounds(150, 30, 150, 25);
        issuePanel.add(bookName3);
        bookAuthorLabel3 = new JLabel("Author:"); // Book author label and textfield
        bookAuthorLabel3.setBounds(100, 55, 80, 25);
        issuePanel.add(bookAuthorLabel3);
        bookAuthor3 = new JTextField(10);
        bookAuthor3.setBounds(150, 55, 150, 25);
        issuePanel.add(bookAuthor3);
        bookGenreLabel3 = new JLabel("Genre:"); // Book genre label and textfield
        bookGenreLabel3.setBounds(100, 80, 80, 25);
        issuePanel.add(bookGenreLabel3);
        bookGenre3 = new JTextField(10);
        bookGenre3.setBounds(150, 80, 150, 25);
        issuePanel.add(bookGenre3);
        bookCountLabel3 = new JLabel("Count:"); // Book count label and textfield
        bookCountLabel3.setBounds(100, 105, 80, 25);
        issuePanel.add(bookCountLabel3);
        bookCount3 = new JTextField(10);
        bookCount3.setBounds(150, 105, 150, 25);
        issuePanel.add(bookCount3);
        dateLabel3 = new JLabel("Due Date:"); // Book due date label and textfield
        dateLabel3.setBounds(90, 130, 80, 25);
        issuePanel.add(dateLabel3);
        dateExample = new JLabel("Format: MM/dd/yyyy HH:mm:ss");
        dateExample.setBounds(305, 130, 200, 25);
        issuePanel.add(dateExample);
        date3 = new JTextField(10);
        date3.setBounds(150, 130, 150, 25);
        issuePanel.add(date3);
        issueStatus = new JLabel(""); // Changes if invalid
        issueStatus.setBounds(125, 150, 300, 25);
        issuePanel.add(issueStatus);
        confirm3 = new JButton(new AbstractAction("Confirm") { // Issue confirm button
            public void actionPerformed(ActionEvent c) {
                String name = bookName3.getText();
                String author = bookAuthor3.getText();
                String genre = bookGenre3.getText();
                try {
                    SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    int count = Integer.parseInt(bookCount3.getText());
                    try {
                        Date date = parser.parse(date3.getText());
                        Books issue = new Books(name, author, genre, count, date);
                        for (int i = 0; i < library.size(); i++) {
                            Books book = library.get(i);
                            if (name.equalsIgnoreCase(book.getName()) && author.equalsIgnoreCase(book.getAuthor()) && genre.equalsIgnoreCase(book.getGenre())) {
                                if (count <= book.getCount()) {
                                    libraryIssued.add(issue);
                                    book.removeCount(count);
                                    issueFrame.dispose();
                                    bookName3.setText("");
                                    bookAuthor3.setText("");
                                    bookGenre3.setText("");
                                    bookCount3.setText("");
                                    date3.setText("");
                                    issueStatus.setText("");
                                    break;
                                }
                                else {
                                    issueStatus.setText("Not enough books available");
                                }
                            }
                            else if (i == library.size() - 1 && !(name.equalsIgnoreCase(book.getName()) && author.equalsIgnoreCase(book.getAuthor()) && genre.equalsIgnoreCase(book.getGenre()))) {
                                issueStatus.setText("Book not available");
                            }
                        }
                    } catch (ParseException e) {
                        issueStatus.setText("Invalid date");
                    }
                } catch (NumberFormatException e) {
                    issueStatus.setText("Invalid number of books");
                }
            }
        });
        confirm3.setBounds(125, 200, 80, 25);
        issuePanel.add(confirm3);
        cancel3 = new JButton(new AbstractAction("Cancel") { // Issue cancel button
            public void actionPerformed(ActionEvent c) {
                issueFrame.dispose();
                bookName3.setText("");
                bookAuthor3.setText("");
                bookGenre3.setText("");
                bookCount3.setText("");
                date3.setText("");
                issueStatus.setText("");
            }
        });
        cancel3.setBounds(225, 200, 80, 25);
        issuePanel.add(cancel3);
        addIssueBook = new JButton(new AbstractAction("Issue Books") {
            public void actionPerformed(ActionEvent c) {
                issueFrame.setVisible(true);
            }
        });
        addIssueBook.setBounds(400, 290, 200, 75);
        panel.add(addIssueBook);

        issueBookButton = new JButton(new AbstractAction("Issued Books List") {
            public void actionPerformed(ActionEvent c) {
                if (libraryIssued.size() == 0) {
                    status.setText("No issued books available to view");
                }
                else {
                    status.setText("");
                    String[] columnNames = {"Name", "Author", "Genre", "Count", "Due", "isOverDue"};
                    String[][] data = new String[libraryIssued.size()][6];
                    ArrayList<Books> libraryIssued2 = new ArrayList<Books>();
                    for (int i = 0; i < libraryIssued.size(); i++) {
                        libraryIssued2.add(libraryIssued.get(i));
                    }
                    for (int i = 0; i < libraryIssued2.size(); i++) {
                        Date current = new Date();
                        if (libraryIssued2.get(i).getDueDate().before(current)) {
                            libraryIssued.get(i).setOverDue(true);
                            libraryIssued2.get(i).setOverDue(true);
                        }
                    }
                    for (int r = 0; r < data.length; r++) {
                        data[r][0] = libraryIssued2.get(r).getName();
                        data[r][1] = libraryIssued2.get(r).getAuthor();
                        data[r][2] = libraryIssued2.get(r).getGenre();
                        data[r][3] = Integer.toString(libraryIssued2.get(r).getCount());
                        data[r][4] = String.valueOf(libraryIssued2.get(r).getDueDate());
                        data[r][5] = String.valueOf(libraryIssued2.get(r).getOverDue());
                    }
                    issueBookTable = new JTable(data, columnNames) {
                        @Override
                        public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex) {
                            JComponent component = (JComponent) super.prepareRenderer(renderer, rowIndex, columnIndex);

                            if (getValueAt(rowIndex, 5).equals("true")) {
                                component.setBackground(Color.RED);
                            }
                            else {
                                component.setBackground(Color.GREEN);
                            }
                            return component;
                        }
                    };
                    issueBookTable.setRowHeight(30);
                    DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
                    cellRenderer.setHorizontalAlignment(JLabel.CENTER);
                    for (int i = 0; i < columnNames.length; i++) {
                        issueBookTable.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
                    }
                    JScrollPane scrollPane = new JScrollPane(issueBookTable);
                    JFrame issueBookTableFrame = new JFrame("Issued Books");
                    issueBookTable.setFont(new Font("Dialog", Font.PLAIN, 20));
                    issueBookTableFrame.setSize(1300, 400);
                    issueBookTableFrame.add(scrollPane);
                    issueBookTableFrame.setLocationRelativeTo(null);
                    issueBookTableFrame.setVisible(true);
                }
            }
        });
        issueBookButton.setBounds(100, 290, 200, 75);
        panel.add(issueBookButton);

        JFrame removeIssueFrame = new JFrame("Remove Issued Books");
        JPanel removeIssuePanel = new JPanel();
        removeIssueFrame.add(removeIssuePanel);
        removeIssuePanel.setLayout(null);
        removeIssueFrame.setSize(500, 281);
        bookNameLabel4 = new JLabel("Book name:"); // Book name label and textfield
        bookNameLabel4.setBounds(80, 30, 80, 25);
        removeIssuePanel.add(bookNameLabel4);
        bookName4 = new JTextField(10);
        bookName4.setBounds(150, 30, 150, 25);
        removeIssuePanel.add(bookName4);
        bookAuthorLabel4 = new JLabel("Author:"); // Book author label and textfield
        bookAuthorLabel4.setBounds(100, 55, 80, 25);
        removeIssuePanel.add(bookAuthorLabel4);
        bookAuthor4 = new JTextField(10);
        bookAuthor4.setBounds(150, 55, 150, 25);
        removeIssuePanel.add(bookAuthor4);
        bookGenreLabel4 = new JLabel("Genre:"); // Book genre label and textfield
        bookGenreLabel4.setBounds(100, 80, 80, 25);
        removeIssuePanel.add(bookGenreLabel4);
        bookGenre4 = new JTextField(10);
        bookGenre4.setBounds(150, 80, 150, 25);
        removeIssuePanel.add(bookGenre4);
        bookCountLabel4 = new JLabel("Count:"); // Book count label and textfield
        bookCountLabel4.setBounds(100, 105, 80, 25);
        removeIssuePanel.add(bookCountLabel4);
        bookCount4 = new JTextField(10);
        bookCount4.setBounds(150, 105, 150, 25);
        removeIssuePanel.add(bookCount4);
        dateLabel4 = new JLabel("Due Date:");
        dateLabel4.setBounds(90, 130, 80, 25);
        removeIssuePanel.add(dateLabel4);
        dateExample2 = new JLabel("Format: MM/dd/yyyy HH:mm:ss");
        dateExample2.setBounds(305, 130, 200, 25);
        removeIssuePanel.add(dateExample2);
        date4 = new JTextField(10);
        date4.setBounds(150, 130, 150, 25);
        removeIssuePanel.add(date4);
        removeIssueStatus = new JLabel(""); // Changes if invalid
        removeIssueStatus.setBounds(125, 150, 150, 25);
        removeIssuePanel.add(removeIssueStatus);
        confirm4 = new JButton(new AbstractAction("Confirm") {
            public void actionPerformed(ActionEvent c) {
                String name = bookName4.getText();
                String author = bookAuthor4.getText();
                String genre = bookGenre4.getText();
                try {
                    SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    int count = Integer.parseInt(bookCount4.getText());
                    try {
                        Date date = parser.parse(date4.getText());
                        for (int i = 0; i < libraryIssued.size(); i++) {
                            Books b = libraryIssued.get(i);
                            if (name.equalsIgnoreCase(b.getName()) && author.equalsIgnoreCase(b.getAuthor()) && genre.equalsIgnoreCase(b.getGenre()) && date.equals(b.getDueDate())) {
                                if (count == b.getCount()) {
                                    for (int n = 0; n < library.size(); n++) {
                                        Books a = library.get(n);
                                        if (name.equalsIgnoreCase(a.getName()) && author.equalsIgnoreCase(a.getAuthor()) && genre.equalsIgnoreCase(a.getGenre())) {
                                            a.addCount(count);
                                            break;
                                        }
                                    }
                                    libraryIssued.remove(i);
                                    removeIssueFrame.dispose();
                                    bookName4.setText("");
                                    bookAuthor4.setText("");
                                    bookGenre4.setText("");
                                    bookCount4.setText("");
                                    date4.setText("");
                                    removeIssueStatus.setText("");
                                    break;
                                }
                                else if (count < b.getCount()) {
                                    for (int n = 0; n < library.size(); n++) {
                                        Books a = library.get(n);
                                        if (name.equalsIgnoreCase(a.getName()) && author.equalsIgnoreCase(a.getAuthor()) && genre.equalsIgnoreCase(a.getGenre())) {
                                            a.addCount(count);
                                            break;
                                        }
                                    }
                                    libraryIssued.get(i).removeCount(count);
                                    removeIssueFrame.dispose();
                                    bookName4.setText("");
                                    bookAuthor4.setText("");
                                    bookGenre4.setText("");
                                    bookCount4.setText("");
                                    date4.setText("");
                                    removeIssueStatus.setText("");
                                    break;
                                }
                                else {
                                    issueStatus.setText("Not enough books available");
                                }
                            }
                            else if (i == library.size() - 1 && !(name.equalsIgnoreCase(b.getName()) && author.equalsIgnoreCase(b.getAuthor()) && genre.equalsIgnoreCase(b.getGenre()) && date.equals(b.getDueDate()))) {
                                issueStatus.setText("Book not available");
                            }
                        }
                    }
                    catch (ParseException e) {
                        removeIssueStatus.setText("Invalid date");
                    }
                }
                catch (NumberFormatException e) {
                    removeIssueStatus.setText("Invalid number of books");
                }
            }
        });
        confirm4.setBounds(125, 200, 80, 25);
        removeIssuePanel.add(confirm4);
        cancel4 = new JButton(new AbstractAction("Cancel") {
            public void actionPerformed(ActionEvent c) {
                removeIssueFrame.dispose();
                bookName4.setText("");
                bookAuthor4.setText("");
                bookGenre4.setText("");
                bookCount4.setText("");
                date4.setText("");
                removeIssueStatus.setText("");
            }
        });
        cancel4.setBounds(225, 200, 80, 25);
        removeIssuePanel.add(cancel4);
        removeIssueBook = new JButton(new AbstractAction("Return Books") {
            public void actionPerformed(ActionEvent c) {
                removeIssueFrame.setVisible(true);
            }
        });
        removeIssueBook.setBounds(700, 290, 200, 75);
        panel.add(removeIssueBook);
        Font mainButtons = new Font("Dialog", Font.PLAIN, 20);
        availableBooks.setFont(mainButtons);
        addBooks.setFont(mainButtons);
        removeBooks.setFont(mainButtons);
        issueBookButton.setFont(mainButtons);
        addIssueBook.setFont(mainButtons);
        removeIssueBook.setFont(mainButtons);
        printBooksName(library);
        frame.setLocationRelativeTo(null);
        addFrame.setLocationRelativeTo(null);
        removeFrame.setLocationRelativeTo(null);
        issueFrame.setLocationRelativeTo(null);
        removeIssueFrame.setLocationRelativeTo(null);
        
        frame.setVisible(true);
    }
}