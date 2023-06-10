# Annotation

## 목차

---

- Annotation
- Annotation 정의하는 방법
- @Retention
- @Target
- @Documented

---

<br/><br/><br/>

### Annotation

---

- Java 5 버전에서 등장했다.
- java.lang.annotation
- 데이터를 위한 데이터를 제공한다. (메타데이터)
- XML 기반에서 어노테이션기반으로 발전했다.
  - 이로 인해 유지보수성이 높아졌다.
  - 이로 인해 생산성이 높아졌다.
- Annotation 장점
  - 생산성과 유지보수성이 용이하다.
  - 컴파일 단계에서 코드의 문법을 관리해 준다. (IDE)
  - 코드가 깔끔해 진다.
- Annotation 종류
  - 내장 어노테이션
    - Java에서 지원해주는 어노테이션이다.
  - 사용자 정의 어노테이션
    - 사용자가 정의한 어노테이션이다.
  - 메타 어노테이션
    - 어노테이션의 기능을 지원하는 어노테이션이다.

<br/><br/><br/>

### Annotation 정의하는 방법

---

- Annotation은 인터페이스 이다.
- @interface 키워드로 선언한다.
- 어노테이션 타입(메타 어노테이션)을 알맞게 추가한다.

```java
@Target
@Retention
@Documented
public @interface MyAnnotation {
  // ...
}
```

<br/><br/><br/>

### @Retention

---

- 메타 어노테이션의 한 종류 이다.
- 어노테이션의 유지 범위를 지정한다.

|    종류   | 설명                         |
|:---------:|------------------------------|
|  SOURCE   | 컴파일 이 후 삭제            |
|   CLASS   | 컴파일이 되어도 유지         |
|  RUNTIME  | 컴파일 및 런타임에 사용 가능 |

```java
// public enum RetentionPolicy {
//   SOURCE,
//   CLASS,
//   RUNTIME
// }
// =============================================================================
@Retention(RetentionPolicy.SOURCE)
public @interface MyAnnotation {
  // ...
}
```

<br/><br/><br/>

### @Target

---

- 메타 어노테이션의 한 종류 이다.
- 어노테이션을 사용할 수 있는 타켓을 지정한다.

|       종류      | 설명                            |
|:---------------:|:--------------------------------|
|      TYPE       | 타입 (클래스,인터페이스,열거형) |
|      FIELD      | 필드                            |
|     METHOD      | 메서드                          |
|    PARAMETER    | 매개변수                        |
|   CONSTRUCTOR   | 생성자                          |
| LOCAL_VARIABLE  | 지역변수                        |
| ANNOTATION_TYPE | 어노테이션                      |
|     PACKAGE     | 패키지                          |
| TYPE_PARAMETER  | 타입 매개변수(JAVA 1.8)         |
|    TYPE_USE     | 타입이 사용 되는 곳(JAVA 1.8)   |
|     MODULE      | 모듈(JAVA 1.9)                  |

```java
//public enum ElementType {
//  TYPE,
//  FIELD,
//  METHOD,
//  PARAMETER,
//  CONSTRUCTOR,
//  LOCAL_VARIABLE,
//  ANNOTATION_TYPE,
//  PACKAGE,
//  /**
//   * Type parameter declaration
//   *
//   * @since 1.8
//   */
//  TYPE_PARAMETER,
//  /**
//   * Use of a type
//   *
//   * @since 1.8
//   */
//  TYPE_USE,
//  /**
//   * Module declaration.
//   *
//   * @since 9
//   */
//  MODULE
//}
// =============================================================================
@Target({ElementType.FIELD})
public @interface MyAnnotation {
  // ...
}
```

<br/><br/><br/>

### @Documented

---

- 메타 어노테이션의 한 종류 이다.
- javadoc 문서에 해당 코드의 정보를 등록한다.
- 문서 생성 방법
  - 프롬프트(cmd)창에 접속한다.
  - 문서를 만드려는 프로젝트의 src/java/main 까지 이동한다.
  - 패키지가 있는 경로를 지정한다.
  - 문서를 생성한다.
  - ```shell
    computer$ cd src/java/main
    computer$ javadoc -sourcepath ./ doc_test
    computer$ javadoc ./*.java
    ```
- @Documented 어노테이션 종류
  - @author
  - @since
  - @version
  - @deprecated
  - @param
  - @return
  - @serial
  - @serialData
  - @serialField
  - @throws
  - 기타 등등...

```java
@Documented
public @interface MyAnnotation {
  // ...
}
```

<br/><br/><br/>

### @Inherited

---

- 메타 어노테이션의 한 종류 이다.
- 상속 관계에 있는 자식 클래스에게도 에너테이션이 적용되도록 한다.

```java
@Inherited
public @interface MyAnnotation {
  // ...
}
```

<br/><br/><br/>

### @Repeatable

---

- 메타 어노테이션의 한 종류 이다.
- 어노테이션 중복 선언을 허용한다.

```java
// =============================================================================
@Target(ElementType.LOCAL_VARIABLE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Fruits {
  Fruit[] value();
}
// =============================================================================
@Repeatable(Fruits.class)
public @interface Fruit {
  String value();
}
// =============================================================================
public class Main {

  public static void main(String[] args) {

    @Fruit("apple")
    @Fruit("banana")
    String fruitName;
    
  }
}
```

<br/><br/><br/>