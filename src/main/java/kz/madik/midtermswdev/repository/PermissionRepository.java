package kz.madik.midtermswdev.repository;

import kz.madik.midtermswdev.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Permission findByName(String roleUser);
}
