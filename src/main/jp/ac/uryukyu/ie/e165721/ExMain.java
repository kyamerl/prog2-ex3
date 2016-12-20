package main.jp.ac.uryukyu.ie.e165721;

/**
 * Created by e165721 on 2016/12/20.
 */

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class Map {
    public static void main(String args[]) {
        int p=1;  //現在の行数
        ArrayList list = new ArrayList();
        list.clear();

        try {
            File file = new File("/Users/e165759/Desktop/map.txt");

            if (checkBeforeReadfile(file)) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String str= "";
                int i = 0,j = 0;

                while((str = br.readLine()) != null) {
                    //for (p=1;p<3;p++) {

                    if(p==1){
                        String[] Position = str.split(" ");
                        int a = Integer.parseInt(Position[0]);
                        int b = Integer.parseInt(Position[1]);
                        p++;
                        continue;
                        //System.out.println(a);
                    }

                    if(p==2){
                        String[] MapSize = str.split(" ");
                        i = Integer.parseInt(MapSize[0]);
                        j = Integer.parseInt(MapSize[1]);
                        p++;
                        continue;
                    }
                    //}

                    //for(p=3;p<j+3;p++){
                    if(p>2) {
                        if(p>2+j)break;


                        String sharp = "#";
                        String empty = " ";
                        String start = "s";
                        String goal = "G";
                        String result1 = str.replaceAll(sharp, "1");
                        String result2 = result1.replaceAll(empty, "0");
                        String result3 = result2.replaceAll(start, "0");
                        String result4 = result3.replaceAll(goal, "2");
                        System.out.println(result4);

                        char[] MapCopy = result4.toCharArray();

                        list.add(MapCopy);

                        p++;
                    }
                }


                System.out.println(list);
                br.close();
            } else {
                System.out.println("ファイルが見つからないか開けません");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static boolean checkBeforeReadfile(File file){
        if (file.exists()){
            if (file.isFile() && file.canRead()){
                return true;
            }
        }

        return false;
    }
}

