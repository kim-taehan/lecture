# Aidev Backend
**Aidev의 Backend**는 `Layered Architecture`를 활용하여 설계됐습니다.\
또한 하나의 Repository Project 하위에 멀티 모듈을 구성하여 `Monorepo` 구조를 활용합니다.\
Aidev에서 활용할 Repository의 패키지구조를 소개합니다.
기본적으로 PIMS 의 구조를 따릅니다.

## 패키지 구조
```plaintext
aidev-backend                                  # 프로젝트 명
├─ gradle                                     # Gradle Wrapper
|
├─ aidev-common                                # 공통 서비스
|  ├─ src.main
|  |  ├─ java.skcc.pims.common
|  |  |  ├─ [feature A]                       # 기능A에 대한 패키지
|  |  |  |  ├─ controller                     # controller
|  |  |  |  ├─ dto
|  |  |  |  |  ├─ query                       # query DTO - queryDSL에서 단일 Entity 조회가 아닌 경우 사용
|  |  |  |  |  ├─ request                     # request DTO - request를 받기 위한 DTO
|  |  |  |  |  └─ response                    # response DTO - response를 주기 위한 DTO
|  |  |  |  ├─ repository                     # repository interface
|  |  |  |  |  └─ impl                        # repository implements - queryDSL활용은 이 패키지를 활용
|  |  |  |  └─ service                        # service interface
|  |  |  |     └─ impl                        # service implements
|  |  |  ├─ [feature B]                       # 기능B에 대한 패키지
|  |  |  └─ PimsCommonApplication.java        # 공통 서비스 실행 Class
|  |  └─ resources
|  |     ├─ application.yaml                  # Application 설정 파일 - 전체 설정
|  |     ├─ application-dev.yaml              # Application 설정 파일 - Develop 환경 설정
|  |     └─ application-prd.yaml              # Application 설정 파일 - Production 환경 설정
|  └─ build.gradle                            # root에서 공통으로 설정된 dependency 이외에 모듈별 독립적인 추가 설정
|
├─ aidev-core                                  # Core 모듈 - 각 서비스에서 모듈 형태로 활용
|  ├─ src.main
|  |  ├─ java.skcc.pims.core
|  |  |  ├─ aop                               # 공통 aop
|  |  |  ├─ config                            # 설정
|  |  |  ├─ entity                            # JPA Entity
|  |  |  ├─ exceoption                        # 예외처리
|  |  |  ├─ response                          # 공통 응답 객체
|  |  |  └─ util                              # 공통 util method
|  |  └─ resources
|  |     ├─ application.yaml                  # Application 설정 파일 - 전체 설정
|  |     ├─ application-dev.yaml              # Application 설정 파일 - Develop 환경 설정
|  |     └─ application-prd.yaml              # Application 설정 파일 - Production 환경 설정
|  └─ build.gradle                            # root에서 공통으로 설정된 dependency 이외에 모듈별 독립적인 추가 설정
|
├─ .gitignore                                 # git 제외 설정
├─ build.gradle                               # gradle build 파일 -root에서 작성되어, 하위 모듈에 적용
├─ gradlew                                    # gradle 실행파일
├─ gradlew.bat                                # gradle 실행파일
└─ settings.gradle                            # gradle을 구성하는 구조를 정의
```