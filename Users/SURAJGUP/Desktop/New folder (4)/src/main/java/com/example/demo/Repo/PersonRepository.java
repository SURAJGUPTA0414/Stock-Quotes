package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {
}
