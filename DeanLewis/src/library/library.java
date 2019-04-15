package library;


import java.util.*;


public class library {

    Scanner myScanner = new Scanner(System.in);

    List<book> books = new ArrayList<book>();
    member[] members = new member[5];
    loan[] loans = new loan[2];


    public static void main(String[] args) {
        library lib = new library();
        lib.init();
    }

    public void init() {
        books.add(new book(1, "In Search of Lost Time", "Marcel Proust", "1913"));
        books.add(new book(2, "Ulysses", "James Joyce", "1922"));
        books.add(new book(3, "Moby Dick", "Herman Melville", "1851"));
        books.add(new book(4, "Pride and Prejudice", "Jane Austen", "1813"));
        books.add(new book(5, "The Canterbury Tales", "Geoffrey Chaucer", "1387"));

        members[0] = new member(1, "Dean", "Lewis", (byte) 30);
        members[1] = new member(2, "Steve", "Beckwith", (byte) 55);
        members[2] = new member(3, "Lisa", "Crow", (byte) 39);
        members[3] = new member(4, "Vicky", "Cross", (byte) 37);
        members[4] = new member(5, "Rachel", "Alsop", (byte) 25);

        loans[0] = new loan(2, 4);
        loans[1] = new loan(5, 2);

//        for (book a : books) {
//            System.out.println(a.bookTitle);
//        }
//
//        System.out.println("\n");
//        Collections.sort(books);
//
//        for (book b : books) {
//            System.out.println(b.bookTitle);
//        }

        Collections.sort(books, book.bookAuthorComparator);

        for(book b : books){
            System.out.println(b.bookAuthor);
        }


    }

    private void menu() {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Welcome to Dean's library");
        System.out.println("Select an option from the list below:");
        System.out.println("1 - Search for a book");
        System.out.println("2 - Check if a book is available");
        System.out.println("3 - Search for an Author");
        int choice = Integer.parseInt(myScanner.nextLine());
/*
        switch (choice) {
            case 1:
                searchBook();
                break;

            case 2:
                checkBook();
                break;

            case 3:
                searchAuthor();
                break;

            default:
                System.out.println("Invalid input provided, please try again");
                menu();
        }
    }

    private void searchAuthor() {
        System.out.println("Which author would you like to search for?");
        String author = myScanner.nextLine();
        int count = 0;

        for (int i = 0; i < books.length; i++) {
            if (books[i].bookAuthor.equalsIgnoreCase(author) && i + 1 < books.length) {
                System.out.println(books[i].bookTitle + "(" + books[i].bookYear + ")");
                count++;
            } else if (books[i].bookAuthor.equalsIgnoreCase(author)) {
                System.out.println(books[i].bookTitle + "(" + books[i].bookYear + ")");
                menu();
            } else if (i == books.length - 1 && count == 0) {
                System.out.println("Sorry, we do not currently stock any books by that author");
                menu();
            } else {
                menu();
            }
        }


    }

    private void checkBook() {
        System.out.println("What is the name of the book you would like to check the availability of?");
        String title = myScanner.nextLine();

        for (int i = 0; i < books.length; i++) {
            if (books[i].bookTitle.equalsIgnoreCase(title)) {
                int bookID = books[i].bookID;
                for (int j = 0; j < loans.length; j++) {
                    if (loans[j].bookID == bookID) {
                        System.out.println("Sorry the book is currently unavailable");
                        System.out.println();
                        menu();
                    } else if (j == loans.length - 1) {
                        System.out.println("That book is available");
                        System.out.println();
                        menu();
                    }
                }
            } else if (i == books.length - 1) {
                System.out.println("Sorry, we do not currently stock that book");
                System.out.println();
                menu();
            }
        }
    }

    private void searchBook() {
        System.out.println("What is the name of the book you would like to search for?");
        String title = myScanner.nextLine();

        for (int i = 0; i < books.length; i++) {
            if (books[i].bookTitle.equalsIgnoreCase(title)) {
                System.out.println("We have that book in the library");
                System.out.println();
                menu();
            } else if (i == books.length - 1) {
                System.out.println("Sorry, we do not currently stock that book");
                System.out.println();
                menu();
            }
        }
        */
    }
}
