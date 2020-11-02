package com.test.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Profile("jdbc")
@Repository
public class JdbcItemRepository implements ItemRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(*) from item", Long.class);
    }

}
