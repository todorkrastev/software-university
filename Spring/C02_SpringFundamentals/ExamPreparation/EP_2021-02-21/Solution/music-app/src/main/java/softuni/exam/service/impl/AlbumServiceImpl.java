package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.model.entity.Album;
import softuni.exam.model.service.AlbumServiceModel;
import softuni.exam.model.view.AlbumViewModel;
import softuni.exam.repository.AlbumRepository;
import softuni.exam.service.AlbumService;
import softuni.exam.service.ArtistService;
import softuni.exam.service.UserService;
import softuni.exam.util.CurrentUser;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final ArtistService artistService;
    private final CurrentUser currentUser;
    private final UserService userService;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, ArtistService artistService, CurrentUser currentUser, UserService userService) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.artistService = artistService;
        this.currentUser = currentUser;
        this.userService = userService;
    }


    @Override
    public void addAlbum(AlbumServiceModel albumServiceModel) {

        Album album = modelMapper.map(albumServiceModel, Album.class);
        album.setArtist(artistService.findArtistByName(albumServiceModel.getArtist()));
        album.setReleasedDate(albumServiceModel.getReleaseDate());
        album.setAddedFrom(userService.findById(currentUser.getId()));

        albumRepository.save(album);

    }

    @Override
    public List<AlbumViewModel> findAllAlbums() {
        return albumRepository.findAll()
                .stream()
                .map(a -> {
                    AlbumViewModel viewModel = modelMapper.map(a, AlbumViewModel.class);
                    viewModel.setArtist(a.getArtist().getName());
                    viewModel.setReleaseDate(a.getReleasedDate());

                    return viewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void removeAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
