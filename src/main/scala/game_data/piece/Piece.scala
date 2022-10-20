package game_data.piece:
  case class Piece(color: PieceColor, pieceType: PieceType, id: Int = IdGenerator.getId())

