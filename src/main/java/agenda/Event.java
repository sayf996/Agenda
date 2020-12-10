package agenda;

import java.time.*;
import java.util.function.BooleanSupplier;

public class Event {

    /**
     * The myTitle of this event
     */
    private String myTitle;
    
    /**
     * The starting time of the event
     */
    private LocalDateTime myStart;

    /**
     * The duration of the event 
     */
    private Duration myDuration;
    
    private LocalDateTime myEnd;



    /**
     * Constructs an event
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
        
        
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) { 
        boolean isInDay = false;
        myEnd = myStart.plus(myDuration);
        if (aDay.compareTo(myStart.toLocalDate()) >= 0 && aDay.compareTo(myEnd.toLocalDate()) <= 0){
            isInDay = true;
        } 
        
        return isInDay;
    }
    public boolean isInHour(LocalTime T) { 
        boolean isInHour = false;
        myEnd = myStart.plus(myDuration);
        if (T.compareTo(myStart.toLocalTime()) >= 0 && T.compareTo(myEnd.toLocalTime()) <= 0){
            isInHour = true;
        } 
        
        return isInHour;
    }
            
   
    /**
     * @return the myTitle
     */
    public String getTitle() {
        return myTitle;
    }

    /**
     * @return the myStart
     */
    public LocalDateTime getStart() {
        return myStart;
    }


    /**
     * @return the myDuration
     */
    public Duration getDuration() {
        return myDuration;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return getTitle();
    }

   

   
    
}
