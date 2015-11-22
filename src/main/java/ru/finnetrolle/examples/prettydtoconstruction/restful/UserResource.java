package ru.finnetrolle.examples.prettydtoconstruction.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import ru.finnetrolle.examples.prettydtoconstruction.dto.UserDto;
import ru.finnetrolle.examples.prettydtoconstruction.entity.User;
import ru.finnetrolle.examples.prettydtoconstruction.service.AccessService;
import ru.finnetrolle.examples.prettydtoconstruction.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static ru.finnetrolle.examples.prettydtoconstruction.service.Transformers.createUserDtoWithAccessRights;
import static ru.finnetrolle.examples.prettydtoconstruction.service.Transformers.createUserDtoWithoutAccessRights;
import static ru.finnetrolle.examples.prettydtoconstruction.service.Transformers.onlyNames;

/**
 * Created by finnetrolle on 22.11.2015.
 */
@Controller
@RequestMapping("user")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private AccessService accessService;

    @RequestMapping(method = GET)
    public @ResponseBody
    List<UserDto> getAllUsers() {
        List<UserDto> result = new ArrayList<>();
        for (User user : userService.getUsers()) {
            result.add(new UserDto(
                    user.getId(),
                    user.getLogin(),
                    user.getName(),
                    accessService.getAccessRights(user.getRole())));
        }
        return result;
    }

    @RequestMapping(name = "meth", method = GET)
    public @ResponseBody
    List<UserDto> getAllUsersMeth() {
        List<UserDto> result = new ArrayList<>();
        for (User user : userService.getUsers()) {
            result.add(createDto(user));
        }
        return result;
    }

    private UserDto createDto(User user) {
        return new UserDto(user.getId(),user.getLogin(),user.getName(),accessService.getAccessRights(user.getRole()));
    }

    @RequestMapping(name = "stream", method = GET)
    public @ResponseBody
    List<UserDto> getAllUsersStream() {
        return userService.getUsers().stream()
                .map(user -> createDto(user))
                .collect(toList());
    }

    @RequestMapping(value = "/func", method = GET)
    public @ResponseBody
    List<UserDto> getAllUsersFunc() {
        return userService.getUsers().stream()
                .map(user -> createUserDtoWithAccessRights.apply(user, accessService))
                .collect(toList());
    }

    @RequestMapping(value = "/names", method = GET)
    public @ResponseBody
    List<String> getAllUsersFuncMin() {
        return userService.getUsers().stream()
                .map(createUserDtoWithoutAccessRights.andThen(onlyNames))
                .collect(toList());
    }



}
