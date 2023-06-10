# 연산자

---

## 목차

---

- 연산자
- 피연산자
- 산술 연산자
- 비트 연산자
- 관계 연산자
- 논리 연산자
- instanceof
- 대입 연산자
- 화살표 연산자
- 삼항 연산자
- 연산자 우선 순위

---

<br/><br/><br/>

### 연산자

---

- Operator
- 연산에 사용되는 기호이다.
- 다양한 종류의 연산이 있다.

<br/><br/><br/>

### 피연산자

---

- Operand
- 연산에 들어가는 대상을 피 연산자라고 한다.

<br/><br/><br/>

### 산술 연산자

---

- Arithmetic Operator
- 산술과 관련된 연산자다.
- 왼쪽의 피연산자와 오른쪽의 피연산자를 연산한다.

| --- |  ------  | -----------------------------------------------------------|
|:---:|:------:|:-------------------------------------------------------------|
|  +  |  덧셈  | 왼쪽의 피연산자와 오른쪽의 피연산자를 더한다.                |
|  -  |  뺄셈  | 왼쪽의 피연산자와 오른쪽의 피연산자를 뺀다.                  |
|  *  |  곱셈  | 왼쪽의 피연산자와 오른쪽의 피연산자를 곱한다.                |
|  /  | 나눗셈 | 왼쪽의 피연산자와 오른쪽의 피연산자를 나눈다.                |
|  %  | 나머지 | 왼쪽의 피연산자와 오른쪽의 피연산자를 나눈 나머지값을 구한다.|


```java
int plus      = 1 + 1;
int minus     = 1 - 1;
int multiply  = 1 * 1;
int divide    = 1 / 1;
int remainder = 1 % 1;
System.out.println("1 + 1 = " + plus);
System.out.println("1 - 1 = " + minus);
System.out.println("1 * 1 = " + multiply);
System.out.println("1 / 1 = " + divide);
System.out.println("1 % 1 = " + remainder);
//==========================================
// 1 + 1 = 2
// 1 - 1 = 0
// 1 * 1 = 1
// 1 / 1 = 1
// 1 % 1 = 0
```

<br/><br/><br/>

### 비트 연산자

---

