# HostManagement
*REST API 설명
1. 조회 API (GetMapping)
호스트 테이블에 등록/수정 시간 컬럼을 추가하여 조회 결과 필드에 포함되도록 설계하였습니다.
JPA를 활용하여 name으로 조회를 할 수 있도록 api를 구현하였습니다.
2. 등록 API (PostMapping)
name, ip 컬럼에 unique, not null 제약조건을 주어 null값과 중복된 값이 들어올수 없도록 설계하였습니다.
호스트 데이터의 값이 100개가 넘지 못하도록 구현하였습니다.
application 설정을 통해 서버가 재시작되어도 데이터베이스를 유지하도록 하였습니다.
service 내부에 컬럼 중복 로직을 넣어 예외처리를 하였습니다.
JPA를 활용하여 호스트의 정보를 등록 할 수 있도록 api를 구현하였습니다.
3. 수정 API (PatchMapping)
조회된 호스트정보를 수정할 수 있도록 하였습니다.
name 또는 ip 데이터가 변경될경우 데이터를 update하는 로직을 구현하였습니다.
4. 삭제 API (DeleteMapping)
조회된 호스트정보를 삭제할 수 있도록 하였습니다.
5. 현재 Alive 상태 조회 API (GetMapping)
InetAddress.isReachable()를 사용하여 PingCheck(0.5초)를 하였습니다.
Alive테이블을 만들어 호스트테이블과 1:1연관관계 매핑을 해주었습니다.
특정 호스트 조회시 연관관계에 의하여 alive테이블과 호스트테이블 데이터를 같이 리턴해주도록 하였습니다.
6. 호스트들의 Alive 모니터링 결과 조회 API (GetMapping)
마지막 alive시간을 포함하기위해 핑을 보냈을경우 alive상태가 변경되었을때 마지막alive시간을 update하는 로직을 구현하였습니다.
전체 조회 시 100개의 호스트가 모두 Unreachable 상태여도 조회를 1초 이내에 응답해야하기 위해
스레드를 사용하여 비동기 병렬처리를 하였습니다. (스레드 maxpoolsize(100)설정)
조회 시간을 확인하기위해 실행시간 Aop를 만들어 TimeTrace어노테이션을 추가하여 1초이내에 응답을하는지 확인해보았습니다.

*제약 사항

UI를 html mustach파일로 구현하여 Springframework.boot 버전이 2.6.7 버전 이하여야 utf-8이 정상적으로 작동합니다.<br/>
dependencies{<br/>
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'<br/>
	implementation 'org.springframework.boot:spring-boot-starter-mustache'<br/>
	implementation 'org.springframework.boot:spring-boot-starter-web'<br/>
	compileOnly 'org.projectlombok:lombok'<br/>
	annotationProcessor 'org.projectlombok:lombok'<br/>
	implementation group: 'org.mariadb.jdbc', name: 'mariadb-java-client', version: '2.4.1'<br/>
	testImplementation 'org.springframework.boot:spring-boot-starter-test'<br/>
}<br/>

*시험 결과 리스트
![image](https://user-images.githubusercontent.com/71069665/175227366-2819ccf1-fb53-4aef-a8cd-557180fe1156.png)

임의의 Unreachable상태인 100개의 호스트 조회 
![image](https://user-images.githubusercontent.com/71069665/175227989-2bf184c8-532c-44d6-afb2-d6dbba2d563a.png)


