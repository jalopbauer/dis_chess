package dis_chess.board.factory

import dis_chess.chessPiece.*
import dis_chess.chessPiece.colour.BlackChessPiece
import dis_chess.chessPiece.colour.ChessPieceColour
import dis_chess.chessPiece.colour.WhiteChessPiece
import dis_chess.chessPiece.type.*
import dis_chess.position.RowColumnPosition
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class SquareChessBoardFactoryTest {

    @Test
    fun build() {
        val positionChessPieceType = SquareChessBoardFactory.build().positionChessPieceType
        val chessPieces = chessPieces()
        chessPieces.forEach {
            if(it.value != positionChessPieceType[it.key]) {
//                println(it.key)
//                println(it.value)
//                println(positionChessPieceType[it.key])
//                println()
            }
        }
        assertTrue(false)
    }

    private fun chessPieces() = fillChessPieceMap(chessPiecesType(), BlackChessPiece, 8) +
            fillChessPieceMap(chessPiecesType(), WhiteChessPiece, 1) +
            fillChessPieceMap(pawns(), BlackChessPiece, 7) +
            fillChessPieceMap(pawns(), WhiteChessPiece, 2)

    private fun pawns() =
        (1 until 9).map { Pawn }

    private fun chessPiecesType() = listOf(
        Rook,
        Knight,
        Bishop,
        Queen,
        King,
        Bishop,
        Knight,
        Rook
    )

    private fun fillChessPieceMap(
        chessPieceTypeList: List<ChessPieceType>,
        chessPieceColour: ChessPieceColour,
        row: Int
    ) = chessPieceTypeList.foldIndexed(mapOf<RowColumnPosition, ChessPiece>()) { index, map, chessPieceType ->
        map + (RowColumnPosition(row, index+1) to ChessPiece(chessPieceType, chessPieceColour))
    }
}