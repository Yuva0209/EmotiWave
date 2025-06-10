import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class MoodAnalyzer {

    public static String getQuote(String mood) {
        switch (mood.toLowerCase()) {
            case "happy":
                return "Happiness is a direction, not a place. – Sydney J. Harris";
            case "sad":
                return "Sadness flies away on the wings of time. – Jean de La Fontaine";
            case "angry":
                return "Speak when you are angry and you will make the best speech you will ever regret. – Ambrose Bierce";
            case "relaxed":
                return "Almost everything will work again if you unplug it for a few minutes. – Anne Lamott";
            case "stressed":
                return "The greatest weapon against stress is our ability to choose one thought over another. – William James";
            case "inspired":
                return "Start where you are. Use what you have. Do what you can. – Arthur Ashe";
            default:
                return "Keep shining, you're doing amazing!";
        }
    }

    public static String getSong(String mood) {
        switch (mood.toLowerCase()) {
            case "happy":
                return "\"Happy\" by Pharrell Williams";
            case "sad":
                return "\"Someone Like You\" by Adele";
            case "angry":
                return "\"Numb\" by Linkin Park";
            case "relaxed":
                return "\"Weightless\" by Marconi Union";
            case "stressed":
                return "\"Let It Be\" by The Beatles";
            case "inspired":
                return "\"Hall of Fame\" by The Script ft. will.i.am";
            default:
                return "Silence can be music too 🌌";
        }
    }

    public static void logMood(String mood, String quote, String song) {
        try (FileWriter writer = new FileWriter("logs/mood_log.txt", true)) {
            writer.write("Mood: " + mood + "\n");
            writer.write("Time: " + LocalDateTime.now() + "\n");
            writer.write("Quote: " + quote + "\n");
            writer.write("Song: " + song + "\n");
            writer.write("------------------------\n");
        } catch (IOException e) {
            System.out.println("Error logging mood: " + e.getMessage());
        }
    }
}