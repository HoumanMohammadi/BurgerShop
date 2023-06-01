package de.iav.burgershop.service;

import de.iav.burgershop.exception.MenuNotFoundException;
import de.iav.burgershop.model.Beverage;
import de.iav.burgershop.model.Food;
import de.iav.burgershop.model.Menu;
import de.iav.burgershop.repository.MenuRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MenuServiceTest {

    MenuRepository menuRepository=mock(MenuRepository.class);
    MenuService menuService=new MenuService(menuRepository);

    @Test
    void addMenu_WhenMenuAdded_ThenVerifyMenuRepository() {

        Menu menuToAdd = new Menu("M01","Menus1",25,
                new Food("cheese burger"),
                new Food("sweet potato"),
                new Beverage("Helles Bier"));



        menuService.addMenu(menuToAdd);
        verify(menuRepository).addMenu(menuToAdd);
    }

    @Test
    void listAllMenus_WhenMenuExists_ThenStatusOKAndListAllMenus() {
        List<Menu> expectedMenus=new ArrayList<>();

        expectedMenus.add(new Menu("M01","Menus1",20,
                new Food("cheese burger"),
                new Food("sweet potato"),
                new Beverage("Helles Bier")));

        when(menuRepository.list()).thenReturn(expectedMenus);

        List<Menu>  actualMenus=menuService.listAllMenus();

        verify(menuRepository).list();
        assertEquals(expectedMenus,actualMenus);
    }

    @Test
    void returnMenuByID_whenNonExistingId_thenThrowMenuNotFoundException() {

        when(menuRepository.getMenuByID("M05")).thenThrow(new MenuNotFoundException("M05"));

        assertThrows(
                MenuNotFoundException.class,()->{
                    menuService.returnMenuByID("M05");
                }
        );

        verify(menuRepository).getMenuByID(anyString());

    }

    @Test
    void changeMenuByID() {

    }

    @Test
    void deleteMenuByID() {
    }
}