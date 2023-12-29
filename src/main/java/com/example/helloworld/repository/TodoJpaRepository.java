package com.example.helloworld.repository;

import com.example.helloworld.dto.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoJpaRepository extends JpaRepository<Todo,Long> {

    List<Todo> findByUserName(String userName);
}
