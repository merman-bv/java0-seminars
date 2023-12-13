import java.security.KeyStore;
import java.sql.Array;
import java.sql.RowId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.*;
import java.io.File;
import java.io.IOException;

// --- Lesson 2. Exercise 2. Start
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;
// --- Lesson 2. Exercise 2. End

// --- Lesson 2. Exercise 3. Start
import java.util.Arrays.*;
// --- Lesson 2. Exercise 3. End
import java.util.*;

import java.util.stream.*;
import java.util.stream.Stream.*;


public class Answer {

    static Logger logger = Logger.getLogger(Answer.class.getName());
    static String msglog; // Сообщения для записи в журнал

    Deque<Integer> MemCalculate = new ArrayDeque<>(); // Для метода Calculate Задачи 1-3 и 4-2


    public static void main(String[] args) {
        //Logger logger = Logger.getLogger(Answer.class.getName());
        //Logger logger = Logger.getLogger(Answer.class.getName());
        logger.setLevel(Level.INFO);

        ConsoleHandler ch = new ConsoleHandler();
        logger.addHandler(ch);

        SimpleFormatter sFormat = new SimpleFormatter();
        ch.setFormatter(sFormat);
        FileHandler fileHndlr;
        try {
            fileHndlr = new FileHandler();
        } catch (IOException e) {
            //e.printStackTrace();
            throw new RuntimeException();
        }
        logger.addHandler(fileHndlr);
        fileHndlr.setFormatter(sFormat);
        logger.log(Level.WARNING, "Start log");
        //}
        //FileHandler fh = new FileHandler ('/answer%/u.log');
        //logger.addHandler(fh);

        logger.log(Level.WARNING, "Тестовое логирование");
        logger.info("Тестовое логирование");
    }

    // Задача 1.
    public int countNTriangle(int n) {
        // Введите свое решение ниже
        int tnum = 0;
        for (int i = 1; i <= n; i++) {
            tnum = tnum + i;
        }
        return tnum;
    }

    // Задача 2
    // показать простые числа
    public void printPrimeNums() {
        for (int i = 1; i <= 1000; i++) {
            //msglog = "Start testing i="+Integer.toString(i);
            //logger.info(msglog);
            boolean simpleNum = isSimpleNum(i);
            if (simpleNum) System.out.println(i);
        }
    }


    private static boolean isSimpleNum(int testNum) {
        // Задача 2. Дополнительный метод
        boolean flag = false;
        //msglog = "SimpleNum start with testNum="+Integer.toString(testNum);
        //logger.info(msglog);
        if (testNum == 1) flag = false;
        else {
            int j = 2;
            while (j <= testNum) {
                if (testNum % j == 0) flag = true;
                else flag = false;
                if (flag & j != testNum) {
                    flag = !flag;
                    j = testNum + 10;
                } else j++;
            }
        }
        return flag;
    }


    public int calculate(char op, int a, int b) {
        // Задача 3
        // про калькулятор, с операциями ("+", "-", "*", "/")
        int resultat = 0;
        //Deque MemCalculate = new ArrayDeque();
        switch (op) {
            case '+':
                resultat = a + b;
                //msglog = "op + res="+Integer.toString(resultat);
                MemCalculate.push(resultat);
                break;

            case '-':
                resultat = a - b;
                //msglog = "op - res="+Integer.toString(resultat);
                MemCalculate.push(resultat);
                break;

            case '*':
                resultat = a * b;
                //msglog = "op * res="+Integer.toString(resultat);
                MemCalculate.push(resultat);
                break;

            case '/':
                resultat = a / b;
                //msglog = "op / res="+Integer.toString(resultat);
                MemCalculate.push(resultat);
                break;

            case '<':
                resultat = MemCalculate.pop();
                resultat = MemCalculate.peek();
                break;

            default:
                msglog = "Некорректный оператор: ";
                msglog = msglog.concat(Character.toString(op));
                throw new IllegalArgumentException(msglog);
        }
        //msglog = "SimpleNum start with testNum="+Integer.toString(testNum);
        //logger.info(msglog);
        return resultat;
    }


