case 4 -> {
                    System.out.print("Enter index of book: ");
                    int index = scanner.nextInt();
                    try {
                        String book = library.get(index);
                        System.out.println("Book at index " + index + ": " + book);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid index.");
                    }
                }
                case 5 -> {
                    int totalBooks = library.size();
                    System.out.println("Total number of books: " + totalBooks);
                    if (totalBooks > 0) {
                        System.out.println("Books in the library:");
                        for (int i = 0; i < totalBooks; i++) {
                            System.out.println((i + 1) + ". " + library.get(i));
                        }
                    } else {
                        System.out.println("No books in the library.");
                    }
                }
                case 6 -> System.out.println("Library is empty: " + library.isEmpty());
                case 7 -> {
                    library.sort();
                    System.out.println("Books sorted.");
                }
                case 8 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Exiting Library Management System.");
    }

    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();
        system.run();
    }
}
