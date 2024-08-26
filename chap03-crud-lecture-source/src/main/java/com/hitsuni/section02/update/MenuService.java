package com.hitsuni.section02.update;

import java.sql.Connection;

import static com.hitsuni.common.JDBCTemplate.*;

public class MenuService {

    public void updateMenu(Menu menu) {
        Connection con = getConnection();

        MenuRepository repository = new MenuRepository();
        int result = repository.updateMenu(con, menu);

        if(result > 0)
            commit(con);
        else
            rollback(con);

        close(con);
    }
}
