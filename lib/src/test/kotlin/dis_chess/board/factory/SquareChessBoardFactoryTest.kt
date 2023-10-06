package dis_chess.board.factory

import dis_chess.chessPiece.*
import dis_chess.chessPiece.colour.BlackChessPiece
import dis_chess.chessPiece.colour.ChessPieceColour
import dis_chess.chessPiece.colour.WhiteChessPiece
import dis_chess.chessPiece.type.*
import dis_chess.chessPiece.type.factory.RegularBoardFirstAndLastRowChessPieceTypeFactory
import dis_chess.chessPiece.type.factory.RegularBoardPawnFactory
import dis_chess.position.RowColumnPosition
import junit.framework.TestCase.assertEquals
import org.junit.Test

class SquareChessBoardFactoryTest {

    @Test
    fun build() {
        val positionChessPieceType = SquareChessBoardFactory.build().positionChessPieceType
        val chessPieces = chessPieces()
        assertEquals(chessPieces, positionChessPieceType)
    }

    private fun chessPieces() = fillChessPieceMap(RegularBoardFirstAndLastRowChessPieceTypeFactory.build(), BlackChessPiece, 8) +
            fillChessPieceMap(RegularBoardFirstAndLastRowChessPieceTypeFactory.build(), WhiteChessPiece, 1) +
            fillChessPieceMap(RegularBoardPawnFactory.build(), BlackChessPiece, 7) +
            fillChessPieceMap(RegularBoardPawnFactory.build(), WhiteChessPiece, 2)

    private fun fillChessPieceMap(
        chessPieceTypeList: List<ChessPieceType>,
        chessPieceColour: ChessPieceColour,
        row: Int
    ) = chessPieceTypeList.foldIndexed(mapOf<RowColumnPosition, ChessPiece>()) { index, map, chessPieceType ->
        map + (RowColumnPosition(row, index+1) to ChessPiece(chessPieceType, chessPieceColour))
    }
}