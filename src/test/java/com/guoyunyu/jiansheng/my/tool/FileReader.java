package com.guoyunyu.jiansheng.my.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * desc
 *
 * @author Yongjian.Liu
 * @date 2019/1/9 16:47
 */
public class FileReader {

    public static void main(String[] args) throws Exception {
        String path = "D:\\file";
        File file = new File(path);
        File[] files = file.listFiles();
        Arrays.sort(files);
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                InputStreamReader reader = new InputStreamReader(new FileInputStream(files[i]),"GB2312");
                BufferedReader br = new BufferedReader(reader);
                String line = "";
                line = br.readLine();
                System.out.println(files[i].getName());
                while (line != null) {
                    System.out.println(files[i].getName() + "=" + line);
                    line = br.readLine();
                }
                br.close();
            }
        }
    }
}
