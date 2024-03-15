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

    /**
     * 공통 메뉴 명령어 정의
     * x means 'Exit'
     * mk means 'Create Table'
     * cat means 'Find The One'
     * touch means 'Insert One'
     * ch-* means 'Change What'
     * rm means 'Delete Row'
     * ls-a means 'All List'
     * ls-n means 'Find By Name'
     * ls-* means 'Something List'
     * cnt means 'Count'
     * 이 외에 일상적이 아닌 단어는 약어 사용
     * withdraw -> with
     * deposit -> depo
     * balance -> bal
     * */
    private void insertMenus(){
        String[] categories = {"navigate", "account", "auth", "crawler", "post", "user", "soccer"};
        String[][] menus = {{"x :Exit", "ath :Auth", "acc :Account", "cwl :Crawler", "pst :Post", "usr :User", "scr :Soccer"},
                            {"x :Exit", "mk :Make Table", "rm-r :Remove Table", "touch :Create", "rm :Delete", "wdw :Withdraw", "dps :Deposit", "bal :Balance", "cat :Find", "ls-a :List"},
                            {"x :Exit", "joi :Join", "log :Login", "cat :Find ID", "ch-p :Change PW", "rm :Secession", "ls-a :Auth List", "ls-n :Search Name", "ls-j :Find Job", "cnt :Count Auth"},
                            {"x :Exit", "bugs :Bugs Music", "mellon :Mellon Music"},
                            {"x :Exit", "mk :Make Table", "rm-r :Remove Table", "ls-a :Posts"},
                            {"x :Exit", "mk :Make Table", "rm-r :Remove Table", "ls-a :List Table", "joi :Register", "log :Login"},
                            {"x :Exit", "mk :Make Table", "rm-r :Remove Table"}
                            };

        for(int i = 0; i < menus.length; i++)
            for(int j = 0; j < menus[i].length; j++)
                menuRepository.insertMenu(Menu.builder().category(categories[i]).item(menus[i][j]).build());
    }
}
