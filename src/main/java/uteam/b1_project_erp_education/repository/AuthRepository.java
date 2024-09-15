package uteam.b1_project_erp_education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import uteam.b1_project_erp_education.entity.Users;

import java.util.UUID;

public interface AuthRepository extends JpaRepository<Users, UUID> {
    UserDetails findByUserName(String username);
}
