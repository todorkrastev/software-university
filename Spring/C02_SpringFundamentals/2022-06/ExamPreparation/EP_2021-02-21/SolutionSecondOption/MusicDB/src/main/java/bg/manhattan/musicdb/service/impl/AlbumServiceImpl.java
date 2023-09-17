package bg.manhattan.musicdb.service.impl;

import bg.manhattan.musicdb.model.entity.Album;
import bg.manhattan.musicdb.model.entity.Artist;
import bg.manhattan.musicdb.model.entity.User;
import bg.manhattan.musicdb.model.service.AlbumServiceModel;
import bg.manhattan.musicdb.model.view.AlbumViewModel;
import bg.manhattan.musicdb.repository.AlbumRepository;
import bg.manhattan.musicdb.service.AlbumService;
import bg.manhattan.musicdb.service.ArtistService;
import bg.manhattan.musicdb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository repository;
    private final UserService userService;
    private final ArtistService artistService;

    private final ModelMapper modelMapper;

    public AlbumServiceImpl(AlbumRepository repository,
                            UserService userService,
                            ArtistService artistService,
                            ModelMapper modelMapper) {
        this.repository = repository;
        this.userService = userService;
        this.artistService = artistService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addAlbum(AlbumServiceModel albumModel) {
        User user = this.userService.getCurrentUser()
                .orElseThrow(() -> new IllegalStateException("User not found!"));
        Artist artist = this.artistService.findByName(albumModel.getArtist())
                .orElseThrow(() -> new IllegalStateException("Artist not found!"));

        Album album = this.modelMapper.map(albumModel, Album.class)
                .setAddedFrom(user)
                .setArtist(artist);
        this.repository.save(album);
    }

    @Override
    public List<AlbumViewModel> getAlbums() {
        return this.repository.findAll()
                .stream()
                .map(album -> this.modelMapper.map(album, AlbumViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
