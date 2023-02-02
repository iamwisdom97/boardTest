package com.test.project.repository;

import com.test.project.entity.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TbUserRepository extends JpaRepository<TbUser, Long> {
}
