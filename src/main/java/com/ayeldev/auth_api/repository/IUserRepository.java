package com.ayeldev.auth_api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ayeldev.auth_api.model.User;

public interface IUserRepository extends CrudRepository<User, Integer>{
	Optional<User>findByEmail(String email);
}
