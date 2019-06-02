package com.example.ellin.webdemo.repository;

import com.example.ellin.webdemo.Hello;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends CrudRepository<Hello,String> {
}
