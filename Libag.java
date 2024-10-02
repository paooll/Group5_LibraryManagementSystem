package LibraryManagementSystem;

import java.util.Scanner;

public class LibrarySystem {
    private LibraryADT<String> library;

    public LibrarySystem() {
        library = new LibraryADT<>(String.class); // Just make sure to pass String.class here
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Insert Book at Index");
            System.out.println("3. Remove Book");
            System.out.println("4. Get Book by Index");
            System.out.println("5. Display Total Number of Books");
            System.out.println("6. Check if Library is Empty");
            System.out.println("7. Sort Books");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter book name: ");
                    String book = scanner.nextLine();
                    library.add(book);
                    System.out.println("Book added.");
                }
                case 2 -> {
                    System.out.print("Enter index: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter book name: ");
                    String book = scanner.nextLine();
                    try {
                        library.insert(index, book);
                        System.out.println("Book inserted.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid index.");
                    }
                }
