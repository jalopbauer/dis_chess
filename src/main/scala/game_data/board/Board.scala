package game_data.board:

  import game_data.piece.Piece
  
  trait Board:
    def coordinateBelongs(playerMovement:Coordinate):Option[Coordinate]
    def getPiece(coordinate:Coordinate):Option[Piece]
