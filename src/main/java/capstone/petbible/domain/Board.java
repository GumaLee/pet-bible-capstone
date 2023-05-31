package capstone.petbible.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "boards")
@Getter
@Setter
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_no")
    private Long boardNo;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

    private String title;

    @Column(name = "board_contents")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "category_no")
    private Category category;

    @Column(name = "board_reg_date")
    private LocalDateTime regDate;

    @Column(name = "board_update_date")
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "board")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "board")
    private List<BoardLike> boardLikes = new ArrayList<>();
}
