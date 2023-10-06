package dis_chess.board.response

import dis_chess.chessPiece.ChessPiece
import dis_chess.position.Position

data class ChessPieceInPosition<T : Position>(val chessPiece: ChessPiece) : GetResponse<T>