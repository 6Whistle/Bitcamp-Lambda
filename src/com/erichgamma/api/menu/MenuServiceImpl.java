package com.erichgamma.api.menu;

import com.erichgamma.api.enums.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;

public class MenuServiceImpl implements MenuService{
    @Getter
    private static final MenuService instance = new MenuServiceImpl();
    private final MenuRepository menuRepository;
    private MenuServiceImpl(){
        menuRepository = MenuRepository.getInstance();
    }

    @Override
    public Messenger makeMenuTable(){
        menuRepository.makeTable();
        this.insertMenus();
        return Messenger.SUCCESS;
    }

    @Override
    public Messenger removeTable() {
        return menuRepository.removeTable();
    }

    @Override
    public List<?> getMenusByCategory(String category){
        return menuRepository.getMenusByCategory(category);
    }

    private void insertMenus(){
        String[] categories = {"navigate", "auth", "account", "crawler", "post", "user", "soccer"};
        String[][] menus = {{"exit-Exit", "auth-Auth", "account-Account", "crawler-Crawler", "post-Post", "user-User"},
                            {"exit-종료", "join-회원가입", "login-로그인", "findId-ID 검색", "updatePw-PW 변경", "delete-탈퇴", "list-회원목록", "searchName-이름 검색", "searchJob-직업 검색", "count-회원수"},
                            {"0-Exit", "1-Create", "2-Withdraw", "3-Deposit", "4-Balance", "5-Delete", "6-Find", "7-List"},
                            {"0-종료", "1-벅스뮤직", "2-멜론"},
                            {"0-Exit", "1-Board"},
                            {"exit-Exit", "touch-Make Table", "rm-Remove Table", "ls-List Table", "join-Register", "login-Login"},
                            {}};

        for(int i = 0; i < menus.length; i++)
            for(int j = 0; j < menus[i].length; j++)
                menuRepository.insertMenu(Menu.builder().category(categories[i]).item(menus[i][j]).build());
    }
}
