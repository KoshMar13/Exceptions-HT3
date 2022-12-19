package HT.HT3;

import java.util.Scanner;
import java.io.IOException;

// 1.Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
// 2. Login должен содержать только латинские буквы, цифры и знак подчеркивания.
// 3. Длина login должна быть меньше 20 символов. Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
// 4. Password должен содержать только латинские буквы, цифры и знак подчеркивания. Длина password должна быть меньше 20 символов. Также password и confirmPassword должны быть равны.
// 5. Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.

// 6. WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами – один по умолчанию, 
// второй принимает сообщение исключения и передает его в конструктор класса Exception.
// 7. Обработка исключений проводится внутри метода.
// 8. Метод возвращает true, если значения верны или false в другом случае.

public class Task1 {
    static Scanner sc = new Scanner(System.in, "ibm866");

    public static void main(String[] args) {
        System.out.print("Введите логин: ");
        String login = sc.nextLine();
        System.out.print("Введите пароль: ");
        String password = sc.nextLine();
        System.out.print("Повторите пароль: ");
        String confirmPassword = sc.nextLine();
        boolean result = false;
        String pattern = "[A-Za-z0-9]+(_[A-Za-z0-9]+)*";
        try {
            result = validation(login, password, confirmPassword, pattern);
        } catch (Exception exc) {
            System.out.println("Вы ввели неверные данные: " + exc.getClass() + " => " + exc.getMessage());
        } finally {
            System.out.println(result);
        }

    }

    private static boolean validation(String login, String password, String confirmPass, String pattern)
            throws WrongLoginException, WrongPasswordException {
        try {
            loginChecker(login, pattern);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            throw new WrongLoginException("Неверный логин", exc);
        }

        try {
            passwordChecker(password, pattern, confirmPass);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            throw new WrongPasswordException("Неверный пароль", exc);
        }

        return true;
    }

    private static void loginChecker(String login, String pattern) throws IOException {
        if (login.length() > 20) {
            throw new IOException("Логин должен быть не длинее 20-и символов");
        }
        if (!login.matches(pattern)) {
            throw new IOException("Логин должен содержать только латинские буквы, цифры и знак подчеркивания");
        }
    }

    private static void passwordChecker(String password, String pattern, String confirmPass) throws IOException {
        if (password.length() > 20) {
            throw new IOException("Пароль должен быть не длинее 20-и символов");
        }
        if (!password.matches(pattern)) {
            throw new IOException("Пароль должен быть не длинее 20-и символов");
        }
        if (!confirmPass.equals(password)) {
            throw new IOException("Пароли не совпадают");
        }
    }
}
