# buybook
도서를 구매할 수 있는 온라인 쇼핑몰 서비스

## Docker 설치 하기

먼저, 배포 환경을 내려받을 수 있도록 로컬 환경에 도커 엔진을 설치 합니다.

- [Windows 용 도커 설치 하기](https://docs.docker.com/desktop/windows/install/)

## Docker Hub에 배포한 이미지를 받아서 컨테이너로 실행하기

아래의 명령어를 실행하여 배포한 이미지를 받을 수 있습니다.

```bash
docker run -p 8080:8080 bloomspes/buybook
```

받은 이미지를 실행하기 위해 아래의 명령어를 입력합니다.
```bash
 docker run -it --rm --name api-server -v $(pwd)/build/libs:/home/api-server -p 80:8080 -e SPRING_PROFILES_ACTIVE=mariadb --network buybook openjdk:17 bash -c "java -jar /home/api-server/buybook-0.0.1-SNAPSHOT.jar"
```

받은 이미지를 확인하는 명령어는 다음과 같습니다.

```bash
docker images
```

## 배포한 서버에서 HTTP 요청 - 응답 확인하기
```
GET /products

상품 목록을 조회합니다.

http GET http://localhost/products
```

```
GET /products/{id}

상품의 상세 정보를 조회합니다.

http GET https://localhost/products/id
```
