package de.iav.burgershop.controller;

import de.iav.burgershop.model.Menu;
import de.iav.burgershop.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class ShopController {

    private final MenuService menuService;

    public ShopController(MenuService menuService) {
        this.menuService = menuService;
    }
    @GetMapping
    public List<Menu> allMenus(){return menuService.listAllMenus();}

    @GetMapping ({"/{id}"})
    public Menu getSingleMenu(@PathVariable String id){return menuService.returnMenuByID(id);}

    @PostMapping
    public void addMenu(@RequestBody Menu menu){menuService.addMenu(menu);}


}
