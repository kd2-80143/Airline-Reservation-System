package com.app.dao;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
import com.app.dto.LoginDTO;
import com.app.entities.User;
public interface CustomerDao extends JpaRepository<User, Long> {

	User getByEmail(LoginDTO ldto);

=======

import com.app.entities.User;
public interface CustomerDao extends JpaRepository<User, Long> {

>>>>>>> main
}
