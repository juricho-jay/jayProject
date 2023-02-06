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
   

<br/>
<br/>
# 🐠📖 2023.01.30[jrcho]: Map & Set & Iterator
### 1. Map의 키 값만 가져오기
     1-1. key/value
     1-2. map의 키값만 가져오고 싶다면...? => Set<String> set = map.keySet();
     1-3. set은 중복값을 가져올 수 없음 (Map의 key는 중복될 수 없음)
     1-4. set은 특별한 순서가 없음. 따라서 인덱스가 없기 때문에 List처럼 가져오는 것이 불가능
     1-5. iterator에 담아서 next로 하나씩 가져와야함
     1-6. ite.hasNext() 있으면 true, 없으면 false
     1-7. true일 때 ite.next()로 해당 값 변수에 담기
     1-8. 그리고 뒤에 리스트에 넣든 후처리
   
### 2. Map의 키에 특정 문자가 담겨있는지 조회하기
    2-1. map.containsKey(오브젝트);
    2-2. 리턴값이 boolean이기 때문에, System.out.println에서는 그대로 넣어서 쓸 수 있지만, 
         log.info()처럼 String이나 다른 타입으로 받는 경우에는 형변환이 필요 (String.valueOf())
    2-3. set에는 순서가 없는데 정렬되는 것을 보아하니, iterator()가 기본으로 정렬해주는듯
    
> 💬 @Test 어노테이션 > 자바 단위 테스트 Java Unit Test
    
    
# 🐠📖 2023.01.30[jrcho]: Interceptor & JWT Token

### 1. build.gradle > dependencies 설정
    1-1. implementation("io.jsonwebtoken:jjwt:0.9.1")
         implementation('javax.xml.bind:jaxb-api:2.4.0-b180830.0359')
### 2. resources > application.properties
    2-1. server.port=1234 포트 설정   
         (default port: http(80), https(443) / JDBC default port: oracle(1521), PostgreSQL(5432), Tibero(8629), MySQL/MariaDB(3306))
    2-2. (customizable) 원하는 대로 설정 (.으로 구분) ex:  jwt.token.key= * (*에 고유 토큰 secretKey) 
         * properties에 넣는 이유는 보안상 소스 코드나 로그에 노출되지 않도록 하기 위해   
         
### 3. Key값 생성 전 세팅
    3-1. JWTService 생성 > init 메서드 생성 + @PostConstruct 
         * @PostConstruc : 의존성 주입이 끝나고 bean이 초기화된 후 WAS가 올라가기 전 딱 한 번 실행됨 (bean이 여러번 초기화되는 것 방지)
           bean : Spring에 의해 생성되고 관리되는 자바 객체
           
         * Filter에서 쓰려다가 안돼서 띠용 했는데, Filter는 스프링 컨텍스트 외부에 존재하기 때문에 스프링 컨텍스트인 @PostConstruct 사용불가  
    3-2. 2-2에서 설정한 프로퍼티 값 주입 (@Value 사용 - 주의:lombok이 아닌 bean의 Value)

# 🐠📖 2023.02.05[jrcho]: AOPConfig & Logback & Process&Thread 

### 1. AOP (Aspect Oriented Programming)