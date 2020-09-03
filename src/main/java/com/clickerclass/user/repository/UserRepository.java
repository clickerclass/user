package com.clickerclass.user.repository;

import com.clickerclass.user.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, String> {
    Mono<User> findUserByDocumentAndDocumentType(String document, String documentType);

    Mono<User> findUserByEmail(String email);
}
