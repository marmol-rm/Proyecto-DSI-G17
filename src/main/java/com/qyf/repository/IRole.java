package com.qyf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qyf.model.Role;

@Repository
public interface IRole extends JpaRepository<Role, Integer> {

}
