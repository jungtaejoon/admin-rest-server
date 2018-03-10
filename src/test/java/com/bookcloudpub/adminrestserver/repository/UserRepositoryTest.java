package com.bookcloudpub.adminrestserver.repository;

import com.bookcloudpub.adminrestserver.domain.Author;
import com.bookcloudpub.adminrestserver.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    private User getTestUser() {
        User user = new User();
        user.setEmail("jungtaejoon@naver.com");
        user.setName("정태준");
        user.setPassword("pass");
        return user;
    }

    @Test
    public void 유저_저장() {
        User user = getTestUser();

        //when
        User savedUser = userRepository.save(user);

        //then
        assertEquals(user, savedUser);
        assertNotNull(savedUser.getEmail());
    }

    @Test
    public void 유저_저장_위드_필명() {
        User user = getTestUser();
        User savedUser = userRepository.save(user);
        Author author = authorRepository.save(new Author("오키더키"));

        //when
        author.setBookcloudpubAccount(savedUser);

        //then
        assertEquals(user, savedUser);
        assertNotNull(savedUser.getEmail());
        assertEquals(author, savedUser.getAuthorData());
    }

    @Test
    public void 유저리스트_가져오기() {
        User user = getTestUser();
        User savedUser = userRepository.save(user);
        Author author = authorRepository.save(new Author("오키더키"));
        author.setBookcloudpubAccount(savedUser);

        User user1 = getTestUser();
        user1.setEmail("jungtaejoon@daum.net");
        userRepository.save(user1);

        //when
        List<User> list = userRepository.findAll();

        //then
        assertEquals(2, list.size());
        assertTrue(list.contains(user));
        assertTrue(list.contains(user1));
    }

    @Test
    public void 아이디로_가져오기() {
        User user = getTestUser();
        User savedUser = userRepository.save(user);
        Author author = authorRepository.save(new Author("오키더키"));
        author.setBookcloudpubAccount(savedUser);

        //when
        User testUser = userRepository.findOne(savedUser.getEmail());

        //then
        assertEquals(savedUser, testUser);
        assertEquals(savedUser.getAuthorData(), author);
    }

    @Test
    public void 이메일로_가져오기() {
        User user = getTestUser();
        userRepository.save(user);

        //when
        User found = userRepository.findOne(user.getEmail());

        //then
        assertEquals(user, found);
    }

    @Test
    public void 패스워드_암호화_후_저장() {
        User user = getTestUser();

        //temp
        String encPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encPassword);
        userRepository.save(user);

        //when
        User savedUser = userRepository.findOne(user.getEmail());

        //then
        assertEquals(encPassword, savedUser.getPassword());
    }
}