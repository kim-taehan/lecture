# 리엑티브 시스템 

## 특징 
- 높은 응답성, 탄력적이고 유연하다.
- 메시지 기반으로 동작하게 된다. 

## 리엑티브 프로그래밍
- 리액티브 시스템을 구축하는데 필요한 프로그래밍 모델
- 데이터 소스에 변경이 있을때마다 데이터를 전파
- 선언형 프로그래밍 패러다임: 실행할 동작을 구체적으로 명시하지 않고 목표만 정의함 
- 함수형 프로그래밍 기법 사용

## 리엑티브 스트림즈를 구현한 구현체
- RxJava
- Java 9 Flow API
- Akka Streams
- Reactor

## Spring WebFlux 란
- 비동기 Non-Blocking I/O 방식으로 적은 수의 쓰레드를 사용한다.
- Reactor 에 의존하여 비동기 로직을 구성하고 리엑티브 스트림을 제공한다.

## 적합한 시스템
- blocking i/o 방식으로 처리하는데 한계가 있는 대량의 요청 트래픽이 발생하는 시스템
- 마이크로 서비스 기반 시스템
- 스트리밍 시스템 또는 실시간 시스템

## reactor 구성요소
- 생산자 : Flux, Mono
- 소비자?? 
- 데이터소스 : 생산자에서 생성하는 데이터
- 데이터생성 연산자: just 체인 형태로 사용가능 

## 용어 정의 
- publisher : 발행자, 게시자, 생산자
- subscriber : 구독자, 소비자
- emit : publisher 가 데이터를 내보내는 것
- sequence : publisher 가 emit 하는 데이터의 연속적인 흐름을 정의
- operate : chain 형태의 연산자 (map, just)
- subscribe/dispose : subscriber 가 sequence 구독/해지

## mono
- 0,1 데이터를 emit 하는 publisher 
- emit 과정에서 애러가 발생하면 onError signal 을 emit 한다.

## flux
- 0,n 데이터를 emit 하는 publisher

## cold sequence 
- subscriber 가 구독할 때마다 타임라인의 처음부터 emit 된 데이터를 받을 수 있다.

## hot sequence
- subscriber 가 구독한 시점 이후에 emit 된 데이터를 받을 수 있다.

## backpressure
- publisher 에서 emit 되는 데이터를 subscriber 에서 안정적으로 처리하기 위한 제어 기능

### 처리방법
- 요청 데이터의 개수를 제어: subscriber 가 적절히 처리할 수 수준의 데이터 개수를 요청
- backpressure 전략 : reactor 에서 제공하는 backpressure 전략을 사용
- ignore 전략
- error 전략
- drop 전략
- LATEST 전략 (가장 나중에 emit 된 데이터부터)
- buffer 전략 (버퍼 안의 데이터를 drop)


## Sinks
- reactive streams 에서 발생하는 signal 을 프로그래밍적으로 push 할 수 있는 기능을 가지고 있는 publisher 의 일종이다.
- thread-safe 하지 않을 수 있는 processor 보다 더 나은 대안이 된다.

## scheduler
### scheduler 전용 Operator
- publishOn(): downstream operator 의 실행을 위한 스레드를 지정한다. 
- subscribeOn(): upstream publisher 의 실행을 위한 스레드 지정한다. (원본 데이터 소스를 emit 하기 위한 스케줄러를 지정한다.)
- parallel(): downstream에 대한 데이터 처리를 병렬로 분할 처리


### scheduler 종류
- Schedulers.immediate : 별도의 스레드를 추가 할당하지 않고 현재 스레드 
- Schedulers.single : 하나의 스레드를 재사용 (저지연 일회성 실행)
- Schedulers.boundedElastic() : 스레드 풀을 생성하여 생성된 스레드를 재사용
- Schedulers.parallel() : 여러개의 스레드를 할당해서 동시에 작업을 수행 (non-blocking i/o)
- Schedulers.fromExecutorService() : 기존의 executor service 를 사용
- Schedulers.newXXXX() : 새로운 Schedulers 생성 

## context
- 상태를 저장할 수 있고, operator 체인에서 공유해서 사용할 수 있는 인터페이스
- subscriber 를 통해 Reactor Sequence 에 연결 되며, 체인에서 각각의 operator 들이 실행 쓰레드가 달라도 연결된 context 에 접근할 수 있다. 
- context 는 체인의 맨 아래서부터 위로 전파된다. 


## debugging 방법
- 디버그 모드 활성화
- checkpoint() operator 를 사용하는 방법
- log() operator 를 사용해서 signal 을 확인하는 방법

