package agenda;

import java.time.LocalDate;
import java.util.*;
import agenda.Event;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
/**
 * Description : An agenda that stores events
 */
public class Agenda {
    
    List<Event> listeEvents;
    public Agenda(){
        listeEvents = new LinkedList();
    }
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        listeEvents.add(e);        
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        List<Event> eventsOfTheDay = new LinkedList();
        for (int i=0; i<listeEvents.size();i++){            
            if (listeEvents.get(i).isInDay(day)){
                eventsOfTheDay.add(listeEvents.get(i));
            }
          /*LocalDate debut = listeEvents.get(i).getStart().toLocalDate();
          LocalDate fin = debut.plus(listeEvents.get(i).getDuration());
          if(day.equals(debut) || (day.isAfter(debut) && day.isBefore(fin))){
              eventsOfTheDay.add(listeEvents.get(i));
          }*/
        }
        return eventsOfTheDay;
    }
}
