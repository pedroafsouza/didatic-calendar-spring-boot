package calendar.springframework.controllers;

import calendar.springframework.entities.Event;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@RestController
public class EventsController {
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");

    @RequestMapping(value = "/api/events")
    public ArrayList<Event> available() {
        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event("Drink a beer", getDate(0), getDate(0)));
        events.add(new Event("Pedro Birthday", getDate(1), getDate(1)));
        events.add(new Event("Fernanda Birthday", getDate(3), getDate(3)));
        events.add(new Event("Oral Exam", getDate(3), getDate(3)));
        events.add(new Event("World cup", getDate(6), getDate(6)));
        events.add(new Event("Complain about bolsonaro", getDate(8), getDate(8)));
        return events;
    }


    private String getDate(int addDays){
        LocalDate from = LocalDate.now(ZoneId.systemDefault());
        return from.plusDays(addDays).format(dateFormatter);
    }
}
