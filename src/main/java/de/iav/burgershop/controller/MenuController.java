package de.iav.burgershop.controller;

import de.iav.burgershop.model.Menu;
import de.iav.burgershop.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }
    @GetMapping
    public List<Menu> allMenus(){return menuService.listAllMenus();}

    @GetMapping ({"/{id}"})
    public Menu getSingleMenu(@PathVariable String id){return menuService.returnMenuByID(id);}

    @PostMapping
    public void addMenu(@RequestBody Menu menu){menuService.addMenu(menu);}

    @PutMapping("/{id}")
    public void changeMenuByID(@PathVariable String id, @RequestBody Menu newMenu){
        menuService.changeMenuByID(id,newMenu);
    }

    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable String id){
        menuService.deleteMenuByID(id);
    }

}
