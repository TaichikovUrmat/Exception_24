import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        userService.addUserDefuld(new User("Burulai", "+996555888777",
                "byrulai06@gmail.com", "B1234"));

        userService.addUserDefuld(new User("Madina", "+996991876543",
                "madina08@gmail.com", "M0808"));

        userService.addUserDefuld(new User("Munarbek", "+996707778899",
                "munarbek06@gmail.com", "M0606"));

        userService.addUserDefuld(new User("Baitik", "+996505888666",
                "Baitik08@gmail.com", "Bai0808"));


        ///  todo Login

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    1. Register
                    2. login 
                    3. get all
                    """);
            int chois = scanner.nextInt();
            switch (chois) {
                case 1 -> {
                    userService.Register();
                }
                case 2 -> {
                    System.out.print("gmail :");
                    String gmail = scanner2.nextLine();
                    System.out.print("password :");
                    String password = scanner2.nextLine();
                    userService.Login(gmail, password);
                }
                case 3 -> {
                    userService.getAll();
                }
            }
        }


    }
}