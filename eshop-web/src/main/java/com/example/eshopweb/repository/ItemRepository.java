package com.example.eshopweb.repository;

import com.example.eshopweb.entity.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    // 1. operace, ktere delaji neco na zaklade hlavicky metody

    // select * from item where name = ?
    List<Item> findByName(String name);

    List<Item> findByName(String name, Sort sort);

    List<Item> findByName(String name, Pageable pageable);

    // select * from item where lower(name) like lower(%?%)
    List<Item> findByNameContainingIgnoreCase(String name);

    // 2. HQL / JPQL

    // select * from item where lower(name) like lower(?)
    @Query("select i from Item i where lower(i.name) like lower(:name)")
    List<Item> search(@Param("name") String name);

    // select * from item where lower(name) like lower(?)
    @Query("select i from Item i where lower(i.name) like lower(:name)")
    List<Item> search(@Param("name") String name, Sort sort);

    // 3. SQL

    @Query(nativeQuery = true, value = "select name from item")
    List<String> getItemNames();

    // 4. @Modifying @Query (DML)
    // 5. projections
    // ...

    // dalsi: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference

}
