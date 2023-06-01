package de.iav.burgershop.controller;

import de.iav.burgershop.model.Menu;
import de.iav.burgershop.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class ShopController {

    private final MenuService menuService;

    public ShopController(MenuService menuService) {
        this.menuService = menuService;
    }
    @GetMapping
    public List<Menu> allMenus(){return MenuService.}
}
