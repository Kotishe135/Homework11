package com.example.sort_test;

import com.example.Main;
import org.hamcrest.MatcherAssert;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Unit-тесты для сортировок массивов типа int.
 *
 * @author Kotov S.V.
 * @version 1.0 27.03.2019
 */

public class Sort_test {
    /**
     * Массив из целочисленных положительных элементов
     */
    private static final int[] NORMAL_ARRAY = {2, 8, 3, 45, 946, 42, 12, 21};
    /**
     * Пустой массив
     */
    private static final int[] EMPTY_ARRAY = {};
    /**
     * Массив из одинаковых элелементов
     */
    private static final int[] IDENTICAL_ELEMENTS_ARRAY = {42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42};
    /**
     * Массив из большого кол-ва элементов
     */
    private static final int[] VERY_LONG_ARRAY = new int[9999];
    /**
     * Массив с отрицательными значениями
     */
    private static final int[] NEGATIVE_ARRAY = {-4, -435436443, -34, 54236, 123, 634, -1, 0, 1};

    /**
     * Метод для создания "длинного массива"
     */
    @BeforeClass
    public static void initArray(){
        for (int i = 0; i < VERY_LONG_ARRAY.length; i++){
            VERY_LONG_ARRAY[i] = (int) Math.random()*1000 - 500;
        }
    }

    /**
     * Тест для сортировки всеми видами сортировки на "нормальном" массиве
     */
    @Test
    public void testSortNormal() {
        MatcherAssert.assertThat("Ошибка!\nСортировка: coctail\n Обычный массив",
                testArray(Main.cocktailSort(NORMAL_ARRAY)));
        MatcherAssert.assertThat("Ошибка!\nСортировка: quick\n Обычный массив",
                testArray(Main.quickSort(NORMAL_ARRAY)));
        MatcherAssert.assertThat("Ошибка!\nСортировка: comb\n Обычный массив",
                testArray(Main.combSort(NORMAL_ARRAY)));
        MatcherAssert.assertThat("Ошибка!\nСортировка: gnome\n Обычный массив",
                testArray(Main.gnomeSort(NORMAL_ARRAY)));
        MatcherAssert.assertThat("Ошибка!\nСортировка: selection\n Обычный массив",
                testArray(Main.selectionSort(NORMAL_ARRAY)));
    }

    /**
     * Тест для сортировки на "пустом" массиве
     */
    @Test
    public void testSortEmpty() {
        try {
            Main.cocktailSort(EMPTY_ARRAY);
        } catch (RuntimeException e) {
            MatcherAssert.assertThat("Ошибка\nСортировка: cocktail\n Пустой массив", false);
        }
        try {
            Main.quickSort(EMPTY_ARRAY);
        } catch (RuntimeException e) {
            MatcherAssert.assertThat("Ошибка\nСортировка: quick\n Пустой массив", false);
        }
        try {
            Main.combSort(EMPTY_ARRAY);
        } catch (RuntimeException e) {
            MatcherAssert.assertThat("Ошибка\nСортировка: comb\n Пустой массив", false);
        }
        try {
            Main.gnomeSort(EMPTY_ARRAY);
        } catch (RuntimeException e) {
            MatcherAssert.assertThat("Ошибка\nСортировка: gnome\n Пустой массив", false);
        }
        try {
            Main.selectionSort(EMPTY_ARRAY);
        } catch (RuntimeException e) {
            MatcherAssert.assertThat("Ошибка\nСортировка: selection\n Пустой массив", false);
        }
    }

    /**
     * Тест для сортировки на массиве из повторящющихся значений
     */
    @Test
    public void testSortIdentical() {
        MatcherAssert.assertThat("Ошибка\nСортировка: cocktail\n  Массив из повторяющихся значений",
                testArray(Main.cocktailSort(IDENTICAL_ELEMENTS_ARRAY)));
        MatcherAssert.assertThat("Ошибка\nСортировка: quick\n  Массив из повторяющихся значений",
                testArray(Main.quickSort(IDENTICAL_ELEMENTS_ARRAY)));
        MatcherAssert.assertThat("Ошибка\nСортировка: comp\n  Массив из повторяющихся значений",
                testArray(Main.combSort(IDENTICAL_ELEMENTS_ARRAY)));
        MatcherAssert.assertThat("Ошибка\nСортировка: gnome\n  Массив из повторяющихся значений",
                testArray(Main.gnomeSort(IDENTICAL_ELEMENTS_ARRAY)));
        MatcherAssert.assertThat("Ошибка\nСортировка: selection\n  Массив из повторяющихся значений",
                testArray(Main.selectionSort(IDENTICAL_ELEMENTS_ARRAY)));
    }

    /**
     * Тест для сортировки на массиве из большого кол-ва элементов
     */
    @Test
    public void testSortLong() {
        try {
            Main.cocktailSort(VERY_LONG_ARRAY);
        } catch (StackOverflowError e) {
            MatcherAssert.assertThat("Ошибка\nСортировка: cocktail\n Массив из большого кол-ва элементов",
                    false);
        }
        try {
            Main.quickSort(VERY_LONG_ARRAY);
        } catch (StackOverflowError e) {
            MatcherAssert.assertThat("Ошибка\nСортировка: quick\n Массив из большого кол-ва элементов",
                    false);
        }
        try {
            Main.combSort(VERY_LONG_ARRAY);
        } catch (StackOverflowError e) {
            MatcherAssert.assertThat("Ошибка\nСортировка: comb\n Массив из большого кол-ва элементов",
                    false);
        }
        try {
            Main.gnomeSort(VERY_LONG_ARRAY);
        } catch (StackOverflowError e) {
            MatcherAssert.assertThat("Ошибка\nСортировка: gnome\n Массив из большого кол-ва элементов",
                    false);
        }
        try {
            Main.selectionSort(VERY_LONG_ARRAY);
        } catch (StackOverflowError e) {
            MatcherAssert.assertThat("Ошибка\nСортировка: selection\n Массив из большого кол-ва элементов",
                    false);
        }
    }

    /**
     * Тест для сортировки пузырьком на массиве с отрицательными числами
     */
    @Test
    public void testSortNegative() {
        MatcherAssert.assertThat("Ошибка\nСортировка: cocktail\n  Массив c отрицательными элементами",
                testArray(Main.cocktailSort(NEGATIVE_ARRAY)));
        MatcherAssert.assertThat("Ошибка\nСортировка: quick\n  Массив c отрицательными элементами",
                testArray(Main.quickSort(NEGATIVE_ARRAY)));
        MatcherAssert.assertThat("Ошибка\nСортировка: comp\n  Массив c отрицательными элементами",
                testArray(Main.combSort(NEGATIVE_ARRAY)));
        MatcherAssert.assertThat("Ошибка\nСортировка: gnome\n  Массив c отрицательными элементами",
                testArray(Main.gnomeSort(NEGATIVE_ARRAY)));
        MatcherAssert.assertThat("Ошибка\nСортировка: selection\n  Массив c отрицательными элементами",
                testArray(Main.selectionSort(NEGATIVE_ARRAY)));
    }

    /**
     * Проверка правильной сортировки массива
     *
     * @param arr входной массив
     * @return true - правильно отсортрован
     * false - неправильно
     */
    private boolean testArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
