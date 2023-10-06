package dis_chess.board.response

import dis_chess.position.Position

sealed interface MoveResponse<T:Position> : ChessBoardResponse<T>