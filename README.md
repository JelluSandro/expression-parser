# GenericTabulator
* Калькулятор который 'парсит' выражение от 3х переменных в заданых интервалах(дефолт от -2 до 2) и выводит итоговый результат выражения
* Как запустить:
	* Build: ```javac -cp Main.java```
	* Run: ```java -cp Main 'mode' 'expression'```
	* Или можете открыть expression как проект в среде и запустить `Main` с аргументами
* Пример вывода призапуске ```java -cp Main i (x + y * z - 2)*6```
```
0 -12 -24 -36 -48 
-12 -18 -24 -30 -36 
-24 -24 -24 -24 -24 
-36 -30 -24 -18 -12 
-48 -36 -24 -12 0 

6 -6 -18 -30 -42 
-6 -12 -18 -24 -30 
-18 -18 -18 -18 -18 
-30 -24 -18 -12 -6 
-42 -30 -18 -6 6 

12 0 -12 -24 -36 
0 -6 -12 -18 -24 
-12 -12 -12 -12 -12 
-24 -18 -12 -6 0 
-36 -24 -12 0 12 

18 6 -6 -18 -30 
6 0 -6 -12 -18 
-6 -6 -6 -6 -6 
-18 -12 -6 0 6 
-30 -18 -6 6 18 

24 12 0 -12 -24 
12 6 0 -6 -12 
0 0 0 0 0 
-12 -6 0 6 12 
-24 -12 0 12 24 
```
* Таким образом мы получим таблицы значений выражения для интервалов переменных от (-2 до 2)
## Доступные функции
* Класс `GenericTabulator` реализовывает интерфейс [Tabulator](java/expression/generic/Tabulator.java) и
* сроит трехмерную таблицу значений заданного выражения.
```
public interface Tabulator {
    Object[][][] tabulate(
        String mode, String expression, 
        int x1, int x2, int y1, int y2, int z1, int z2
    ) throws Exception;
}
```
  * `mode` – режим вычислений:
     * `i` – вычисления в `int` с проверкой на переполнение;
     * `d` – вычисления в `double` без проверки на переполнение;
     * `bi` – вычисления в `BigInteger`.
	 * `u` – вычисления в `int` без проверки на переполнение;
     * `p` – вычисления в целых числах по модулю 1009;
     * `b` – вычисления в `byte` без проверки на переполнение
  * `expression` – выражение, для которого надо построить таблицу;
  * Например: `x * (x - 2)*x + 1`
  * В записи выражения могут встречаться:
	* бинарные операции: умножение `*`, деление `/`, сложение `+` и вычитание -, `mod` взятие по модулю (`1 + 5 mod 3` равно `1 + (5 mod 3)` равно `3`).; 
	* унарные операции: - ,`abs`, `square`;
	* переменные `x`, `y` и `z`;
	* константы взависимости от режима вычисления;
	* круглые скобки для явного обозначения приоритета операций;
	* произвольное число пробельных символов в любом месте, не влияющем на однозначность понимания формулы (например, между операцией и переменной, но не внутри констант).
* Приоритет операций, начиная с наивысшего
	* унарный минус, abs, square
	* умножение и деление,  `mod` – взятие по модулю, приоритет как у умножения (`1 + 5 mod 3` равно `1 + (5 mod 3)` равно `3`).;
	* сложение и вычитание.
* Разбор выражений производиться методом рекурсивного спуска.
* Алгоритм работает за линейное время.
  * `x1`, `x2` – минимальное и максимальное значения переменной `x` (включительно)
  * `y1`, `y2`, `z1`, `z2` – аналогично для `y` и `z`.
  * Результат: элемент `result[i][j][k]` содержит
  * значение выражения для `x = x1 + i`, `y = y1 + j`, `z = z1 + k`.
  * Если значение не определено (например, по причине переполнения),
  * то соответствующий элемент равен `null`.