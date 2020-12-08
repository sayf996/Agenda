package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */

public class RepetitiveEvent extends Event {
    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    List<LocalDate> exceptions = new LinkedList<>();
    ChronoUnit frequency;
    
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        // TODO : implémenter cette méthode
        this.frequency = frequency;
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        // TODO : implémenter cette méthode
        exceptions.add(date);
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return frequency;   
    }
    
    @Override 
    public boolean isInDay(LocalDate day){
        if(exceptions.contains(day)){
            return false;
        }
        // Dernière date d'event avant le day
        LocalDateTime closestStart = this.getStart();
        while(closestStart.toLocalDate().isBefore(day)){
            closestStart = closestStart.plus(1, frequency);
        } 
        return day.compareTo(closestStart.toLocalDate()) >= 0 && day.compareTo(closestStart.plus(this.getDuration()).toLocalDate()) <= 0;
    
    }

}
