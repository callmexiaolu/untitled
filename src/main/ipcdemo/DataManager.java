package main.ipcdemo;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class DataManager {

    public void writeMethod(PipedOutputStream out) {
        try {
            System.out.println("write: ");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                out.write(outData.getBytes());
                System.out.println(outData);
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMethod(PipedInputStream in) {
        try {
            System.out.println("read: ");
            byte[] readBuffer = new byte[20];
            //如果没有数据写入，线程会阻塞在in.read处，直到有数据被写入才继续向下运行
            int readLength = in.read(readBuffer);
            while (readLength != -1) {
                String newData = new String(readBuffer, 0, readLength);
                System.out.println(newData);
                readLength = in.read(readBuffer);
            }
            System.out.println();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
