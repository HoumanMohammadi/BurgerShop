package de.iav.burgershop.controller;

import de.iav.burgershop.repository.MenuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc

class MenuControllerIntegerationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private MenuRepository menuRepository;

    @Test
    void allMenus_WhenNoMenus_thenExpectStatusOkAndEmptyList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/menus"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
[]
"""));

    }

    @Test
    void getSingleMenu() {
    }

    @Test
    void addMenu() {
    }

    @Test
    void changeMenuByID() {
    }

    @Test
    void deleteMenu() {
    }
}