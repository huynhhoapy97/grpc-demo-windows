## Các lệnh trên terminal sử dụng trong demo này:

### .\gradlew generateProto : lệnh này dùng để tạo ra file .java từ file .proto
### .\gradlew clean build : lệnh này dùng để xóa cache, hoặc kiểm tra sự đúng đắn của project, cũng có thể tạo ra file .java từ file .proto
### .\gradlew dependencies --configuration runtimeClasspath : lệnh này dùng để show ra danh sách các dependencies trong file gradle
### .\gradlew dependencies --configuration runtimeClasspath | findstr "netty" : lệnh này dùng để show ra danh sách các dependencies trong file gradle với tên cần tìm kiếm

## Chúng ta còn có thể chạy trực tiếp để tạo ra file .java từ file .proto bằng lệnh trên Terminal như sau, yêu cầu phải cài đặt protoc và protoc-gen-grpc-java sau đó cấu hình 2 phần này trong PATH của environment system variables:

### protoc --java_out=src/main/java --grpc-java_out=src/main/java `
###     --plugin=protoc-gen-grpc-java=C:\protobuf\protoc-gen-grpc-java.exe `
###     -I=src/main/proto src/main/proto/hello.proto
