# jayProject
personal project   
Special Thanks to ๐ https://ssjeong.tistory.com/   ๐ https://github.com/JeongSeongSoo

<br/>
<br/>

# ๐ ๐ 2023.01.25[jrcho]: <spring ์ธํ>
### 1. spring initializr     ๐https://start.spring.io/

    1-1. Gradle - Grooby / Language - Java / Spring Boot - 2.7.8
        * Spring Boot 3์ Java 14 ๋ฒ์ ๋ถํฐ ์ฌ์ฉ ๊ฐ๋ฅ (Java 11 ์ดํ๋ ์ ๋ฃ)
        
    1-2. Dependencies (lombok, spring web)
    
    1-3. generate (zip ํ์ผ ์์ฑ)
        * ์ํ๋ ์์น์ ์์ถ ํ๊ณ  ์ธํ๋ฆฌ์ ์ด์์ ํ๋ก์ ํธ ์ด๊ธฐ

> ๐ฌ 2๋ ์ ์ ๊ตญ๋นํ์์์ cmd ์ฐฝ์ผ๋ก maven ํ๋ก์ ํธ ์์ฑํ๋ ๋๊ฐ ๊ธฐ์ต๋ฌ๋ค.   
     ๊ทธ๋ผ ๊ทธ๋ ์ง. ๊ฐ๋ฐ์๊ฐ ๊ทธ๋ ๊ฒ ๊ท์ฐฎ์ ์ง์ ํ ๋ฆฌ๊ฐ.


### 2. IntelliJ Setting   

    2-1. File > Settings > Build, Execution, Deployment > Build Tools > Gradle
          * Build and run : Build and run using / Run test using > IntelliJ IDEA๋ก ์ค์ 
          * Gradle : Gradle JVM : Java ๋ฒ์  (11)
    
    2-2. Project Settings > Project > SDK > Java ๋ฒ์  (11)

