# buybook

도서를 구매할 수 있는 온라인 쇼핑몰 서비스.

## REST Docs 문서 생성

```bash
./gradlew asciidoctor
```

```bash
open build/docs/asciidoc/index.html
```

## 로컬에서 Jar 빌드하고 실행하기

```bash
./gradlew bootJar
```

```bash
java -jar build/libs/buybook-*.jar
```

## MariaDB 사용하도록 Jar 실행

먼저 MariaDB 서버 띄우기.

```bash
docker run -d --name buybook-mariadb \
  -p 3306:3306 \
  -e MYSQL_ROOT_PASSWORD=password \
  -e MYSQL_DATABASE=buybook \
  mariadb \
  --character-set-server=utf8mb4 \
  --collation-server=utf8mb4_unicode_ci

docker logs -f buybook-mariadb
```

환경변수로 DB 정보 전달하면서 실행.

```bash
SPRING_PROFILES_ACTIVE=mariadb \
DB_HOST=localhost \
DB_PORT=3306 \
DB_DATABSE=buybook \
DB_USERNAME=root \
DB_PASSWORD=password \
java -jar build/libs/buybook-*.jar
```

## Docker 빌드하고 Docker Hub에 올리기

```bash
./gradlew clean bootJar

docker build -t buybook .

docker tag buybook bloomspes/buybook

docker push bloomspes/buybook
```

Docker Hub: <https://hub.docker.com/r/bloomspes/buybook>

## API 문서

<https://codesoom-project.github.io/buybook-project/>

### HTTPie로 확인

상품 목록 조회:

```bash
http GET http://localhost/products
```

상품 상세 정보 조회:

```bash
http GET https://localhost/products/{id}
```
