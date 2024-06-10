package com.adminka.practice78.Repositories;

import com.adminka.practice78.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    User findByUserId(Integer id);

    User findByUserName(String name);

    @Query(value = "CALL del_user(:del_id);", nativeQuery = true)
    void delUser(@Param("del_id") Integer userId);
}
