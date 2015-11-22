package ru.finnetrolle.examples.prettydtoconstruction.service;

import org.springframework.stereotype.Service;
import ru.finnetrolle.examples.prettydtoconstruction.entity.Role;

import java.util.*;

import static ru.finnetrolle.examples.prettydtoconstruction.entity.Role.*;

/**
 * Created by finnetrolle on 22.11.2015.
 */
@Service
public class AccessService {

    private static final Map<Role, Set<String>> accessRightsMap;
    static
    {
        accessRightsMap = new HashMap<>();
        accessRightsMap.put(GUEST, new HashSet<>(Arrays.asList("read")));
        accessRightsMap.put(USER, new HashSet<>(Arrays.asList("read", "create")));
        accessRightsMap.put(MODERATOR, new HashSet<>(Arrays.asList("read", "create", "update")));
        accessRightsMap.put(ADMIN, new HashSet<>(Arrays.asList("read", "create", "update", "delete")));
    }

    public Set<String> getAccessRights(Role role) {
        return accessRightsMap.get(role);
    }

}
