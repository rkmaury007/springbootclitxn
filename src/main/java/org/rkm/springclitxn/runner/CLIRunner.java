package org.rkm.springclitxn.runner;

import org.rkm.springclitxn.entity.User;
import org.rkm.springclitxn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CLIRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        try {
            User user = new User(100, "rkmau");
            User user1 = new User(101, "ajayaaaaaaaa");
            userService.addUsers(Arrays.asList(user, user1));
        } catch (RuntimeException r) {
            System.out.println("Excp in batch 1 "+r.getMessage());
        }
        try {
            User user2 = new User(102, "vinay");
            userService.addUsers(Arrays.asList(user2));
        } catch (RuntimeException r) {
            System.out.println("Excp in batch 1 "+r.getMessage());
        }
        System.out.println(userService.getUsers());
    }
}
