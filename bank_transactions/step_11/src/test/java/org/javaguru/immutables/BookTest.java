package org.javaguru.immutables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void shouldCreateBook() {
        Book book = ImmutableBook.of(
                "Vasja Pupkin",
                "How to build Java program?");
        assertNotNull(book);
        assertEquals(book.authorFullName(), "Vasja Pupkin");
        assertEquals(book.title(), "How to build Java program?");
    }

    @Test
    public void shouldBuildTransactionWithBuilder() {
        Book book = ImmutableBook.builder()
                .authorFullName("Vasja Pupkin")
                .title("How to build Java program?")
                .build();
        assertNotNull(book);
        assertEquals(book.authorFullName(), "Vasja Pupkin");
        assertEquals(book.title(), "How to build Java program?");
    }

}