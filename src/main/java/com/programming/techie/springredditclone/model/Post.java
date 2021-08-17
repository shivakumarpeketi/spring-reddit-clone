package com.programming.techie.springredditclone.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Post Response")
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(
                                name = "PostByUserFirstAndLastName",
                                procedureName ="PostByUserFirstAndLastName",
                                parameters = {
                                        @StoredProcedureParameter(mode=ParameterMode.IN, name="firstName", type=String.class),
                                        @StoredProcedureParameter(mode=ParameterMode.IN, name="lastName", type=String.class)}
)})
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long postId;
    @NotBlank(message = "Post Name cannot be empty or Null")
    private String postName;
    @Nullable
    private String url;
    @Nullable
    @Lob
    private String description;
    private Integer voteCount = 0;
    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
    private Instant createdDate;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Subreddit subreddit;
}
