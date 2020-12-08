/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author saifmohanad
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.of(2020, 12, 8, 18, 30);
        Duration duration = Duration.ofHours(2);
        Event event = new Event("event",  start, duration);
        System.out.println(event.isInDay(LocalDate.of(2020, 12, 9)));
        System.out.println(event.isInDay(LocalDate.of(2020, 12, 8)));
    }
    
}
