CREATE TABLE IF NOT EXISTS board (
    id            BIGSERIAL,
    title         VARCHAR(255),
    content       TEXT,

    status        VARCHAR(255),
    like_count    INT DEFAULT 0,
    dislike_count INT DEFAULT 0,
    created_at    TIMESTAMP       DEFAULT NOW(),
    updated_at    TIMESTAMP,

    CONSTRAINT pk_board PRIMARY KEY (id)
);

--테이블 코멘트
COMMENT ON TABLE board IS '게시판';

-- 컬럼 코멘트
COMMENT ON COLUMN board.title         IS '글 제목';
COMMENT ON COLUMN board.content       IS '내용';
COMMENT ON COLUMN board.status        IS '상태';
COMMENT ON COLUMN board.like_count    IS '좋아요 수';
COMMENT ON COLUMN board.dislike_count IS '싫어요 수';
COMMENT ON COLUMN board.created_at    IS '생성일';
COMMENT ON COLUMN board.updated_at    IS '마지막 수정일';
