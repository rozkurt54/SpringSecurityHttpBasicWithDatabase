package com.rozkurt.ss_2022_c2_e1;

import com.rozkurt.ss_2022_c2_e1.entities.Authority;
import com.rozkurt.ss_2022_c2_e1.entities.User;
import com.rozkurt.ss_2022_c2_e1.repositories.AuthorityRepository;
import com.rozkurt.ss_2022_c2_e1.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Ss2022C2E1Application implements CommandLineRunner {

    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;

    public Ss2022C2E1Application(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Ss2022C2E1Application.class, args);
    }



        @Override
        public void run(String... args) throws Exception {

            Optional<User> admin = userRepository.findByUsername("admin");
            Optional<User> user = userRepository.findByUsername("user");
            Optional<Authority> write = authorityRepository.findByNameIgnoreCase("write");
            Optional<Authority> read = authorityRepository.findByNameIgnoreCase("read");
            Optional<Authority> update = authorityRepository.findByNameIgnoreCase("update");


            if (write.isEmpty()) {
                Authority authority = Authority.builder()
                        .name("write")
                        .build();
                write = Optional.of(authorityRepository.save(authority));

            }
            if(read.isEmpty()) {
                Authority authority = Authority.builder()
                        .name("read")
                        .build();
                read = Optional.of(authorityRepository.save(authority));
            }

            if(update.isEmpty()) {
                Authority authority = Authority.builder()
                        .name("update")
                        .build();
                update = Optional.of(authorityRepository.save(authority));
            }



            if(admin.isEmpty()){
                var newUser = User.builder()
                        .username("admin")
                        .password("12345")
                        .authoritySet(new HashSet<>())
                        .build();
                newUser.getAuthoritySet().add(write.get());
                newUser.getAuthoritySet().add(read.get());
                newUser.getAuthoritySet().add(update.get());
                admin = Optional.of(userRepository.save(newUser));

                System.out.println("Admin created");

            } else {
                System.out.println("Admin already exists");
            }

            if(user.isEmpty()){
                var newUser = User.builder()
                        .username("user")
                        .password("12345")
                        .authoritySet(new HashSet<>())
                        .build();
                newUser.getAuthoritySet().add(read.get());
                user = Optional.of(userRepository.save(newUser));

                System.out.println("User created");

            } else {
                System.out.println("User already exists");
            }


        }


}
