package com.huynhhoapy97.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.huynhhoapy97.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class GrpcClient {
    public void sendMessage(String name) {
        // Tạo kết nối với gRPC server đang chạy ở localhost:9090
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext() // Không dùng SSL
                .build();

        // Tạo Stub để gọi API (service method)
        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        HelloResponse response = stub.sayHello(request);

        System.out.println("Response from Server: " + response.getMessage());

        // Đóng kênh
        channel.shutdown();
    }

    public String getCityByProvinceId(int provinceId) throws InvalidProtocolBufferException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        AddressServiceGrpc.AddressServiceBlockingStub stub = AddressServiceGrpc.newBlockingStub(channel);
        AddressRequest request = AddressRequest.newBuilder()
                .setProvinceId(provinceId)
                .build();
        AddressResponse response = stub.getCityByProvinceId(request);

        channel.shutdown();

        // Convert Protobuf sang JSON
        return JsonFormat.printer().print(response);
    }
}
