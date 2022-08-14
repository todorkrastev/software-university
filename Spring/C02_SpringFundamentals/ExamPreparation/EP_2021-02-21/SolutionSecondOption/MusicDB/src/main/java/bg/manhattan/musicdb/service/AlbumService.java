package bg.manhattan.musicdb.service;

import bg.manhattan.musicdb.model.service.AlbumServiceModel;
import bg.manhattan.musicdb.model.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    void addAlbum(AlbumServiceModel albumModel);

    List<AlbumViewModel> getAlbums();

    void delete(Long id);
}
