import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счёт?");
        Scanner sc = new Scanner(System.in);
        int guests = 0;
        double total = 0.00;
        double price = 0.00;
        String list = "";


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

        while (true) {
            System.out.println("Если хотите добавить блюдо, то ведите его название либо \"Закончить\" для завершения");
            String dish = sc.next();
            if (dish.equalsIgnoreCase("закончить")) {
                break;
            }
            System.out.println("Введите стоимость блюда в формате \"Рубли,копейки\":");
            price = sc.nextDouble();

            System.out.println("Вы успешно добавили новое блюдо");
            total += price;

            System.out.println(dish + " - " + formatPrice(price));

            list = list.concat(dish+"").concat("\n");
        }


        System.out.println("Добавленные товары:\n" + list);
        System.out.println("Итого: " + formatPrice(total));

        double split = total / guests;
        System.out.println("Сумма на одного гостя: " + formatPrice(split));

        sc.close();
    }

    public static String formatPrice(double price) {
        int rubles = (int) price;
        int kopecks = (int) ((price - rubles) * 100);

        String rubleWord = "";

        if (rubles % 10 == 1 && rubles % 100 != 11) {
            rubleWord = "рубль";
        } else if (rubles % 10 >= 2 && rubles % 10 <= 4 && (rubles % 100 < 10 || rubles % 100 > 20)) {
            rubleWord = "рубля";
        } else {
            rubleWord = "рублей";
        }

        return rubles + " " + rubleWord + " " + kopecks + " коп.";
    }
  }
