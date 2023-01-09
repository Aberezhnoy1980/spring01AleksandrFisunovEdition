package ru.home.lesson2;

import java.io.FileOutputStream;
import java.io.IOException;

public class ReportMaker {
    public void createReport(String filename, String data) throws IOException {
        FileOutputStream out = null;
        if (filename.length() < 10) {
            throw new IOException("file not find");
        }
        out = new FileOutputStream(filename);
        out.write(data.getBytes());
        out.close();
    }
}
