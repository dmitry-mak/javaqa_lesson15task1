package ru.netology.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {

    @Test
    void add() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Moscow", "Pskov", 1000, 15, 18);
        Ticket ticket2 = new Ticket("Kalinin", "Tver", 10000, 17, 20);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expected = new Ticket[]{ticket1, ticket2};
        Assertions.assertArrayEquals(expected, aviaSouls.findAll());
    }

    // должен возвращать отсортированный массив билетов по времени в пути, в порядке убывания
    @Test
    public void shouldSortTicketsByTime() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1_middle = new Ticket("Moscow", "Pskov", 1000, 15, 18);
        Ticket ticket2_last = new Ticket("Moscow", "Pskov", 10000, 17, 21);
        Ticket ticket3_first = new Ticket("Moscow", "Pskov", 500, 18, 19);

        aviaSouls.add(ticket1_middle);
        aviaSouls.add(ticket2_last);
        aviaSouls.add(ticket3_first);

        Ticket[] expected = new Ticket[]{ticket3_first, ticket1_middle, ticket2_last};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moscow", "Pskov", new TicketTimeComparator());
        Assertions.assertArrayEquals(expected, actual);

    }

    //    должен возвращать отрицательное значение, если цена первого билета меньше второго
    @Test
    public void shouldSortTicketsByPrice_returnNegative() {

        Ticket ticket1_expensv = new Ticket("Moscow", "Pskov", 1000, 15, 18);
        Ticket ticket2_cheap = new Ticket("Moscow", "Pskov", 10000, 17, 21);

        int expected = -1;
        Assertions.assertEquals(expected, ticket1_expensv.compareTo(ticket2_cheap));
    }

    //    должен возвращать положительное значение, если цена первого билета выше цены второго
    @Test
    public void shouldSortTicketsByPrice_returnPositive() {

        Ticket ticket1_expensv = new Ticket("Moscow", "Pskov", 1000, 15, 18);
        Ticket ticket2_cheap = new Ticket("Moscow", "Pskov", 10000, 17, 21);

        int expected = 1;
        Assertions.assertEquals(expected, ticket2_cheap.compareTo(ticket1_expensv));
    }

    //    должен возвращать 0, если цены передаваемых билетов равны
    @Test
    public void shouldSortTicketsByPrice_returnZero() {

        Ticket ticket1 = new Ticket("Moscow", "Pskov", 1000, 17, 18);
        Ticket ticket2 = new Ticket("Moscow", "Pskov", 1000, 15, 20);

        int expected = 0;
        Assertions.assertEquals(expected, ticket1.compareTo(ticket2));
    }

    //    Должен возвращать список билетов по заданному направлению. Сортировка по времени в пути
    @Test
    void searchTest() {

        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Moscow", "Pskov", 1, 12, 13);
        Ticket ticket2 = new Ticket("Tokyo", "Budapest", 10, 12, 14);
        Ticket ticket3 = new Ticket("Moscow", "Pskov", 20, 12, 15);
        Ticket ticket4 = new Ticket("Shanghai", "Praga", 30, 12, 16);
        Ticket ticket5 = new Ticket("Moscow", "Pskov", 40, 12, 17);
        Ticket ticket6 = new Ticket("Istanbul", "Tegeran", 50, 12, 18);
        Ticket ticket7 = new Ticket("Moscow", "Pskov", 60, 12, 19);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);

        Ticket[] expected = new Ticket[]{ticket1, ticket3, ticket5, ticket7};
        Assertions.assertArrayEquals(expected, aviaSouls.search("Moscow", "Pskov"));
    }

//    Должен добавлять объекты у которых совпадают значения параметров from и to
    @Test
    public void shouldAddSimilarObjects() {

        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Moscow", "Pskov", 10, 12, 13);
        Ticket ticket2 = new Ticket("Tokyo", "Budapest", 10, 12, 14);
        Ticket ticket3 = new Ticket("Moscow", "Pskov", 10, 12, 13);
        Ticket ticket4 = new Ticket("Shanghai", "Praga", 30, 12, 16);
        Ticket ticket5 = new Ticket("Moscow", "Pskov", 10, 12, 13);
        Ticket ticket6 = new Ticket("Istanbul", "Tegeran", 50, 12, 18);
        Ticket ticket7 = new Ticket("Moscow", "Pskov", 10, 12, 13);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);

        Ticket[] expected = new Ticket[]{ticket1, ticket3, ticket5, ticket7};
        Assertions.assertArrayEquals(expected, aviaSouls.search("Moscow", "Pskov"));
    }

//    Добавляет только те объекты, у которых совпадают оба значения параметров- from и to
    @Test
    public void shouldAddSimilarObjectsPartTwo() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Moscow", "Pskov", 10, 12, 13);
        Ticket ticket2 = new Ticket("Moscow", "Budapest", 10, 12, 14);
        Ticket ticket3 = new Ticket("Pskov", "Moscow", 10, 12, 13);
        Ticket ticket4 = new Ticket("Moscow", "Prague", 30, 12, 16);
        Ticket ticket5 = new Ticket("Moscow", "Pskov", 10, 12, 13);
        Ticket ticket6 = new Ticket("Moscow", "Minsk", 50, 12, 18);
        Ticket ticket7 = new Ticket("Istanbul", "Pskov", 10, 12, 13);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);

        Ticket[] expected = new Ticket[]{ticket1, ticket5};
        Assertions.assertArrayEquals(expected, aviaSouls.search("Moscow", "Pskov"));
    }
}