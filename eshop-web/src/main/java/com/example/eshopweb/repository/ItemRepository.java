package com.example.eshopweb.repository;

import com.example.eshopweb.entity.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    // KE ZISKANI VICE ZAZNAMU V RAMCI JEDNOHO SELECTU POUZIJEME BUD "join fetch" NEBO @EntityGraph!!!
    // select * from item left join category on ...
//    @Transactional(readOnly = true)
//    @Query("select i from Item i left join fetch i.category")
//    List<Item> findAllFetchCategory(Sort sort);

    // select * from item left join category on ... where id = ?
//    @Transactional(readOnly = true)
//    @Query("select i from Item i left join fetch i.category where i.id = ?1")
//    Optional<Item> findByIdFetchCategory(int id);


    @EntityGraph(Item.GRAPH_CATEGORY)
    @Override
    List<Item> findAll(Sort sort);

    @EntityGraph(Item.GRAPH_CATEGORY)
    @Override
    Optional<Item> findById(Integer integer);


    // 1. operace, ktere delaji neco na zaklade hlavicky metody

    // select * from item where name = ?
    List<Item> findByName(String name);

    List<Item> findByName(String name, Sort sort);

    List<Item> findByName(String name, Pageable pageable);

    // select * from item where lower(name) like lower(%?%)
    List<Item> findByNameContainingIgnoreCase(String name);

    // 2. HQL / JPQL

    // select * from item where lower(name) like lower(?)
    @Transactional(readOnly = true)
    @Query("select i from Item i where lower(i.name) like lower(:name)")
    List<Item> search(@Param("name") String name);

    // select * from item where lower(name) like lower(?)
    @Transactional(readOnly = true)
    @Query("select i from Item i where lower(i.name) like lower(:name)")
    List<Item> search(@Param("name") String name, Sort sort);

    // 3. SQL

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select name from item")
    List<String> getItemNames();

    // 4. @Transactional @Modifying @Query (DML)
    // 5. projections
    // ...

    // dalsi: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference

}
