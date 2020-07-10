# Getting Started

## Prerequisites
This demo project was built with java 11

Note: This is the steps needed on a machine running Ubuntu 20.04. The steps may differ on other systems but should be similar.

1.  Install GraalVM. I recommend using [SDKMAN](https://sdkman.io/). You simply run
```
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```
Then install GraalVM using SDKMAN with
```
sdk install java 20.1.0.r11-grl
```
 have the correct configuration of your PATH variable in place, you may need to restart your console. 
 If everything went well, you should see java -version output the following:
```
openjdk version "11.0.7" 2020-04-14
OpenJDK Runtime Environment GraalVM CE 20.1.0 (build 11.0.7+10-jvmci-20.1-b02)
OpenJDK 64-Bit Server VM GraalVM CE 20.1.0 (build 11.0.7+10-jvmci-20.1-b02, mixed mode, sharing)
```
2.  Install GraalVM Native Image
GraalVM ships with its own updater tool `gu`. Install GraalVM Native Image by running
``` 
gu install native-image
```
Verify that install was successfull by running
```
native-image --version
```
3.  Install dependencies needed when compiling with native-image.
For compilation native-image depends on the local toolchain, so make sure: glibc-devel, zlib-devel (header files for the C library and zlib) and gcc are available on your system

4.  Build the native image using the gradle plugin.
Simply run 
```
./gradlew buildNativeImage
```
This process takes about 3 minutes to finish (on a 32gb RAM system)

5.  Run the binary created. Inside of `build/native` lies the generated binary, running it with
``` 
cd build/native
./demo
```

Should give the following erronous output
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                        

2020-07-10 19:16:23.201  INFO 1436236 --- [           main] .l.GraalGrpcSpringBootStarterApplication : Starting GraalGrpcSpringBootStarterApplication on nickjn92 with PID 1436236 (/home/nikjon/git/demo/build/native/demo started by nikjon in /home/nikjon/git/demo/build/native)
2020-07-10 19:16:23.201  INFO 1436236 --- [           main] .l.GraalGrpcSpringBootStarterApplication : No active profile set, falling back to default profiles: default
2020-07-10 19:16:23.266  WARN 1436236 --- [           main] onfigReactiveWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanDefinitionStoreException: @Configuration classes need to be marked as proxyBeanMethods=false. Found: [net.devh.boot.grpc.common.autoconfigure.GrpcCommonCodecAutoConfiguration, net.devh.boot.grpc.client.autoconfigure.GrpcClientMetricAutoConfiguration, net.devh.boot.grpc.client.autoconfigure.GrpcClientSecurityAutoConfiguration, net.devh.boot.grpc.client.autoconfigure.GrpcClientAutoConfiguration, net.devh.boot.grpc.client.autoconfigure.GrpcClientHealthAutoConfiguration, net.devh.boot.grpc.server.autoconfigure.GrpcServerMetricAutoConfiguration, net.devh.boot.grpc.server.autoconfigure.GrpcServerAutoConfiguration, net.devh.boot.grpc.server.autoconfigure.GrpcServerFactoryAutoConfiguration]
2020-07-10 19:16:23.267  INFO 1436236 --- [           main] ConditionEvaluationReportLoggingListener : 

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2020-07-10 19:16:23.267 ERROR 1436236 --- [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanDefinitionStoreException: @Configuration classes need to be marked as proxyBeanMethods=false. Found: [net.devh.boot.grpc.common.autoconfigure.GrpcCommonCodecAutoConfiguration, net.devh.boot.grpc.client.autoconfigure.GrpcClientMetricAutoConfiguration, net.devh.boot.grpc.client.autoconfigure.GrpcClientSecurityAutoConfiguration, net.devh.boot.grpc.client.autoconfigure.GrpcClientAutoConfiguration, net.devh.boot.grpc.client.autoconfigure.GrpcClientHealthAutoConfiguration, net.devh.boot.grpc.server.autoconfigure.GrpcServerMetricAutoConfiguration, net.devh.boot.grpc.server.autoconfigure.GrpcServerAutoConfiguration, net.devh.boot.grpc.server.autoconfigure.GrpcServerFactoryAutoConfiguration]
	at org.springframework.context.annotation.ConfigurationClassPostProcessor.enhanceConfigurationClasses(ConfigurationClassPostProcessor.java:71) ~[demo:na]
	at org.springframework.context.annotation.ConfigurationClassPostProcessor.postProcessBeanFactory(ConfigurationClassPostProcessor.java:257) ~[demo:na]
	at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:291) ~[na:na]
	at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:131) ~[na:na]
	at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:707) ~[na:na]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:533) ~[na:na]
	at org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext.refresh(ReactiveWebServerApplicationContext.java:62) ~[na:na]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:758) ~[demo:na]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:750) ~[demo:na]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:397) ~[demo:na]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:315) ~[demo:na]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1237) ~[demo:na]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1226) ~[demo:na]
	at com.lthd92.GraalGrpcSpringBootStarterApplication.main(GraalGrpcSpringBootStarterApplication.java:10) ~[demo:na]

```