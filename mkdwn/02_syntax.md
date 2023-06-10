# 문법

## 목차

---

- 제어문
  - break
  - continue
- 조건문
    - if
    - if else
    - switch case
- 반복문
    - for
    - forEach
    - while
    - do ~ while

---

<br/><br/><br/>

### break

---

- 조건 또는 반복 문법 실행을 중단 하고 다음 로직으로 이동 한다.
- 조건 또는 반복 문법을 탈출 한다.

<br/><br/><br/>

### continue

---

- 조건 또는 반복 문법 실행을 중단 하고 다음 분기로 이동 한다.
- 조건 또는 반복 문법의 다음 순번 로직을 실행 한다.

<br/><br/><br/>

### if

---

- 조건의 결과로 로직이 달라지는 문법이다.
- 조건의 결과 값은 boolean(true, false) 이다.

```java
boolean condition = true;

if( condition ) {
   // 조건이 참 일때 수행되는 로직
   System.out.println("condition is true");
}
// =========================================
// condition is true
```

<br/><br/><br/>

### if ~ else

---

- 조건이 True일 때와 False 일때 로직을 구분할 수 있다.
- 조건이 True일 때 if문 내부 로직을 수행 한다.
- 조건이 False일 때 else문 내부 로직을 수행 한다.

```java
   // this is code area
boolean trueCondition  = true;
boolean falseCondition = false;

//if( trueCondition ) {
if( falseCondition ) {
   // 조건이 참 일 때 수행되는 로직
   System.out.println("condition is true");
} else {
   // 조건이 거짓 일 때 수행되는 로직
   System.out.println("condition is false");
}
// ==========================================
// condition is false
```

<br/><br/><br/>

### if ~ else if ~ else

---

- 여러 조건이 존재하는 경우에 사용 된다.
- if문의 조건문이 맞지 않을 경우 else if문의 조건을 확인한다.
- 여러 조건이 맞지 않는 경우 else문 내부 로직을 수행 한다.

```java
int intValue = 10;

if (intValue == 0) {
    System.out.println("intValue의 값은 0 입니다.");
} else if (intValue > 10) {
    System.out.println("intValue의 값은 10 보다 큽니다.");
} else if (intValue == 10) {
    System.out.println("intValue의 값은 10 입니다.");
} else {
    System.out.println("모든 조건이 맞지 않을 경우 수행되는 로직입니다.");
}
// =======================================================================
// intValue의 값은 10 입니다.
```

<br/><br/><br/>

### switch ~ case

---

- 조건 값의 일치에 의해 로직이 변경 된다.
- 로직이 수행된 후에 break문이 존재하지 않으면 다음 로직을 수행 한다.
- 조건 값의 로직만 수행하고 싶으면 break문을 꼭 기술해 주어야 한다.

```java
String fooStr = "foo";
String barStr = "bar";
String bazStr = "baz";
String etcStr = "etc";

// switch(barStr) {
// switch(bazStr) {
// switch(etcStr) {
switch(fooStr) {
    case "foo":
        System.out.println("Hello foo");
        break;
    case "bar":
        System.out.println("Hello bar");
    case "baz":
        System.out.println("Hello baz");
        break;
    default:
        System.out.println("Hello etc");
        break;
}
// ======================================
// Hello foo
```

<br/><br/><br/>

### for

---

- 조건이 True가 아니면 반복해서 내부 로직을 수행 한다.
- for문의 인자값 설명 
  - int i = 1 :: 시작 값을 서술 한다.
  - i < 10    :: 조건을 서술 한다.
  - i = i + 1 :: 조건이 맞지 않을 경우 내부 로직 수행 후 i를 증가 시켜 준다.

```java
int dan = 2;
        
for (int i = 1; i < 10; i = i + 1) {
    int result = dan * i;
    System.out.println(dan + " * " + i + " = " + result);
}
// =====================================================
// 2 * 1 = 2
// 2 * 2 = 4
// 2 * 3 = 6
// 2 * 4 = 8
// 2 * 5 = 10
// 2 * 6 = 12
// 2 * 7 = 14
// 2 * 8 = 16
// 2 * 9 = 18
```

<br/><br/><br/>

### forEach

---

- for문의 다른 형태 이다.
- '여러 값을 소유 하고 있는 하나의 객체'를 하나씩 호출 한다.
- 불러온 객체는 수정이 불가능 하다.

```java
String[] studentNames = {"foo", "bar", "baz"};

for (String name : studentNames) {
  name = name + " !";
  System.out.println("student name is " + name);
}

System.out.println();
System.out.println(studentNames[0]);
System.out.println(studentNames[1]);
System.out.println(studentNames[2]);
// ===========================================
// student name is foo !
// student name is bar !
// student name is baz !
//
// foo
// bar
// baz
```

<br/><br/><br/>

### while

---

- 조건이 True일 때 까지 내부 로직을 반복 한다.
- '선 조건 후 로직' 형태 이다.
- 조건을 만족 하지 못하면 무한 루프(무한 재실행)의 늪에 빠진다.
- while문 내부 로직에 while문 조건을 만족할 수 있도록 로직을 추가 해야 한다.

```java
int dan = 3;
int increaseValue = 1;

while (increaseValue < 10) {
    int result = dan * increaseValue;

    System.out.println(dan + " * " + increaseValue + " = " + result);

    increaseValue = increaseValue + 1;
}
// ==================================================================
// 3 * 1 = 3
// 3 * 2 = 6
// 3 * 3 = 9
// 3 * 4 = 12
// 3 * 5 = 15
// 3 * 6 = 18
// 3 * 7 = 21
// 3 * 8 = 24
// 3 * 9 = 27
```

<br/><br/><br/>

### do ~ while

---

- 조건이 True일 때 까지 내부 로직을 반복 한다.
- '선 로직 후 조건' 형태 이다.
- while문과 다른 점은 do로직을 먼저 실행한 후 while조건을 확인 한다.
- 조건을 만족 하지 못하면 무한 루프(무한 재실행)의 늪에 빠진다.
- do문 내부 로직에 while문 조건을 만족할 수 있도록 로직을 추가 해야 한다.

```java
int dan = 4;
int increaseValue = 1;

do {
    
    int result = dan * increaseValue;

    System.out.println(dan + " * " + increaseValue + " = " + result);

    increaseValue = increaseValue + 1;

} while (increaseValue < 10);
// ===================================================================
// 4 * 1 = 4
// 4 * 2 = 8
// 4 * 3 = 12
// 4 * 4 = 16
// 4 * 5 = 20
// 4 * 6 = 24
// 4 * 7 = 28
// 4 * 8 = 32
// 4 * 9 = 36
```

<br/><br/><br/>