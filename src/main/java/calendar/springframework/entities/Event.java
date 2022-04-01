package calendar.springframework.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Event {
    @Getter @Setter private String title;
    @Getter @Setter private String start;
    @Getter @Setter private String end;
}
