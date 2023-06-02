package de.iav.burgershop.repository;

import de.iav.burgershop.exception.MenuNotFoundException;
import de.iav.burgershop.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Repository
public class MenuRepository {

    private final Map<String, Menu> menuRepository;

    public MenuRepository(Map<String, Menu> menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void addMenu(Menu menu){
        this.menuRepository.put(menu.id(), menu);
    }

    public Menu getMenuByID(String id){
        if (this.menuRepository.containsKey(id)){
            return this.menuRepository.get(id);
        }else throw new MenuNotFoundException(id);
    }

    public List<Menu> list(){
        return new ArrayList<Menu>(this.menuRepository.values());
    }

    public void changeMenuByID(String menuIDToChange, Menu menu) {
        if (this.menuRepository.containsKey(menuIDToChange)){
            this.menuRepository.replace(menuIDToChange,menu);
        }else throw new MenuNotFoundException(menuIDToChange);
    }

    public void deleteMenuByID(String menuIDToDelete) {
        if (this.menuRepository.containsKey(menuIDToDelete)){
            this.menuRepository.remove(menuIDToDelete);
        }else throw new MenuNotFoundException(menuIDToDelete);
    }
}
