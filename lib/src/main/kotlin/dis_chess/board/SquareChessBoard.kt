package dis_chess.board

import dis_chess.board.response.GetResponse
import dis_chess.board.response.PutResponse
import dis_chess.board.response.RemoveResponse
import dis_chess.chessPiece.ChessPiece
import dis_chess.position.RowColumnPosition

data class SquareChessBoard(
    val boardSize: Int,
    val positionChessPieceType: Map<RowColumnPosition, ChessPiece>
) : ChessBoard<RowColumnPosition> {
    override fun put(position: RowColumnPosition, chessPiece: ChessPiece): PutResponse<RowColumnPosition> {
        TODO("Not yet implemented")
    }

    override fun remove(position: RowColumnPosition): RemoveResponse<RowColumnPosition> {
        TODO("Not yet implemented")
    }

    override fun get(position: RowColumnPosition): GetResponse<RowColumnPosition> {
        TODO("Not yet implemented")
    }
}