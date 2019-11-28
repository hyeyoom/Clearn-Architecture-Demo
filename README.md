# Clean Architecture 구현

프로젝트를 다음과 같이 분리하였음

- module-core: 순수 엔티티
- module-dataprovider: 데이터 영속화 계층
- module-usecase: 유스케이스
- module-app: REST 애플리케이션