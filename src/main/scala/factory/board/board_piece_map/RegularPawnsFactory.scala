package factory.board.board_piece_map:

  import game_data.board.Coordinate
  import game_data.piece.{Piece,PieceColor}

  case class RegularPawnsFactory() extends BoardPieceMapFactory:
    val whitePawns: YcoordPawnsFactory = YcoordPawnsFactory(2,PieceColor.WHITE, 8)
    val blackPawns: YcoordPawnsFactory = YcoordPawnsFactory(7,PieceColor.BLACK, 8)
    def createPieces(): Map[Coordinate, Option[Piece]] =
      val pieces = whitePawns.createPieces().concat(blackPawns.createPieces())
      pieces