    public StringBuilder querySting(String QUERY, String PARAMS) {
        // Задача 2-1
        // select * from students where "
        PARAMS = PARAMS.replaceAll("\"", "");//Удалим все кавычки
        //System.out.println(PARAMS);
        PARAMS = PARAMS.trim();
        String[] thisArr = PARAMS.substring(1, PARAMS.length() - 1).split(",");// Разобьем на пары

        StringBuilder thisStrBldr = new StringBuilder();
        thisStrBldr.append(QUERY);

        //Map<String, String> thisList = new HashMap<String, String>();

        Boolean flag = false;
        for (int i = 0; i < thisArr.length; i++) {
            String[] thisRow = new String[2];
            //msglog = thisArr[i];
            //logger.info(msglog);
            thisArr[i] = thisArr[i].trim();
            thisRow = thisArr[i].split(":");
            if (!thisRow[1].equals(("null"))) {
                if (flag) thisStrBldr.append(" and ");
                thisStrBldr.append(thisRow[0]);
                thisStrBldr.append("='");
                thisStrBldr.append(thisRow[1]);
                thisStrBldr.append("'");
                flag = true;
            }

        }

        //msglog = thisStrBldr.toString();
        //logger.info(msglog);
        return thisStrBldr;
    }


    public static void BubbleSort(int[] arr) {
        // Задача 2-2
        // сортировка пузырьком числового массива
        int[] beforeArr = Arrays.copyOf(arr, arr.length);//Копия массива для вывода на экран
        BubbleSort bubble = new BubbleSort();
        bubble.sort(arr);
        System.out.println(Arrays.toString(beforeArr) + " Before");
        System.out.println("------ Журнал ------");
        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int[] mergeSort(int[] a) {
        // Lesson 2. Exercise 1
        // сортировка слиянием
        //logger.info("Начало с массивом "+Arrays.toString(a));
        if (a == null) return null;
        // Проверим, если элемент 1, то делить нечего и вернем его.
        if (a.length < 2) return a;
        if (a.length == 2) {
            if (a[0] > a[1]) {
                int buf = a[0];
                a[0] = a[1];
                a[1] = buf;
            }
            // Если элементы равны ничего делать не надо
            // Если первый элемент меньше ничего делать на надо
            //logger.info("Массив из 2 элементов отсортирован: "+Arrays.toString(a));
            return a;
        }

        // Поделим массив пополам на левый и правый
        int[] left = Arrays.copyOf(a, a.length / 2);
        int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);
        //logger.info("left & right :"+Arrays.toString(left)+" & "+Arrays.toString(right));
        // Запустить эту процедуру ещё раз с левым и правым массивом
        int[] left1 = mergeSort(left);
        int[] right1 = mergeSort(right);
        //logger.info("left  & right after "+Arrays.toString(left1)+" & "+Arrays.toString(right1));
        // Возвраты по условиям длина массива 1
        return mergeSortArr(left1, right1);
    } // --- окончание метода  mergeSort ---


