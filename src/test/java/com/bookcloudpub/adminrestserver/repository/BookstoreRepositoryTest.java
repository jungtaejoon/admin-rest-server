package com.bookcloudpub.adminrestserver.repository;

import com.bookcloudpub.adminrestserver.domain.Bookstore;
import com.bookcloudpub.adminrestserver.domain.enumSet.PaymentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class BookstoreRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BookstoreRepository bookstoreRepository;

    @Test
    public void 서점_데이터_전체_불러오기() {
        Bookstore bookstore = new Bookstore();
        bookstore.setName("교보문고");
        bookstore.setAddress("서울특별시 종로구 종로 1 (종로1가,교보빌딩)");
        bookstore.setEmail("11670@kyobobook.co.kr");
        bookstore.setPresidentName("허정도");
        bookstore.setPaymentType(PaymentType.CHARGE);
        bookstore.setSalesRate(0.65f);
        bookstore.setCreateTime(new Timestamp(System.currentTimeMillis()));
        testEntityManager.persist(bookstore);
        testEntityManager.flush();

        Bookstore bookstore1 = new Bookstore();
        bookstore.setName("（주）인터파크");
        bookstore.setAddress("서울특별시 강남구 삼성로 512");
        bookstore.setEmail("yuya00@interparklogis.com");
        bookstore.setPresidentName("이상규");
        bookstore.setPaymentType(PaymentType.CHARGE);
        bookstore.setSalesRate(0.6f);
        bookstore.setCreateTime(new Timestamp(System.currentTimeMillis()));
        testEntityManager.persist(bookstore1);
        testEntityManager.flush();

        //when
        List<Bookstore> list = bookstoreRepository.findAll();

        //then
        assertEquals(2, list.size());
        assertEquals(list.get(0), bookstore);
        assertEquals(list.get(1), bookstore1);
    }



}