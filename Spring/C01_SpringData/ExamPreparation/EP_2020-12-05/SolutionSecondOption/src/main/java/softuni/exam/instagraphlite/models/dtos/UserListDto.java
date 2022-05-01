package softuni.exam.instagraphlite.models.dtos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserListDto {
    private String username;
    private List<PostDetailsDto> posts;

    public UserListDto(String username) {
        this.username = username;
        this.posts = new ArrayList<>();
    }

    public List<PostDetailsDto> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("User: %s", username)).append(System.lineSeparator());
        sb.append(String.format("Post count: %d", posts.stream().count()));
        if (!posts.isEmpty()) {
            sb.append(System.lineSeparator());
            sb.append(posts
                    .stream()
                    .sorted(Comparator.comparingDouble(PostDetailsDto::getPictureSize))
                    .map(PostDetailsDto::toString)
                    .collect(Collectors.joining(System.lineSeparator())));
        }
        return sb.toString();
    }
}
