import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Logger;


public class BubbleSort {
    static Logger logger = Logger.getLogger(Answer.class.getName());
    static String msglog; // Сообщения для записи в журнал
    private static File log;
    private static FileWriter fileWriter;

    // Задача 2-2
    // сортировка пузырьком числового массива
    public static void sort(int[] mas) {
        log = new File("log.txt");
        try (FileWriter thisFlWrt = new FileWriter(log, false)) {
            log.createNewFile();
            fileWriter = new FileWriter(log);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        boolean isSorted = false;
        int retry = 0;
        int checks = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length - 1 - retry; i++) {
                //logger.info(" Step "+retry+" check "+i);
                int tmp;
                checks = i;
                if (mas[i] > mas[i + 1]) {
                    isSorted = false;
                    tmp = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = tmp;
                }
            }
            logger.info(Arrays.toString(mas) + " Step " + retry + " checks " + checks);
            retry++;
            // Запишем в файл журнала
            try {
                fileWriter = new FileWriter(log, true);
                Date thisDate = new Date();
                SimpleDateFormat thisFormatDate = new SimpleDateFormat("Y-M-d H:m ");
                String msg = thisFormatDate.format(thisDate);
                msg = msg.concat(Arrays.toString(mas));
                fileWriter.write(msg);
                fileWriter.append('\n');
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}