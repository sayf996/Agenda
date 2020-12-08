package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive event that terminates after a given date, or after
 * a given number of occurrences
 */
public class FixedTerminationEvent extends RepetitiveEvent {

    LocalDate terminationInclusive;
    long numberOfOccurrences;
    /**
     * Constructs a fixed terminationInclusive event ending at a given date
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param terminationInclusive the date when this event ends
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, LocalDate terminationInclusive) {
        super(title, start, duration, frequency);
        this.terminationInclusive = terminationInclusive;

    }

    /**
     * Constructs a fixed termination event ending after a number of iterations
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param numberOfOccurrences the number of occurrences of this repetitive event
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, long numberOfOccurrences) {
        super(title, start, duration, frequency);
        this.numberOfOccurrences = numberOfOccurrences;
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }

    /**
     *
     * @return the termination date of this repetitive event
     */
    public LocalDate getTerminationDate() {
        if(terminationInclusive != null){
            return terminationInclusive;
        }  
        else{
            return getStart().toLocalDate().plus(numberOfOccurrences-1, frequency);
        }
    }

    public long getNumberOfOccurrences() {
        if(numberOfOccurrences != 0){
            return numberOfOccurrences; 
        }
        else{
            return frequency.between(getStart().toLocalDate(), terminationInclusive)+1;
        }
    }
    
    @Override 
    public boolean isInDay(LocalDate day){
        if(exceptions.contains(day)){
            return false;
        }
        // Dernière date d'event avant le day
        LocalDateTime closestStart = this.getStart();
        // On vérifie qu'on ne dépasse pas le nombre d'occurrences ou la date limite
        long occurrences = 0;
        while(closestStart.toLocalDate().isBefore(day) && closestStart.toLocalDate().isBefore(terminationInclusive) && occurrences < numberOfOccurrences ){
            closestStart = closestStart.plus(1, frequency);
            occurrences++;
        } 
        return day.compareTo(closestStart.toLocalDate()) >= 0 && day.compareTo(closestStart.plus(this.getDuration()).toLocalDate()) <= 0;
    
    }
}
