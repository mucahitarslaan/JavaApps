package com.mucahitarslan.application.data.repository;

import com.mucahitarslan.application.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    User findByName (String userName);
}
