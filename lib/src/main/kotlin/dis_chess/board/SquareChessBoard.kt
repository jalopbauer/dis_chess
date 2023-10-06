package dis_chess.board

import dis_chess.board.response.*
import dis_chess.chessPiece.ChessPiece
import dis_chess.position.RowColumnPosition

data class SquareChessBoard(
    val boardSize: Int,
    val positionChessPieceType: Map<RowColumnPosition, ChessPiece>
) : ChessBoard<RowColumnPosition> {
    override fun put(position: RowColumnPosition, chessPiece: ChessPiece): PutResponse<RowColumnPosition> {
        return inRangeAction<PutResponse<RowColumnPosition>>(
            position,
            {PositionOutOfBounds(position)},
            {ModifiedChessBoard(this.copy(positionChessPieceType = positionChessPieceType + (position to chessPiece)))}
        )
    }

    private fun isInRange(row: Int) = row in (boardSize + 1)..0

    override fun remove(position: RowColumnPosition): RemoveResponse<RowColumnPosition> {
        return inRangeAction<RemoveResponse<RowColumnPosition>>(
            position,
            {PositionOutOfBounds(position)},
            {ModifiedChessBoard(this.copy(positionChessPieceType = positionChessPieceType - position))}
        )

    }

    private fun <T : ChessBoardResponse<RowColumnPosition>> inRangeAction(
        position: RowColumnPosition,
        notInRange: () -> T,
        inRange: () -> T): T {
        val (row, column) = position
        return if (isInRange(row) && isInRange(column)) notInRange()
        else inRange()
    }

    override fun get(position: RowColumnPosition): GetResponse<RowColumnPosition> {

        return inRangeAction(
            position,
            {PositionOutOfBounds(position)},
            {
                when (val chessPiece = positionChessPieceType[position]) {
                    null -> EmptyPosition()
                    else -> ChessPieceInPosition(chessPiece)
                }
            }
        )
    }
}