[![](https://jitpack.io/v/eello/naneozoo-common.svg)](https://jitpack.io/#eello/naneozoo-common)

## nnz-common
나너주 서비스에 공통으로 필요한 기능을 라이브러리로 만든 레포지토리

### 기능
1. 공통 예외
- `CustomException, AbstractErrorCode`
  - 나너주 서비스에서 공통으로 쓰이는 커스텀 예외와 커스텀 예외에 넣는 에러코드의 추상화
  
2. MMSender
- 사용자의 요청에 대해 `CustomException`이 발생하면 `ControllerrAdvisor`를 통해 로그를 출력하고
- 연결된 MM 채널에 에러 메시지 전송

3. Request-Response Logger
- AOP를 활용해 모든 요청과 응답에 대한 로그 출력

4. KafkaMessage
- 나너주 서비스에서 공통으로 쓰일 `KafkaMessage<?>`와
- KafkaMessage를 Serialize/Deserialize할 `KafkaMessageUtils`

5. JwtDecode
- Jwt를 Decode해 `DecodedToken`을 반환하는 유틸 클래스 `JwtDecoder`
- 컨트롤러에서 Jwt 토큰 디코드가 필요할 때 파라미터에 `DecodedToken`을 추가하면 자동으로 디코드해서 값은 바인딩해주는 `JwtTokenDecodeResolver`
- 토큰을 검증하지는 않음

6. 기타
- 모든 Entity에 들어갈 `BaseEntity` 정의
- 페이징 응답 스펙을 맞추기위한 `PageDTO`

### 적용
- build.gradle
```groovy
// jitpack 레포지토리 추가
// repositories {
//     mavenCentral()
// }
allprojects {
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}

// 의존성 추가
dependencies {
  ...
  implementation 'com.github.eello:naneozoo-common:${Version}'
  ...
}
```
