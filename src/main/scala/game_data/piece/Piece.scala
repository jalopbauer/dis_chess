package game_data.piece:
  case class Piece(id: Int, color: PieceColor, pieceType: PieceType):
    def this(color: PieceColor, pieceType: PieceType) = this(IdGenerator.getId(), color,pieceType)

