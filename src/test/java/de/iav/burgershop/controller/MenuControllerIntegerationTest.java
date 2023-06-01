package de.iav.burgershop.controller;

import de.iav.burgershop.model.Beverage;
import de.iav.burgershop.model.Food;
import de.iav.burgershop.model.Menu;
import de.iav.burgershop.repository.MenuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
    void getSingleMenu_whenAMenu_thenExpectStatusOKAndOneMenu() throws Exception {
        Menu menu=new Menu("M01","Menus1",25,
                new Food("cheese burger"),
                new Food("sweet potato"),
                new Beverage("Cola"));
        menuRepository.addMenu(menu);

        final String searchID= menu.id();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/menus/{id}",searchID))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                        {
                                            "id":"M01",
                                            "name":"Menus1",
                                            "price":25,
                                            "mainDish":{"name":"cheese burger"},
                                            "sideDish":{"name":"sweet potato"},
                                            "beverage":{"name":"Cola"}
                                        }
                                        """
                ));
    }

    @Test
    void addMenu_WhenAMenuAvailable_thenStatusNotOK() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/api/menus")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        """
                                        {
                                            "id":"M01",
                                            "name":"Menus1",
                                            "price":25,
                                            "mainDish":{"name":"cheese burger"},
                                            "sideDish":{"name":"sweet potato"},
                                            "beverage":{"name":"Cola"}
                                        }
                                        """
                )).andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/menus"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value("M01"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Menus1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(25))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].mainDish.name").value("cheese burger"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].sideDish.name").value("sweet potato"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].beverage.name").value("Cola"));

    }


    @Test
    void changeMenuByID() {
    }

    @Test
    void deleteMenu() {
    }
}