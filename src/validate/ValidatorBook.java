package validate;

import input.Input;

public class ValidatorBook {
     public static int inputId(){
          String regex = "^[0-9]{2}$";
          String id;
          do{
               System.out.println("Nhap id 2 chu so");
               id = Input.inputString();
               if (id.matches(regex)){
                    break;
               }
          }while (true);
          return Integer.parseInt(id);
     }
}
