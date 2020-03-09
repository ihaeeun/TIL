# Interceptor란?
- 컨트롤러에 들어오는 요청 HttpRequest와 컨트롤러가 응답하는 HttpResponse를 가로채는 역할
- 관리자만 접근할 수 있는 관리자 페이지에 접근하기 전에 관리자 인증을 하는 용도로 활용될 수 있음
- DispatcherServlet이 실행된 후 호출됨

### 필요성
- 특정 url 진입 시 인가된 사용자가 접근 시
- 특정 url 진입 시 JWT와 같은 토큰 검사
- 특정 url의 경우 계정 권한에 따라 접근 제어

<br>

# HandlerInterceptor
## 개요
- Spring에서 Custom interceptor를 등록할 때 사용하는 **인터페이스**.
- interceptor는 주로 검증, 보안, 로깅 등 시스템 내에서 전체적으로 적용되어야 할 기능 수행
- Interceptor는 HandlerInterceptor를 상속받아 구현

<br>

## Spring에서 Interceptor 동작
### preHandle
- 요청 시 Controller로 진입하기 직전에 실행
- return 타입 : boolean
- false를 return 하면 요청 거부
### postHandle
- 요청 시 Controller에서 return 되는 과정에서 실행
- postHandle에 도달하기 전에 Exception이 발생하면 이후의 postHandle은 생략
### afterCompletion
- Exception이 발생해도 반드시 실행됨

<br>

## Interceptor 사용방법
- WebConfig에서 WebMvcConfigurer 인터페이스를 상속받아 구현
    - addInterceptors() : 등록할 인터셉터 설정