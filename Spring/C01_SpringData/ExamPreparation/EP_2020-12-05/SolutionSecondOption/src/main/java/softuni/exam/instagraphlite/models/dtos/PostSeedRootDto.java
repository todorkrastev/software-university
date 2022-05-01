package softuni.exam.instagraphlite.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostSeedRootDto {

    @XmlElement(name = "post")
    private final List<PostSeedDto> posts;

    public PostSeedRootDto() {
        this.posts = new ArrayList<>();
    }

    public List<PostSeedDto> getPosts() {
        return posts;
    }
}
