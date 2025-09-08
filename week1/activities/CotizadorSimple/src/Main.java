import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("------- FitPro Gym - Quoter-------");

        String nameUser;
        byte age;
        double height;
        double weight;
        int answerSubscription;
        String subscription;
        String answerFirstTime;
        boolean firstTime;
        int discount1 = 0, discount2 = 0;
        double Baseprice = 0;

        System.out.println("Is your first time in the Gym? (y/n)");
        answerFirstTime = sc.next().toLowerCase();
        if (answerFirstTime.equals("y")){
            firstTime = true;
            discount1 = 10;
        } else if (answerFirstTime.equals("n")){
            firstTime = false;
        }

        System.out.println("\nEnter your name: ");
        nameUser = sc.next().toUpperCase();

        System.out.println("\nEnter your age: ");
        age = sc.nextByte();

        if (age>=16 && age<=25){
            discount2 = 10;
        }

        if (age<14){
            System.out.println("Not eligible");
            return;
        } else if (age>=14 && age<18){
            System.out.println("Requires tutor authorization");
            return;
        }

        System.out.println("\nEnter your height (meters): ");
        height = sc.nextDouble();

        System.out.println("\nEnter your weight (kg): ");
        weight = sc.nextDouble();

        System.out.println("\nChoose a number of subscription: \n1. BASIC\n2. PLUS\n3. PREMIUM");
        answerSubscription = sc.nextInt();
        if (answerSubscription == 1){
            subscription = "BASIC";
            Baseprice = 80;
        } else if (answerSubscription == 2){
            subscription = "PLUS";
            Baseprice = 120;
        }else {
            subscription = "PREMIUM";
            Baseprice = 180;
        }

        double bmi;
        String showBMI="";

        bmi = weight/(height*height);
        if (bmi>=30){
            showBMI = "OBESITY";
        }

        if (bmi>25 && bmi<29.9){
            showBMI = "OVERWEIGHT";
        }

        if (bmi>18.5 && bmi<24.9){
            showBMI = "NORMAL";
        }

        if (bmi<=18.5){
            showBMI = "UNDERWEIGHT";
        }

        double finalPrice;
        finalPrice = Baseprice-(Baseprice*((double) (discount1+discount2) /100));

        System.out.println("\n------ Result ------");
        System.out.println("Name: "+nameUser);
        System.out.println("Subscription chosen: "+subscription);
        System.out.println("Base price: $"+Baseprice);
        System.out.println("Discount applied: "+(discount1+discount2)+"%");
        System.out.println("Final price: $"+finalPrice);
        System.out.println("BMI category: "+showBMI);


    }

}