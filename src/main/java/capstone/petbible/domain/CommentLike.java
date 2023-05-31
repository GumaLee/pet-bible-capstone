package capstone.petbible.domain;

import lombok.Getter;
import org.hibernate.mapping.Join;

import javax.persistence.*;

@Entity
@Table(name = "comment_likes")
@Getter
public class CommentLike {

    @Id @GeneratedValue
    @Column(name = "comment_like_no")
    private Long likeNo;

    @ManyToOne
    @JoinColumn(name = "comment_no")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;
}
