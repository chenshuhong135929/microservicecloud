package com.chenshuhong.springcloud.service;

import com.chenshuhong.springcloud.entities.Dept;

import java.util.List;

/**
 * Created by ZeroV on 2018/11/6.
 */
public interface DeptService {

     boolean add(Dept dept);

     Dept get(Long id);

     List<Dept> list();
}
