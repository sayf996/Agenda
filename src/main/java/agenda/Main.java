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
        Duration duration = Duration.ofHours(8);
        Event event = new Event("event",  start, duration);
        for (int i = 7; i < 11; i++){
        if (event.isInDay(LocalDate.of(2020, 12, i))) {
            System.out.println("YOU HAVE AN EVENT THIS DAY!");
        } else {
            System.out.println("There is no Event in that day");
        }}
        
    }
    
}
