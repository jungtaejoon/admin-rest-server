package com.bookcloudpub.adminrestserver.repository;

import com.bookcloudpub.adminrestserver.domain.Publisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
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

    @Test
    public void 출판사_하나_가져오기() {
        Publisher publisher = getTestPublisher();
        Publisher savedPublisher = publisherRepository.save(publisher);

        //when
        Publisher found = publisherRepository.findOne(savedPublisher.getId());

        //then
        assertNotNull(found);
        assertEquals(savedPublisher, found);
        assertEquals("3539200480", found.getCorporateNumber());
        assertNotNull(publisher.getCreatedTime());
        assertNotNull(publisher.getLastModifiedTime());
    }
}
