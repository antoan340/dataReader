import java.util.Scanner;

public class mainMenu {
    //FileReader fileReader = new FileReader("src/enemy_teritory.txt");
    //int columns = fileReader.readData("width");
    public static void menu(){
        int chose;
        Scanner word = new Scanner(System.in);
        System.out.println("Изберете опция");
        System.out.println("1. Селектирай ми всички граждани?");
        System.out.println("2. Селектирай ми всички граждани, които са пенсионери/работещи/майки?");
        System.out.println("3. Селектирай ми всички граждани, които имат дете с определено име?");
        System.out.println("4. Селектирай ми всички граждани, които са от определен тип и пол?");
        System.out.println("5. Селектирай ми всички граждани, които имат определено име");
        System.out.println("6. Селектирай ми всички граждани на определена възраст");
        System.out.println("7. Изход");
        do {
            chose=word.nextInt();
            switch (chose) {
                case 1: {
                    selectAll(word);
                    break;
                }
                case 2: {
                    choseType(word);
                    break;
                }
                case 3: {
                    selectByKidName(word);
                    break;
                }
                case 4: {
                    selectByTypeAndSex(word);
                    break;
                }
                case 5: {
                    selectByName(word);
                    break;
                }
                case 6: {
                    selectByAge(word);
                    break;
                }
                case 7:{
                    System.exit(-1);
                }
                default: {
                    menu();
                    break;
                }
            }
        }while (chose<1||chose>6);
    }

    public static void choseType(Scanner word){
        System.out.println("Изберете категория");
        System.out.println("1. Работещи");
        System.out.println("2. Майки");
        System.out.println("3. Пенсионери");
        System.out.println("4. Върнете се на предищното меню");
        int chose;
            chose = word.nextInt();
            FileReader fileReader = new FileReader("src/people");
            switch (chose) {
                case 1: {
                    String fate = "t";
                    do {
                    String data = fileReader.readDataForOneType("{TYPE}=[W", fate);
                    System.out.println(data);
                }while (fate.equals("t"));
                    choseType(word);
                    break;
                }
                case 2: {
                    String fate="t";
                    do {
                        String data = fileReader.readDataForOneType("{TYPE}=[M",fate);
                        System.out.println(data);
                    }while (fate.equals("t"));
                    choseType(word);
                    break;
                }
                case 3: {
                    String fate="t";
                        String data = fileReader.readDataForOneType("{TYPE}=[R",fate);
                        System.out.println(data);
                    choseType(word);
                    break;
                }
                case 4:{
                    menu();
                    break;
                }
                default: {
                    choseType(word);
                    break;
                }
            }
    }

    public static void selectAll(Scanner word){
        System.out.println("Изберете опция");
        System.out.println("1. Изведете всички");
        System.out.println("2. Изход");
        int chose;
        chose = word.nextInt();
        FileReader fileReader = new FileReader("src/people");
        switch (chose) {
            case 1: {
                String fate = "t";
                do {
                    String data = fileReader.readDataForOneType("{TYPE}=", fate);
                    System.out.println(data);
                }while (fate.equals("t"));
                selectAll(word);
                break;
            }
            case 2:{
                menu();
                break;
            }

            default: {
                selectAll(word);
                break;
            }
        }
    }

    public static void selectByName(Scanner word){
        String name="";
        int chose;
        System.out.println("Изберете опция");
        System.out.println("1. Изведете информация спрямо име");
        System.out.println("2. Върнете се към предишното меню ");
        chose = word.nextInt();
        if(chose==1){
            System.out.println("Въведете име");
            System.out.println(name=word.nextLine());
        }
        FileReader fileReader = new FileReader("src/people");
        switch (chose) {
            case 1: {

                String fate = "t";
                do {
                    String data = fileReader.readDataForOneType(name, fate);
                    System.out.println(data);
                }while (fate.equals("t"));
                selectByName(word);
                break;
            }
            case 2:{
                menu();
                break;
            }

            default: {
                selectByName(word);
                break;
            }
        }
    }
    public static void selectByKidName(Scanner word){
        String name="";
        int chose;
        System.out.println("Изберете опция");
        System.out.println("1. Изведете информация спрямо име");
        System.out.println("2. Върнете се към предишното меню ");
        chose = word.nextInt();
        if(chose==1){
            name=word.nextLine();
            System.out.println("Въведете име");
System.out.println(name=word.nextLine());
        }
        FileReader fileReader = new FileReader("src/people");
        switch (chose) {
            case 1: {

                String fate = "t";
                do {
                    String data = fileReader.readDataWithKidName("{SPECIAL_PROPERTY}::{KID}=", fate,name);
                    System.out.println(data);
                }while (fate.equals("t"));
                selectByName(word);
                break;
            }
            case 2:{
                menu();
                break;
            }

            default: {
                selectByName(word);
                break;
            }
        }
    }
    public static void selectByAge(Scanner word){
        int age=0;
        int chose;
        System.out.println("Изберете опция");
        System.out.println("1. Изведете информация спрямо възраст");
        System.out.println("2. Върнете се към предишното меню ");
        chose = word.nextInt();
        if(chose==1) {
            System.out.println("Въведете възраст");
            age = word.nextInt();
        }
        String sAge="";
        if (age<150) {
            FileReader fileReader = new FileReader("src/people");
            switch (chose) {
                case 1: {

                    sAge = String.valueOf(age);
                    String fate = "t";
                    do {
                        String data = fileReader.readDataForOneType(sAge, fate);
                        System.out.println(data);
                    } while (fate.equals("t"));
                    selectByAge(word);
                    break;
                }
                case 2: {
                    menu();
                    break;
                }

                default: {
                    selectByAge(word);
                    break;
                }
            }
        }else selectByAge(word);
    }
    public static void selectByTypeAndSex(Scanner word){
            String type="",sex="";
            int chose;
            System.out.println("Изберете опция");
            System.out.println("1. Изведете информация спрямо тип");
            System.out.println("2. Върнете се към предишното меню ");
            chose = word.nextInt();
            if(chose==1){
                // name=word.nextLine();
                System.out.println("Въведете тип");
                type=word.nextLine();
                System.out.println("Въведете пол");
                sex=word.nextLine();

            }
            FileReader fileReader = new FileReader("src/people");
            switch (chose) {
                case 1: {

                    String fate = "t";
                    do {
                        String data = fileReader.readDataWithTypeSex(sex, fate,type);
                        System.out.println(data);
                    }while (fate.equals("t"));
                    selectByName(word);
                    break;
                }
                case 2:{
                    menu();
                    break;
                }

                default: {
                    selectByName(word);
                    break;
                }
            }

    }
    public static void main(String[] args) {
        menu();
    }
}
