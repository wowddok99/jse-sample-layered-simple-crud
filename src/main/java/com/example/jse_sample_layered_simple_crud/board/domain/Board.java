package com.example.jse_sample_layered_simple_crud.board.domain;

import com.example.jse_sample_layered_simple_crud.board.domain.type.BoardStatus;
import com.example.jse_sample_layered_simple_crud.common.jpa.support.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Board extends BaseEntity {
    private String title;
    private String content;
    @Enumerated(EnumType.STRING)
    private BoardStatus status;
    private int likeCount;
    private int dislikeCount;
    private Instant createdAt;
    private Instant updatedAt;

    @Builder(
            builderClassName = "UpdateBoardBuilder",
            builderMethodName = "prepareUpdate",
            buildMethodName = "update"
    )
    public void updateBoard(String title, String content) {
        Objects.requireNonNull(title, "title cannot be null");
        Objects.requireNonNull(content, "content cannot be null");

        this.title = title;
        this.content = content;
    }
}
