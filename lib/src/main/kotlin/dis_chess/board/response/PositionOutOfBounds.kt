package dis_chess.board.response

import dis_chess.position.Position

data class PositionOutOfBounds<T: Position>(val position: T) : ErrorResponse<T>