### 3. Application.java ํ์ธ   

    3-1. ํ๋ก์ ํธ๋ช(jayri) > src > main > java > com > jayri > jayri > JayriApplication 
         * public static void main(String[] args) ~~ ํ์ธ
         * com.***.*** ์๋์ ํจํค์ง ์์ฑ (Application๊ณผ ๊ฐ์ 
         
### 4. ํจํค์ง > Controller class ์์ฑ   

    4-1. public class Controller ์์ annotation ์ถ๊ฐ (@RestController)
        * ํจํค์ง๋ช: ์๋ฌธ์, ํด๋์ค: ๋๋ฌธ์
        * @RestController = @Controller + @ResponseBody
        * @Controller : Model ๊ฐ์ฒด์ ๋ฐ์ดํฐ๋ฅผ ๋ด๊ณ  View๋ฅผ ์ฐพ์ 
        * @RestController : ๊ฐ์ฒด๋ง ๋ฐํ (JSON/XML)
    
> ๐ฌ ๊ทธ๋ฐ๋ฐ, ์์ฆ์๋ ์๋ฒ์์ ํ์ด์ง๋ฅผ ๋ค ๊ทธ๋ ค์ ํด๋ผ์ด์ธํธ๋ก ๋ณด๋ด๋ SSR(์๋ฒ ์ฌ์ด๋ ๋ ๋๋ง)๋ณด๋ค (ex: JSP/PHP)   
  ์๋ฒ์์ ๋ฐ์ดํฐ๋ง ๋ณด๋ด๊ณ  ํด๋ผ์ด์ธํธ์ธ ๋ธ๋ผ์ฐ์ ๊ฐ ํ๋ฉด(View)๋ฅผ ๊ทธ๋ฆฌ๋ CSR(ํด๋ผ์ด์ธํธ ์ฌ์ด๋ ๋ ๋๋ง) ๋ฐฉ์์ ์ฌ์ฉํ๊ธฐ ๋๋ฌธ์ (ex: Vue, React)
  ๊ฑฐ์ @RestController๋ฅผ ์ฌ์ฉ.
  
### 5. @GetMapping("/   ์ฌ๋์ ๋ค์ URI ๋ฃ๊ธฐ  ")   

    5-1. URI(Uniform Resource Identifier): ํตํฉ ์์ ์๋ณ์ (๊ณ ์ ํ ๋ฌธ์์ด ์ํ์ค) / URL: ์น์ฃผ์
        * ex: jayri.com/index.html (URI: O / URL: O) | jayri.com/index (URI: O / URL: X)
    
    5-2. public void test() {} / public String test() { return ์คํธ๋ง๋ฌด์ธ๊ฐ;}

> ๐ฌ GetMapping์ ์ฃผ์ ๋ค์ ์ฟผ๋ฆฌ์คํธ๋ง์ผ๋ก ๋ฐ์ดํฐ๋ฅผ ๋ฐ์์ฌ ์ ์๊ธฐ ๋๋ฌธ์ ๋ธ๋ผ์ฐ์  ์์์ ๋ฐ์ดํฐ ์ ๋ฌ์ด ๊ฐ๋ฅํ์ง๋ง PostMapping์ PostMan์ผ๋ก API ํ์คํธ๋ฅผ ํด๋ด์ผํจ

### 6. @PostMapping("/login") - postman ํ์คํธ   
    6-1. ํฌ์คํธ๋งจ ๋ก๊ทธ์ธ ํ ํ๋ก์ ํธ์ฉ Collections ์์ฑ
    6-2. Add Request
    6-3. POST ์ ํ / URI ์์ฑ
    6-4. Request ๋ฐ์ดํฐ ์ธํ - Body, raw, JSON ์ ํ (Beautify ๋๋ฅด๋ฉด ์์๊ฒ ์ ๋ ฌ!)
    6-5. @RequestBody > Map์ผ๋ก ๋ฐ์ ๊ฒฝ์ฐ ๋ชจ๋  ๋ฐ์ดํฐ๋ฅผ ๋ฐ์์ค๊ธฐ ๋๋ฌธ์ ๋ช์๋ ๋ณ์์ ํค ๋งตํ์ผ๋ก ๋ฐ์์ค๋๋ก VO(Value Object) ์์ฑ   

### 7. lombok (Getter, Setter, ToString, NoArgsConstructor, AllArgsConstructor) + required(true*/false)
   

<br/>
<br/>
# ๐ ๐ 2023.01.30[jrcho]: Map & Set & Iterator
### 1. Map์ ํค ๊ฐ๋ง ๊ฐ์ ธ์ค๊ธฐ
     1-1. key/value
     1-2. map์ ํค๊ฐ๋ง ๊ฐ์ ธ์ค๊ณ  ์ถ๋ค๋ฉด...? => Set<String> set = map.keySet();
     1-3. set์ ์ค๋ณต๊ฐ์ ๊ฐ์ ธ์ฌ ์ ์์ (Map์ key๋ ์ค๋ณต๋  ์ ์์)
     1-4. set์ ํน๋ณํ ์์๊ฐ ์์. ๋ฐ๋ผ์ ์ธ๋ฑ์ค๊ฐ ์๊ธฐ ๋๋ฌธ์ List์ฒ๋ผ ๊ฐ์ ธ์ค๋ ๊ฒ์ด ๋ถ๊ฐ๋ฅ
     1-5. iterator์ ๋ด์์ next๋ก ํ๋์ฉ ๊ฐ์ ธ์์ผํจ
     1-6. ite.hasNext() ์์ผ๋ฉด true, ์์ผ๋ฉด false
     1-7. true์ผ ๋ ite.next()๋ก ํด๋น ๊ฐ ๋ณ์์ ๋ด๊ธฐ
     1-8. ๊ทธ๋ฆฌ๊ณ  ๋ค์ ๋ฆฌ์คํธ์ ๋ฃ๋  ํ์ฒ๋ฆฌ
   
### 2. Map์ ํค์ ํน์  ๋ฌธ์๊ฐ ๋ด๊ฒจ์๋์ง ์กฐํํ๊ธฐ
    2-1. map.containsKey(์ค๋ธ์ ํธ);
    2-2. ๋ฆฌํด๊ฐ์ด boolean์ด๊ธฐ ๋๋ฌธ์, System.out.println์์๋ ๊ทธ๋๋ก ๋ฃ์ด์ ์ธ ์ ์์ง๋ง, 
         log.info()์ฒ๋ผ String์ด๋ ๋ค๋ฅธ ํ์์ผ๋ก ๋ฐ๋ ๊ฒฝ์ฐ์๋ ํ๋ณํ์ด ํ์ (String.valueOf())
    2-3. set์๋ ์์๊ฐ ์๋๋ฐ ์ ๋ ฌ๋๋ ๊ฒ์ ๋ณด์ํ๋, iterator()๊ฐ ๊ธฐ๋ณธ์ผ๋ก ์ ๋ ฌํด์ฃผ๋๋ฏ
    
> ๐ฌ @Test ์ด๋ธํ์ด์ > ์๋ฐ ๋จ์ ํ์คํธ Java Unit Test
    
    
# ๐ ๐ 2023.01.30[jrcho]: Interceptor & JWT Token

### 1. build.gradle > dependencies ์ค์ 
    1-1. implementation("io.jsonwebtoken:jjwt:0.9.1")
         implementation('javax.xml.bind:jaxb-api:2.4.0-b180830.0359')
### 2. resources > application.properties
    2-1. server.port=1234 ํฌํธ ์ค์    
         (default port: http(80), https(443) / JDBC default port: oracle(1521), PostgreSQL(5432), Tibero(8629), MySQL/MariaDB(3306))
    2-2. (customizable) ์ํ๋ ๋๋ก ์ค์  (.์ผ๋ก ๊ตฌ๋ถ) ex:  jwt.token.key= * (*์ ๊ณ ์  ํ ํฐ secretKey) 
         * properties์ ๋ฃ๋ ์ด์ ๋ ๋ณด์์ ์์ค ์ฝ๋๋ ๋ก๊ทธ์ ๋ธ์ถ๋์ง ์๋๋ก ํ๊ธฐ ์ํด   
         
### 3. Key๊ฐ ์์ฑ ์  ์ธํ
    3-1. JWTService ์์ฑ > init ๋ฉ์๋ ์์ฑ + @PostConstruct 
         * @PostConstruc : ์์กด์ฑ ์ฃผ์์ด ๋๋๊ณ  bean์ด ์ด๊ธฐํ๋ ํ WAS๊ฐ ์ฌ๋ผ๊ฐ๊ธฐ ์  ๋ฑ ํ ๋ฒ ์คํ๋จ (bean์ด ์ฌ๋ฌ๋ฒ ์ด๊ธฐํ๋๋ ๊ฒ ๋ฐฉ์ง)
           bean : Spring์ ์ํด ์์ฑ๋๊ณ  ๊ด๋ฆฌ๋๋ ์๋ฐ ๊ฐ์ฒด
           
         * Filter์์ ์ฐ๋ ค๋ค๊ฐ ์๋ผ์ ๋ ์ฉ ํ๋๋ฐ, Filter๋ ์คํ๋ง ์ปจํ์คํธ ์ธ๋ถ์ ์กด์ฌํ๊ธฐ ๋๋ฌธ์ ์คํ๋ง ์ปจํ์คํธ์ธ @PostConstruct ์ฌ์ฉ๋ถ๊ฐ  
    3-2. 2-2์์ ์ค์ ํ ํ๋กํผํฐ ๊ฐ ์ฃผ์ (@Value ์ฌ์ฉ - ์ฃผ์:lombok์ด ์๋ bean์ Value)

# ๐ ๐ 2023.02.05[jrcho]: AOPConfig & Logback & Process&Thread 

### 1. AOP (Aspect Oriented Programming)

# ๐ ๐ 2023.02.18[jrcho]: React & Spring Boot ์ฐ๋

### 1. spring initializr > settings (java version, build and run > intelliJ IDEA)

### 2. terminal > install react

### 3. react default port: 3000 

### 4. proxy setting for CORS Policy 

### 5. front-end axios setting

### 6. back-end controller setting

### 7. buil.gradle setting > When Spring Boot build your project, React project will be built first.

### 8. home directory (cd %userprofile%) > gradle build

> port ์์  > npm start์์ set PORT=3002 && ์ถ๊ฐ

### 9. When it is successfully built, there is jar file in build/libs