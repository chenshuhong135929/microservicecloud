package com.chenshuhong.springcloud.dao;

import com.chenshuhong.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by ZeroV on 2018/11/6.
 */
@Mapper
public interface DeptDao {

     boolean addDept(Dept dept);

     Dept findById(Long id);

     List<Dept> findAll();
}