[[ 참고 : TCPSCHOOL ]](http://www.tcpschool.com/c/c_refer_bitCalculation)

- Bitwise Operator
- 비트(bit) 단위로 연산 하는 연산자이다.
- 2진 데이터로 연산 한다.

| 기호 |   연산  |  연산식   | 설명                                            |
|:----:|:-------:|:---------:|:------------------------------------------------|
|  &   |   AND   |   1 & 1   | 두 비트가 1일때만 1, 다르면 0을 반환            |
|  l   |   OR    |   1 & 0   | 두 비트중 하나라도 1이 있으면 1, 아니면 0을 반환|
|  ^   |   XOR   |   1 ^ 1   | 두 비트가 같으면 1, 아니면 0을 반환             |
|  ~   |   NOT   |    1 ~    | 비트의 반전을 반환 1 ~ 은 0                     |
|  <<  | LSHIFT  | 0001 << 2 | 0001 << 2 = 0100 (1 => 4)                       |
|  >>  | RSHIFT  | 0100 >> 2 | 0100 >> 2 = 0001 (4 => 1)                       |

<br/><br/><br/>

### 관계 연산자

---

- Relational Operator
- 피연산자 사이의 크기를 판단 한다.
- 피연산자가 큰지, 작은지, 같은지, 다른지 판별 한다.
- 판별한 결과값으로 논리값(boolean)을 되돌려 준다.

|  기호 |  연산 |  연산식  | 설명                   |
|:-----:|:-----:|:--------:|:-----------------------|
|   >   |  gt   |  a > b   | a가 b보다 크다.        |
|  >=   |  ge   |  a >= b  | a가 b보다 크거나 같다. |
|   <   |  lt   |  a < b   | a가 b보다 작다.        |
|  <=   |  le   |  a <= b  | a가 b보다 작거나 같다. |
|  ==   |  eq   |  a == b  | a가 b보다 같다.        |
|  !=   |  ne   |  a != b  | a가 b보다 다르다.      |

```java
int big   = 10;
int small = 1;
System.out.println("big > small = " + (big > small));
System.out.println("big >= small = " + (big >= small));
System.out.println("big < small = " + (big < small));
System.out.println("big <= small = " + (big <= small));
System.out.println("big == small = " + (big == small));
System.out.println("big != small = " + (big != small));
//=====================================================
// big > small = true
// big >= small = true
// big < small = false
// big <= small = false
// big == small = false
// big != small = true
```

<br/><br/><br/>

### 논리 연산자

---

- Logical Operator
- 여러 논리식을 비교하는 연산자다.
- 이항 연산자로 'AND' 와 'OR' 이 존재하며, 단항 연산자로 'NOT' 이 존재한다.
- 결과값으로 논리값(boolean)을 되돌려 준다.

| 기호 | 연산 | 설명                                                |
|:----:|:----:|:----------------------------------------------------|
|  &&  |  AND | 양쪽이 True일 때 True, 아니면 False                 |
|  ll  |  OR  | 한쪽이라도 True일 때 True, 양쪽 다 False이면 False  |
|   !  |  NOT | 논리값의 반대                                       |

```java
// AND Operator
System.out.println("true && true = "   + (true && true));
System.out.println("true && false = "  + (true && false));
System.out.println("false && true = "  + (false && true));
System.out.println("false && false = " + (false && false));

// OR Operator
System.out.println("true || true = "   + (true || true));
System.out.println("true || false = "  + (true || false));
System.out.println("false || true = "  + (false || true));
System.out.println("false || false = " + (false || false));

// NOT Operator
System.out.println("!true = "  + !true);
System.out.println("!false = " + !false);
// ========================================================
// true && true = true
// true && false = false
// false && true = false
// false && false = false
// true || true = true
// true || false = true
// false || true = true
// false || false = false
// !true = false
// !false = true
```

<br/><br/><br/>

### instanceof

---

- 객체의 타입을 확인하는 연산자이다.
  - 변수가 참조하고 있는 인스턴스의 타입을 확인할 수 있다.
- 객체의 타입을 변환할 수 있는 여부를 확인 하기도 한다. (상속)
- instanceof 연산자 기준으로 왼쪽에 객체가 오른쪽에 타입이 들어간다.
  - Object instanceof Type

```java
// 객체의 타입을 확인하는 연산자이다.
String stringType = "Hello World!";
System.out.println("stringType instanceof String = " + stringType instanceof String);
//===================================================================================
// stringType instanceof String = true
```

```java
class Unit { }
class Marine extends Unit { }
class Medic  extends Unit { }
class Starcraft {
    public static void main(String[] args) {

        Marine marine = new Marine();
        Medic medic   = new Medic();

        System.out.println("marine instanceof Unit = " + marine instanceof Unit);
        System.out.println("medic instanceof Unit = "  + medic instanceof Unit);
    }
}
//==================================================
// marine instanceof Unit = true
// medic instanceof Unit = true
```


<br/><br/><br/>

### 대입 연산자

---

- Assignment Operator
- 변수에 값을 대입할 때 사용하는 연산자이다.
- 대입 연산자를 기준으로 왼쪽은 변수 오른쪽은 값이다.
  - 변수 = 값
- 대입 연산자 앞에 산술, 비트 연산자와 혼합 하여 사용할 수 있다.
  - 혼합하여 사용시 자기 자신과 값을 산술,비트 연산 하여 자기 자신에게 저장한다.

```java
// 대입 연산자
int variable = 5;
System.out.println("variable : " + variable);

// 산술 + 대입 연산자
variable += 2;
System.out.println("variable += 2 : " + variable);
variable -= 2;
System.out.println("variable -= 2 : " + variable);
variable *= 2;
System.out.println("variable *= 2 : " + variable);
variable /= 2;
System.out.println("variable /= 2 : " + variable);
variable %= 2;
System.out.println("variable %= 2 : " + variable);

// 비트 + 대입 연산자
variable &= 2;
System.out.println("variable &= 2 : " + variable);
variable |= 2;
System.out.println("variable |= 2 : " + variable);
variable ^= 2;
System.out.println("variable ^= 2 : " + variable);
variable <<= 2;
System.out.println("variable ^= 2 : " + variable);
variable >>= 2;
System.out.println("variable ^= 2 : " + variable);
variable >>>= 2;
System.out.println("variable ^= 2 : " + variable);
//================================================
// variable : 5
// variable += 2 : 7
// variable -= 2 : 5
// variable *= 2 : 10
// variable /= 2 : 5
// variable %= 2 : 1
// variable &= 2 : 0
// variable |= 2 : 2
// variable ^= 2 : 0
// variable ^= 2 : 0
// variable ^= 2 : 0
// variable ^= 2 : 0
```

<br/><br/><br/>

### 화살표 연산자

---

- Arrow Operator
- Java 8 에서 도입 되는 람다 표현식의 구문 이다.
- 화살표 연산자를 기준으로 왼쪽에 파라미터 오른쪽에 로직이 들어간다.
  - ( parameter ) -> { logic }

```java
Runnable r = new Runnable() {
    @Override
    public void run() {
    }
};

r = () -> { System.out.println("Hello World"); };
r.run();
//================================================
// Hello World
```

<br/><br/><br/>

### 삼항 연산자

---

- Ternary Operator
- 조건식을 기준으로 조건식이 참일 때와 거짓일 때 다르게 처리할 수 있다.
- 문법중에 if문과 비슷하다.
  - if 문의 가독성과 삼항 연산자의 숏 코딩은 항상 논쟁이 된다.
- 문법
  - 조건식 ? 참일 때 반환 값 : 거짓일 때 반환 값

```java
boolean setVariable = 1 == 1 ? true : false;

String strVariable;
strVariable = 1 != 1 ? "Hello" : "World !";

System.out.println("setVariable = " + setVariable);
System.out.println("strVariable = " + strVariable);
//=================================================
// setVariable = true
// strVariable = World !
```

<br/><br/><br/>

### 연산자 우선 순위

---

> 연산자 우선 순위 표

| 순위 | 연산자                                      |
|-----:|:--------------------------------------------|
|    1 | (), []                                      |
|    2 | !, ~, ++, --                                |
|    3 | *, /, %                                     |
|    4 | +, -                                        |
|    5 | <<, >>, >>>                                 |
|    6 | <, <=, >, >=                                |
|    7 | ==, !=                                      |
|    8 | &                                           |
|    9 | ^                                           |
|   10 | l                                           |
|   11 | &&                                          |
|   12 | ll                                          |
|   13 | ?:                                          |
|   14 | =, +=, -=, *=, /=, %=, <<=, >>=, &=, ^=, ~= |