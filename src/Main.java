import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a = 1;
        Network net = new Network(
                8,
                3,
                new int[] { 8, 8, 8 },
                x -> 1 / (1 + Math.pow(Math.E, -a * x)),
                x -> a * (1 / (1 + Math.pow(Math.E, -a * x))) * (1 - (1 / (1 + Math.pow(Math.E, -a * x)))),
                0.4
        );
        Scanner scanner = new Scanner(System.in);
        List<Input> xs = new ArrayList<>();
        xs.add(new Input("низкое", "бутылка", "крепленое", "низкий", 20, "0-1", "нет","машиной"));
        xs.add(new Input("отличное", "бутылка", "некрепленое", "высокий", 20, "1-4", "есть","вручную"));
        xs.add(new Input("низкое", "бутылка", "крепленое", "средний", 67, "1-4", "нет","машиной"));
        xs.add(new Input("отличное", "бутылка", "некрепленое", "низкий", 20, "0-1", "есть","вручную"));
        xs.add(new Input("среднее", "бутылка", "некрепленое", "высокий", 33, "1-4", "нет","вручную"));
        xs.add(new Input("низкое", "бутылка", "крепленое", "высокий", 32, "1-4", "есть","машиной"));
        xs.add(new Input("отличное", "бутылка", "крепленое", "средний", 77, "4-10", "нет","вручную"));
        xs.add(new Input("низкое", "бочка", "крепленое", "высокий", 24, "0-1", "есть","машиной"));
        xs.add(new Input("среднее", "бочка", "крепленое", "низкий", 11, "1-4", "нет","машиной"));
        xs.add(new Input("низкое", "бочка", "некрепленое", "низкий", 67, "4-10", "есть","машиной"));
        xs.add(new Input("низкое", "бутылка", "крепленое", "высокий", 48, "0-1", "нет","машиной"));
        xs.add(new Input("отличное", "бочка", "некрепленое", "высокий", 20, "4-10", "нет","вручную"));
        xs.add(new Input("низкое", "бутылка", "некрепленое", "средний", 73, "1-4", "есть","вручную"));
        xs.add(new Input("низкое", "бочка", "крепленое", "низкий", 67, "1-4", "нет","машиной"));
        xs.add(new Input("среднее", "бочка", "крепленое", "высокий", 63, "1-4", "есть","вручную"));
        xs.add(new Input("среднее", "бутылка", "некрепленое", "высокий", 20, "0-1", "нет","машиной"));
        xs.add(new Input("низкое", "бутылка", "некрепленое", "средний", 12, "0-1", "есть","машиной"));
        xs.add(new Input("среднее", "бутылка", "крепленое", "средний", 20, "4-10", "нет","вручную"));
        xs.add(new Input("отличное", "бочка", "крепленое", "высокий", 89, "10+", "есть","вручную"));
        xs.add(new Input("низкое", "бочка", "некрепленое", "средний", 56, "1-4", "нет","машиной"));
        xs.add(new Input("среднее", "бочка", "некрепленое", "средний", 67, "4-10", "есть","вручную"));
        xs.add(new Input("отличное", "бутылка", "некрепленое", "низкий", 45, "4-10", "нет","вручную"));
        xs.add(new Input("среднее", "бочка", "некрепленое", "средний", 44, "1-4", "есть","машиной"));
        xs.add(new Input("отличный", "бочка", "крепленое", "низкий", 22, "10+", "нет","вручную"));
        xs.add(new Input("среднее", "бутылка", "крепленое", "низкий", 20, "0-1", "есть","машиной"));
        xs.add(new Input("отличное", "бутылка", "крепленое", "средний", 20, "1-4", "нет","машиной"));
        xs.add(new Input("среднее", "бутылка", "крепленое", "средней", 34, "1-4", "есть","машиной"));
        xs.add(new Input("отличное", "бочка", "некрепленое", "средний", 20, "0-1", "нет","вручную"));


        List<double[]> expect = new ArrayList<>();
        expect.add(new double[] {0, 0, 1});
        expect.add(new double[] {1, 0, 0});
        expect.add(new double[] {0, 0, 1});
        expect.add(new double[] {0, 1, 0});
        expect.add(new double[] {0, 1, 0});
        expect.add(new double[] {0, 0, 1});
        expect.add(new double[] {1, 0, 0});
        expect.add(new double[] {0, 0, 1});
        expect.add(new double[] {0, 1, 0});
        expect.add(new double[] {0, 0, 1});
        expect.add(new double[] {0, 0, 1});
        expect.add(new double[] {1, 0, 0});
        expect.add(new double[] {0, 1, 0});
        expect.add(new double[] {0, 0, 1});
        expect.add(new double[] {1, 0, 0});
        expect.add(new double[] {0, 1, 0});
        expect.add(new double[] {0, 0, 1});
        expect.add(new double[] {1, 0, 0});
        expect.add(new double[] {1, 0, 0});
        expect.add(new double[] {0, 1, 0});
        expect.add(new double[] {1, 0, 0});
        expect.add(new double[] {1, 0, 0});
        expect.add(new double[] {0, 1, 0});
        expect.add(new double[] {1, 0, 0});
        expect.add(new double[] {0, 0, 1});
        expect.add(new double[] {0, 1, 0});
        expect.add(new double[] {0, 1, 0});
        expect.add(new double[] {1, 0, 0});




        double[] output = net.go(xs.get(24).toConvert());
        double mistake = net.mistake(output, expect.get(24));
        boolean isNotBreak = true;
        double g = 0.01;
        System.out.println("Обучение.... ");
        System.out.println("Первоначальная ошибка: " + mistake);
        while (isNotBreak) {
            // Обучение
            for (int i = 0; i < 24; i++) {
                g += 0.01;
                output = net.go(xs.get(i).toConvert());
                net.correct(output, expect.get(i));
                mistake = net.mistake(output, expect.get(i));
                if (g == 100) {
                    System.out.println(mistake);
                    scanner.nextLine();
                    System.out.println("\033[H\033[2J");
                }
                if (mistake < 0.001) {
                    isNotBreak = false;
                    break;
                }
            }
        }
        System.out.println("Завершено!");
        System.out.println("Ошибка: " + mistake);
        System.out.println();
        while (true) {
            System.out.print("Качество винограда (отличное/среднее/низкое): ");
            String grapeQuality = scanner.nextLine();
            System.out.print("Хранение вина (бочка/бутылка): ");
            String storage = scanner.nextLine();
            System.out.print("Процент алкоголя (крепленое/некрепленое): ");
            String alcoholPercentage = scanner.nextLine();
            System.out.print("Рейтинг региона выращивания(высокий/средний/низкий): ");
            String regionRating = scanner.nextLine();
            System.out.print("Баланс вкусовых характеристик (0-100): ");
            double balance = Double.parseDouble(scanner.nextLine());
            System.out.print("Выдержка (0-1/1-4/4-10/10+): ");
            String excerpt = scanner.nextLine();
            System.out.print("Содержание сахара (есть/нет): ");
            String sugar = scanner.nextLine();
            System.out.print("Отжим сока (машиной/вручную): ");
            String spin = scanner.nextLine();
            System.out.println();
            System.out.println("Результат: ");
            Input i = new Input(grapeQuality, storage, alcoholPercentage, regionRating, balance, excerpt, sugar, spin);
            output = net.go(i.toConvert());
            System.out.println("Отличное вино: " + output[0]);
            System.out.println("Вино среднего сегмента: " + output[1]);
            System.out.println("Вино низкого качества: " + output[2]);
            System.out.print("Продолжить? (Д/Н): ");
            String isGo = scanner.nextLine();
            if ("Н".equalsIgnoreCase(isGo)) {
                break;
            } else {
                System.out.println("\033[H\033[2J");
            }
        }
        scanner.close();
    }
}