package ru.netology.generics;

public class Main {
    public static void main(String[] args) {


        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1Middle = new Ticket("Moscow", "Pskov", 1000, 15, 18);
        Ticket ticket2Last = new Ticket("Moscow", "Pskov", 10000, 17, 21);
        Ticket ticket3First = new Ticket("Moscow", "Pskov", 500, 18, 19);

        aviaSouls.add(ticket1Middle);
        aviaSouls.add(ticket2Last);
        aviaSouls.add(ticket3First);

        for (Ticket ticket : aviaSouls.findAll()) {
            System.out.println(ticket);
        }

        Ticket[] sortedTicketList = aviaSouls.searchAndSortBy("Moscow", "Pskov", new TicketTimeComparator());
        System.out.println(" ");
        System.out.println("SORTING");
        System.out.println(" ");
        for (Ticket ticket : sortedTicketList) {
            System.out.println(ticket);
        }
    }
}