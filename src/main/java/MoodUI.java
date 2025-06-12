import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.net.URI;
import java.util.List;

public class MoodUI extends Application {

    private boolean isDarkTheme = false;
    private boolean isTamilMode = false;

    private BorderPane root;
    private Scene scene;
    private VBox mainBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();
        mainBox = new VBox(20);
        mainBox.setAlignment(Pos.CENTER);
        root.setCenter(mainBox);

        scene = new Scene(root, 800, 600);
        updateBackground();

        // Greeting text
        Label greeting = new Label("Hi, how are you feeling today? Let me know 💭");
        greeting.setFont(Font.font("Verdana", FontWeight.BOLD, 22));
        greeting.setTextFill(Color.WHITE);
        greeting.setStyle("-fx-effect: dropshadow(gaussian, black, 2, 0, 2, 2);");
        mainBox.getChildren().add(greeting);

        // Mode toggles
        HBox toggles = new HBox(20);
        CheckBox themeToggle = new CheckBox("Dark Theme");
        CheckBox tamilToggle = new CheckBox("Tamil Songs");
        toggles.setAlignment(Pos.CENTER);
        toggles.getChildren().addAll(themeToggle, tamilToggle);
        mainBox.getChildren().add(toggles);

        themeToggle.setOnAction(e -> {
            isDarkTheme = themeToggle.isSelected();
            updateBackground();
        });

        tamilToggle.setOnAction(e -> isTamilMode = tamilToggle.isSelected());

        // Mood emojis
        HBox moodsBox = new HBox(15);
        moodsBox.setAlignment(Pos.CENTER);
        String[] moods = {"😊", "😢", "😡", "😤", "🥺", "😬"};
        String[] moodLabels = {"Happy", "Sad", "Angry", "Frustrated", "Nostalgic", "Nervous"};

        for (int i = 0; i < moods.length; i++) {
            Button moodBtn = new Button(moods[i]);
            String mood = moodLabels[i];
            moodBtn.setFont(Font.font(30));
            moodBtn.setOnAction(e -> showMoodScreen(primaryStage, mood));
            moodsBox.getChildren().add(moodBtn);
        }

        mainBox.getChildren().add(moodsBox);

        primaryStage.setTitle("EmotiWave 🎵");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateBackground() {
        Stop[] stops = isDarkTheme ?
                new Stop[]{new Stop(0, Color.web("#1e1f66")), new Stop(1, Color.web("#000000"))}
                : new Stop[]{new Stop(0, Color.web("#ffecd2")), new Stop(1, Color.web("#fcb69f"))};
        root.setBackground(new Background(new BackgroundFill(
                new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops),
                CornerRadii.EMPTY, Insets.EMPTY
        )));
    }

    private void showMoodScreen(Stage stage, String mood) {
        BorderPane moodPane = new BorderPane();
        VBox contentBox = new VBox(15);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setPadding(new Insets(20));

        // Mood Title
        Label moodTitle = new Label("Mood: " + mood);
        moodTitle.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        moodTitle.setTextFill(Color.WHITE);
        contentBox.getChildren().add(moodTitle);

        // Songs title
        Label songTitle = new Label("🎧 Songs");
        songTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        songTitle.setTextFill(Color.LIGHTYELLOW);
        contentBox.getChildren().add(songTitle);

        List<MoodAnalyzer.Song> songs = MoodAnalyzer.getSongsForMood(mood, isTamilMode);
        for (MoodAnalyzer.Song song : songs) {
            Hyperlink songLink = new Hyperlink(song.getName());
            songLink.setOnAction(e -> openLink(song.getUrl()));
            songLink.setFont(Font.font("Verdana", 14));
            contentBox.getChildren().add(songLink);
        }

        // Quote title
        Label quoteTitle = new Label("💬 Quote");
        quoteTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        quoteTitle.setTextFill(Color.LIGHTGREEN);
        contentBox.getChildren().add(quoteTitle);

        String quote = MoodAnalyzer.getQuoteForMood(mood);
        Label quoteLabel = new Label("\"" + quote + "\"");
        quoteLabel.setWrapText(true);
        quoteLabel.setFont(Font.font("Georgia", FontPosture.ITALIC, 16));
        quoteLabel.setTextFill(Color.WHITE);
        contentBox.getChildren().add(quoteLabel);

        // Back Button
        Button backBtn = new Button("🏠 Back to Home");
        backBtn.setOnAction(e -> start(stage));
        contentBox.getChildren().add(backBtn);

        moodPane.setCenter(contentBox);
        Stop[] stops = isDarkTheme ?
                new Stop[]{new Stop(0, Color.web("#3a1c71")), new Stop(1, Color.web("#000000"))}
                : new Stop[]{new Stop(0, Color.web("#89f7fe")), new Stop(1, Color.web("#66a6ff"))};

        moodPane.setBackground(new Background(new BackgroundFill(
                new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops),
                CornerRadii.EMPTY, Insets.EMPTY
        )));

        Scene moodScene = new Scene(moodPane, 800, 600);
        stage.setScene(moodScene);
    }

    private void openLink(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
