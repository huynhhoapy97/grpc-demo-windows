package com.huynhhoapy97.controller;

import com.google.protobuf.InvalidProtocolBufferException;
import com.huynhhoapy97.service.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrpcController {
    private final GrpcClient grpcClient;

    public GrpcController(GrpcClient grpcClient) {
        this.grpcClient = grpcClient;
    }

    @GetMapping("hello")
    public String hello(@RequestParam String name) {
        System.out.println(name);
        grpcClient.sendMessage(name);

        return "gRPC request sent";
    }

    @GetMapping("get-address")
    public String getAddress(@RequestParam int provinceId) throws InvalidProtocolBufferException {
        return grpcClient.getCityByProvinceId(provinceId);
    }
}
