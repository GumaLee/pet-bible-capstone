package capstone.petbible.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "board_likes")
@Getter
@Setter
public class BoardLike {

    @Id @GeneratedValue
    @Column(name = "board_like_no")
    private Long LikeNo;

    @ManyToOne
    @JoinColumn(name = "board_no")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;
}
