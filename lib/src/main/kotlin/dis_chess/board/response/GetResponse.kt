package dis_chess.board.response

import dis_chess.position.Position

sealed interface GetResponse<T: Position> : ChessBoardResponse<T>, MoveResponse<T>