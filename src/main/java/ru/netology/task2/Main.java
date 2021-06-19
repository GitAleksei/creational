package ru.netology.task2;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Программа запустилась");

        logger.log("Запрос пользователя ввести данные");
        int length = requestInt("Ведите размер списка: ");
        int max = requestInt("Ведите верхнюю границу для значений: ");

        logger.log("Создаем и наполняем список");
        List<Integer> list = createList(length, max);
        System.out.println("Ваш случайный список: " + list);

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        int threshold = requestInt("Введите порог для фильтра: ");
        Filter filter = new Filter(threshold);
        System.out.println("Отфильтрованный список: " + filter.filterOut(list));

        logger.log("Завершение программы");
    }

    private static List<Integer> createList(int length, int max) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            list.add(random.nextInt(max));
        }

        return list;
    }

    private static int requestInt(String request) {
        Logger logger = Logger.getInstance();
        int answer;

        while (true) {
            try {
                System.out.print(request);
                answer = Integer.parseInt(scanner.nextLine());
                if (answer < 0) {
                    throw new IllegalArgumentException("Отрицательное число");
                }
                break;
            }
            catch (Exception ex) {
                System.out.println("Нужно вводить не отрицательное число");
                logger.log("Ошибка: " + ex.getMessage() + ". Нужно вводить не отрицательное число");
            }
        }

        return answer;
    }
}
