package dis_chess.chessPiece.type.factory

import dis_chess.chessPiece.type.ChessPieceType
import dis_chess.chessPiece.type.Pawn

object RegularBoardPawnFactory : ChessPieceTypeFactory {
    override fun build() : List<ChessPieceType> {
        return (1 until 9).map { Pawn }
    }
}