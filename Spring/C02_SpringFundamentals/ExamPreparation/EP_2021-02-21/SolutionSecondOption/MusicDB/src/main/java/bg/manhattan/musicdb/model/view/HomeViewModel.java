package bg.manhattan.musicdb.model.view;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel {
    private final List<AlbumViewModel> albums;

    private final Long totalCopies;

    public HomeViewModel() {
        this(new ArrayList<>());
    }

    public HomeViewModel(List<AlbumViewModel> albums) {
        this.albums = albums;
        this.totalCopies = albums
                .stream()
                .map(album -> Long.valueOf(album.getCopies()))
                .reduce((sum, curr) -> sum += curr)
                .orElse(0L);
    }

    public List<AlbumViewModel> getAlbums() {
        return albums;
    }

    public Long getTotalCopies() {
        return totalCopies;
    }
}
