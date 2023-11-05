import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счёт?");

        PeopleCounter counter = new PeopleCounter();
        int peopleCount = counter.countPeople();


        double total = 0.00;
        double price;
        String list = "";

        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("Если хотите добавить блюдо, то ведите его название либо \"Закончить\" для завершения");
            String dish = sc.next();
            if (dish.equalsIgnoreCase("закончить")) {
                break;
            }
            System.out.println("Введите стоимость блюда в формате \"Рубли,копейки\":");
            while (true) {
                if (sc.hasNextDouble()){
                    price = sc.nextDouble();
                    if (price <= 0) {
                        System.out.println("Введите число больше \"0\"");
                        sc.nextLine();
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Введено не допустимое значение, повторите ввод");
                    sc.next();
                }
            }


            System.out.println("Вы успешно добавили новое блюдо");
            total += price;

            System.out.println(dish + " - " + formatPrice(price));

            list = list.concat(dish+"").concat("\n");
        }


        System.out.println("Добавленные товары:\n" + list);
        System.out.println("Итого: " + formatPrice(total));

        double split = total / peopleCount;
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
