# Spring + Docker + Nginx 배포하기
- default : 8080
- real1 : 8081
- real2 : 8082

<br>

## nginx 잘 동작하는지 확인하기
### 1. docker로 nginx 실행
- Mac OS 경우 /etc/apache2/httpd.conf파일에 들어가서 Listen 80 주석 처리해줘야 됨
~~~
$ docker run -p 80:80 nginx # nginx 실행
~~~
### 2. http://localhost로 확인
"Welcome to nginx!" 페이지뜨면 확인 
- Mac OS 경우 /etc/apache2/httpd.conf파일에 들어가서 Listen 80 주석 처리해줘야 됨


<br>

## docker로 profile별로 spring 실행하기
~~~
$ docker run --name spring-nginx-app -p 9090:8080 -e SPRING_PROFILE=default spring-nginx-app.jar
$ docker run --name spring-nginx-app -p 9090:8081 -e SPRING_PROFILE=real1 spring-nginx-app.jar
$ docker run --name spring-nginx-app -p 9090:8082 -e SPRING_PROFILE=real2 spring-nginx-app.jar
~~~

<br>

## docker-compose로 spring + nginx 실행하기
docker-compose.yml
~~~
version: '3'

services:
  nginx:
    container_name: spring-nginx
    image: nginx
    restart: always
    ports:
      - 80:80
    volumes:
      - ./nginx/conf.d:/etc/nginx/conf.d
    depends_on:
      - spring-nginx-app

  spring-nginx-app:
    restart: always
    build: .
    ports:
      - 8080:8081
    volumes:
    - ./app:/app
    - ~/.m2:/root/.m2
    environment:
      - "SPRING_PROFILE=real1"
~~~

<br>

app.conf
~~~
server{
  listen 80;
  charset utf-8;
  access_log off;

  location / {
    proxy_pass http://spring-nginx-app:8081; # spring-nginx-app은 스프링 앱 컨테이너 이름, 8081 포트는 spring port와 매칭 
      proxy_set_header Host $host:$server_port;
    proxy_set_header X-Forwarded-Host $server_name;
    proxy_set_header X-Real-IP $remote_addr;
    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
  }

  location /static {
    access_log off;
    expires 30d;

    alias /app/static;
  }
}
~~~

<br>

## 실행 후 테스트
- Run command `docker-compose up`
- Access to `http://localhost`


<br>

ret
- https://hellokoding.com/docker-compose-with-spring-boot-nginx/
