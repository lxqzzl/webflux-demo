package com.webflux.crud.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.webflux.crud.demo.service.TestService;
import com.webflux.crud.demo.dao.TestMapper;
import com.webflux.crud.demo.entity.TestDO;
import org.springframework.stereotype.Service;


/**
 * @Description TestServiceImpl服务实现类
 * @author lxq
 * @since 2020-09-20 18:19:08
 */

@Service("TestService")
public class TestServiceImpl extends ServiceImpl<TestMapper, TestDO> implements TestService {

}