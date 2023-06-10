# IOStream

## 목차

---

- I/O
- Stream
- Buffer
- InputStream / OutputStream
- Reader / Writer
- 파일 읽고 쓰기

---

<br/><br/><br/>

### I/O

---

- I/O는 Input과 Output의 약자이다.
  - Input은 데이터를 입력 받는 것 이다.
  - Output은 데이터를 출력 하는 것 이다.
- 프로그램의 외부에서 데이터를 조작하기 위해 사용한다.
- 자세한 내용은 Java Api Document에서 java.io를 확인하자.

<br/><br/><br/>

### Stream

---

- Stream은 데이터의 흐름이다.
  - 데이터가 시냇물처럼 한 방향으로 흐른다고 하여...
- 단방향으로 데이터를 통신한다.
  - FIFO(First In First Out) 구조이다.
- Stream은 통신하는 데이터의 크기에 따라 두 가지로 나뉜다.
  - ByteStream [ 1 Byte ]
  - CharacterStream [ 2 Byte ]
- 데이터의 크기만큼 읽어서 바로 전송한다.
  - 이로 인해 외부에 요청이 많아 성능상 단점이 존재한다.
- 스트림은 동기(순차) 방식으로 처리된다.

<br/><br/><br/>

### Buffer

---

- 고속 <-> 저속 장치 간의 속도 차이를 줄여주기 위해 사용하는 임시 공간이다.
- 데이터의 크기만큼 읽고 모아서 전송한다.
  - 이로 인해 외부에 한번에 요청하여 성능상 이점이 존재한다.
- 데이터의 전송 시점
  - 개행문자를 만난 경우
  - 버퍼가 가득 찬 경우
  - 강제로 전송(flush) 하는 경우

<br/><br/><br/>

### InputStream / OutputStream

---

- 바이트 단위의 입출력을 지원한다.
- 바이트 기반이여서 모든 데이터를 주고 받을 수 있다.
- InputStream과 OutputStream은 바이트 기반 Stream의 조상이다.
- 1 Byte를 기준으로 통신한다.

> 하위 클래스

|       InputStream       |       OutputStream       |
|:-----------------------:|:------------------------:|
|    AudioInputStream     |    AudioOutputStream     |
|  ByteArrayInputStream   |  ByteArrayOutputStream   |
|     FileInputStream     |     FileOutputStream     |
|    FilterInputStream    |    FilterOutputStream    |
|    ObjectInputStream    |    ObjectOutputStream    |
|    PipedInputStream     |    PipedOutputStream     |
|   SequenceInputStream   |   SequenceOutputStream   |
| StringBufferInputStream | StringBufferOutputStream |

<br/><br/><br/>

### Reader / Writer

---

- 문자 단위의 입출력을 지원한다.
- 문자 기반이여서 문자만 주고 받을 수 있다.
- Reader와 Writer는 문자 기반 Stream의 조상이다.
- 2 Byte를 기준으로 통신한다.

> 하위 클래스

|      Reader       |      Writer       |
|:-----------------:|:-----------------:|
|  BufferedReader   |  BufferedWriter   |
|  CharArrayReader  |  CharArrayWriter  |
|   FilterReader    |   FilterWriter    |
| InputStreamReader | InputStreamWriter |
|    PipedReader    |    PipedWriter    |
|   StringReader    |   StringWriter    |

<br/><br/><br/>

### 파일 읽고 쓰기

---

- 프로젝트 루트 디렉토리에 file.txt 파일을 생성하여 쓰고 읽어 본다.
- try - catch - finally와 try - with - resources를 모두 사용해 본다.
- File 클래스를 활용해 본다.

> try - catch - finally

````java
// try - catch - finally
InputStream inputStream = null;
OutputStream outputStream = null;

try {
  outputStream = new FileOutputStream("file.txt");
  outputStream.write(65);
  outputStream.write(66);
  outputStream.write(67);
  outputStream.write(68);
  outputStream.write(69);
}
catch (IOException e) {
  String ioExceptionMessage = e.getMessage();
  System.out.println("OutputStream IOException = " + ioExceptionMessage);
}
catch (Exception e) {
  String exceptionMessage = e.getMessage();
  System.out.println("OutputStream Exception = " + exceptionMessage);
}
finally {
  if (outputStream != null) {
    try {
        outputStream.close();
    }
    catch (IOException e) {
      String ioExceptionCloseMessage = e.getMessage();
      System.out.println("OutputStream Close IOException = " + ioExceptionCloseMessage);
    }
    catch (Exception e) {
      String exceptionCloseMessage = e.getMessage();
      System.out.println("OutputStream Close Exception = " + exceptionCloseMessage);
    }
  }
}
// =============================================================================
try {
  inputStream = new FileInputStream("file.txt");
  
  int readData;
  
  while ((readData = inputStream.read()) != -1) {
    System.out.println("readData = " + readData);
  }
}
catch (FileNotFoundException e) {
  String fileNotFoundExceptionMessage = e.getMessage();
  System.out.println("InputStream FileNotFound Exception = " + fileNotFoundExceptionMessage);
}
catch (IOException e) {
  String ioexceptionMessage = e.getMessage();
  System.out.println("InputStream Exception Message = " + ioexceptionMessage);
}
catch (Exception e) {
  String exceptionMessage = e.getMessage();
  System.out.println("InputStream Exception Message = " + exceptionMessage);
}
finally {
  if (inputStream != null) {
    try {
        inputStream.close();
    }
    catch (IOException e) {
      String ioexceptionCloseMessage = e.getMessage();
      System.out.println("InputStream Exception Message = " + ioexceptionCloseMessage);
    }
    catch (Exception e) {
      String exceptionCloseMessage = e.getMessage();
      System.out.println("InputStream Close Exception Message = " + exceptionCloseMessage);
    }
  }
}
// =============================================================================
// readData = 65
// readData = 66
// readData = 67
// readData = 68
// readData = 69
````

<br/>

> try - with - resources

```java
try (OutputStream outputStream = new FileOutputStream("file.txt")) {
  outputStream.write(65);
  outputStream.write(66);
  outputStream.write(67);
  outputStream.write(68);
  outputStream.write(69);
}
catch (IOException e) {
  String ioExceptionMessage = e.getMessage();
  System.out.println("OutputStream IOException = " + ioExceptionMessage);
}
catch (Exception e) {
  String exceptionMessage = e.getMessage();
  System.out.println("OutputStream Exception = " + exceptionMessage);
}
// =============================================================================
try (InputStream inputStream = new FileInputStream("file.txt")) {

  int readData;
  
  while (true) {
      readData = inputStream.read();
      if(readData == -1)
          break;
        System.out.println("readData = " + readData);
  }

}
catch (FileNotFoundException e) {
  String ioExceptionMessage = e.getMessage();
  System.out.println("InputStream FileNotFoundException = " + ioExceptionMessage);
}
catch (IOException e) {
  String exceptionMessage = e.getMessage();
  System.out.println("InputStream ExceptionMessage = " + exceptionMessage);
}
// =============================================================================
// readData = 65
// readData = 66
// readData = 67
// readData = 68
// readData = 69
```

<br/><br/><br/>