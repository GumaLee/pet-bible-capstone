package capstone.petbible.domain;

import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comments")
@Getter
@Setter
public class Comment {

    @Id @GeneratedValue
    @Column(name = "comment_no")
    private Long commentNo;

    @ManyToOne
    @JoinColumn(name = "board_no")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

    @Column(name = "comment_contents")
    private String contents;

    @Column(name = "comment_reg_date")
    private LocalDateTime regDate;

    @Column(name = "comment_update_date")
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "comment")
    private List<CommentLike> commentLikes = new ArrayList<>();
}
