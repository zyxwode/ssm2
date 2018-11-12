package com.baizhi.dao;

import com.baizhi.entity.dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface deptDAO {
    public List<dept> findAll(@Param("start") Integer start,@Param("rows") Integer rows);
    public void save(dept dept);
    public long total();
}
