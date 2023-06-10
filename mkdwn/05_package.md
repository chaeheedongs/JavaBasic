# Package, Import, Classpath, 접근제한자

## 목차

---

- package 키워드
- import 키워드
- 클래스 패스
- 접근제한자

---

<br/><br/><br/>

### package 키워드

---

- 각 클래스나 인터페이스를 효율적으로 관리 한다.
- 패키지를 관리함으로써 같은 이름이더라도 충돌이 일어나지 않는다.
- 디렉터리를 계층적으로 관리하며 계층의 사이는 ' . ' 으로 표기 한다.
- package를 기술하지 않으면 JVM이 해당 클래스나 인터페이스를 찾지 못한다.

```java
// Project
//     l
//     l- src
//     l   l- com
//     l       l- naver
//     l             l- domain
//     l                   l- Naver.java
//     l- // etc directory
// =============================================================================
package com.naver.domain;
// com 디렉토리 내부에
// naver 디렉토리 내부에
// domain 디렉토리 내부

public class Naver {
    
}

```

<br/><br/><br/>

### import 키워드

---

- 외부 패키지의 클래스를 현재 자신의 클래스로 불러 온다.
- import를 하지 않으면 코드에서 전체 경로를 작성 해야 한다.
  - 이로 인해 코드의 가독성이 떨어 진다.
  - 매번 전체 경로를 입력하는 것 도 일이다.
- import를 하면 해당 경로의 클래스만 작성해서 호출할 수 있다.

```java
package com.study.java.vo;

public class Aclass {
  
}
// =============================================================================

package com.study.java.dto;

import com.study.java.vo.Aclass;

public class Bclass {
  
  // import를 하지 않은 경우
  // com.study.java.vo.Aclass aClass = new Aclass();

  // import를 한 경우
  Aclass aclass = new Aclass();
}

```

<br/><br/><br/>

### 클래스 패스

---

- 클래스를 찾기 위한 경로 이다.
- JVM이 .class 파일을 찾아 가는 기준이 되는 경로 이다.
  - .java 파일 컴파일 -> .class 파일 생성
- 설정방법
  - 컴퓨터의 환경변수를 지정
  - java runtime -classpath flag

<br/><br/><br/>

### 접근제한자

---

- 클래스, 인터페이스, 추상클래스 외 기타 등등에 대해 접근 권한을 부여할 수 있다.
- 접근을 권한별로 나눌 수 있다.
  - 정보를 은닉할 수 있다는 장점이 있다.
- 접근 권한에 따라 외부에서의 적집적인 접근 범위를 허용시키지 않는다.
- 접근 제한 순서
  - public > protected > default > private
- 종류
  - private
    - scope : 같은 클래스
  - default
    - scope : 같은 패키지
  - protected
    - scope : 자식 클래스
  - public
    - scope : 전체

<br/>

|   접근제한자   | 같은 클래스  |  같은 패키지  |  자식 클래스 |  기타 |
|:---------:|:------------:|:-------------:|:------------:|:-----:|
|  private  |      O       |       X       |      X       |   X   |
|  default  |      O       |       O       |      X       |   X   |
| protected |      O       |       O       |      O       |   X   |
|  public   |      O       |       O       |      O       |   O   |

<br/><br/><br/>