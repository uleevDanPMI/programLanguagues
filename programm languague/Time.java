public class Time {
    public int hour;
    public int minute;
    public int second;

    public Time(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }

    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60 || second < 0 || second >= 60) {
            throw new IllegalArgumentException("Это значение времени недопустимо");
        }

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void addedHours(int hours) {
        int newHour = (this.hour + hours) % 24;
        if (newHour < 0) {
            newHour += 24;
        }
        this.hour = newHour;
    }

    public void addedMinutes(int minutes) {
        int totalMinutes = this.hour * 60 + this.minute + minutes;
        this.hour = (totalMinutes / 60) % 24;
        if (this.hour < 0) {
            this.hour += 24;
        }
        this.minute = totalMinutes % 60;
    }

    public void addedSeconds(int seconds) {
        int totalSeconds = this.hour * 3600 + this.minute * 60 + this.second + seconds;
        this.hour = (totalSeconds / 3600) % 24;
        if (this.hour < 0) {
            this.hour += 24;
        }
        totalSeconds %= 3600;
        this.minute = totalSeconds / 60;
        this.second = totalSeconds % 60;
    }
}