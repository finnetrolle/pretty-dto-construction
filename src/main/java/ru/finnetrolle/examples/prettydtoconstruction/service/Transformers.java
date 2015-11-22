package ru.finnetrolle.examples.prettydtoconstruction.service;

import ru.finnetrolle.examples.prettydtoconstruction.dto.UserDto;
import ru.finnetrolle.examples.prettydtoconstruction.entity.User;

import java.util.Formatter;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by finnetrolle on 22.11.2015.
 */
public class Transformers {

    public static Function<User, UserDto> createUserDtoWithoutAccessRights = user ->
            new UserDto(user.getId(), user.getLogin(), user.getName(), null);

    public static BiFunction<User, AccessService, UserDto> createUserDtoWithAccessRights = (user, service) ->
            new UserDto(user.getId(), user.getLogin(), user.getName(), service.getAccessRights(user.getRole()));

    public static Function<UserDto, String> onlyNames = user ->
            new Formatter().format("user: %s {%s}", user.getLogin(), user.getName()).toString();

}
