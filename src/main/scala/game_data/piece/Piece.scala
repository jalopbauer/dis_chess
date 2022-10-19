package game_data.piece:
  case class Piece(color: PieceColor, pieceType: PieceType):
    val id: Int = IdGenerator.getId()
