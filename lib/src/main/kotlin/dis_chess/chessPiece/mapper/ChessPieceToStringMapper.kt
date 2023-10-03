package dis_chess.chessPiece.mapper

import dis_chess.chessPiece.*
import dis_chess.chessPiece.colour.BlackChessPiece
import dis_chess.chessPiece.colour.WhiteChessPiece

object ChessPieceToStringMapper {
    fun from(string: ChessPiece) : String? {
        return mapOf(
            Rook(BlackChessPiece) to "♜",
            Knight(BlackChessPiece) to "♞",
            Bishop(BlackChessPiece) to "♝",
            Queen(BlackChessPiece) to "♛",
            King(BlackChessPiece) to "♚",
            Pawn(BlackChessPiece) to "♟",
            Pawn(WhiteChessPiece) to "♙",
            Rook(WhiteChessPiece) to "♖",
            Knight(WhiteChessPiece) to "♘",
            Bishop(WhiteChessPiece) to "♗",
            Queen(WhiteChessPiece) to "♕",
            King(WhiteChessPiece) to "♔",
        )[string]
    }
}
