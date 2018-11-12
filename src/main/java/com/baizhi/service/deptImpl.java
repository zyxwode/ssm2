package com.baizhi.service;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.dao.deptDAO;
import com.baizhi.entity.dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
@Transactional
public class deptImpl implements  deptService{

    @Autowired
    private deptDAO deptDAO;

   /* public List<dept> findAll() {
        List<dept> list = deptDAO.findAll();
        JSONArray jsonArray = JSONArray.fromObject(list);
       Jedis jedis =   new Jedis("192.168.224.133",6379);


            if(jedis.exists("li")){
                String str = jedis.get("li");

                return  (List<dept>)JSONArray.toList(JSONArray.fromObject(str),dept.class);
            }
            else{
                jedis.set("li",jsonArray.toString());

                return (List<dept>)JSONArray.toList(jsonArray,dept.class);
            }




    }
*/
   public List<dept> findAll(Integer page,Integer rows) {
       Jedis jedis=null;
       int start=(page-1)*rows;
       try {
           String keys="findall"+start+"-"+rows;
           jedis = new Jedis("192.168.224.133",6379);
                   if(jedis.hexists("deptservice",keys)){
                       String json = jedis.hget("deptservice", keys);
                       return JSONObject.parseArray(json,dept.class);
                   }else{
                        List<dept> list = deptDAO.findAll(start,rows);
                       String json = JSONObject.toJSONString(list);
                       jedis.hset("deptservice",keys,json);
                       return JSONObject.parseArray(json,dept.class);
                   }
       } catch (Exception e) {
           e.printStackTrace();
           return deptDAO.findAll(start,rows);
       } finally {
           jedis.close();
       }


   }

    public void save(dept dept) {
        Jedis jedis=null;
        try {
                    jedis = new Jedis("192.168.224.135",6379);

                    jedis.del("deptservice");
            deptDAO.save(dept);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("redis exception");
        } finally {
            jedis.close();;
        }
    }
    public long total(){
       return deptDAO.total();
    }
}
