package edu.sustech.xiangqi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class interchecking {
    public static int enteruser(String A0){
        String RoadN=".\\src\\main\\java\\edu\\sustech\\xiangqi\\Nickname";
        int X=0;
        int C=0;
        try{
            Scanner fnscanner=new Scanner(new File(RoadN));

            while(fnscanner.hasNextLine()) {
                if(!fnscanner.hasNextLine()){return -1;}
                String findingname=fnscanner.nextLine();
                if(Objects.equals(findingname,A0)){
                     return X;}
                else if(findingname.isEmpty())
                {return -1;}
                else{X++;}
            }
           return -1;

        } catch (FileNotFoundException e) {
            System.out.println("找不到该文件");
            return -2;
        }

    }


    public static boolean enterpassword(String A1,int enteruser){
        if(enteruser<0){
            return false;
        }
        else{

                try {
                    String RoadP = ".\\src\\main\\java\\edu\\sustech\\xiangqi\\Password";
                    Scanner fpscanner = new Scanner(new File(RoadP));
                    for (int i = 0; i < enteruser; i++) {
                        fpscanner.nextLine();
                    }
                    if(!fpscanner.hasNextLine()){String findingpassword="";return false;}
                    else{
                        String findingpassword= fpscanner.nextLine();
                        if (Objects.equals(findingpassword,A1)){
                            return true;}
                        else{return false;}
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("找不到文件！！！");
                    return true;
                }

        }
    }


}
