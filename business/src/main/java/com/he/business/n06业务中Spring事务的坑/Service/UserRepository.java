package com.he.business.n06业务中Spring事务的坑.Service;

import com.he.business.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
