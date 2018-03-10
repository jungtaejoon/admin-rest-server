package com.bookcloudpub.adminrestserver.repository;

import com.bookcloudpub.adminrestserver.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    private final String TEST_BOOK_TITLE = "Java의 정석";

    Book getTestBook() {
        Book book = new Book();
        book.setIsbn("9788994492032");
        book.setTitle(TEST_BOOK_TITLE);
        book.setAuthors(Arrays.asList(authorRepository.save(AuthorRepositoryTest.getTestAuthor())));
        return book;
    }

    @Test
    public void 책_등록() {
        Book book = getTestBook();

        //when
        Book savedBook = bookRepository.save(book);

        //then
        assertNotNull(savedBook);
        assertNotNull(savedBook.getId());
        assertEquals(book.getIsbn(), savedBook.getIsbn());
        assertEquals(TEST_BOOK_TITLE, savedBook.getTitle());
    }
}
