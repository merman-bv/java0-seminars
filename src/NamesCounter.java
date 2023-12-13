import java.util.HashMap;
public class NamesCounter {
    private HashMap<String, Integer> names = new HashMap<>();

    // Метод для добавления имени в HashMap
    public void addName(String name) {
        // Введите свое решение ниже
        if (names.containsKey(name)) {
            int count = names.get(name) + 1;
            names.replace(name,count);
        } else {
            names.put(name, 1);
        }
    } // --- Finish add

    // Метод для вывода содержимого HashMap
    public void showNamesOccurrences() {
        // Введите свое решение ниже
        System.out.println(names);
    }

}
