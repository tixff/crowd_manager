package com.ti.crowd_manager.controller;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class ItemControllerTest extends AbstractControllerTest {

    @Test
    @DatabaseSetup(value = "classpath:data/item.xml", type = DatabaseOperation.CLEAN_INSERT)
    @Transactional
    @Rollback
    public void addItem() throws Exception {
        mockMvc.perform(post("/item/add")
                .param("id", "1101").param("name", "mac众筹"));
        mockMvc.perform(get("/item/find")
                .param("id", "1101")).andExpect(jsonPath("$.data.name").value("mac众筹"));
    }
}