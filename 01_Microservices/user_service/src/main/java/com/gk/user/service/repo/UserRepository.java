package com.gk.user.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gk.user.service.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	// Custom Methods
}
