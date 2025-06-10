import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MoodAnalyzer {


    public static Map<String, String> getSongs(String mood) {
        Map<String, String> songs = new HashMap<>();
        switch (mood.toLowerCase()) {
            case "happy" -> {
                songs.put("Tum Hi Ho Bandhu", "https://www.youtube.com/watch?v=Pn8EoOXxZ8w");
                songs.put("Zinda", "https://www.youtube.com/watch?v=8mIXtGgkGXI");
            }
            case "sad" -> {
                songs.put("Channa Mereya", "https://www.youtube.com/watch?v=284Ov7ysmfA");
                songs.put("Agar Tum Saath Ho", "https://www.youtube.com/watch?v=sK7riqg2mr4");
            }
            case "relaxed" -> {
                songs.put("Raabta", "https://www.youtube.com/watch?v=JbnLlDcQ7cA");
            }
            case "inspired" -> {
                songs.put("Zinda", "https://www.youtube.com/watch?v=8mIXtGgkGXI");
            }
            // Add more moods and songs if you like
            default -> songs.put("Let the vibe guide you ✨", "https://www.youtube.com/");
        }
        return songs;
    }

    public static String getQuote(String mood) {
        return switch (mood.toLowerCase()) {
            case "happy" -> "Happiness is not something ready made. It comes from your own actions. – Dalai Lama";
            case "sad" -> "Tears come from the heart and not from the brain. – Leonardo da Vinci";
            case "relaxed" -> "It’s a good idea always to do something relaxing prior to making an important decision. – Paulo Coelho";
            case "angry" -> "For every minute you remain angry, you give up sixty seconds of peace of mind. – Ralph Waldo Emerson";
            case "inspired" -> "Believe you can and you're halfway there. – Theodore Roosevelt";
            case "stressed" -> "You cannot always control what goes on outside. But you can always control what goes on inside. – Wayne Dyer";
            default -> "Every emotion is valid — just feel it and move through it. 💖";
        };
    }


}
