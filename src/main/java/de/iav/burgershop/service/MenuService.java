package de.iav.burgershop.service;

import de.iav.burgershop.model.Menu;
import de.iav.burgershop.repository.MenuRepository;

import java.util.List;

public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void addMenu(Menu menuToAdd){menuRepository.addMenu(menuToAdd);}

    public List<Menu> listAllMenus(){return menuRepository.list();}

    public Menu returnMenuByID(String menuIDToReturn){return menuRepository.getMenuByID(menuIDToReturn);}

    public void changeMenuByID(String menuIDToChange, Menu menu){menuRepository.changeMenuByID(menuIDToChange, menu);}
    public void deleteMenuByID(String menuIDTOoDelete){menuRepository.deleteMenuByID(menuIDTOoDelete);}

}
