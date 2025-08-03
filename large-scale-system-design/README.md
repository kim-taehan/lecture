# 스프링부트로 직접 만들면서 배우는 대규모 시스템 설계 (쿠케)

## scale-up/out
> scale-up : 단일 서버의 성능을 향상 
> scale-out : 서버를 추가하여 성능을 향상

## cache 
- 더 느린 저장소에서 더 빠른 저장소에 데이터를 저장해두고 접근한는 기술


## distributed relational database
- 분산 관계형 데이터베이스는 샤딩을 이용하여 데이터를 여러 DB에 분산할 수 있다. 
  - 샤딩: 데이터를 여러 데이터베이스에 분산하여 저장하는 기술
  - 샤드: 샤딩된 각각의 데이터 단위
- 수직 샤딩 : 데이터를 수직으르로 분할(컬럼 단위)
- 수평 샤딩 : 데이터를 수평으로 분할하는 방식 (row 단위)

### 논리적 샤드 
- 데이터를 논리적으로 분산한 가상의 단위
- 물리적 확장시, client 변경없이 유연한 매핑이 가능 (라우터만 수정됨)

### replica
- 특정 샤드가 장애가 발생했을 때 다른 샤드에서 처리할 수 있는 복사본 

### 인덱스에 대한 이해 
- Relational Database에서는 주로 B+ tree(Balanced Tree)
  - 데이터가 정렬된 상태로 저장된다.
  - 검색, 삽입, 삭제 연산을 로그 시간에 수행 가능
  - 트리 구조에서 leaf node 간 연결되기 때문에 범위 검색 효율적

### Clustered Index vs Secondary Index
|  | Clustered Index | Secondary Index        |
|--| --|------------------------|
|생성 | 테이블의 Primary Key로 자동 생성 | 테이블의 컬럼으로 직접 생성        |
|데이터| 행 데이터(row data)| 데이터에 접근하기 위한 포인터 <br/>인덱스 컬럼 데이터 |
|개수 |테이블 당 1개| 테이블 당 여러 개|


### covering index
- 인덱스만으로 쿼리의 모든 데이터를 처리할 수 있는 인덱스 
- 데이터를 읽지 안혹, 인덱스 포함된 정보만으로 쿼리 가능한 인덱스 

### 계층형의 depth에 따라서 설계 방식
- 최대 2 depth :  Adjacency list (인접 리스트)
- 무한 depth :  • Path enumeration (경로 열거)

### record lock 
- 테이블 행 데이터에 락을 거느것 
- 동일한 레코드를 동시에 조회 또는 수정할 떄 데이터의 무결성 보장, 경쟁 상태 방지

### JPA for update 사용법
```java
// select ... for update
@Lock(LockModeType.PESSIMISTIC_WRITE)
Optional<ArticleLikeCount> findLockedByArticleId(Long articleId);
```

### redis 에는 디스크로의 데이터 백업을 위해, AOF와 RDB 기능을 제공한다. 
- AOF(Append Only File) : 수행된 명령어를 로그 파일에 기록하고, 복구를 위해 로그를 재실행한다. 
- RDB : 저장된 데이터를 주기적으로 파일에 저장한다. 

### kafka cluster
- 분산 이벤트 스트리밍 플랫폼으로 대규모 데이터를 실시간으로 처리하기 위해 사용 
- topic : 생산/소비되는 데이터를 논리적으로 구분하는 단위

### CQRS 
- command query responsibility segregation

### request collapsing 
- 여러 개의 동일하거나 유사한 요청을 하나의 요청으로 병합하여 처리하는 기법