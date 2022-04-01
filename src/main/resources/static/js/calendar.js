let calendar;

$(document).ready(() =>{
        // fetch data from backend.
        $.get('api/events').then((events) =>{
            // recovers div element from HTML.
            const calendarEl = document.getElementById('calendar');

            // render content inside of that div.
            calendar = new FullCalendar.Calendar(calendarEl, {
                initialView: 'dayGridMonth',
                events
            });

            calendar.render();
        })
});;
