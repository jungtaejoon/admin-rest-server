package com.bookcloudpub.adminrestserver.repository;

import com.bookcloudpub.adminrestserver.domain.Publisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PublisherRepositoryTest {

    @Autowired
    private PublisherRepository publisherRepository;

    private Publisher getTestPublisher() {
        Publisher publisher = new Publisher();
        publisher.setCorporateNumber("3539200480");
        publisher.setAddress("광주광역시 광산구 첨단중앙로181번길 42-14, 102동 803호(월계동, 첨단일신아파트)");
        publisher.setPresidentName("정태준");
        publisher.setEmail("jungtaejoon@naver.com");
        publisher.setName("책구름");
        publisher.setWorkStyle("출판업");
        publisher.setWorkType("서적 및 전자서적출판");
        return publisher;
    }

    @Test
    public void 출판사_등록() {
        Publisher publisher = getTestPublisher();

        //when
        Publisher savedPublisher = publisherRepository.save(publisher);

        //then
        assertNotNull(publisher.getId());
        assertNotNull(publisher.getCreatedTime());
        assertNotNull(publisher.getLastModifiedTime());
        assertEquals(publisher, savedPublisher);
    }
}
