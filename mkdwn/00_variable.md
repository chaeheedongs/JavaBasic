# 자바 데이터 타입, 변수 그리고 배열

---

## 목차

---

- 데이터 타입
  - 데이터 타입 이란?
  - Primitive, Reference
  - 타입 테이블 표
- 변수
  - 변수란?
  - 선언 방식
  - 네이밍 방식
- 상수
  - 상수란?
  - 선언 방식
- 배열
  - 배열 이란?
  - 1차원 배열 선언 방식
  - 1차원 배열 예시
  - 2차원 배열 선언 방식
  - 2차원 배열 예시
- var
  - var 란?

---

<br/><br/><br/>


### 데이터 타입

---

[[ 참조 : 위키백과 ]](https://ko.wikipedia.org/wiki/%EC%9E%90%EB%A3%8C%ED%98%95#cite_note-1)

> 데이터 타입이란?

자료형(資料型) 또는 데이터 타입(영어: data type)은 컴퓨터 과학과  
프로그래밍 언어에서 실수치, 정수, 불린 자료형 따위의 **여러 종류의 데이터를 식별하는 분류**로서,  
더 나아가 해당 자료형에 대한 가능한 값, 해당 자료형에서 수행을 마칠 수 있는 명령들,  
데이터의 의미, 해당 자료형의 값을 저장하는 방식을 결정한다.  

자바에서 데이터 타입은 크게 **Primitive** 타입과 **Reference** 타입으로 나누어져 있다.  
Primitive 타입의 경우 원시 타입 으로도 불리며, 정수, 실수, 문자, 논리형 데이터를 저장하고,  
Reference 타입의 경우 참조 타입 으로도 불리며, Primitive 타입을 제외한 나머지를 저장하게 된다.

- Primitive (원시타입)
  - 특성
    - null(빈값)을 저장할 수 없다.
    - stack 메모리에서 관리 한다. (빠름)
  - 종류
      - 정수
          - byte
          - short
          - int
          - long
      - 실수
          - float
          - double
      - 문자
          - char
      - 논리
          - boolean
- Reference (참조타입)
  - 특성
    - null(빈값)을 저장할 수 있다.
    - heap 메모리에서 관리 한다. (느림)
  - 종류
      - Object

> 타입 테이블 표

|       |  타입   | 메모리 | 기본값  |                           범위                            |
|------:|:-------:|:------:|:-------:|:---------------------------------------------------------:|
|  정수 |  byte   | 1 byte |    0    |                       - 128 ~ + 127                       |
|  정수 |  short  | 2 byte |    0    |                    - 32,768 ~ + 32,767                    |
|  정수 |   int   | 4 byte |    0    |             - 2,147,483,648 ~ + 2,147,483,647             |
|  정수 |  long   | 8 byte |   0L    | - 9,223,372,036,854,775,808 ~ + 9,223,372,036,854,775,807 |
|  실수 |  float  | 4 byte |  0.0F   |              (3.4 X 10e-38) ~ (3.4 X 10e38)               |
|  실수 | double  | 8 byte |   0.0   |             (1.7 X 10e-308) ~ (1.7 X 10e308)              |
|  문자 |  char   | 2 byte | '\u000' |                       0 ~ + 65,535                        |
|  논리 | boolean | 1 byte |  false  |                        true, false                        |
|  객체 | Object  | 4 byte |  null   |                                                           |

```java
// Primitive Type
// 정수
byte    byteVariable    = 0;
short   shortVariable   = 0;
int     intVariable     = 0;
long    longVariable    = 0L;
// 실수
float   floatVariable   = 0.0f;
double  doubleVariable  = 0.0;
// 문자
char    charVariable    = ' ';
// 논리
boolean booleanVariable = false;

// Reference Type (Primitive Type 을 제외한 나머지)
String stringVariable = "This is String";
LocalDate localDateVariable = LocalDate.now();
LocalDateTime localDateTimeVariable = LocalDateTime.now();

// Primitive 출력
System.out.println("[정수] byteVariable   : " + byteVariable);
System.out.println("[정수] shortVariable  : " + shortVariable);
System.out.println("[정수] intVariable    : " + intVariable);
System.out.println("[정수] longVariable   : " + longVariable);
System.out.println("[실수] floatVariable  : " + floatVariable);
System.out.println("[실수] doubleVariable : " + doubleVariable);
System.out.println("[문자] charVariable   : " + charVariable);
System.out.println("[논리] booleanVariable: " + booleanVariable);

// Reference 출력
System.out.println("[객체] stringVariable : " + stringVariable);
System.out.println("[객체] localDateVariable : " + localDateVariable);
System.out.println("[객체] localDateTimeVariable : " + localDateTimeVariable);

// --------------------------------------------------------------------------------
// [정수] byteVariable   : 0
// [정수] shortVariable  : 0
// [정수] intVariable    : 0
// [정수] longVariable   : 0
// [실수] floatVariable  : 0.0
// [실수] doubleVariable : 0.0
// [문자] charVariable   :
// [논리] booleanVariable: false
// [객체] stringVariable : This is String
// [객체] localDateVariable : 2022-05-29
// [객체] localDateTimeVariable : 2022-05-29T16:29:00.033679

```

<br/><br/><br/>

### 변수

---

[[ 참조 : 위키백과 ]](https://ko.wikipedia.org/wiki/%EB%B3%80%EC%88%98)

> 변수란?

- 변수는 수학에서 쓰이는 수식에 따라서 **변하는 값**을 뜻한다.
- 변수는 컴퓨터 프로그래밍에서 아직 알려지지 않거나  
어느 정도까지만 알려져 있는 양이나 정보에 대한 상징적인 이름이다.  
  
변수는 ' 접근제한자 자료형 변수명; ' 으로 선언할 수 있으며, 변수에 값 할당은 ' 접근제한자 변수명 = 값; ' 으로 할당할 수 있다.  
위 내용을 ' 접근제한자 자료형 변수명 = 값; ' 으로 한번에 할 수도 있다.  

변수를 표기하는 방법은 [이곳](https://dev-heedong.tistory.com/11) 에서 확인한다.

아래 코드를 참고 하자.  

```java
// 변수의 선언 - ( ' 자료형 변수명; ' )
int intVariable1;

// 변수의 값 할당 - ( ' 변수명 = 값; ' )
intVariable1 = 1;

// 변수의 선언과 동시에 값 할당 - ( ' 자료형 변수명 = 값; ' )
int intVariable2 = 2;
```

<br/><br/><br/>

### 상수

---

[[ 참조 : 위키백과 ]](https://ko.wikipedia.org/wiki/%EC%83%81%EC%88%98)

> 상수란?

- 상수란 수식에서 **변하지 않는 값**을 뜻한다. 이것은 변하는 값 변수와 반대이다.
- 상수란 **변하지 않고, 항상 일정한 값을 갖는 수**를 말한다.  

상수란 변하지 않는(불변) 값을 뜻하며, 주로 등급과 같은 값을 저장할때 사용한다.  
상수는 변수와 다르게 선언과 동시에 값을 할당(초기화)해 주어야 하며,  
전역 변수로 선언해 주어야 한다. (지역변수 불가)  
' 접근제한자 static final 자료형 변수명 = 값; ' 으로 선언과 동시에 값을 할당한다.

```java
static final String BRONZE_GRADE   = "BRONZE";
static final String SILVER_GRADE   = "SILVER";
static final String GOLD_GRADE     = "GOLD";
static final String PLATINUM_GRADE = "PLATINUM";
static final String DIA_GRADE      = "DIA";
static final String MASTER_GRADE   = "MASTER";

// 상수 출력
System.out.println("[상수] BRONZE_GRADE : "   + BRONZE_GRADE);
System.out.println("[상수] SILVER_GRADE : "   + SILVER_GRADE);
System.out.println("[상수] GOLD_GRADE : "     + GOLD_GRADE);
System.out.println("[상수] PLATINUM_GRADE : " + PLATINUM_GRADE);
System.out.println("[상수] DIA_GRADE : "      + DIA_GRADE);
System.out.println("[상수] MASTER_GRADE : "   + MASTER_GRADE);

// ----------------------------------------
// [상수] BRONZE_GRADE : BRONZE
// [상수] SILVER_GRADE : SILVER
// [상수] GOLD_GRADE : GOLD
// [상수] PLATINUM_GRADE : PLATINUM
// [상수] DIA_GRADE : DIA
// [상수] MASTER_GRADE : MASTER
```

<br/><br/><br/>


### 배열

---

[[참조 : 위키백과]](https://ko.wikipedia.org/wiki/%EB%B0%B0%EC%97%B4)

> 배열이란 ?

컴퓨터 과학에서 **배열은 번호(인덱스)와 번호에 대응하는 데이터들로 이루어진 자료 구조**를 나타낸다.  
일반적으로 배열에는 **같은 종류의 데이터들이 순차적으로 저장**되어,  
값의 번호가 곧 배열의 시작점으로부터 값이 저장되어 있는 상대적인 위치가 된다.  
대부분의 프로그래밍 언어에서 사용할 수 있는 가장 기초적인 자료 구조로,  
기본적인 용도 외에 다른 복잡한 자료 구조들을 표현하기 위해서  
행렬, 벡터 등을 컴퓨터에서 표현하는 용도 등으로도 사용된다.  

배열은 **크기가 정해진 같은 자료형의 묶음**이라고 생각하면 된다.  
과자를 예로 들면 과자 봉지의 크기는 일정하고, 과자 봉지 안에 같은 과자들이 들어 있다.  

1차원 배열의 선언 방법은 두가지 방식이 존재한다.  

- 선언과 동시에 값을 할당(초기화) 하는 방식
- 선언 후 순차적으로 값을 할당(초기화) 하는 방식

처음으로 ' 접근제한자 자료형[] 변수명 = new 자료형[크기]{ ... }; ' 와 같이 선언과 동시에 값을 할당(초기화) 할 수 있으며,  
두번째로 ' 접근제한자 자료형[] 변수명 = new 자료형[크기]; ' 와 같이 선언만 하고 ' 변수명[주소] = 값; ' 으로 값을 할당(초기화) 할 수 있다.

```java
// 1차원 배열 - 선언과 동시에 할당
int[] intArr1 = new int[]{0, 1, 2, 3, 4};

// intArr1 출력
System.out.println("intArr1[0]  = " + intArr1[0]);
System.out.println("intArr1[1]  = " + intArr1[1]);
System.out.println("intArr1[2]  = " + intArr1[2]);
System.out.println("intArr1[3]  = " + intArr1[3]);
System.out.println("intArr1[4]  = " + intArr1[4]);

// -----------------------------------------------
// intArr1[0]  = 0
// intArr1[1]  = 1
// intArr1[2]  = 2
// intArr1[3]  = 3
// intArr1[4]  = 4
```

```java
// 1차원 배열 - 선언 후 순차적 할당
int[] intArr2 = new int[5];
intArr2[0] = 0;
intArr2[1] = 1;
intArr2[2] = 2;
intArr2[3] = 3;
intArr2[4] = 4;

// intArr2 출력
System.out.println("intArr2[0]  = " + intArr2[0]);
System.out.println("intArr2[1]  = " + intArr2[1]);
System.out.println("intArr2[2]  = " + intArr2[2]);
System.out.println("intArr2[3]  = " + intArr2[3]);
System.out.println("intArr2[4]  = " + intArr2[4]);

// -----------------------------------------------
// intArr2[0]  = 0
// intArr2[1]  = 1
// intArr2[2]  = 2
// intArr2[3]  = 3
// intArr2[4]  = 4
```

2차원 배열의 선언 방법 또한 두가지 방식이 존재한다.  

- 선언과 동시에 값을 할당(초기화) 하는 방식
- 선언 후 순차적으로 값을 할당(초기화) 하는 방식

처음으로 ' 접근제한자 자료형[][] 변수명 = new 자료형[크기][크기]{ { ... }, { ... } }; ' 와 같이 선언과 동시에 값을 할당(초기화) 할 수 있으며,  
두번째로 ' 접근제한자 자료형[][] 변수명 = new 자료형[크기][크기]; ' 와 같이 선언만 하고 ' 변수명[주소][주소] = 값; ' 으로 값을 할당(초기화) 할 수 있다.

```java
// 2차원 배열 - 길이 추정
int[][] intArr3 = new int[][]{{0, 1}, {2, 3}};

// 2차원 배열 - 길이 지정
int[][] intArr4 = new int[2][2];
intArr4[0][0] = 0;
intArr4[0][1] = 1;
intArr4[1][0] = 2;
intArr4[1][1] = 3;

// intArr3 출력
System.out.println("intArr3[0][0]  = " + intArr3[0][0]);
System.out.println("intArr3[0][1]  = " + intArr3[0][1]);
System.out.println("intArr3[1][0]  = " + intArr3[1][0]);
System.out.println("intArr3[1][1]  = " + intArr3[1][1]);

// intArr4 출력
System.out.println("intArr4[0][0]  = " + intArr4[0][0]);
System.out.println("intArr4[0][1]  = " + intArr4[0][1]);
System.out.println("intArr4[1][0]  = " + intArr4[1][0]);
System.out.println("intArr4[1][1]  = " + intArr4[1][1]);

// -----------------------------------------------------
// intArr3[0][0]  = 0
// intArr3[0][1]  = 1
// intArr3[1][0]  = 2
// intArr3[1][1]  = 3
// intArr4[0][0]  = 0
// intArr4[0][1]  = 1
// intArr4[1][0]  = 2
// intArr4[1][1]  = 3
```

<br/><br/><br/>

### var

---

> var 란?

- Java 10 부터 var를 사용할 수 있다.
- Java 11 부터 람다식에서 사용할 수 있다.
- var 키워드는 자료형 대신 들어간다.
- 컴파일러가 var 키워드 변수의 타입을 컴파일 할 때 추론한다.
- null 값이 들어갈 수 없다.
- 선언과 동시에 초기화를 해야 한다.
- 지역변수로만 사용이 가능하다.

```java
//        var foo;        // Cannot infer type: 'var' on variable without initializer
//        var foo = null; // Variable 'foo' is already defined in the scope
var foo = "hello foo";

if (foo instanceof String) {
System.out.println("var : " + foo);
}
// -----------------------------------------------------
// var : hello foo
```