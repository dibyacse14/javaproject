package com.devglan.executor;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.Future;

public interface UserService {

    void createUserWithDefaultExecutor();

    Future<User> createAndReturnUser();

    void createUserWithThreadPoolExecutor();

    void createUserWithConcurrentExecutor();
}
