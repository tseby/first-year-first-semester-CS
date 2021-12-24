package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        float numA;
        float numB;
        float dx;
        double result;
        double Xn;
        //Принимаем значеня от пользователя, попутно проверяя их на правильность (фильтруем ввод: ввод только цифр)
        Scanner TypeInput = new Scanner(System.in);
        System.out.print("Input number A: ");
        while (!TypeInput.hasNextFloat()) {
            TypeInput.next();
            System.out.print("Only numbers allowed. Try again: ");
        }
        numA = TypeInput.nextFloat();
        ////Принимаем значеня от пользователя, попутно проверяя их на правильность (фильтруем ввод: ввод только цифр)
        System.out.print("Input number B: ");
        while (!TypeInput.hasNextFloat()) {
            TypeInput.next();
            System.out.print("Only numbers allowed. Try again: ");
        }
        numB = TypeInput.nextFloat();
        //Фильтруем введеные данные теперь на корректность (введеные числа не должны быть равны друг-другу; так же numB должен быть большчем, чем numA; попутно корректируем на
        // правильность - воод лишь цифр)
        while (numA > numB || numA == numB) {
            System.out.println("Please enter numbers again so that B is greater (and not even with) than A");
            System.out.print("Input number A: ");
            while (!TypeInput.hasNextFloat()) {
                TypeInput.next();
                System.out.print("Only numbers allowed. Try again: ");
            }
            numA = TypeInput.nextFloat();
            System.out.print("Input number B: ");
            while (!TypeInput.hasNextFloat()) {
                TypeInput.next();
                System.out.print("Only numbers allowed. Try again: ");
            }
            numB = TypeInput.nextFloat();
        }

        // Рассчет шага между numA и numB; вывод шага и введеных пользователем цифр
        dx = (numB - numA) / 10;
        System.out.println("A= " + numA);
        System.out.println("B= " + numB);
        System.out.println("dx= " + dx);

        // Начинаем выводить заголовок финальной таблицы
        System.out.println("|------------------------|------------------------|------------------------|");
        System.out.format("|%-23s |%-23s |%-24s|%n", "n", "Xn", "F(Xn)");
        System.out.println("|------------------------|------------------------|------------------------|");
        //Рассчитываем первый (нумерация строк) и второй (шаг между введеными числами) столбец таблицы
        //Рассчет нумерации
        for (int x = 0; x <= 10; x++) {
            //Рассчет шага
            if (x == 0) {
                Xn = numA;
            } else {
                Xn = numA + dx * x;
            }
            //Расчитываем результат третьего столбца (финальной формулы)
            result = byFormula(Xn);
            if (Double.isNaN(result)) {
                System.out.format("|%-23d |%-23g |%-24s|%n", x, Xn, "ошибка");
            } else {
                System.out.format("|%-23d |%-23g |%-24f|%n", x, Xn, result);
            }
            System.out.println("|------------------------|------------------------|------------------------|");
        }

    }
    // Static — модификатор, применяемый к полю, блоку, методу или внутреннему классу.
    // Данный модификатор указывает на  привязку субъекта  к текущему классу.
    // static - Модификатор static в Java напрямую связан с классом.
    // Если поле статично, значит оно принадлежит классу, если метод статичный — аналогично: он принадлежит классу.
    // Исходя из этого, можно обращаться к статическому методу или полю, используя имя класса.
    // Например, если поле count статично в классе Counter, значит, вы можете обратиться к переменной запросом вида: Counter.count.

    static double byFormula(double step) {
        int myNum = 8;
        double FirstPart = ((1-myNum)/(Math.sin(step+myNum))); //<--- проверено считает верно +++
        double SecondPart = Math.log(FirstPart) / Math.log(21); //<--- проверено считает верно +++
        double ThirdPart = Math.abs(Math.cos(step)/myNum);//<--- проверено считает верно +++
        double FourthPart = Math.max(SecondPart, ThirdPart);
        return FourthPart;


    }
}
