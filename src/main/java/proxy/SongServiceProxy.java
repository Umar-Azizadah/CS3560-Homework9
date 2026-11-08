package proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceProxy implements SongService {

    private final SongService realService;

    private final Map<Integer, Song> idCache = new HashMap<>();
    private final Map<String, List<Song>> titleCache = new HashMap<>();
    private final Map<String, List<Song>> albumCache = new HashMap<>();

    public SongServiceProxy(SongService realService) {
        this.realService = realService;
    }

    @Override
    public Song searchById(Integer songID) {

        if (idCache.containsKey(songID)) {
            System.out.println("[CACHE] Found song ID: " + songID);
            return idCache.get(songID);
        }

        Song song = realService.searchById(songID);

        if (song != null) {
            idCache.put(songID, song);
        }

        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {

        String key = title.toLowerCase();

        if (titleCache.containsKey(key)) {
            System.out.println("[CACHE] Found title: " + title);
            return titleCache.get(key);
        }

        List<Song> results = realService.searchByTitle(title);
        titleCache.put(key, results);

        return results;
    }

    @Override
    public List<Song> searchByAlbum(String album) {

        String key = album.toLowerCase();

        if (albumCache.containsKey(key)) {
            System.out.println("[CACHE] Found album: " + album);
            return albumCache.get(key);
        }

        List<Song> results = realService.searchByAlbum(album);
        albumCache.put(key, results);

        return results;
    }
}
