
public class Main {
    public static void main(String[] args) {
        System.out.println("Лабораторная 1. Методы работы со строками.");
        String s1 = "Первая строка.";
        //длина строки вычисляется при помощи метода lenght
        System.out.println("Длина строки s1 = \"" + s1 + "\" составляет " + s1.length() + " символов;");
        System.out.println();

        //строки неизменяемы, однако их можно объединять при помощи + или concat()
        String s2 = s1 + " Ой! Уже вторая.";
        String s3 = s2.concat(" А нет, уже третья.");

        System.out.println("После объединения получились строки: ");
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);
        System.out.println();

        //Если прибавлять цифры, они автоматически приведутся к виду строки
        String s4 = s2 + 2;
        String s5 = s3 + (2 + 1);

        System.out.println("Результат прибавления цифр:");
        System.out.println("После прибавления к втроке s2 цифры 2 получилась строка\ns4 = " + s4);
        System.out.println("После прибавления к втроке s23 цифр (2 + 1) получилась строка\ns5 = " + s5);
        System.out.println();

        //Сравнение строк
        //Сравнивать можно адрес памяти (через ==) или содержимое (через equals)
        String s6 = "Magic";
        String s7 = "Magic";
        String s8 = "Mag";
        String s9 = s8 + "ic";

        System.out.println("Сравним несколько строк при помощи ==:");
        System.out.println("s6 = " + s6 + ", s7 = " + s7 + ",\ns6 == s7: " + (s6 == s7));
        System.out.println();
        System.out.println("s6 = " + s6 + ", s8 = " + s8 + ", s9 = s8 + \"ic\" = " + s9 + ",\ns6 == s9: " + (s6 == s9));
        System.out.println();
        System.out.println("Теперь сравним строки s6 и s9 при помощи equals:");
        System.out.println("s6.equals(s9) = " + s6.equals(s9));
        System.out.println();

        //Существует также нулевая строка
        String s0 = null;

        if (s0 == null) {
            System.out.println("s0 = null: null string");
        } else {
            System.out.println("s0 = null: NOT null string");
        }

        s0 = "";
        if (s0.length() == 0){
            System.out.println("s0 = \"\": empty string");
        } else {
            System.out.println("s0 = \"\": NOT empty string");
        }

        if (s0 == null) {
            System.out.println("s0 = \"\": null string");
        } else {
            System.out.println("s0 = \"\": NOT null string");
        }
        System.out.println();

        String s_new = new String();

        if (s_new == null){
            System.out.println("s_new = new String(): null string");
        } else {
            System.out.println("s_new = new String(): NOT null string");
        }

        if (s_new.length() == 0){
            System.out.println("s_new = new String(): empty string");
        } else {
            System.out.println("s_new = new String(): NOT empty string");
        }
        System.out.println();

        //Класс StringBuilder предоставляет методы, недоступные строкам:
        //s.append(x) - добавляет символ x в конец строки s
        //s.setCharAt(n, x) - заменяет в строке s символ на позиции n на символ x
        //s.toString() - конвертирует StringBuilder в String

        StringBuilder s = new StringBuilder("Test");
        System.out.println("К строке s = " + s + " применим метод append():");
        s.append("1234");
        s.append('5');
        System.out.println("s = " + s);
        System.out.println();

        System.out.println("При помощи setCharAt заменим символ на 0 позиции на B:");
        s.setCharAt(0, 'B');
        System.out.println("s = " + s);
        System.out.println();

        System.out.println("При помощи toString преобразуем s в string:");
        String s_from_builder = s.toString();
        System.out.println("s_from_builder = " + s_from_builder);
        System.out.println();

        //Команды изменения регистра
        System.out.println("Изменять регистры строк можно при помощи методов toLowerCase() и toUpperCase()");
        String just_string = "JuSt StRiNg";
        System.out.println("just_string = " + just_string);
        System.out.println("just_string.toLowerCase() = " + just_string.toLowerCase());
        System.out.println("just_string.toUpperCase() = " + just_string.toUpperCase());
        System.out.println();

        //Удаление пробелов
        System.out.println("Метод trim() удаляет пробелы в начале и конце строки");
        String space_string = "   Hello world!   ";
        System.out.println("space_string = \"" + space_string + "\"");
        System.out.println("space_string.trim() = \"" + space_string.trim() + "\"");
        System.out.println();

        //нахождение индекса первого вхождения подстроки
        System.out.println("Метод str.indexOf(x) выдаёт индекс первого вхождения подстроки x в строку str");
        String str = "Мама мыла раму";
        System.out.println("str = " + str + ", str.indexOf(\"ам\") = " + str.indexOf("ам"));
        System.out.println();

        //замена одной подстроки на другую
        System.out.println("Метод str.replace(x, y) позволяет заменить все вхождения подстроки x на подстроку y");
        System.out.println("str.replace(\"ам\", \"ап\") = " + str.replace("ам", "ап"));
        System.out.println();
    }
}
