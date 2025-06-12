import java.util.*;

public class MoodAnalyzer {

    public static class Song {
        private final String name;
        private final String url;

        public Song(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }

    public static List<Song> getSongsForMood(String mood, boolean isTamil) {
        List<Song> songs = new ArrayList<>();

        switch (mood.toLowerCase()) {
            case "happy":
                if (isTamil) {
                    songs.add(new Song("Vaathi Coming", "https://www.youtube.com/watch?v=hpigjnKl7nI"));
                    songs.add(new Song("Jimikki Ponnu", "https://www.youtube.com/watch?v=BGS7SpI7obY"));
                    songs.add(new Song("So Baby", "https://www.youtube.com/watch?v=UAnEUzkt1nU"));
                    songs.add(new Song("Kutty Pattas", "https://www.youtube.com/watch?v=xLs8ZftpBZg"));
                    songs.add(new Song("Chellamma", "https://www.youtube.com/watch?v=0pqjT006Y3U"));
                } else {
                    songs.add(new Song("Happy – Pharrell Williams", "https://www.youtube.com/watch?v=y6Sxv-sUYtM"));
                    songs.add(new Song("Can't Stop the Feeling!", "https://www.youtube.com/watch?v=ru0K8uYEZWw"));
                    songs.add(new Song("Uptown Funk", "https://www.youtube.com/watch?v=OPf0YbXqDm0"));
                    songs.add(new Song("Best Day of My Life", "https://www.youtube.com/watch?v=Y66j_BUCBMY"));
                    songs.add(new Song("Shake It Off", "https://www.youtube.com/watch?v=nfWlot6h_JM"));
                }
                break;

            case "sad":
                if (isTamil) {
                    songs.add(new Song("Ennai Vittu", "https://www.youtube.com/watch?v=sMI9E_h5Fnc"));
                    songs.add(new Song("Unakkenna Venum Sollu", "https://www.youtube.com/watch?v=toZfJz7vPq4"));
                    songs.add(new Song("Kanne Kalaimaane", "https://www.youtube.com/watch?v=5PvE6WqZzRU"));
                    songs.add(new Song("Munbe Vaa", "https://www.youtube.com/watch?v=Teh7r3gGz0Y"));
                    songs.add(new Song("Naan Pizhaippeno", "https://www.youtube.com/watch?v=ipkb3-UUWpo"));
                } else {
                    songs.add(new Song("Let Her Go – Passenger", "https://www.youtube.com/watch?v=RBumgq5yVrA"));
                    songs.add(new Song("Someone Like You – Adele", "https://www.youtube.com/watch?v=hLQl3WQQoQ0"));
                    songs.add(new Song("Stay With Me – Sam Smith", "https://www.youtube.com/watch?v=pB-5XG-DbAA"));
                    songs.add(new Song("Fix You – Coldplay", "https://www.youtube.com/watch?v=k4V3Mo61fJM"));
                    songs.add(new Song("All I Want – Kodaline", "https://www.youtube.com/watch?v=mtf7hC17IBM"));
                }
                break;

            case "angry":
                if (isTamil) {
                    songs.add(new Song("Surviva", "https://www.youtube.com/watch?v=wFVuu1lG5Qk"));
                    songs.add(new Song("Aalaporan Thamizhan", "https://www.youtube.com/watch?v=qZkuyLsN_0I"));
                    songs.add(new Song("Verithanam", "https://www.youtube.com/watch?v=zI-Pux4uaqM"));
                    songs.add(new Song("Thaarame Thaarame", "https://www.youtube.com/watch?v=djIxAqKxz-Y"));
                    songs.add(new Song("Sodakku", "https://www.youtube.com/watch?v=JYNjYJxVZdg"));
                } else {
                    songs.add(new Song("Believer – Imagine Dragons", "https://www.youtube.com/watch?v=7wtfhZwyrcc"));
                    songs.add(new Song("Stronger – Kanye West", "https://www.youtube.com/watch?v=PsO6ZnUZI0g"));
                    songs.add(new Song("Lose Yourself – Eminem", "https://www.youtube.com/watch?v=_Yhyp-_hX2s"));
                    songs.add(new Song("Radioactive – Imagine Dragons", "https://www.youtube.com/watch?v=ktvTqknDobU"));
                    songs.add(new Song("Numb – Linkin Park", "https://www.youtube.com/watch?v=kXYiU_JCYtU"));
                }
                break;

            case "frustrated":
                if (isTamil) {
                    songs.add(new Song("Vikram Title Track", "https://www.youtube.com/watch?v=VYoXn8hHh3A"));
                    songs.add(new Song("Oru Kutti Kathai", "https://www.youtube.com/watch?v=PgMYhWmcV10"));
                    songs.add(new Song("Marana Mass", "https://www.youtube.com/watch?v=Ixo3W2P6ru0"));
                    songs.add(new Song("Therikkudha", "https://www.youtube.com/watch?v=4z1wtXZzVg4"));
                    songs.add(new Song("Petta Paraak", "https://www.youtube.com/watch?v=tYB3BGe65B0"));
                } else {
                    songs.add(new Song("Demons – Imagine Dragons", "https://www.youtube.com/watch?v=mWRsgZuwf_8"));
                    songs.add(new Song("Animals – Martin Garrix", "https://www.youtube.com/watch?v=gCYcHz2k5x0"));
                    songs.add(new Song("Stronger (What Doesn’t Kill You)", "https://www.youtube.com/watch?v=Xn676-fLq7I"));
                    songs.add(new Song("We Will Rock You – Queen", "https://www.youtube.com/watch?v=-tJYN-eG1zk"));
                    songs.add(new Song("Centuries – Fall Out Boy", "https://www.youtube.com/watch?v=LBr7kECsjcQ"));
                }
                break;

            case "nostalgic":
                if (isTamil) {
                    songs.add(new Song("Anbil Avan", "https://www.youtube.com/watch?v=EJzq-mnT6TI"));
                    songs.add(new Song("Pachai Nirame", "https://www.youtube.com/watch?v=KeOn_S95hOU"));
                    songs.add(new Song("Anbil Avan", "https://www.youtube.com/watch?v=BCo8nNf2tRo"));
                    songs.add(new Song("Ennai Konjam", "https://www.youtube.com/watch?v=TXVPtx14l1w"));
                    songs.add(new Song("Kadhal Rojave", "https://www.youtube.com/watch?v=aC8Esm95JpI"));
                } else {
                    songs.add(new Song("Photograph – Ed Sheeran", "https://www.youtube.com/watch?v=nSDgHBxUbVQ"));
                    songs.add(new Song("See You Again – Wiz Khalifa", "https://www.youtube.com/watch?v=RgKAFK5djSk"));
                    songs.add(new Song("Somewhere Over the Rainbow", "https://www.youtube.com/watch?v=V1bFr2SWP1I"));
                    songs.add(new Song("Yesterday – The Beatles", "https://www.youtube.com/watch?v=NrgmdOz227I"));
                    songs.add(new Song("Let It Be – The Beatles", "https://www.youtube.com/watch?v=QDYfEBY9NM4"));
                }
                break;

            case "nervous":
                if (isTamil) {
                    songs.add(new Song("Kannaana Kanney", "https://www.youtube.com/watch?v=4z1wtXZzVg4"));
                    songs.add(new Song("Ennadi Maayavi Nee", "https://www.youtube.com/watch?v=FJ55SHCzt88"));
                    songs.add(new Song("Thalli Pogathey", "https://www.youtube.com/watch?v=pPbhL0dWQko"));
                    songs.add(new Song("Aval", "https://www.youtube.com/watch?v=HQHCrNxXbCs"));
                    songs.add(new Song("Vizhigalil Oru Vaanavil", "https://www.youtube.com/watch?v=QzY5EOw33UY"));
                } else {
                    songs.add(new Song("Lovely – Billie Eilish", "https://www.youtube.com/watch?v=V1Pl8CzNzCw"));
                    songs.add(new Song("The Night We Met – Lord Huron", "https://www.youtube.com/watch?v=KtlgYxa6BMU"));
                    songs.add(new Song("Sweater Weather", "https://www.youtube.com/watch?v=GCdwKhTtNNw"));
                    songs.add(new Song("Breathe Me – Sia", "https://www.youtube.com/watch?v=SFGvmrJ5rjM"));
                    songs.add(new Song("Youth – Daughter", "https://www.youtube.com/watch?v=VEpMj-tqixs"));
                }
                break;
        }

        return songs;
    }

    public static String getQuoteForMood(String mood) {
        Map<String, String> quotes = new HashMap<>();
        quotes.put("happy", "Happiness is not something ready-made. It comes from your own actions.");
        quotes.put("sad", "Tears come from the heart and not from the brain.");
        quotes.put("angry", "For every minute you are angry you lose sixty seconds of happiness.");
        quotes.put("frustrated", "Frustration, although quite painful at times, is a very positive and essential part of success.");
        quotes.put("nostalgic", "Sometimes you will never know the value of a moment until it becomes a memory.");
        quotes.put("nervous", "Don’t let your fears take control — let your dreams lead the way.");

        return quotes.getOrDefault(mood.toLowerCase(), "Be yourself; everyone else is already taken.");
    }
}
