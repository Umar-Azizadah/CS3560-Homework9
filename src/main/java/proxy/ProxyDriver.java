package proxy;

import java.util.List;

public class ProxyDriver {

    public static void main(String[] args) {

        RealSongService realService = new RealSongService();

        // Create songs
        realService.addSong(new Song(101, "Pretty Mami", "Lil Uzi Vert", "Luv Is Rage 2", 264));
        realService.addSong(new Song(102, "Feelings Mutual", "Lil Uzi Vert", "Luv Is Rage 2", 233));
        realService.addSong(new Song(103, "Early 20 Rager", "Lil Uzi Vert", "Luv Is Rage 2", 274));
        realService.addSong(new Song(104, "Malfunction", "Lil Uzi Vert", "Luv Is Rage 2", 199));
        realService.addSong(new Song(105, "Chrome Heart Tags", "Lil Uzi Vert", "Eternal Atake", 212));
        realService.addSong(new Song(106, "Bust Me", "Lil Uzi Vert", "Eternal Atake", 194));
        realService.addSong(new Song(107, "Secure the Bag", "Lil Uzi Vert", "Eternal Atake", 238));
        realService.addSong(new Song(108, "Bigger Than Life", "Lil Uzi Vert", "Eternal Atake", 192));

        SongService proxy = new SongServiceProxy(realService);

        // Search by ID
        System.out.println("SEARCH BY ID");

        System.out.println("\nFirst search:");
        System.out.println(proxy.searchById(101));

        System.out.println("\nSecond search (cached):");
        System.out.println(proxy.searchById(101));

        // Search by title
        System.out.println("\nSEARCH BY TITLE");

        System.out.println("\nFirst search:");
        printSongs(proxy.searchByTitle("Chrome Heart Tags"));

        System.out.println("\nSecond search (cached):");
        printSongs(proxy.searchByTitle("Chrome Heart Tags"));

        // Search by album
        System.out.println("\nSEARCH BY ALBUM");

        System.out.println("\nFirst search:");
        printSongs(proxy.searchByAlbum("Luv Is Rage 2"));

        System.out.println("\nSecond search (cached):");
        printSongs(proxy.searchByAlbum("Luv Is Rage 2"));

        // Additional search
        System.out.println("\nADDITIONAL SEARCH");
        System.out.println(proxy.searchById(107));

        System.out.println("\nProxy demonstration complete.");
    }

    private static void printSongs(List<Song> songs) {

        if (songs.isEmpty()) {
            System.out.println("No songs found.");
            return;
        }

        for (Song song : songs) {
            System.out.println(song);
        }
    }
}
