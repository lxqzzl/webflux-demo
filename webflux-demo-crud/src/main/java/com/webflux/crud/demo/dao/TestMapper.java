package com.webflux.crud.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.webflux.crud.demo.entity.TestDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description TestDOMapper 接口
 * @author lxq
 * @since 2020-09-20 18:19:08
 */
@Mapper
public interface TestMapper extends BaseMapper<TestDO> {

}