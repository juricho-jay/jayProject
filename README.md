# jayProject
personal project   
Special Thanks to 👍 https://ssjeong.tistory.com/   👍 https://github.com/JeongSeongSoo

<br/>
<br/>

# 🐠📖 2023.01.25[jrcho]: <spring 세팅>
### 1. spring initializr     🔗https://start.spring.io/

    1-1. Gradle - Grooby / Language - Java / Spring Boot - 2.7.8
        * Spring Boot 3은 Java 14 버전부터 사용 가능 (Java 11 이후는 유료)
        
    1-2. Dependencies (lombok, spring web)
    
    1-3. generate (zip 파일 생성)
        * 원하는 위치에 압축 풀고 인텔리제이에서 프로젝트 열기

> 💬 2년 전에 국비학원에서 cmd 창으로 maven 프로젝트 생성하던 때가 기억났다.   
     그럼 그렇지. 개발자가 그렇게 귀찮은 짓을 할리가.


### 2. IntelliJ Setting   

    2-1. File > Settings > Build, Execution, Deployment > Build Tools > Gradle
          * Build and run : Build and run using / Run test using > IntelliJ IDEA로 설정
          * Gradle : Gradle JVM : Java 버전 (11)
    
    2-2. Project Settings > Project > SDK > Java 버전 (11)

### 3. Application.java 확인   

    3-1. 프로젝트명(jayri) > src > main > java > com > jayri > jayri > JayriApplication 
         * public static void main(String[] args) ~~ 확인
         * com.***.*** 아래에 패키지 생성 (Application과 같은 
         
### 4. 패키지 > Controller class 생성   

    4-1. public class Controller 위에 annotation 추가 (@RestController)
        * 패키지명: 소문자, 클래스: 대문자
        * @RestController = @Controller + @ResponseBody
        * @Controller : Model 객체에 데이터를 담고 View를 찾음 
        * @RestController : 객체만 반환 (JSON/XML)
    
> 💬 그런데, 요즘에는 서버에서 페이지를 다 그려서 클라이언트로 보내는 SSR(서버 사이드 렌더링)보다 (ex: JSP/PHP)   
  서버에서 데이터만 보내고 클라이언트인 브라우저가 화면(View)를 그리는 CSR(클라이언트 사이드 렌더링) 방식을 사용하기 때문에 (ex: Vue, React)
  거의 @RestController를 사용.
  
### 5. @GetMapping("/   슬래시 뒤에 URI 넣기  ")   

    5-1. URI(Uniform Resource Identifier): 통합 자원 식별자 (고유한 문자열 시퀀스) / URL: 웹주소
        * ex: jayri.com/index.html (URI: O / URL: O) | jayri.com/index (URI: O / URL: X)
    
    5-2. public void test() {} / public String test() { return 스트링무언가;}

> 💬 GetMapping은 주소 뒤에 쿼리스트링으로 데이터를 받아올 수 있기 때문에 브라우저 상에서 데이터 전달이 가능하지만 PostMapping은 PostMan으로 API 테스트를 해봐야함

### 6. @PostMapping("/login") - postman 테스트   
    6-1. 포스트맨 로그인 후 프로젝트용 Collections 생성
    6-2. Add Request
    6-3. POST 선택 / URI 작성
    6-4. Request 데이터 세팅 - Body, raw, JSON 선택 (Beautify 누르면 예쁘게 정렬!)
    6-5. @RequestBody > Map으로 받을 경우 모든 데이터를 받아오기 때문에 명시된 변수와 키 맵핑으로 받아오도록 VO(Value Object) 생성   

### 7. lombok (Getter, Setter, ToString, NoArgsConstructor, AllArgsConstructor) + required(true*/false)
   

# 🐠📖 2023.01.30[jrcho]: <Interceptor & JWT Token>
### 1. Interceptor
     1-1. Request > Controller로 가기 전 인터셉트 
