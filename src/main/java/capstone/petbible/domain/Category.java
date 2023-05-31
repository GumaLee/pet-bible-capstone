package capstone.petbible.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_no")
    private Long categoryNo;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Board> boards = new ArrayList<>();
}
