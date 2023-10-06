package dis_chess.board.response

import dis_chess.position.Position

// This is neccesary because kotlin is garbagio
sealed interface GetNotErrorResponse<T: Position> : GetResponse<T>