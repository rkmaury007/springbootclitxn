package org.rkm.springclitxn.service;

import org.rkm.springclitxn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void addUsers(List<User> users){
        for (User user: users) {
            System.out.println("In Service...."+user.getName());
            jdbcTemplate.update("insert into user(Id,Name) values (?,?)",
                    preparedStatement -> {
                        preparedStatement.setInt(1,user.getId());
                        preparedStatement.setString(2,user.getName());
                    });
        }
    }
    public List<User> getUsers(){
        List<User> userList = jdbcTemplate.query("select id,name from user", (resultSet, i) -> new User(resultSet.getInt("Id"),
        resultSet.getString("Name")));
        return userList;
    }
}
