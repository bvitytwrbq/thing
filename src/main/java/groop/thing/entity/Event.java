package groop.thing.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    private int id;


    private String eventTitle;

    private String eventLocation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventDate;

    public Event() {
    }

    public Event(String eventTitle, String eventLocation, LocalDate eventDate) {
        this.eventTitle = eventTitle;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
    }

    /*    @ManyToMany(mappedBy = "events")
    private List<Event> locations = new ArrayList<>();*/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

/*    public List<Event> getLocations() {
        return locations;
    }

    public void setLocations(List<Event> locations) {
        this.locations = locations;
    }*/
}
