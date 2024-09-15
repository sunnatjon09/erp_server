package uteam.b1_project_erp_education.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import uteam.b1_project_erp_education.entity.Role;
import uteam.b1_project_erp_education.entity.Users;
import uteam.b1_project_erp_education.entity.enums.RoleName;
import uteam.b1_project_erp_education.repository.AuthRepository;
import uteam.b1_project_erp_education.repository.RoleRepository;

import java.util.Collections;
import java.util.Date;


@Configuration
public class DataLoader implements CommandLineRunner {

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String initMode;

    @Autowired
    AuthRepository authRepository;

    @Autowired
    RoleRepository roleRepository;


    @Override
    public void run(String... args) throws Exception {
        if (initMode.equals("create-drop") || initMode.equals("create")) {
            for (RoleName value : RoleName.values()) {
                roleRepository.save(new Role(value));
            }
            String encryptedPassword = new BCryptPasswordEncoder().encode("Qozijon123");
            authRepository.save(
                    Users.builder()
                            .name("Qozi")
                            .surname("Gadayev")
                            .birthDate(new Date(2000, 12, 12))
                            .phoneNumber("900000909")
                            .roles(Collections.singleton(roleRepository.findById(1).get()))
                            .userName("qozijon")
                            .password(encryptedPassword)
                            .accountNonExpired(true)
                            .accountNonLocked(true)
                            .enabled(true)
                            .credentialsNonExpired(true)
                            .build()
            );
        }
    }
}


