package game_data.board:

  import game_data.movement.Movement
  import game_data.piece.Piece
  
  trait Board:
    def makeMovement(movement:Movement): (Board,Option[Piece])
    def coordinateBelongs(playerMovement:Coordinate):Option[Coordinate]
    def getPiece(coordinate:Coordinate):Option[Piece]
    def getPieces:Map[Coordinate,Piece]
