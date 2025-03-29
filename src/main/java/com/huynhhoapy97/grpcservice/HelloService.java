package com.huynhhoapy97.grpcservice;

import com.huynhhoapy97.grpc.HelloRequest;
import com.huynhhoapy97.grpc.HelloResponse;
import com.huynhhoapy97.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * Annotation @GrpcService đánh dấu đây là một gRPC Service trong Spring Boot
 * Annotation @GrpcService giúp Spring Boot tự động đăng ký service vào gRPC server
 * Nó tương tự như @RestController trong REST API nhưng dành cho gRPC.*/
@GrpcService
public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = "Hello, " + request.getName() + "!";

        HelloResponse response = HelloResponse.newBuilder()
                .setMessage(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
