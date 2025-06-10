
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;

import java.util.*;

public class MoodUI extends Application {

    private final Map<String, List<Pair<String, String>>> moodSongs = new HashMap<>();
    private final Map<String, String> moodQuotes = new HashMap<>();
    private final Map<String, String> moodEmojis = new HashMap<>();
    private boolean isDarkMode = false;
    private Background lightBackground;
    private Background darkBackground;

    @Override
    public void start(Stage stage) {
        setupSongs();
        setupQuotes();
        setupEmojis();
        setupBackgrounds();

        Label moodLabel = new Label("🌈 Select Your Mood:");
        moodLabel.setFont(Font.font("Comic Sans MS", 24));

        ComboBox<String> moodCombo = new ComboBox<>();
        moodCombo.getItems().addAll(moodSongs.keySet());
        moodCombo.setStyle("-fx-font-size: 18px; -fx-font-family: 'Comic Sans MS';");

        Text emojiText = new Text("");
        emojiText.setStyle("-fx-font-size: 48px; -fx-font-family: 'Comic Sans MS';");

        Text quoteText = new Text("💬");
        quoteText.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-font-family: 'Comic Sans MS';");

        VBox songList = new VBox(10);
        songList.setAlignment(Pos.CENTER);

        Button themeButton = new Button("🌓 Toggle Theme");
        themeButton.setStyle("-fx-font-size: 16px; -fx-font-family: 'Comic Sans MS';");
        themeButton.setOnAction(e -> toggleTheme(stage.getScene()));

        moodCombo.setOnAction(e -> {
            String mood = moodCombo.getValue();
            String quote = "💬 " + moodQuotes.getOrDefault(mood, "Every mood matters 🌟");
            String emoji = moodEmojis.getOrDefault(mood, "✨");
            animateText(quoteText, quote);
            animateEmoji(emojiText, emoji);

            songList.getChildren().clear();
            List<Pair<String, String>> songs = moodSongs.get(mood);
            if (songs != null) {
                for (Pair<String, String> song : songs) {
                    Hyperlink link = new Hyperlink("🎵 " + song.getKey());
                    link.setStyle("-fx-font-size: 18px; -fx-font-family: 'Comic Sans MS';");
                    link.setOnAction(evt -> getHostServices().showDocument(song.getValue()));
                    songList.getChildren().add(link);
                }
            }

            FadeTransition fade = new FadeTransition(Duration.millis(600), songList);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
        });

        VBox root = new VBox(15, moodLabel, moodCombo, emojiText, quoteText, songList, themeButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setBackground(lightBackground);
        root.setStyle("-fx-font-size: 16px; -fx-font-family: 'Comic Sans MS';");

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Mood Analyzer 🎶");
        stage.show();
    }

    private void toggleTheme(Scene scene) {
        VBox root = (VBox) scene.getRoot();
        if (isDarkMode) {
            root.setBackground(lightBackground);
            root.setStyle("-fx-text-fill: black; -fx-font-family: 'Comic Sans MS';");
            isDarkMode = false;
        } else {
            root.setBackground(darkBackground);
            root.setStyle("-fx-text-fill: white; -fx-font-family: 'Comic Sans MS';");
            isDarkMode = true;
        }
    }

    private void animateText(Text textNode, String newText) {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(300), textNode);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished(event -> {
            textNode.setText(newText);
            FadeTransition fadeIn = new FadeTransition(Duration.millis(300), textNode);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();

            ScaleTransition scale = new ScaleTransition(Duration.millis(300), textNode);
            scale.setFromX(0.8);
            scale.setFromY(0.8);
            scale.setToX(1.0);
            scale.setToY(1.0);
            scale.play();
        });
        fadeOut.play();
    }

    private void animateEmoji(Text emojiNode, String emoji) {
        emojiNode.setText(emoji);
        ScaleTransition scale = new ScaleTransition(Duration.millis(500), emojiNode);
        scale.setFromX(0.5);
        scale.setFromY(0.5);
        scale.setToX(1.2);
        scale.setToY(1.2);
        scale.setAutoReverse(true);
        scale.setCycleCount(2);
        scale.play();
    }

    private void setupSongs() {
        moodSongs.put("😊 Happy", List.of(
                new Pair<>("Vaathi Coming", "https://www.youtube.com/watch?v=UyI3F8yK-9U"),
                new Pair<>("Jimikki Ponnu", "https://www.youtube.com/watch?v=vFJ2_8cMAbE")
        ));

        moodSongs.put("😢 Sad", List.of(
                new Pair<>("Kannalanae (Bombay)", "https://www.youtube.com/watch?v=GMhi8wI6hK0"),
                new Pair<>("Ennodu Nee Irundhaal", "https://www.youtube.com/watch?v=yG3AKuC7Ywo")
        ));

        moodSongs.put("🔥 Motivated", List.of(
                new Pair<>("Surviva (Vivegam)", "https://www.youtube.com/watch?v=qvdZrB0KDFk"),
                new Pair<>("Ulagam Oruvanukka", "https://www.youtube.com/watch?v=Aj1tZV7f8Aw")
        ));

        moodSongs.put("❤️ Love", List.of(
                new Pair<>("Kadhal Rojave", "https://www.youtube.com/watch?v=1W1S1Qh6Vfc"),
                new Pair<>("Anbil Avan", "https://www.youtube.com/watch?v=HqLF6lID3MM")
        ));

        moodSongs.put("😌 Nostalgic", List.of(
                new Pair<>("Munbe Vaa", "https://www.youtube.com/watch?v=xL8dhVFFED4"),
                new Pair<>("Pachai Nirame", "https://www.youtube.com/watch?v=4M6p60lMa7I")
        ));
    }

    private void setupQuotes() {
        moodQuotes.put("😊 Happy", "Happiness is a direction, not a place. 🌟");
        moodQuotes.put("😢 Sad", "Tears come from the heart and not from the brain. 💧");
        moodQuotes.put("🔥 Motivated", "The best view comes after the hardest climb. ⛰️");
        moodQuotes.put("❤️ Love", "Love is composed of a single soul inhabiting two bodies. ❤️");
        moodQuotes.put("😌 Nostalgic", "Sometimes you will never know the value of a moment until it becomes a memory. 🕰️");
    }

    private void setupEmojis() {
        moodEmojis.put("😊 Happy", "😄");
        moodEmojis.put("😢 Sad", "😭");
        moodEmojis.put("🔥 Motivated", "💪");
        moodEmojis.put("❤️ Love", "😍");
        moodEmojis.put("😌 Nostalgic", "🕰️");
    }

    private void setupBackgrounds() {
        Stop[] lightStops = new Stop[] {
                new Stop(0, Color.web("#f0f8ff")),
                new Stop(1, Color.web("#e6e6fa"))
        };
        LinearGradient lightGradient = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, lightStops);
        lightBackground = new Background(new BackgroundFill(lightGradient, CornerRadii.EMPTY, Insets.EMPTY));

        Stop[] darkStops = new Stop[] {
                new Stop(0, Color.web("#232526")),
                new Stop(1, Color.web("#414345"))
        };
        LinearGradient darkGradient = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, darkStops);
        darkBackground = new Background(new BackgroundFill(darkGradient, CornerRadii.EMPTY, Insets.EMPTY));
    }

    public static void main(String[] args) {
        launch(args);
    }

}
