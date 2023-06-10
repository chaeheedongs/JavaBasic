package iostream.file;

import java.io.*;
import java.nio.file.Path;
import java.util.Properties;

public class FileBasic {

    public static void main(String[] args) throws IOException {

//        // try - catch - finally
//        InputStream inputStream = null;
//        OutputStream outputStream = null;
//
//        try {
//            outputStream = new FileOutputStream("file.txt");
//            outputStream.write(65);
//            outputStream.write(66);
//            outputStream.write(67);
//            outputStream.write(68);
//            outputStream.write(69);
//        }
//        catch (IOException e) {
//            String ioExceptionMessage = e.getMessage();
//            System.out.println("OutputStream IOException = " + ioExceptionMessage);
//        }
//        catch (Exception e) {
//            String exceptionMessage = e.getMessage();
//            System.out.println("OutputStream Exception = " + exceptionMessage);
//        }
//        finally {
//            if (outputStream != null) {
//                try {
//                    outputStream.close();
//                }
//                catch (IOException e) {
//                    String ioExceptionCloseMessage = e.getMessage();
//                    System.out.println("OutputStream Close IOException = " + ioExceptionCloseMessage);
//                }
//                catch (Exception e) {
//                    String exceptionCloseMessage = e.getMessage();
//                    System.out.println("OutputStream Close Exception = " + exceptionCloseMessage);
//                }
//            }
//        }
//        // =====================================================================
//        try {
//            inputStream = new FileInputStream("file.txt");
//
//            int readData;
//         // 더이상 읽읅게 없으면 -1을 반환
//            while ( (readData = inputStream.read()) != -1 ) {
//                System.out.println("readData = " + readData);
//            }
//        }
//        catch (FileNotFoundException e) {
//            String fileNotFoundExceptionMessage = e.getMessage();
//            System.out.println("InputStream FileNotFound Exception = " + fileNotFoundExceptionMessage);
//        }
//        catch (IOException e) {
//            String ioexceptionMessage = e.getMessage();
//            System.out.println("InputStream Exception Message = " + ioexceptionMessage);
//        }
//        catch (Exception e) {
//            String exceptionMessage = e.getMessage();
//            System.out.println("InputStream Exception Message = " + exceptionMessage);
//        }
//        finally {
//            if (inputStream != null) {
//                try {
//                    inputStream.close();
//                }
//                catch (IOException e) {
//                    String ioexceptionCloseMessage = e.getMessage();
//                    System.out.println("InputStream Exception Message = " + ioexceptionCloseMessage);
//                }
//                catch (Exception e) {
//                    String exceptionCloseMessage = e.getMessage();
//                    System.out.println("InputStream Close Exception Message = " + exceptionCloseMessage);
//                }
//            }
//        }

        // =====================================================================

//        // try - with - resources
//        try (OutputStream outputStream = new FileOutputStream("file.txt")) {
//            outputStream.write(65);
//            outputStream.write(66);
//            outputStream.write(67);
//            outputStream.write(68);
//            outputStream.write(69);
//        }
//        catch (IOException e) {
//            String ioExceptionMessage = e.getMessage();
//            System.out.println("OutputStream IOException = " + ioExceptionMessage);
//        }
//        catch (Exception e) {
//            String exceptionMessage = e.getMessage();
//            System.out.println("OutputStream Exception = " + exceptionMessage);
//        }
//
//        // =====================================================================
//
//        try (InputStream inputStream = new FileInputStream("file.txt")) {
//
//            int readData;
//
//            while (true) {
//                readData = inputStream.read();
//                if(readData == -1)
//                    break;
//                System.out.println("readData = " + readData);
//            }
//
//        }
//        catch (FileNotFoundException e) {
//            String ioExceptionMessage = e.getMessage();
//            System.out.println("InputStream FileNotFoundException = " + ioExceptionMessage);
//        }
//        catch (IOException e) {
//            String exceptionMessage = e.getMessage();
//            System.out.println("InputStream ExceptionMessage = " + exceptionMessage);
//        }

        // =====================================================================

//        String filePath = "study" + File.separator
//                + "src" + File.separator
//                + "iostream" + File.separator
//                + "file";
//
//        String fileName = "test.txt";
//
//        File file = new File(filePath + fileName);
//
//        String absolutePath = file.getAbsolutePath();
//        File absoluteFile = file.getAbsoluteFile();
//        String path = file.getPath();
//        String name = file.getName();
//        file.get
//
//        System.out.println("absolutePath = " + absolutePath);
//        System.out.println("absoluteFile = " + absoluteFile);
//        System.out.println("path = " + path);
//        System.out.println("name = " + name);
//
//
//        if (!file.exists()) {
//            try {
//                file.createNewFile();
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        try (OutputStream outputStream = new FileOutputStream(file)) {
//
//            if (file.canWrite()) {
//                outputStream.write(97);
//                outputStream.write(98);
//            }
//        }
//        catch (Exception e) {
//
//        }
    }
}
