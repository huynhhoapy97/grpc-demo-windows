package com.huynhhoapy97.grpcservice;

import com.huynhhoapy97.grpc.AddressRequest;
import com.huynhhoapy97.grpc.AddressResponse;
import com.huynhhoapy97.grpc.AddressServiceGrpc;
import com.huynhhoapy97.grpc.City;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.ArrayList;
import java.util.List;

@GrpcService
public class AddressService extends AddressServiceGrpc.AddressServiceImplBase {
    @Override
    public void getCityByProvinceId(AddressRequest request, StreamObserver<AddressResponse> responseObserver) {
        City cityOne = City.newBuilder()
                .setId(21)
                .setName("Thành phố Tuy Hòa")
                .build();
        City cityTwo = City.newBuilder()
                .setId(22)
                .setName("Đông Hòa")
                .build();
        City cityThree = City.newBuilder()
                .setId(23)
                .setName("Tây Hòa")
                .build();

        List<City> cities = new ArrayList<>();
        cities.add(cityOne);
        cities.add(cityTwo);
        cities.add(cityThree);

        AddressResponse response = AddressResponse.newBuilder()
                .setId(request.getProvinceId())
                .setName("Phú Yên")
                .addAllCity(cities)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