    private static int[] mergeSortArr(int[] leftArr, int[] rightArr) {
        /* Считаем, что каждый массив отсортирован */
        //msglog = "Начало mergeSortArr с массивами " + Arrays.toString(leftArr) + " и " + Arrays.toString(rightArr);
        //logger.info(msglog);

        int[] result = new int[leftArr.length + rightArr.length];
        // Если оба полученных массива пустые, тогда вернем пустой массив
        if (result.length == 0) return result;
        // Если один из полученных массивов пустой, то вернем либо левый, либо правый
        //?????
        //if (result.length == leftArr.length) return leftArr;
        //else return rightArr;
        //msglog = "Длины массивов отличны от 0 " + Arrays.toString(leftArr) + " и " + Arrays.toString(rightArr);
        //logger.info(msglog);

        //int leftSizeArr = 0; int rightSizeArr = 0;// ?? Размеры левого и правого массивов
        //int leftPos = 0; int rightPos = 0; // ?? Текущая позиция проверки левого и правого массива

        //int curPos = 2; // Текущая позиция проверки
        // zeroElem - истина когда первый элемент из левого массива
        boolean zeroElem = false;

        // Проверим и первые элементы исходных массивов
        // Определим первый элемент массива-результата
        if (leftArr[0] > rightArr[0]) {
            result[0] = rightArr[0];
            zeroElem = false;
        } else {
            result[0] = leftArr[0];
            zeroElem = true;
        }
        //logger.info("Первый элемент найден: " + Arrays.toString(result));

        // С первым элементом определились.
        // Если слева и справа по одному элементу дополним результат и выйдем
        if (result.length == 2) {
            if (zeroElem) result[1] = rightArr[0];
            else result[1] = leftArr[0];
            //logger.info("Массивы по одному элементу: " + Arrays.toString(result));
            return result;
        }

        // Определим количество элементов, в левой и правой части, после выбора первого элемента результата
        int leftNewSize;
        int rightNewSize; // Расчетные размеры левой и правой части
        int[] leftNewArr;
        int[] rightNewArr; // Объявляем новые левые и правые части
        if (zeroElem) {
            leftNewSize = leftArr.length - 1;
            rightNewSize = rightArr.length;
        } else {
            leftNewSize = leftArr.length;
            rightNewSize = rightArr.length - 1;
        }
        //msglog = "Новые размеры: левой - " + Integer.toString(leftNewSize);
        //msglog = msglog + " и правой - " + Integer.toString(rightNewSize);
        //logger.info(msglog);

        /* Если в массиве-результате 3 элемента. Сравним новые длины массивов */

        int[] tail;
        if (result.length == 3) {
            //msglog = "Размер 3-Начало : " +  Arrays.toString(leftArr);
            //msglog = msglog + " / "+Arrays.toString(rightArr) + " Результат: ";
            //msglog = msglog + Arrays.toString(result);
            //logger.info(msglog);
            // Осталось разобрать 2 элемента
            //logger.info("Размер 3 начало: " + Arrays.toString(result));
            if (leftNewSize != rightNewSize) {
                // Означает, в одной новой части 0 элементов, в другой 2 элемента.
                // Всего элементов 3. С первым уже определились, осталось 2.
                //Вспомним, что каждый массив уже отсортирован
                if (leftNewSize == result.length - 1) {
                    logger.info("Размер 3 2/0: " + Arrays.toString(leftArr) + " / " + Arrays.toString(rightArr));
                    // В этой - левой части 2 элемента. Дополним массив-результат
                    for (int i = 0; i < leftArr.length; i++) {
                        result[1 + i] = leftArr[i];
                    }
                    //result[1]=leftArr[1];result[2]=leftArr[2];
                } else {
                    logger.info("Размер 3 0/2: " + Arrays.toString(leftArr) + " / " + Arrays.toString(rightArr));
                    // В этой - правой части 2 элемента. Дополним массив-результат
                    for (int i = 0; i < rightArr.length; i++) {
                        result[1 + i] = rightArr[i];
                    }
                    //result[1]=rightArr[1];result[2]=rightArr[2];
                }
            } else {
                //logger.info("Размер 3 1/1: " + Arrays.toString(result));
                // Теперь известно что, новые левая и правая части равны и в них по одному элементу.
                // Вопрос из какой части забрали в массив-результат
                // Вызовем сам метод, который вернет по длине 2 отсортированный массив.
                if (zeroElem) {
                    leftNewArr = Arrays.copyOfRange(leftArr, 1, leftArr.length);
                    rightNewArr = Arrays.copyOf(rightArr, rightArr.length);
                } else {
                    leftNewArr = Arrays.copyOf(leftArr, leftArr.length);
                    rightNewArr = Arrays.copyOfRange(rightArr, 1, rightArr.length);
                }
                logger.info("Размер 3 1/1: " + Arrays.toString(leftNewArr) + " / " + Arrays.toString(rightNewArr));
                tail = mergeSortArr(leftNewArr, rightNewArr);
                result[1] = tail[0];
                result[2] = tail[1];
            }
            msglog = "Размер 3 Финиш: левый " + Integer.toString(leftNewSize);
            msglog = msglog + " правый " + Integer.toString(rightNewSize) + " Результат: ";
            msglog = msglog + Arrays.toString(result);
            logger.info(msglog);
            return result;
            // --- Окончание c 3-мя элементами. Других комбинаций нет ---
        }

        msglog = "Результат 4: левый " + Arrays.toString(leftArr);
        msglog = msglog + " правый " + Arrays.toString(rightArr) + " Результат: ";
        msglog = msglog + Arrays.toString(result);
        logger.info(msglog);
        // Осталось разобрать 3 элемента
        // В каждой части были по 2 элемента и один элемент забрали в массив-результат
        // Новые размеры могут быть только, либо 1, либо 2
        // Надо понять с какой стороны 1, а с какой 2.
        if (leftNewSize > rightNewSize) {
            if (zeroElem) {
                leftNewArr = Arrays.copyOfRange(leftArr, 1, leftArr.length);
                rightNewArr = Arrays.copyOf(rightArr, rightArr.length);
            } else {
                leftNewArr = Arrays.copyOf(leftArr, leftArr.length);
                rightNewArr = Arrays.copyOfRange(rightArr, 1, rightArr.length);
            }
        } else {
            if (zeroElem) {
                leftNewArr = Arrays.copyOfRange(leftArr, 1, leftArr.length);
                rightNewArr = Arrays.copyOf(rightArr, rightArr.length);
            } else {
                leftNewArr = Arrays.copyOf(leftArr, leftArr.length);
                rightNewArr = Arrays.copyOfRange(rightArr, 1, rightArr.length);
            }
        }
        tail = mergeSortArr(leftNewArr, rightNewArr);
        for (int i = 0; i < tail.length; i++) {
            result[1 + i] = tail[i];
        }
        msglog = "Финиш левый " + Arrays.toString(leftArr);
        msglog = msglog + " правый " + Arrays.toString(rightArr) + " Результат: ";
        msglog = msglog + Arrays.toString(result);
        logger.info(msglog);
        return result;
    } // --- Окончание метода mergeSortArr


