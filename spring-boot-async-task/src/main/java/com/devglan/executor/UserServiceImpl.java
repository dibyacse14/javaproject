package com.devglan.executor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class UserServiceImpl implements UserService {

    @Override
    @Async
    public void createUserWithDefaultExecutor(){
        //SimpleAsyncTaskExecutor
        System.out.println("Currently Executing thread name - " + Thread.currentThread().getName());
        System.out.println("User created with default executor");
    }

    @Override
    @Async
    public Future<User> createAndReturnUser() {
        System.out.println("Currently Executing thread name - " + Thread.currentThread().getName());
        try {
            User user = new User();
            user.setFirstName("John");
            user.setLastName("Doe");
            user.setGender("Male");
            Thread.sleep(5000);
            return new AsyncResult<User>(user);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    @Async("threadPoolExecutor")
    public void createUserWithThreadPoolExecutor(){
        System.out.println("Currently Executing thread name - " + Thread.currentThread().getName());
        System.out.println("User created with thread pool executor");
    }

    @Override
    @Async("ConcurrentTaskExecutor")
    public void createUserWithConcurrentExecutor(){
        System.out.println("Currently Executing thread name - " + Thread.currentThread().getName());
        System.out.println("User created with concurrent task executor");
    }




}
