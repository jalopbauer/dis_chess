package dis_chess.board

import dis_chess.chessPiece.ChessPiece
import dis_chess.position.RowColumnPosition

data class SquareChessBoard(
    val boardSize: Int,
    val positionChessPieceType: Map<RowColumnPosition, ChessPiece>
) : ChessBoard<RowColumnPosition>