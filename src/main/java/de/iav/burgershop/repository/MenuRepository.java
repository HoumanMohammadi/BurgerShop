package de.iav.burgershop.repository;

import de.iav.burgershop.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Repository
public class MenuRepository {

    private Map<String, Menu> menuRepository;

    public MenuRepository(Map<String, Menu> menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void addMenu(Menu menu){
        this.menuRepository.put(menu.id(), menu);
    }

    public Menu getMenuByID(String id){
        return this.menuRepository.get(id);
    }

    public List<Menu> list(){
        return new ArrayList<Menu>(this.menuRepository.values());
    }
}
