package com.webflux.crud.demo.webflux.handle;

import com.webflux.crud.demo.service.TestService;
import com.webflux.crud.demo.entity.TestDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class TestHandle {

    private final TestService testService;

    @Autowired
    public TestHandle(TestService testService){
        this.testService = testService;
    }

    public Mono<ServerResponse> saveTestDO(ServerRequest request) {
        // 将request的body暴露为Mono
        Mono<TestDO> testDO_mono = request.bodyToMono(TestDO.class);

        // 异步的转换发布的元素testDO_mono,返回一个新的Mono，被转换的元素和新Mono是动态绑定的;同步为map
        Mono<Object> testDO_mono_flatMap = testDO_mono.flatMap(testDO -> Mono.just(testService.save(testDO)));

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(testDO_mono_flatMap, TestDO.class);
    }

    public Mono<ServerResponse> getTestDO(ServerRequest request) {
        // 获取对应请求的TestDO数据
        Long id = Long.valueOf(request.pathVariable("id"));
        TestDO testDO = testService.getById(id);

        // 将数据testDO发出;只有testDO不为null时,才产生对应元素
        Mono<TestDO> testDO_mono = Mono.justOrEmpty(testDO);

        // 异步的转换发布的元素testDO_mono,返回一个新的Mono<ServerResponse>，被转换的元素和新Mono是动态绑定的;同步为map
        return testDO_mono.flatMap(
                testDO1 -> ServerResponse.ok().body(testDO_mono, TestDO.class));

    }

    public Mono<ServerResponse> getTestDOs() {
        // 获取数据(无筛选条件)
        List<TestDO> testDOs = testService.list(null);

        // 发出一个集合
        Flux<TestDO> testDO_flux = Flux.fromIterable(testDOs);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(testDO_flux, TestDO.class);
    }

    public Mono<ServerResponse> updateTestDO(ServerRequest request) {
        // 将request的body暴露为Mono
        Mono<TestDO> testDO_mono = request.bodyToMono(TestDO.class);

        // 异步转换发布的testDO_mono,调用testService.updateById（）进行数据更新，返回一个新的Mon<TestDO>
        Mono<Boolean> testDO_mono_flatMap = testDO_mono.flatMap(testDO ->
                Mono.just(testService.updateById(testDO))
        );

        return testDO_mono_flatMap.flatMap(
                testDO -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(testDO_mono_flatMap, Boolean.class)
        );
    }

    public Mono<ServerResponse> deleteTestDO(ServerRequest request) {
        // 获取要删除的id及对应数据
        Long id = Long.valueOf(request.pathVariable("id"));
        TestDO testDO = testService.getById(id);

        // 发布testDO
        Mono<TestDO> testDO_mono = Mono.justOrEmpty(testDO);

        // 发布一个新序列，他发出的数据为调用testService.removeById()的结果
        Mono<Boolean> remove_result_mono = Mono.justOrEmpty(testService.removeById(id));

        // 在序列结束之后返回一个 Mono<ServerResponse>
        return testDO_mono.then(
                ServerResponse.ok().body(remove_result_mono, Boolean.class));
    }
}


