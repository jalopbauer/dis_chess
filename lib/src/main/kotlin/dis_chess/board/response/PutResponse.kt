package dis_chess.board.response

import dis_chess.position.Position

sealed interface PutResponse<T: Position> : ChessBoardResponse<T>, MoveResponse<T>