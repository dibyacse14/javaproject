package com.devglan.executor;

import com.devglan.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = Application.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void createUserWithDefaultExecutorTest(){
        System.out.println("Current Thread in test class " + Thread.currentThread().getName());
        userService.createUserWithDefaultExecutor();
    }

    @Test
    public void createAndReturnUserTest() throws ExecutionException, InterruptedException {
        System.out.println("Current Thread in test class " + Thread.currentThread().getName());
        long startTime = System.currentTimeMillis();
        Future<User> futureUser = userService.createAndReturnUser();
        futureUser.get();
        assertTrue((System.currentTimeMillis() - startTime) >= 5000);
    }

    @Test
    public void createUserWithThreadPoolExecutorTest(){
        System.out.println("Current Thread in test class " + Thread.currentThread().getName());
        userService.createUserWithThreadPoolExecutor();
    }

    @Test
    public void createUserWithConcurrentExecutorTest(){
        System.out.println("Current Thread in test class " + Thread.currentThread().getName());
        userService.createUserWithConcurrentExecutor();
    }
}
