package softuni.exam.service;

import softuni.exam.model.service.AlbumServiceModel;
import softuni.exam.model.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    void addAlbum(AlbumServiceModel albumServiceModel);

    List<AlbumViewModel> findAllAlbums();

    void removeAlbum(Long id);
}
