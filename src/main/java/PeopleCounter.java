import java.util.Scanner;

public class PeopleCounter {

    int countPeople() {
        Scanner sc = new Scanner(System.in);
        int guests;

        while (true) {
            if (sc.hasNextInt()) {
                int quantity = sc.nextInt();
                if (quantity > 1) {
                    System.out.println("Отлично! Теперь мы сможем сделать расчёт!");
                    guests = quantity;
                    sc.nextLine();
                    break;
                } else if (quantity == 1) {
                    System.out.println("Счёт на 1 человека ты и сам разделишь ;-) Попробуем снова?");
                } else if (quantity < 1) {
                    System.out.println("Введено 0 или отрицательное значение, попробуйте ещё раз");
                }
            } else {
                System.out.println("Введенно ошибочное значение. Пожалуйста, введите корректное количество гостей");
            }
            sc.nextLine();
        }
        return guests;
    }
}
