# 1. Clean Architecture 구현

프로젝트를 다음과 같이 나누었음

- module-core: 순수 엔티티
- module-dataprovider: 데이터 영속화 계층
- module-usecase: 유스케이스
- module-app: REST 애플리케이션

## 1.1 module-core

순수 엔티티가 위치한다. 고차 컴포넌트(High Order Component)가 위치하는 곳.  
의존성이 없고 순수 POJO 집합

## 1.2 module-dataprovider

데이터 영속화를 담당한다. 순수하지 않은 곳.  

## 1.3 module-usecase

유스케이스

## 1.4 module-app

이 모든 것을 조립해서 사용하는 애플리케이션

# 2. Requirements

```text
$ docker run -d -p 1521:1521 -p 8080:81 -e H2_OPTIONS='-ifNotExists' --name=local_h2 oscarfonts/h2:1.4.199
```