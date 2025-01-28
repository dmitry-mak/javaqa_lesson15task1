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
}