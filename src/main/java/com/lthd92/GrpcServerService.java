package com.lthd92;

import com.lthd92.test.grpc.HelloReply;
import com.lthd92.test.grpc.HelloRequest;
import com.lthd92.test.grpc.SimpleGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
@GrpcService
public class GrpcServerService extends SimpleGrpc.SimpleImplBase {

  @Override
  public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
    HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }
}