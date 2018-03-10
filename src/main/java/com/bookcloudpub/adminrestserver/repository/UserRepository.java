package com.bookcloudpub.adminrestserver.repository;

import com.bookcloudpub.adminrestserver.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, String> {
}
