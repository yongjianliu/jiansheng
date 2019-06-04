package com.guoyunyu.jiansheng.my.tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * desc
 *
 * @author Yongjian.Liu
 * @date 2019/1/9 16:46
 */
public class FileWrite {
    public static void main(String[] args) {
        try {

            String path = "D:\\file\\b.txt";
            String content = "爱爱对方";
            File file = new File(path);
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
