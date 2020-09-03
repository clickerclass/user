package com.clickerclass.user.handler;

import com.clickerclass.user.model.UserModel;
import com.clickerclass.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Optional;

@Component
public class UserHandler {

    private UserService userService;
    private Validator validator;

    public UserHandler(@Autowired UserService userService, @Autowired Validator validator) {
        this.userService = userService;
        this.validator = validator;
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        Optional<String> id = request.queryParam("id");
        if (!id.isPresent()) {
            return ServerResponse.badRequest().build();
        }
        return userService.findById(id.get())
                .flatMap(user -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(user)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findByEmail(ServerRequest request) {
        Optional<String> email = request.queryParam("email");
        if (!email.isPresent()) {
            return ServerResponse.badRequest().build();
        }
        return userService.findUserByEmail(email.get())
                .flatMap(user -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(user)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findByEmailWithPassword(ServerRequest request) {
        Optional<String> email = request.queryParam("email");
        if (!email.isPresent()) {
            return ServerResponse.badRequest().build();
        }
        return userService.findUserByEmailWithPassword(email.get())
                .flatMap(user -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(user)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<UserModel> userModel = request.bodyToMono(UserModel.class);
        return userModel.flatMap(user -> {
            Errors errors = new BeanPropertyBindingResult(user, UserModel.class.getName());
            validator.validate(user, errors);
            if (errors.hasErrors()) {
                return ServerResponse.badRequest()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(errors.getFieldErrors()));
            }
            return userService.save(user).
                    flatMap(u -> ServerResponse
                            .created(URI.create("/api/user/findById?id=".concat(u.getId())))
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromValue(u)))
                    .onErrorResume(DuplicateKeyException.class,
                            e -> ServerResponse.status(HttpStatus.CONFLICT)
                                    .body(BodyInserters.fromValue(e.getMessage())));
        });
    }
}
