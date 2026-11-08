package proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RealSongService implements SongService {

    private final Map<Integer, Song> songs = new HashMap<>();

    public RealSongService() {
        // Supplid  by the driver
    }

    public void addSong(Song song) {
        songs.put(song.getSongID(), song);
    }

    private void simulateDelay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public Song searchById(Integer songID) {
        simulateDelay();
        System.out.println("[SERVER] Searching by ID: " + songID);

        return songs.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        simulateDelay();
        System.out.println("[SERVER] Searching by title: " + title);

        List<Song> results = new ArrayList<>();

        for (Song song : songs.values()) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                results.add(song);
            }
        }

        return results;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        simulateDelay();
        System.out.println("[SERVER] Searching by album: " + album);

        List<Song> results = new ArrayList<>();

        for (Song song : songs.values()) {
            if (song.getAlbum().equalsIgnoreCase(album)) {
                results.add(song);
            }
        }

        return results;
    }
}
