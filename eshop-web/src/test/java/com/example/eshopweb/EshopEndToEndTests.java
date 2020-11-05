package com.example.eshopweb;

import com.example.eshopweb.dto.ItemDto;
import com.example.eshopweb.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// diky "webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT"
// se spusti Tomcat na nahodnem portu
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EshopEndToEndTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    // end-to-end test
    @Test
    void contextLoads() {
        ItemDto itemDto = testRestTemplate.getForObject("/item/1", ItemDto.class);
        assertThat(itemDto)
                .isNotNull();
        assertThat(itemDto.getId())
                .isEqualTo(1);
    }

}
