import java.util.ArrayList;
import java.util.List;

public class Univers {
    public class University {
        public static class Book {
            private String title;
            private String author;
            private int year;

            public Book(String title, String author, int year) {
                this.author = author;
                this.title = title;
                this.year = year;
            }

            public void printFullInfo() {
                System.out.println("Книга: " + title + " Автор: " + author + " Год выпуска: " + year);
            }
        }

        public static class LibraryClass {
            private List<Book> collection;

            public LibraryClass() {
                this.collection = new ArrayList<>();
            }

            public void addBook(Book book) {
                collection.add(book);
            }

            public void searchAuthor(String author) {
                for (Book book : collection) {
                    if (book.author.equals(author)) {
                        book.printFullInfo();
                    }
                }
            }

            public void searchYear(int year) {
                for (Book book : collection) {
                    if (book.year == year) {
                        book.printFullInfo();
                    }
                }
            }

            public void printAllBooks() {
                for (Book book : collection) {
                    book.printFullInfo();
                }
            }
        }

        public static void main(String[] args) {
            Book first = new Book("1984", "Джордж Оруэлл", 1956);
            Book second = new Book("О дивный новый мир", "Олдос Хаксли", 1949);
            Book third = new Book("Мы", "Замятин", 1931);
            LibraryClass moscow = new LibraryClass();
            moscow.addBook(first);
            moscow.addBook(second);
            moscow.addBook(third);
            moscow.printAllBooks();
            moscow.searchAuthor("Олдос Хаксли");
        }
}
