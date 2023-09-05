package com.transactionalBank.demo.repositories;

import com.transactionalBank.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
