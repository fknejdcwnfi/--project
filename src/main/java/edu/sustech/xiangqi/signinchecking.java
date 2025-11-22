package edu.sustech.xiangqi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class signinchecking {
    public static boolean rightname(String putnickname){
        if(Objects.equals(putnickname,"")){return false;}
        else if(putnickname.length()>=15){return false;}
        else {
            try {
                    Scanner nicknamescanner = new Scanner(new File(".\\src\\main\\java\\edu\\sustech\\xiangqi\\Nickname"));
                if(!nicknamescanner.hasNextLine()){return true;}
                    while(nicknamescanner.hasNextLine()){
                        String remainnickname=nicknamescanner.nextLine();
                        if(Objects.equals(putnickname,remainnickname))
                        {return false;}
                      //  else if(Objects.equals(remainnickname,"")){return true;}
                    }
                    return true;
            } catch (FileNotFoundException e) {
                    System.out.println("未找到相应文件！！！");
                return false;
                }

        }
    }

    public static boolean passworkcheck(String putsetpassword){
        if(putsetpassword.length()<8){return false;}
        else{return true;}
    }
}
