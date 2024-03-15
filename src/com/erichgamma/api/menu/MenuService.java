package com.erichgamma.api.menu;

import com.erichgamma.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {
    Messenger makeMenuTable();

    Messenger removeTable();

    List<?> getMenusByCategory(String category);

    Messenger insertMenus();
}
