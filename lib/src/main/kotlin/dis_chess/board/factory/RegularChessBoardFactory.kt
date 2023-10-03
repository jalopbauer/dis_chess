package dis_chess.board.factory

import dis_chess.board.SquareChessBoard
import dis_chess.chessPiece.ChessPiece
import dis_chess.chessPiece.mapper.StringToChessPieceMapper
import dis_chess.position.RowColumnPosition
import java.io.File

object RegularChessBoardFactory {
    fun build() : SquareChessBoard {
        val boardSize = 8
        val initial = Pair(RowColumnPosition(boardSize, 1), mapOf<RowColumnPosition, ChessPiece>())
        val positionChessPiece = File("regular_chess_board")
            .readLines()
            .fold(initial) { currentPositionPositionChessPieceMap, fileRow ->
                fileRow.split("|")
                    .fold(currentPositionPositionChessPieceMap) { (currentPosition, chessPieceMap), pieceString ->
                        val newChessPieceMap =
                            when (val maybeChessPiece = StringToChessPieceMapper.toChessPiece(pieceString)) {
                                null -> chessPieceMap
                                else -> chessPieceMap + (currentPosition to maybeChessPiece)
                            }
                        val nextPosition = currentPosition.copy(column = currentPosition.column + 1)
                        Pair(nextPosition, newChessPieceMap)
                    }.let { it.copy(first = it.first.copy(row = it.first.row + 1)) }
            }
        return SquareChessBoard(8,  positionChessPiece.second)
    }
}