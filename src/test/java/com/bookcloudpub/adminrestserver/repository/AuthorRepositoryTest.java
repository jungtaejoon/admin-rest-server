package com.bookcloudpub.adminrestserver.repository;

import com.bookcloudpub.adminrestserver.domain.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    static Author getTestAuthor() {
        Author author = new Author("오키더키");
        return author;
    }

    @Test
    public void 작가_저장() {
        Author author = getTestAuthor();

        //when
        Author savedAuthor = authorRepository.save(author);

        //then
        assertNotNull(savedAuthor);
        assertNotNull(savedAuthor.getId());
        assertEquals(author.getPenName(), savedAuthor.getPenName());
    }

}
