package com.itmuch.contentcenter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class TestController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("test2")
    public List<ServiceInstance> getInstances() {
        // 查询指定服务的所有实例的信息
        // consul/eureka/zookeeper...
        return this.discoveryClient.getInstances("user-center");
    }
}
