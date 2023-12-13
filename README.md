# Java  (семинары): знакомство и как пользоваться базовым API

Для решения данного домашнего задания вам необходимо воспользоваться сервисом автоматической проверки написанного кода.
Для того, чтобы успешно выполнить задание, необходимо перейти по каждой из представленных ссылок и решить все предложенные задачи. Будьте внимательны, количество попыток отправки кода на проверку ограничено! Вам дано 5 попыток на каждую задачу.
Итоговая оценка домашнего задания появится автоматически на платформе после решения всех задач. Полученная оценка не повлияет на получение итогового документа об обучении.

Основной класс Sem1, который в методе main запускает нужный урок.
Вспомогательный класс - Answer, в большинстве случаев, содержит методы решения задач.

---
## Урок 1. Знакомство с языком программирования Java

Для урока 1 это вызов метода gbPrinter (n), где n - номер задачи

### Задача 1
Вычислить n-ое треугольного число(сумма чисел от 1 до n).

Внутри класса Answer напишите метод countNTriangle, который принимает число n и возвращает его n-ое треугольное число.
Если число n < 1 (ненатуральное) метод должен вернуть -1.

Пример
```
n = 4 -> 10

n = 5 -> 15
```
Проверка решения. Вызов метода - Answer.countNTriangle(i);

### Задача 2
Напишите функцию printPrimeNums, которая выведет на экран все простые числа в промежутке от 1 до 1000, каждое на новой строке.

Напишите свой код в методе printPrimeNums класса Answer.

Пример
```
2
3
5
7
11
...
```
Проверка решения. Вызов метода - Answer.printPrimeNums();

### Задача 3
В методе calculate класса Calculator реализовать калькулятор, который будет выполнять математические операции (+, -, *, /) над двумя целыми числами и возвращать результат вещественного типа.

В классе Printer необходимо реализовать проверку переданного оператора, при некорректном операторе программа должна вывести сообщение об ошибке "Некорректный оператор: 'оператор'".

Аргументы, передаваемые в метод/функцию:
```
'3'
'+'
'7'
```
На выходе:
```
10.0
```
Проверка решения. Вызов метода - Answer.calculate(item, 3, 7);;

---
## Урок 5. Хранение и обработка данных ч2: множество коллекций Map

Для урока 5 это вызов метода gbPrinterLesson5(n), где n - номер задачи

### Задача 1 (Класс PhoneBook)
Напишите программу, представляющую телефонную книгу. Программа должна иметь следующие функции:

add(String name, Integer phoneNum): Добавляет запись в телефонную книгу.
Если запись с именем name уже существует, добавляет новый номер телефона в существующую запись.
Если запись с именем name не существует, создает новую запись с этим именем и номером телефона phoneNum.

find(String name): Поиск номеров телефона по имени в телефонной книге.
Если запись с именем name существует, возвращает список номеров телефона для этой записи.
Если запись с именем name не существует, возвращает пустой список.

getPhoneBook(): Возвращает всю телефонную книгу в виде HashMap, где ключи - это имена, а значения - списки номеров телефона.

Пример.

На входе:
```java
add("Alice", 123456);   
add("Alice", 789012);   
add("Bob", 789012); 
```
На выходе:

Команды:
```java
find("Alice")
getPhoneBook()
find("Me")
```
Результат
```java
[123456, 789012].
{Bob=[789012], Alice=[123456, 789012]}
[]
```
Решение - Класс PhoneBook

Для проверки вызов метода gbPrinterLesson5(1)

### Задача 2 (Класс NamesCounter)
Вы работаете с приложением для учета имен пользователей. Ваша задача - разработать программу, которая принимает на вход пять имен пользователей (или использует имена по умолчанию, если аргументы не предоставлены) и подсчитывает, сколько раз каждое имя встречается.
Программа должна использовать HashMap для хранения имен и их количества вхождений.
По завершении, программа выводит результат в виде пар "имя - количество".

На входе:
```
'Elena'
'Elena'
'Elena'
'Ivan'
'Ivan'
```
На выходе:
```java
{Ivan=2, Elena=3}
```
Решение - Класс NamesCounter

Для проверки вызов метода gbPrinterLesson5(2)