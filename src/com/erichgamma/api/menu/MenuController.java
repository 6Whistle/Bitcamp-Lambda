package com.erichgamma.api.menu;

import com.erichgamma.api.enums.Messenger;
import lombok.Getter;

import java.util.List;

public class MenuController {
    @Getter
    private static final MenuController instance = new MenuController();
    private final MenuService menuService;
    private MenuController(){
        menuService = MenuServiceImpl.getInstance();
    }

    public Messenger makeMenuTable(){
        return menuService.makeMenuTable() == Messenger.SUCCESS
                ? menuService.insertMenus()
                : Messenger.FAIL;
    }
    public Messenger removeMenuTable(){
        return menuService.removeTable();
    }

    public List<?> getMenusByCategory(String category){
        return menuService.getMenusByCategory(category);
    }

    public void printMenusByCategory(String category){
        System.out.println("[" + category + "]");
        menuService.getMenusByCategory(category).forEach(i -> System.out.print(((Menu)i).getItem() + "  "));
        System.out.println();
    }
}
