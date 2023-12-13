import java.time.LocalTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.LinkedList;

public class Sem1 {
    public static void main(String[] args) {
        //gbPrinter (3); //Урок 1, Задачи: 1, 2, 3
        //gbPrinterLesson2 (2); //Урок 2, Задачи: 1 и 2
        //gbPrinterLesson3 (3); //Урок 3, Задачи: 1, 2, 3
        //gbPrinterLesson4 (3); //Урок 3, Задачи: 1, 2, 3
        gbPrinterLesson5 (3); //Урок 3, Задачи: 1, 2, 3

    }

    //Урок 1
    public static void gbPrinter (int task) {
        Answer ans = new Answer();
        System.out.println("Урок 1. Задача " + task + ".");
        switch (task) {
            case 1: // Вызов для Задачи 1
                int n = 10;
                for (int i = 1; i <= n; i++) {
                    int itresume_res = ans.countNTriangle(i);
                    System.out.println(itresume_res);
                }
                break;
            case 2: // Вызов для Задачи 2
                // выбрать простые числ, из чисел с 1 до 1000
                ans.printPrimeNums();
                break;
            case 3:// Вызов для Задачи 3
                // передаем '+','3','7' и ожидаем 10
                char[] oper = new char[]{'+', '-', '*', '/', '%'};
                for (char item : oper) {
                    int result = ans.calculate(item, 3, 7);
                    System.out.println(result);
                }
                break;
            default:
                System.out.println("Кто-то забыл передать  номер задачи??");
        }
    }

    // Урок 2
    public static void gbPrinterLesson2 (int task){
        Answer ans = new Answer();
        System.out.println("Урок 2. Задача " + task + ".");
        switch (task) {
            case 1: // Задача 2-1
                // String QUERY - начало SQL-запроса
                // String PARAMS - JSON с параметрами
                String QUERY = ""; String PARAMS = "";
                QUERY = "select * from students where ";
                PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
                System.out.println(ans.querySting(QUERY, PARAMS));
                break;
            case 2: // Задача 2-2
                //int[] arr = new int[]{9, 4, 8, 3, 1}; // Тест 1
                int[] arr = new int[]{9, 3, 4, 8, 2, 5, 7, 1, 6, 10}; // Тест 2
                //int[] arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}; // Тест 3
                // Используется класс BubbleSort
                ans.BubbleSort(arr);
                break;
            default:
                System.out.println("Кто-то забыл передать  номер задачи??");
        }
    }

    // Урок 3
    public static void gbPrinterLesson3 (int task){
        Answer ans = new Answer();
        System.out.println("Урок 3. Задача " + task + ".");
        Integer[] arr;
        switch (task) {
            case 1: // Задача 3-1
                int[] a = new int[]{5, 1, 6, 2, 3, 4};
                //int[] a = new int[]{9, 5, 2, 1, 6, 7}; // '9, 5, 2, 1, 6, 7'
                //int[] a = new int[]{8, 1, 6, 4, 7}; // '8, 1, 6, 4, 7'
                String itresume_res = Arrays.toString(ans.mergeSort(a));
                System.out.println(itresume_res);
                break;
            case 2: // Задача 3-2
                arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                //arr = new Integer[]{2, 4, 6, 8};
                ans.removeEvenNumbers(arr);
                break;
            case 3: //Задача 3-3
                arr = new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9};
                //arr = new Integer[]{-2, -1, 0, 1, 2, 3, 4, 5}; // '-2, -1, 0, 1, 2, 3, 4, 5'
                //arr = new Integer[]{10, 20, 30, 40, 50}; // '10, 20, 30, 40, 50'
                arr = new Integer[]{1, 3, 5, 7, 9}; // '1, 3, 5, 7, 9'
                ans.analyzeNumbers(arr);
                break;
            default:
                System.out.println("Кто-то забыл передать  номер задачи??");
        }
    }

    public static void gbPrinterLesson4 (int task) {
        Answer ans = new Answer();
        System.out.println("Урок 4. Задача " + task + ".");
        Integer[] arr;
        switch (task) {
            case 1: // Задача 4-1
                LinkedList<Object> ll = new LinkedList<>();
                ll.add(1);
                ll.add("One");
                ll.add(2);
                ll.add("Two");
                System.out.println(ll);
                LinkedList<Object> reversedList = ans.revertLLTasks(ll);
                System.out.println(reversedList);
                break;
            case 2: // Задача 4-2
                MyQueue<Integer> queue;
                queue = new MyQueue<>();
                queue.enqueue(1);
                queue.enqueue(10);
                queue.enqueue(15);
                queue.enqueue(5);
                System.out.println(queue.getElements());
                queue.dequeue();
                queue.dequeue();
                System.out.println(queue.getElements());
                System.out.println(queue.first());
                break;
            case 3: // Задача 4-3
                int a, b, c, d;
                char op, op2, undo;
                a = 3;
                op = '+';
                b = 7;
                c = 4;
                op2 = '+';
                d = 7;
                undo = '<';
                int result = ans.calculate(op, a, b);
                System.out.println(result);
                int result2 = ans.calculate(op2, c, d);
                System.out.println(result2);
                int prevResult = ans.calculate(undo, 0, 0);
                System.out.println(prevResult);
                break;
            default:
                System.out.println("Кто-то забыл передать  номер задачи??");
        }
    }

    public static void gbPrinterLesson5 (int task) {
        Answer ans = new Answer();
        System.out.println("Урок 5. Задача " + task + ".");
        switch (task) {
            case 1: // Задача 5-1
                String name1 = "Ivanov";
                String name2 = "Petrov";
                int phone1 = 123456;
                int phone2 = 654321;

                PhoneBook myPhoneBook = new PhoneBook();
                myPhoneBook.add(name1, phone1);
                myPhoneBook.add(name1, phone2);
                myPhoneBook.add(name2, phone2);

                myPhoneBook.add("Alice", 123456);
                myPhoneBook.add("Alice", 789012);
                myPhoneBook.add("Bob", 789012);

                myPhoneBook.add("David", 111111);
                myPhoneBook.add("David", 222222);

                System.out.println(name1);
                System.out.println(myPhoneBook.find(name1));
                System.out.println("Alice");
                System.out.println(myPhoneBook.find("Alice"));
                System.out.println(PhoneBook.getPhoneBook());
                System.out.println(myPhoneBook.find("Me"));

                TreeMap<String, ArrayList<Integer>> sorted = new TreeMap<>(PhoneBook.getPhoneBook());
                System.out.println(sorted);
                break;
            case 2: // Задача 5-2
                //String name1 = "Elena";
                //String name2 = "Elena";
                //String name3 = "Elena";
                //String name4 = "Elena";
                //String name5 = "Ivan";
                String[] Names1 = new String[]{"Elena","Elena","Elena","Elena","Ivan"};
                String[] Names2 = new String[]{"Elena","Elena","Elena","Ivan","Ivan"};
                String Source[] = Names2;
                NamesCounter namesCounter = new NamesCounter();
                for (int i = 0; i < Source.length; i++) {
                    namesCounter.addName(Source[i]);
                }
                namesCounter.showNamesOccurrences();
                break;
            case 3: // Задача 5-3
                int[] initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};
                //int[] initArray = new int[]{5, 8, 12, 3, 6, 9};
                System.out.println("Initial array:");
                System.out.println(Arrays.toString(initArray));
                HeapSort.heapSort(initArray, initArray.length);
                System.out.println("Sorted array:");
                System.out.println(Arrays.toString(initArray));
                break;
            default:
                System.out.println("Кто-то забыл передать  номер задачи??");
        }
    }

}

