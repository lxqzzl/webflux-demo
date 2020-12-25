package com.webflux.crud.demo.controller;

import com.webflux.crud.demo.service.TestService;
import com.webflux.crud.demo.entity.TestDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/controller/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping
    public Flux<TestDO> getList(){
        // 获取数据
        List<TestDO> testDOList = testService.list(null);

        // 创建一个新的序列，他发出一个集合
        Flux<TestDO> testDO_flux = Flux.fromIterable(testDOList);

        return testDO_flux;
    }

    @GetMapping("/{id}")
    public Mono<TestDO> getOne(@PathVariable("id") Long id){
        // 获取数据
        TestDO testDO = testService.getById(id);

        // 创建一个新的序列，他发出一个实体类
        Mono<TestDO> testDO_mono = Mono.justOrEmpty(testDO);

        return testDO_mono;
    }

    @PostMapping
    public Mono<Boolean> insert(@RequestBody TestDO testDO){
        // 存入数据并获取结果
        Boolean insertResult_boolean = testService.save(testDO);

        // 创建一个新的序列，他发出一个布尔型数据
        Mono<Boolean> result_mono = Mono.just(insertResult_boolean);

        return result_mono;
    }

    @PutMapping
    public Mono<Boolean> update(@RequestBody TestDO testDO){
        // 更新数据并获取结果
        Boolean insertResult_boolean = testService.updateById(testDO);

        // 创建一个新的序列，他发出一个布尔型数据
        Mono<Boolean> result_mono = Mono.just(insertResult_boolean);

        return result_mono;
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> delete(@PathVariable("id") Long id){
        // 更新数据并获取结果
        Boolean insertResult_boolean = testService.removeById(id);

        // 创建一个新的序列，他发出一个布尔型数据
        Mono<Boolean> result_mono = Mono.just(insertResult_boolean);

        return result_mono;
    }

}
