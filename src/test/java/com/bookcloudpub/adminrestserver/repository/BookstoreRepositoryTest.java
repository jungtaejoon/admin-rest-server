package com.bookcloudpub.adminrestserver.repository;

import com.bookcloudpub.adminrestserver.domain.Bookstore;
import com.bookcloudpub.adminrestserver.domain.enumSet.PaymentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BookstoreRepositoryTest {

    @Autowired
    private BookstoreRepository bookstoreRepository;

    private Bookstore getTestBookstore() {
        Bookstore bookstore = new Bookstore();
        bookstore.setName("교보문고");
        bookstore.setAddress("서울특별시 종로구 종로 1 (종로1가,교보빌딩)");
        bookstore.setEmail("11670@kyobobook.co.kr");
        bookstore.setPresidentName("허정도");
        bookstore.setPaymentType(PaymentType.CHARGE);
        bookstore.setSalesRate(0.65f);
        bookstore.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        return bookstore;
    }

    @Test
    public void 서점_데이터_전체_불러오기() {
        Bookstore bookstore = getTestBookstore();
        bookstoreRepository.save(bookstore);

        Bookstore bookstore1 = new Bookstore();
        bookstore1.setName("（주）인터파크");
        bookstore1.setAddress("서울특별시 강남구 삼성로 512");
        bookstore1.setEmail("yuya00@interparklogis.com");
        bookstore1.setPresidentName("이상규");
        bookstore1.setPaymentType(PaymentType.CHARGE);
        bookstore1.setSalesRate(0.6f);
        bookstore1.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        bookstoreRepository.save(bookstore1);

        //when
        List<Bookstore> list = bookstoreRepository.findAll();

        //then
        assertEquals(2, list.size());
        assertEquals(list.get(0), bookstore);
        assertEquals(list.get(1), bookstore1);
    }

}