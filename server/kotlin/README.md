# Kotlin 기반 서비스

## 개요

- User, Item, Payment 등 Battle 서비스에 비해 상대적으로 실시간성이 많이 요구되지 않고 외부 인프라(DB, Kafka, Web Client) 서비스들은 Kotlin, Spring 기반 서비스 로 구현한다.
- Kafka Streams, Protocol Buffer를 기반으로 서비스간 통신을 구현한다.

## 아키텍처


### 코드 아키텍처


#### Repository 인터페이스 위치

- Repository 인터페이스를 usecase 모듈이 아닌 domain 모듈 내에 위치시킵니다.
  - Port와 Adapter 패턴을 사용함에도 불구하고 Repository 인터페이스를 domain 모듈에 위치시키는 이유는 다음과 같습니다.
- Domain 모듈에 위치시키는 이유
  - 도메인 중심성: Repository는 도메인 엔티티와 밀접하게 연관되어 있으며 도메인 모델의 영속성을 다룹니다. 이를 domain 모듈에 배치함으로써 도메인 관심사를 아키텍처의 중심에 두는 원칙에 부합합니다.
  - 의존성 방향: Domain 모듈은 가장 독립적인 계층이어야 하며 외부로의 의존성이 없어야 합니다. Repository 인터페이스를 이곳에 배치함으로써 이 원칙을 유지하고 domain이 외부 계층에 의존하는 것을 방지합니다.
  - 재사용성: Domain 모듈에 있는 repository 인터페이스는 불필요한 의존성을 만들지 않고 여러 usecase에서 쉽게 재사용할 수 있습니다.
  - 응집도: 이 접근 방식을 통해 도메인 관련 인터페이스를 한 곳에 모아 domain 모듈의 전반적인 응집도를 높일 수 있습니다.
