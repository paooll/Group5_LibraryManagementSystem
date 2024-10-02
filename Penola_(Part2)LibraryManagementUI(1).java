package LibraryManagementSystem;

import javax.swing.*;
import java.awt.*;

public class LibraryManagementUI extends JFrame {
    private LibraryADT<String> library;
    private JTextField bookField;
    private JTextField indexField;
    private JTextArea outputArea;

    // Color palette for modern design
    private final Color darkBlue = new Color(0x001219);
    private final Color teal = new Color(0x005f73);
    private final Color lightTeal = new Color(0x0a9396);
    private final Color mintGreen = new Color(0x94d2bd);

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                LibraryManagementUI frame = new LibraryManagementUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public LibraryManagementUI() {
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        getContentPane().setLayout(new BorderLayout(0, 0));

        // Top panel with title
        JPanel topPanel = new JPanel();
        topPanel.setBackground(teal);
        getContentPane().add(topPanel, BorderLayout.NORTH);

        JLabel titleLabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        titleLabel.setForeground(mintGreen);
        titleLabel.setFont(new Font("Roboto", Font.BOLD, 24));
        topPanel.add(titleLabel);

        // Main content panel
        JPanel mainPanel = new JPanel();
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        GridBagLayout gbl_mainPanel = new GridBagLayout();
        gbl_mainPanel.columnWidths = new int[]{0, 0, 0};
        gbl_mainPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_mainPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        mainPanel.setLayout(gbl_mainPanel);
        mainPanel.setBackground(darkBlue);  // Set background

        // Labels and TextFields for Book and Index
        JLabel bookLabel = createModernLabel("BOOK NAME:");
        GridBagConstraints gbc_bookLabel = new GridBagConstraints();
        gbc_bookLabel.insets = new Insets(10, 10, 10, 10);
        gbc_bookLabel.anchor = GridBagConstraints.WEST;
        gbc_bookLabel.gridx = 0;
        gbc_bookLabel.gridy = 0;
        mainPanel.add(bookLabel, gbc_bookLabel);

        bookField = createModernTextField(20);
        GridBagConstraints gbc_bookField = new GridBagConstraints();
        gbc_bookField.insets = new Insets(10, 10, 10, 10);
        gbc_bookField.fill = GridBagConstraints.HORIZONTAL;
        gbc_bookField.gridx = 1;
        gbc_bookField.gridy = 0;
        mainPanel.add(bookField, gbc_bookField);

        JLabel indexLabel = createModernLabel("INDEX:");
        GridBagConstraints gbc_indexLabel = new GridBagConstraints();
        gbc_indexLabel.insets = new Insets(10, 10, 10, 10);
        gbc_indexLabel.anchor = GridBagConstraints.WEST;
        gbc_indexLabel.gridx = 0;
        gbc_indexLabel.gridy = 1;
        mainPanel.add(indexLabel, gbc_indexLabel);

        indexField = createModernTextField(5);
        GridBagConstraints gbc_indexField = new GridBagConstraints();
        gbc_indexField.insets = new Insets(10, 10, 10, 10);
        gbc_indexField.fill = GridBagConstraints.HORIZONTAL;
        gbc_indexField.gridx = 1;
        gbc_indexField.gridy = 1;
        mainPanel.add(indexField, gbc_indexField);
