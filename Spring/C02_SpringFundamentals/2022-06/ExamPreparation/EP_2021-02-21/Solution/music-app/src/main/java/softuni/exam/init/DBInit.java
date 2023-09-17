package softuni.exam.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.exam.service.ArtistService;

@Component
public class DBInit implements CommandLineRunner {

    private final ArtistService artistService;

    public DBInit(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Override
    public void run(String... args) throws Exception {
        artistService.initializeArtists();
    }
}
