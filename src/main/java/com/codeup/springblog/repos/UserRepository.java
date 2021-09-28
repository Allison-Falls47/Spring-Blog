
package com.codeup.springblog.repos;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {

    User getByUsername(String username);
}