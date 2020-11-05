package com.example.eshopweb;

import com.example.eshopweb.dto.ItemDto;
import com.example.eshopweb.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class EshopWebApplicationTests {

    @Autowired
    private ItemService itemService;

    // integracni test
    @Test
    void contextLoads() {
        List<ItemDto> items = itemService.findAll(Sort.by("id"));
        // https://assertj.github.io/doc/
        assertThat(items)
                .isNotNull()
                .isNotEmpty()
                .extracting(ItemDto::getName)
                .contains("Java in 21 days", "Java cup");
    }

}
