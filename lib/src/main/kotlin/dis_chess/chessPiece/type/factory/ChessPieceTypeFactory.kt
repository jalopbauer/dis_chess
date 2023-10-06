package dis_chess.chessPiece.type.factory

import dis_chess.chessPiece.type.ChessPieceType

interface ChessPieceTypeFactory {
    fun build() : List<ChessPieceType>
}