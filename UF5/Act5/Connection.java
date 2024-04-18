package M3.UF5.Act5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Connection {
    private String iniDateTime;
    private String endDateTime;

    public Connection(String iniDateTime, String endDateTime) {
        this.iniDateTime = iniDateTime;
        this.endDateTime = endDateTime;
    }

    public long nMinutes() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
        LocalDateTime iniDateTimeL = LocalDateTime.parse(iniDateTime, formatter);
        LocalDateTime endDateTimeL = LocalDateTime.parse(endDateTime, formatter);
        Duration duration = Duration.between(iniDateTimeL, endDateTimeL);
        return duration.toMinutes();
    }
}