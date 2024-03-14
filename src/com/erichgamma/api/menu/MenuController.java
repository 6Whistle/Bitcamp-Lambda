package com.erichgamma.api.menu;

import com.erichgamma.api.enums.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;

public class MenuController {
    @Getter
    private static final MenuController instance = new MenuController();
    private final MenuService menuService;
    private MenuController(){
        menuService = MenuServiceImpl.getInstance();
    }

    public Messenger makeMenuTable(){
        return menuService.makeMenuTable();
    }
    public Messenger removeMenuTable(){
        return menuService.removeTable();
    }

    public List<?> getMenusByCategory(String category){
        return menuService.getMenusByCategory(category);
    }
}
