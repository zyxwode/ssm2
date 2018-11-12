package com.baizhi.controller;

import com.baizhi.entity.dept;
import com.baizhi.service.deptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dept")
public class deptcon {
    @Autowired
    private deptService deptService;

    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> finddept(Integer page, Integer rows){
        Map<String,Object> map=new HashMap<String, Object>();
        List<dept> list = deptService.findAll(page,rows);
        for (dept dept : list) {
            System.out.println(dept);
        }
        map.put("total",deptService.total());
        map.put("rows",list);
        return map;
    }
    @RequestMapping("/save")
    @ResponseBody
    public Map<String,Object> savedept(dept dept){
        Map<String,Object> map=new HashMap<String, Object>();
        try {
            deptService.save(dept);
            map.put("success",true);
            System.out.println(dept);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("message",e.getMessage());
            return map;
        }
    }
}
