package k23cnt2.nhom4.prj4.ttcd.repository;

import k23cnt2.nhom4.prj4.ttcd.entity.ENUMS;
import k23cnt2.nhom4.prj4.ttcd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    // Dashboard
    long countByRole(ENUMS.UserRole role);

    long countByIsActive(Boolean isActive);
}