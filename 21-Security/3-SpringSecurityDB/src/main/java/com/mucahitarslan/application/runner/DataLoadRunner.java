package com.mucahitarslan.application.runner;

import com.mucahitarslan.application.data.entity.Role;
import com.mucahitarslan.application.data.entity.User;
import com.mucahitarslan.application.data.repository.IRoleRepository;
import com.mucahitarslan.application.data.repository.IUserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoadRunner implements ApplicationRunner {

    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;

    public DataLoadRunner(IUserRepository userRepository, IRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Role roleAdmin = Role.builder().id(1L).role_name("ROLE_ADMIN").build();
        Role roleUser = Role.builder().id(2L).role_name("ROLE_USER").build();

        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        List<Role> adminRoleList = new ArrayList<>();
        adminRoleList.add(roleAdmin);

        List<Role> userRoleList = new ArrayList<>();
        userRoleList.add(roleUser);

        User admin = User.builder().id(3L).name("Ali").password("1234").roles(adminRoleList).build();
        userRepository.save(admin);

        User user = User.builder().id(4L).name("Veli").password("1234").roles(userRoleList).build();
        userRepository.save(user);

        System.out.println("---Roles---");
        roleRepository.findAll().forEach(System.out::println);

        System.out.println("---Users---");
        userRepository.findAll().forEach(System.out::println);
    }
}
