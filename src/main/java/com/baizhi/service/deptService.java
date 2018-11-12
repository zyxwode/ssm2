package com.baizhi.service;

import com.baizhi.entity.dept;

import java.util.List;

public interface deptService {
    public List<dept> findAll(Integer page,Integer rows);
    public void save(dept dept);
    public long total();
}
