package factory.board.board_piece_map:

  import game_data.board.Coordinate
  import game_data.piece.Piece

  trait BoardPieceMapFactory:
    def createPieces(): Map[Coordinate, Option[Piece]]
