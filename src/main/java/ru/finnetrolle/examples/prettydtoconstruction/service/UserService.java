package ru.finnetrolle.examples.prettydtoconstruction.service;

import org.springframework.stereotype.Service;

import ru.finnetrolle.examples.prettydtoconstruction.entity.User;

import java.util.ArrayList;
import java.util.List;

import static ru.finnetrolle.examples.prettydtoconstruction.entity.Role.GUEST;
import static ru.finnetrolle.examples.prettydtoconstruction.entity.Role.MODERATOR;
import static ru.finnetrolle.examples.prettydtoconstruction.entity.Role.USER;
import static ru.finnetrolle.examples.prettydtoconstruction.entity.Role.ADMIN;

/**
 * Created by finnetrolle on 22.11.2015.
 */
@Service
public class UserService {

    private static final List<User> users;
    static {
        users = new ArrayList<>();
        users.add(new User(1L, "ivan001", "Ivan Reitman", "1230F03AE4", GUEST));
        users.add(new User(1L, "petr",    "Petr Sukhov",  "6720903D4E", USER));
        users.add(new User(1L, "god",     "Nikita M.",    "DDA78EB224", MODERATOR));
        users.add(new User(1L, "owner",   "Vladimir P.",  "AEF23BB123", ADMIN));
    }

    public List<User> getUsers() {
        return users;
    }

}
