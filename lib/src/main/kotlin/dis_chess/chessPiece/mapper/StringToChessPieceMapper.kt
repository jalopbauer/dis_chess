package dis_chess.chessPiece.mapper

import dis_chess.chessPiece.*
import dis_chess.chessPiece.colour.BlackChessPiece
import dis_chess.chessPiece.colour.WhiteChessPiece
import dis_chess.chessPiece.type.*

object StringToChessPieceMapper {
    fun toChessPiece(string: String) : ChessPiece? {
        return mapOf(
            "♜" to ChessPiece(Rook,BlackChessPiece),
            "♞" to ChessPiece(Knight,BlackChessPiece),
            "♝" to ChessPiece(Bishop,BlackChessPiece),
            "♛" to ChessPiece(Queen,BlackChessPiece),
            "♚" to ChessPiece(King,BlackChessPiece),
            "♟" to ChessPiece(Pawn,BlackChessPiece),
            "♙" to ChessPiece(Pawn,WhiteChessPiece),
            "♖" to ChessPiece(Rook,WhiteChessPiece),
            "♘" to ChessPiece(Knight,WhiteChessPiece),
            "♗" to ChessPiece(Bishop,WhiteChessPiece),
            "♕" to ChessPiece(Queen,WhiteChessPiece),
            "♔" to ChessPiece(King,WhiteChessPiece),
        )[string]
    }
}
