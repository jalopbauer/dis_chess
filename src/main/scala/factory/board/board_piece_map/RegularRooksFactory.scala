package factory.board.board_piece_map:

  import game_data.board.Coordinate
  import game_data.piece.{Piece, PieceColor}

  case class RegularRooksFactory() extends BoardPieceMapFactory:
    val whiteRooks: RegularSingleColorRooksFactory = RegularSingleColorRooksFactory(8,PieceColor.WHITE)
    val blackRooks: RegularSingleColorRooksFactory = RegularSingleColorRooksFactory(1,PieceColor.BLACK)
    def createPieces(): Map[Coordinate, Option[Piece]] =
      whiteRooks.createPieces() ++ blackRooks.createPieces()