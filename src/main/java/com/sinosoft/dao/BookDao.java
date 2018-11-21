package com.sinosoft.dao;

import org.springframework.stereotype.Repository;

/**
 * @author hoverkan
 * @create 2018-11-19 10:02
 */
@Repository
public class BookDao {
    public String label = "1";

    @Override
    public String toString() {
        return "BookDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
