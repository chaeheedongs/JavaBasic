package iostream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

    public static void main(String[] args) {

        InputStream inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }

            @Override
            public int read(byte[] b) throws IOException {
                return super.read(b);
            }

            @Override
            public int read(byte[] b, int off, int len) throws IOException {
                return super.read(b, off, len);
            }

            @Override
            public byte[] readAllBytes() throws IOException {
                return super.readAllBytes();
            }

            @Override
            public byte[] readNBytes(int len) throws IOException {
                return super.readNBytes(len);
            }

            @Override
            public int readNBytes(byte[] b, int off, int len) throws IOException {
                return super.readNBytes(b, off, len);
            }

            @Override
            public long skip(long n) throws IOException {
                return super.skip(n);
            }

            @Override
            public int available() throws IOException {
                return super.available();
            }

            @Override
            public synchronized void mark(int readlimit) {
                super.mark(readlimit);
            }

            @Override
            public synchronized void reset() throws IOException {
                super.reset();
            }

            @Override
            public boolean markSupported() {
                return super.markSupported();
            }

            @Override
            public long transferTo(OutputStream out) throws IOException {
                return super.transferTo(out);
            }

            @Override
            public void close() throws IOException {
                super.close();
            }
        };
// =============================================================================
        OutputStream outputStream = new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }

            @Override
            public void write(byte[] b) throws IOException {
                super.write(b);
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                super.write(b, off, len);
            }

            @Override
            public void flush() throws IOException {
                super.flush();
            }

            @Override
            public void close() throws IOException {
                super.close();
            }
        };
    }
}
