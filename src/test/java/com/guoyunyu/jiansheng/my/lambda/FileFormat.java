package com.guoyunyu.jiansheng.my.lambda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * desc
 *
 * @author Yongjian.Liu
 * @date 2018/12/25 17:48
 */
public class FileFormat {
    public static void main(String[] args) throws Exception {
        String path = "D:\\file2";
        File file = new File(path);
        File[] files = file.listFiles();
        Arrays.sort(files);
        String shangchuan = "";
        String xiazai = "";
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                InputStreamReader reader = new InputStreamReader(new FileInputStream(files[i]),"GB2312");
                BufferedReader br = new BufferedReader(reader);
                String line = "";
                line = br.readLine();
//                System.out.println(files[i].getName());
                while (line != null) {
                    shangchuan += line + "、";
                    xiazai += line + "、";
                    line = br.readLine();
                }
                System.out.println(shangchuan.substring(0,shangchuan.length() -1 ));
                System.out.println(xiazai.substring(0,xiazai.length() -1 ));
                br.close();
            }
        }
    }

}