    public static void removeEvenNumbers(Integer[] arr) {
        System.out.println(Arrays.toString(arr));
        ArrayList NumList = new ArrayList<Integer>();
        //Arrays.stream(arr).forEach((e) -> {NumList.add(e);});
        for (int i = 0; i < arr.length; i++) {
            NumList.add(arr[i]);
        }
        Iterator<Integer> NumIterator = NumList.iterator();
        while (NumIterator.hasNext()) {
            Integer NextNum = NumIterator.next();
            if (NextNum.intValue() % 2 == 0) {
                NumIterator.remove();
            }
            ;
        }
        NumList.toArray(arr);
        arr = Arrays.copyOf(arr, NumList.size());
        System.out.println(Arrays.toString(arr));
    }


    public static void analyzeNumbers(Integer[] arr) {
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        ArrayList<Integer> NumList = new ArrayList<Integer>(Arrays.asList(arr));
        System.out.println("Minimum is " + Collections.min(NumList));
        System.out.println("Maximum is " + Collections.max(NumList));
        System.out.println("Average is = " + NumList.stream().mapToInt(i->i).sum()/NumList.size());

    }


    public  static LinkedList<Object> revertLLTasks (LinkedList<Object> ll) {
        // Урок 4 Задание 1
        // Разворот списка
        int cur = ll.size()-1;
        LinkedList<Object> llResult = new LinkedList<>();
        for (int i = 0; i < ll.size(); i++) {
            llResult.add(ll.get(cur));
            cur--;
        }
        return llResult;
    } // --- Окончание revertLLTasks

} //--- Окончание класса
