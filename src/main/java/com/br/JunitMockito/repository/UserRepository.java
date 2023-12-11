package com.br.JunitMockito.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.JunitMockito.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID>{

}
