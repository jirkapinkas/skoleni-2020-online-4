package com.test.app.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("dummy")
@Repository
public class DummyItemRepository implements ItemRepository {

    @Override
    public long count() {
        return 123L;
    }

}
