// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //Switch в Java принимает следующие типы:

        //1. Byte
        Byte _byte = 1;
        switch (_byte){
            case 1:
                System.out.println("Переменная _byte равна 1");
                break;
            case 2:
                System.out.println("Переменная _byte равна 2");
                break;
            default:
                System.out.println("Переменная _byte не равна ни 1, ни 2");
                break;
        }


        //2. Short
        Short _short = 30000;
        switch (_short){
            case 10000:
                System.out.println("Переменная _short равна 10000");
                break;
            case 30000:
                System.out.println("Переменная _short равна 30000");
                break;
            default:
                System.out.println("Переменная _short не равна ни 10000, ни 30000");
                break;
        }

        //3. Char
        Character _char = 'a';
        switch (_char){
            case 'a':
                System.out.println("Переменная _char равна a");
                break;
            case 'b':
                System.out.println("Переменная _char равна b");
                break;
            default:
                System.out.println("Переменная _char не равна ни a, ни b");
                break;
        }

        //4. Integer
        Integer _int = 2000000000;
        switch (_int){
            case 1000000000:
                System.out.println("Переменная _int равна 1000000000");
                break;
            case 2000000000:
                System.out.println("Переменная _int равна 2000000000");
                break;
            default:
                System.out.println("Переменная _int не равна ни 1000000000, ни 2000000000");
                break;
        }

        //5. String
        String _string = "abracadabra";
        switch (_string){
            case "abracadabra":
                System.out.println("Переменная _string равна \"abracadabra\"");
                break;
            case "avada kedavra":
                System.out.println("Переменная _string равна \"avada kedavra\"");
                break;
            default:
                System.out.println("Переменная _string не является заклинанием");
                break;
        }

        //6. Enum
        enum DayOfWeek {
            SUNDAY,
            MONDAY,
            TUESDAY,
            WEDNESDAY,
            THURSDAY,
            FRIDAY,
            SATURDAY}


        DayOfWeek today = DayOfWeek.MONDAY;
        String _today = switch (today) {
            case MONDAY -> "Сегодня понедельник";
            case TUESDAY -> "Сегодня вторник";
            case WEDNESDAY -> "Сегодня среда";
            case THURSDAY -> "Сегодня четверг";
            case FRIDAY -> "Сегодня пятница";
            case SATURDAY -> "Сегодня суббота";
            case SUNDAY -> "Сегодня воскресенье";
        };
        System.out.println(_today);
    }
}