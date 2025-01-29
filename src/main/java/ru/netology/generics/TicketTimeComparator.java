package ru.netology.generics;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        int travelTime1 = o1.getTimeTo() - o1.getTimeFrom();
        int travelTime2 = o2.getTimeTo() - o2.getTimeFrom();
        return Integer.compare(travelTime1, travelTime2);
    }
}
