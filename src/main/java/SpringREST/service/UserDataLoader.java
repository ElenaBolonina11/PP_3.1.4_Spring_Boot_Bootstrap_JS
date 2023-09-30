package SpringREST.service;

import SpringREST.model.Role;
import SpringREST.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class UserDataLoader {

    private final RoleService roleService;
    private final UserService userService;

    public UserDataLoader(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void loadDataUser() {
        Set<Role> allRoles = new HashSet<>();
        allRoles.add(new Role("ROLE_ADMIN"));
        allRoles.add(new Role("ROLE_USER"));
        roleService.addRole(allRoles);

        User user = new User("Alex", "Kalinin", (byte) 23, "alex@mail.ru", "alex");
        user.setRoles("ROLE_ADMIN, ROLE_USER");
        userService.addUser(user);

        User user2 = new User("Kim", "ChenIn", (byte) 45, "kim5@chen.com", "kim");
        user2.setRoles("ROLE_USER");
        userService.addUser(user2);

        User user3 = new User("Zaur", "Tregulov", (byte) 33, "tregulov@ya.ru", "zaur");
        user3.setRoles("ROLE_USER");
        userService.addUser(user3);

        User user4 = new User("Billy", "Herrington", (byte) 48, "fingerinmy@ss.cum", "gachi");
        user4.setRoles("ROLE_ADMIN");
        userService.addUser(user4);

        User user5 = new User("MichalPalych", "Terentyev", (byte) 88, "howthere@with.money", "capital");
        user5.setRoles("ROLE_ADMIN");
        userService.addUser(user5);
    }
}
