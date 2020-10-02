package ru.kpfu.servlets;

import java.io.FileWriter;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVWriter;

public class FileSerializer {

    private User user;

    public FileSerializer(User user) {
        this.user = user;
    }

    public void writeInCSV(){
        String csv = "D:\\Projects\\Programming\\KFU\\itis_second_course\\First Semester\\HW №6\\servletExampleFirst\\src\\main\\java\\ru\\kpfu\\servlets\\data.csv";
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(csv, true));
            String[] record = (user.getEmail() + "," + user.getName() + "," + user.getPassword()).split(",");
            writer.writeNext(record);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
