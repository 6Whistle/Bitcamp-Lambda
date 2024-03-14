package com.erichgamma.api.board;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Board {
    private Long id;
    private String boardName;
    private String boardType;

    @Builder
    public Board(Long id, String boardName, String boardType){
        this.id = id;
        this.boardName = boardName;
        this.boardType = boardType;
    }
}
