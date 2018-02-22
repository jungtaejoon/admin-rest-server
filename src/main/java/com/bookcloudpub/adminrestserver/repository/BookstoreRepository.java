package com.bookcloudpub.adminrestserver.repository;

import com.bookcloudpub.adminrestserver.domain.Bookstore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookstoreRepository extends JpaRepository<Bookstore, Long> {
}
