import javax.security.sasl.AuthenticationException;
import java.util.Random;
import java.util.Scanner;

public class UserServiceImpl implements UserService {


    User[] users = new User[6];
    int size = 0;

    Scanner scanner = new Scanner(System.in);

    @Override
    public void Register() {
        while (true) {
            try {
                System.out.print("userName: ");
                String userName = scanner.nextLine();
                System.out.print("phoneNumber: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("gmail: ");
                String gmail = scanner.nextLine();
                System.out.print("password: ");
                String password = scanner.nextLine();

                for (int i = 0; i < size; i++) {
                    if (users[i].getUserName().equals(userName)) {
                        throw new RuntimeException("мындый userName уже бар башка танданыз !");

                    }
                }
                if (!phoneNumber.startsWith("+996") || !(phoneNumber.length() == 13)) {
                    throw new RuntimeException("Телефон +996  менен башталып узундугу 13 цифрадан туруш керек!");
                }
                if (!gmail.contains("@")) {
                    throw new RuntimeException("gmail @  -  камтыш керек ! ");
                }

                User user1 = new User(userName, phoneNumber, gmail, password);

                users[size] = user1;
                size++;


                System.out.println("succesfull  register !");
                return;

            } catch (RuntimeException e) {
                System.out.println("e.getMessage() = " + e.getMessage());
            }
        }

    }

    @Override
    public void Login(String gmail, String password) {
        try {
            for (User user : users) {
                if (user.getGmail().equals(gmail) && user.getPassword().equals(password)) {
                    System.out.println("succesfull ");
                    return;
                }
            }
            throw new RuntimeException("Login  же password  туура эмес !");


        } catch (RuntimeException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }

    }

    @Override
    public void addUserDefuld(User user) {
        users[size] = user;
        size++;
    }

    @Override
    public void getAll() {
        for (User user : users) {
            System.out.println("users  = " + user);
        }
    }


}
