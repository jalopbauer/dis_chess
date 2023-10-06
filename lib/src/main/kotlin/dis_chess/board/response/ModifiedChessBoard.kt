package dis_chess.board.response

import dis_chess.board.ChessBoard
import dis_chess.position.Position

data class ModifiedChessBoard<T : Position>(val chessBoard: ChessBoard<T>) : RemoveResponse<T>, PutResponse<T>