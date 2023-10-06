package dis_chess.board

import dis_chess.board.response.*
import dis_chess.chessPiece.ChessPiece
import dis_chess.position.Position


interface ChessBoard<T : Position> {
    fun put(position: T, chessPiece: ChessPiece) : PutResponse<T>
    fun remove(position: T): RemoveResponse<T>
    fun get(position: T): GetResponse<T>

    companion object {
        fun <T : Position> move(from: T, to: T, chessBoard: ChessBoard<T>): MoveResponse<T> {
            return when (val fromGetResponse = chessBoard.get(from)) {
                !is ChessPieceInPosition -> fromGetResponse
                else -> {
                    val (fromChessPiece) = fromGetResponse
                    when (val fromRemoveResponse = chessBoard.remove(from)) {
                        !is ModifiedChessBoard<T> -> fromRemoveResponse
                        else -> {
                            val (postFromRemoveChessBoard) = fromRemoveResponse
                            when (val toGetResponse = postFromRemoveChessBoard.get(to)) {
                                !is GetNotErrorResponse<T>-> toGetResponse
                                else -> {
                                    val toChessPieceOptional = when (toGetResponse) {
                                        is ChessPieceInPosition -> toGetResponse.chessPiece
                                        is EmptyPosition -> null
                                    }
                                    when (val toRemoveResponse = postFromRemoveChessBoard.remove(to)) {
                                        !is ModifiedChessBoard<T> -> toRemoveResponse
                                        else -> {
                                            val (postToRemoveChessBoard) = toRemoveResponse
                                            when (val putResponse: PutResponse<T> = postToRemoveChessBoard.put(to, fromChessPiece)) {
                                                !is ModifiedChessBoard<T> -> putResponse
                                                else -> ValidMoveResponse(toChessPieceOptional, putResponse.chessBoard)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


