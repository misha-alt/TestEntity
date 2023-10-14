package misha.Test;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import misha.dao.PersonDAOImpl;
import misha.model.Course;
import misha.model.Person;
import misha.service.CourseService;
import misha.service.PersonService;
import misha.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Gh {





    private static char p;
    private static List ma = new ArrayList();



    public static void main(String[] args) {






  char ch = 'g';
  char ch1= 'р';

  if (ch==ch1){
      System.out.println("они равны");
  }


    }


    public static List removeDuplicate3(List list){
        for(int i =0;i<list.size();i++){
            for(int j = list.size()-1;j>i;j--){
                if(list.get(j).equals(list.get(i))){
                    list.remove(j);
                }
            }
        }
        return list;
    }

    public static void Pars (){

        int s= 5;
        String id= Integer.toString(s);
        System.out.println(id);
    }

    public static void mass (){
        String hi ="hello world";





       char[] result= hi.toCharArray();
        for(int i = 0; i<hi.length(); i++){
            int sum= 0;
            char df;

            for(int j =0; j<hi.length(); j++){


                if (result[i]== result[j]) {
                    Gh.p=result[i];
                    sum += 1;


                }

            }
            if (sum>1) {

                ma.add(Gh.p);
                ma.add(sum);
            }
        }

    }



}