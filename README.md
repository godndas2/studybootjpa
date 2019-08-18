## Springboot 2.x / SpringSecurity / Jpa / H2 / Oauth2.0
## ISSUE
Spring Boot의 기본 설정 Spring Security 에서 H2 데이터 베이스 콘솔에 접근을 차단함.  
H2 접속을 위해 SecurityConfiguration.java 클래스에 아래와 같이 설정해준다.  
- /console/* 의 URL접근 허용  
- CRSF(Cross-Site Request Forgery) 중지. 기본 값이고, CRSF 공격에 대하여 방어  
- H2 데이터베이스 콘솔이 frame 안에서 동작 하도록 하는 Spring Security 옵션  
- root url("/") 에 대한 요청 허용
- H2 데이터베이스 콘솔 url("/console/*") 요청에 대한 허용
- CSRF 중지
- X-Frame-Options in Spring Security 중지  

> Configure setting을 할 때 아래와 같이 세팅해주었다.  
.antMatchers("/h2-console/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf()
                .ignoringAntMatchers("/h2-console/**")
                .and()
                .headers()
                .addHeaderWriter(new StaticHeadersWriter("X-Content-Security-Policy","script-src 'self'"))
                .frameOptions().disable()  

2019-08-18  
id,pw 받고, 로그인 시 No AuthenticationProvider found for org.springframework.security.authentication.UsernamePasswordAuthenticationToken

## Memo
- 2019.08.18 User.java, Role.java (x) Account.java 사용 중

