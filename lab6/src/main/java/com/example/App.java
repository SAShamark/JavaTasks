package com.example;

public class App {
    private static final int NUM_HALLS = 5;
    private static final int NUM_ROWS = 10;
    private static final int NUM_SEATS_PER_ROW = 20;

    private int[][][] cinemaSeats;

    public App() {
        cinemaSeats = new int[NUM_HALLS][NUM_ROWS][NUM_SEATS_PER_ROW];
    }

    public void bookSeats(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (cinemaSeats[hallNumber][row][seat] == 0) {
                cinemaSeats[hallNumber][row][seat] = 1;
            } else {
                System.out.println("Place " + seat + " in a row " + row + " in the hall " + hallNumber + " already booked.");
            }
        }
    }

    public void cancelBooking(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            cinemaSeats[hallNumber][row][seat] = 0;
        }
    }

    public boolean checkAvailability(int hallNumber, int numSeats) {
        for (int row = 0; row < NUM_ROWS; row++) {
            int consecutiveAvailableSeats = 0;
            for (int seat = 0; seat < NUM_SEATS_PER_ROW; seat++) {
                if (cinemaSeats[hallNumber][row][seat] == 0) {
                    consecutiveAvailableSeats++;
                    if (consecutiveAvailableSeats == numSeats) {
                        return true;
                    }
                } else {
                    consecutiveAvailableSeats = 0;
                }
            }
        }
        return false;
    }

    public void printSeatingArrangement(int hallNumber) {
        System.out.println("Placement scheme for the hall " + hallNumber + ":");
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int seat = 0; seat < NUM_SEATS_PER_ROW; seat++) {
                if (cinemaSeats[hallNumber][row][seat] == 0) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CinemaApp cinemaApp = new CinemaApp();

        int hallNumber = 2;
        int rowToBook = 3;
        int[] seatsToBook = {3, 4, 5};

        cinemaApp.bookSeats(hallNumber, rowToBook, seatsToBook);
        cinemaApp.printSeatingArrangement(hallNumber);

        int[] seatsToCancel = {4, 5};
        cinemaApp.cancelBooking(hallNumber, rowToBook, seatsToCancel);
        cinemaApp.printSeatingArrangement(hallNumber);

        int numSeatsToCheck = 3;
        boolean isAvailable = cinemaApp.checkAvailability(hallNumber, numSeatsToCheck);
        System.out.println("Are " + numSeatsToCheck + " consecutive seats available in hall " + hallNumber + "? " + isAvailable);
    }
}