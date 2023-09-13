package org.javaguru.mentor.lesson_7.homework.day_3.solutions;

import java.util.ArrayList;
import java.util.List;

class BookLibrary {

    private List<Book> books = new ArrayList();

    public void addBook(Book book) {
        books.add(book);
    }

    public int getBookCount() {
        return books.size();
    }

    public List<Book> findBooksByTitle(String bookTitleToSearch) {
        List<Book> foundBooks = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            String title = book.getTitle();
            if (title.equals(bookTitleToSearch)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public List<Book> findBooksByAuthor(String bookAuthorToSearch) {
        List<Book> foundBooks = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            String author = book.getAuthor();
            if (author.equals(bookAuthorToSearch)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public int countPagesByAuthor(String bookAuthorToSearch) {
        int pageCountByAuthor = 0;
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            String author = book.getAuthor();
            if (author.equals(bookAuthorToSearch)) {
                pageCountByAuthor += book.getPageCount();
            }
        }
        return pageCountByAuthor;
    }

}
