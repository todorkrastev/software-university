package org.softuni.exam;

import org.junit.Before;
import org.junit.Test;
import org.softuni.exam.entities.User;
import org.softuni.exam.entities.Video;
import org.softuni.exam.structures.ViTubeRepository;
import org.softuni.exam.structures.ViTubeRepositoryImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class ViTubeRepositoryTests {
    private interface InternalTest {
        void execute();
    }

    private ViTubeRepository viTubeRepository;

    private User getRandomUser() {
        return new User(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString());
    }

    private Video getRandomVideo() {
        return new Video(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                Math.min(1, Math.random() * 1_000_000_000),
                (int) Math.min(1, Math.random() * 1_000_000_000),
                (int) Math.min(1, Math.random() * 1_000_000_000),
                (int) Math.min(1, Math.random() * 1_000_000_000));
    }

    @Before
    public void setup() {
        this.viTubeRepository = new ViTubeRepositoryImpl();
    }

    public void performCorrectnessTesting(InternalTest[] methods) {
        Arrays.stream(methods)
                .forEach(method -> {
                    this.viTubeRepository = new ViTubeRepositoryImpl();

                    try {
                        method.execute();
                    } catch (IllegalArgumentException ignored) { }
                });

        this.viTubeRepository = new ViTubeRepositoryImpl();
    }

    // Correctness Tests

    @Test
    public void testContains_WithExistentUser_ShouldReturnTrue() {
        User user = getRandomUser();
        this.viTubeRepository.registerUser(user);

        assertTrue(this.viTubeRepository.contains(user));
    }

    @Test
    public void testContains_WithNonExistentUser_ShouldReturnFalse() {
        User user = getRandomUser();
        this.viTubeRepository.registerUser(user);

        assertFalse(this.viTubeRepository.contains(getRandomUser()));
    }

    @Test
    public void testContains_WithExistentVideo_ShouldReturnTrue() {
        Video video = getRandomVideo();
        this.viTubeRepository.postVideo(video);

        assertTrue(this.viTubeRepository.contains(video));
    }

    @Test
    public void testContains_WithNonExistentVideo_ShouldReturnFalse() {
        Video video = getRandomVideo();
        this.viTubeRepository.postVideo(video);

        assertFalse(this.viTubeRepository.contains(getRandomVideo()));
    }

    @Test
    public void testGetVideos_WithData_ShouldReturnCorrectResults() {
        Video video1 = getRandomVideo();
        Video video2 = getRandomVideo();
        Video video3 = getRandomVideo();

        this.viTubeRepository.postVideo(video1);
        this.viTubeRepository.postVideo(video2);
        this.viTubeRepository.postVideo(video3);

        Set<Video> set =
                StreamSupport.stream(this.viTubeRepository.getVideos().spliterator(), false)
                        .collect(Collectors.toSet());

        assertEquals(set.size(), 3);
        assertTrue(set.contains(video1));
        assertTrue(set.contains(video2));
        assertTrue(set.contains(video3));
    }

    // Performance Tests

    @Test
    public void testContainsUser_With100000Results_ShouldPassQuickly() {
        this.performCorrectnessTesting(new InternalTest[] {
                this::testContains_WithExistentUser_ShouldReturnTrue,
                this::testContains_WithNonExistentUser_ShouldReturnFalse
        });

        int count = 100000;

        User userToContain = null;

        for (int i = 0; i < count; i++)
        {
            if(i == count / 2)  {
                userToContain = getRandomUser();
                this.viTubeRepository.registerUser(userToContain);
            } else {
                this.viTubeRepository.registerUser(getRandomUser());
            }

        }

        long start = System.currentTimeMillis();

        this.viTubeRepository.contains(userToContain);

        long stop = System.currentTimeMillis();

        long elapsedTime = stop - start;

        assertTrue(elapsedTime <= 5);
    }

    @Test
    public void testGetVideos_With100000Results_ShouldPassQuickly() {
        this.performCorrectnessTesting(new InternalTest[] {
                this::testGetVideos_WithData_ShouldReturnCorrectResults,
        });

        int count = 100000;

        for (int i = 0; i < count; i++)
        {
            this.viTubeRepository.postVideo(getRandomVideo());
        }

        long start = System.currentTimeMillis();

        this.viTubeRepository.getVideos();

        long stop = System.currentTimeMillis();

        long elapsedTime = stop - start;

        assertTrue(elapsedTime <= 5);
    }
}
