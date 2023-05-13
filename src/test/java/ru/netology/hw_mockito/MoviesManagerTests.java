package ru.netology.hw_mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoviesManagerTests {

    @Test
    public void ShouldAddMovies() { //добавляем 7 фильмов
        MoviesManager manager = new MoviesManager();
        manager.add("Бладшот");
        manager.add("Вперед");
        manager.add("Отель «Белград»");
        manager.add("Джентельмены");
        manager.add("Человек-невидимка");
        manager.add("Тролли. Мировой тур");
        manager.add("Номер один");


        String[] actual = manager.findAll();
        String[] expected = {"Бладшот", "Вперед", "Отель «Белград»", "Джентельмены", "Человек-невидимка", "Тролли. Мировой тур", "Номер один"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldAddOneMovie() { //добавляем 1 фильм
        MoviesManager manager = new MoviesManager();
        manager.add("Джентельмены");


        String[] actual = manager.findAll();
        String[] expected = {"Джентельмены"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldAddNothing() { //ничего не добавляем
        MoviesManager manager = new MoviesManager();


        String[] actual = manager.findAll();
        String[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldReturnLast() { //последние пять без указания лимита
        MoviesManager manager = new MoviesManager();
        manager.add("Бладшот");
        manager.add("Вперед");
        manager.add("Отель «Белград»");
        manager.add("Джентельмены");
        manager.add("Человек-невидимка");
        manager.add("Тролли. Мировой тур");
        manager.add("Номер один");


        String[] actual = manager.findLast();
        String[] expected = {"Номер один" , "Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель «Белград»"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldReturnLastSeven() { //лимит 7 всего 7
        MoviesManager manager = new MoviesManager(7);
        manager.add("Бладшот");
        manager.add("Вперед");
        manager.add("Отель «Белград»");
        manager.add("Джентельмены");
        manager.add("Человек-невидимка");
        manager.add("Тролли. Мировой тур");
        manager.add("Номер один");

               String[] actual = manager.findLast();
        String[] expected = {"Номер один" , "Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель «Белград»", "Вперед", "Бладшот"};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void ShouldReturnLastTwo() { //лимит 2 всего 7
        MoviesManager manager = new MoviesManager(2);
        manager.add("Бладшот");
        manager.add("Вперед");
        manager.add("Отель «Белград»");
        manager.add("Джентельмены");
        manager.add("Человек-невидимка");
        manager.add("Тролли. Мировой тур");
        manager.add("Номер один");

        String[] actual = manager.findLast();
        String[] expected = {"Номер один" , "Тролли. Мировой тур"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldReturnLastLessLimit() { //лимит 5 всего 3, меньше лимита
        MoviesManager manager = new MoviesManager(5);

        manager.add("Человек-невидимка");
        manager.add("Тролли. Мировой тур");
        manager.add("Номер один");

        String[] actual = manager.findLast();
        String[] expected = {"Номер один" , "Тролли. Мировой тур", "Человек-невидимка"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldReturnLastEqualsLimit() { //лимит 6 всего 6, равно лимиту
        MoviesManager manager = new MoviesManager(6);

        manager.add("Вперед");
        manager.add("Отель «Белград»");
        manager.add("Джентельмены");
        manager.add("Человек-невидимка");
        manager.add("Тролли. Мировой тур");
        manager.add("Номер один");

        String[] actual = manager.findLast();
        String[] expected = {"Номер один" , "Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель «Белград»", "Вперед"};

        Assertions.assertArrayEquals(expected, actual);
    }

}
