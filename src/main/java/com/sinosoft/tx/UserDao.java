package com.sinosoft.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author hoverkan
 * @create 2018-11-27 9:13
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql = "insert into tb_user (name,age) values (?,?)";
        String name = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql, name, 20);
    }



}
