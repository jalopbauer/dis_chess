package dis_chess.board.response

import dis_chess.position.Position

sealed interface ErrorResponse<T:Position> : ChessBoardResponse<T>, MoveResponse<T>