package dis_chess.chessPiece.type.factory

import dis_chess.chessPiece.type.*

object RegularBoardFirstAndLastRowChessPieceTypeFactory : ChessPieceTypeFactory {
    override fun build() : List<ChessPieceType> {
        return listOf(
            Rook,
            Knight,
            Bishop,
            Queen,
            King,
            Bishop,
            Knight,
            Rook
        )
    }
}