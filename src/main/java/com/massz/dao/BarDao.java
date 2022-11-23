package com.massz.dao;

import com.massz.model.Bar;
import com.massz.model.Post;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarDao {
    @Select("select bar_id barId,bar_name barName from bar order by bar_name")
    List<Bar> getBarAll();

}
