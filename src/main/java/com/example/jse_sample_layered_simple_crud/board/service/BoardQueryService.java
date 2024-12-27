package com.example.jse_sample_layered_simple_crud.board.service;

import com.example.jse_sample_layered_simple_crud.board.domain.type.BoardStatus;
import com.example.jse_sample_layered_simple_crud.board.exception.BoardCommandErrorCode;
import com.example.jse_sample_layered_simple_crud.board.repository.BoardQueryRepository;
import com.example.jse_sample_layered_simple_crud.board.repository.projection.BoardProjection.*;
import com.example.jse_sample_layered_simple_crud.board.usecase.BoardSelectAllUseCase;
import com.example.jse_sample_layered_simple_crud.board.usecase.BoardSelectOneUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.EnumSet;

@Service
@RequiredArgsConstructor
public class BoardQueryService implements BoardSelectOneUseCase, BoardSelectAllUseCase {
    private final BoardQueryRepository boardQueryRepository;
    @Override
    public BoardDetailProjection findById(Long id) {
        return boardQueryRepository.findBoardById(id)
                .orElseThrow(BoardCommandErrorCode.BOARD_NOT_FOUND::defaultException);
//                .orElseThrow(() -> new RuntimeException("id에 해당하는 Board가 존재하지 않습니다."));
    }

    @Override
    public Page<BoardSummaryProjection> findGeneralBy(Pageable pageable) {
        Collection<BoardStatus> statuses = EnumSet.of(BoardStatus.ACTIVE, BoardStatus.SUSPENDED);

        var page = boardQueryRepository.findPageByStatusIn(statuses, pageable);
        page.map(this::hideTitleIfSuspended);

        return page;
    }

    // BoardStatus가 SUSPENDED라면 toBuilder를 이용하여 기존 빌더 객체를 새로운 객체로 재구성
    private BoardSummaryProjection hideTitleIfSuspended(BoardSummaryProjection board) {
        return board.status() == BoardStatus.SUSPENDED
                ? board.toBuilder()
                .title("접근할 수 없는 게시물입니다.")
                .build()
                : board;
    }
}
