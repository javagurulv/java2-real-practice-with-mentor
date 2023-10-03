package org.javaguru.mentor.lesson_13.homework.level_1_junior.solutions;

import java.util.List;

class BookLibraryTest {

    public static void main(String[] args) {
        BookLibraryTest test = new BookLibraryTest();
        test.shouldReturnZeroWhenLibraryIsEmpty();
        test.shouldReturnBookCountWhenLibraryIsNotEmpty();
        test.shouldFoundZeroBooksByTitle();
        test.shouldFoundOneBookByTitle();
        test.shouldFoundBooksByTitle();
        test.shouldFoundZeroBooksByAuthor();
        test.shouldFoundOneBookByAuthor();
        test.shouldFoundBooksByAuthor();
        test.shouldReturnZeroPagesWhenBooksNotFoundByAuthor();
        test.shouldCountPagesByAuthor();
    }

    public void shouldReturnZeroWhenLibraryIsEmpty() {
        BookLibrary bookLibrary = new BookLibrary();
        int bookCount = bookLibrary.getBookCount();
        checkResult(bookCount, 0, "shouldReturnZeroWhenLibraryIsEmpty");
    }

    public void shouldReturnBookCountWhenLibraryIsNotEmpty() {
        BookLibrary bookLibrary = new BookLibrary();
        Book book = new Book("War and peace", "Dostoevsky", 1820);
        bookLibrary.addBook(book);
        int bookCount = bookLibrary.getBookCount();
        checkResult(bookCount, 1, "shouldReturnBookCountWhenLibraryIsNotEmpty");
    }

    public void shouldFoundZeroBooksByTitle() {
        BookLibrary bookLibrary = new BookLibrary();
        List<Book> foundBooks = bookLibrary.findBooksByTitle("War");
        checkResult(foundBooks.size(), 0, "shouldFoundZeroBooksByTitle");
    }

    public void shouldFoundOneBookByTitle() {
        BookLibrary bookLibrary = new BookLibrary();
        Book book = new Book("War and peace", "Dostoevsky", 1820);
        bookLibrary.addBook(book);
        List<Book> foundBooks = bookLibrary.findBooksByTitle("War and peace");
        checkResult(foundBooks.size(), 1, "shouldFoundOneBookByTitle");
    }

    public void shouldFoundBooksByTitle() {
        BookLibrary bookLibrary = new BookLibrary();
        Book book1 = new Book("War and peace", "Dostoevsky", 1820);
        bookLibrary.addBook(book1);
        Book book2 = new Book("War and peace", "Dostoevsky", 1820);
        bookLibrary.addBook(book2);
        List<Book> foundBooks = bookLibrary.findBooksByTitle("War and peace");
        checkResult(foundBooks.size(), 2, "shouldFoundBooksByTitle");
    }

    public void shouldFoundZeroBooksByAuthor() {
        BookLibrary bookLibrary = new BookLibrary();
        List<Book> foundBooks = bookLibrary.findBooksByAuthor("Dostoevsky");
        checkResult(foundBooks.size(), 0, "shouldFoundZeroBooksByAuthor");
    }

    public void shouldFoundOneBookByAuthor() {
        BookLibrary bookLibrary = new BookLibrary();
        Book book = new Book("War and peace", "Dostoevsky", 1820);
        bookLibrary.addBook(book);
        List<Book> foundBooks = bookLibrary.findBooksByAuthor("Dostoevsky");
        checkResult(foundBooks.size(), 1, "shouldFoundOneBookByAuthor");
    }

    public void shouldFoundBooksByAuthor() {
        BookLibrary bookLibrary = new BookLibrary();
        Book book1 = new Book("War and peace", "Dostoevsky", 1820);
        bookLibrary.addBook(book1);
        Book book2 = new Book("War and peace", "Dostoevsky", 1820);
        bookLibrary.addBook(book2);
        List<Book> foundBooks = bookLibrary.findBooksByAuthor("Dostoevsky");
        checkResult(foundBooks.size(), 2, "shouldFoundBooksByAuthor");
    }

    public void shouldReturnZeroPagesWhenBooksNotFoundByAuthor() {
        BookLibrary bookLibrary = new BookLibrary();
        int pageCount = bookLibrary.countPagesByAuthor("Dostoevsky");
        checkResult(pageCount, 0, "shouldReturnZeroPagesWhenBooksNotFoundByAuthor");
    }

    public void shouldCountPagesByAuthor() {
        BookLibrary bookLibrary = new BookLibrary();
        Book book1 = new Book("War and peace", "Dostoevsky", 1000);
        bookLibrary.addBook(book1);
        Book book2 = new Book("War and peace", "Dostoevsky", 1000);
        bookLibrary.addBook(book2);
        int pageCount = bookLibrary.countPagesByAuthor("Dostoevsky");
        checkResult(pageCount, 2000, "shouldCountPagesByAuthor");
    }


    private void checkResult(int realResult,
                             int expectedResult,
                             String testScenarioName) {
        if (realResult == expectedResult) {
            System.out.println(testScenarioName + ": TEST OK!");
        } else {
            System.out.println(testScenarioName + ": TEST FAIL!");
        }
    }

}
