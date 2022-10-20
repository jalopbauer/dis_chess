package game_action.movement_validation.piece.pawn:
  
  import game_action.movement_validation.MovementValidator
  import game_action.movement_validation.generic.movement.*
  import game_action.movement_validation.generic.{AndCompositeValidator, OrCompositeValidator, ToPositionIsEmptyOrPieceIsDifferentColorValidator, ToPositionIsEmptyValidator}
  import game_data.GameData
  import game_data.board.Coordinate
  import game_data.piece.PieceColor
  import game_interruption.{GameInterruption, MoveIsInvalid}
  
  case class PawnTwoStraightMovementValidator() extends MovementValidator() :
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      val movement = gameData.movement
      val from = movement.from
      val fromPiece = gameData.board.getPiece(from).get
      val toPositionIsEmpty = gameData.board.getPiece(movement.to).isEmpty
      val vector = movement.vector()
      if (from.y == 7 && vector == Coordinate(0, -2) && fromPiece.color == PieceColor.WHITE && toPositionIsEmpty) Left(gameData)
      else if (from.y == 2 && vector == Coordinate(0, 2) && fromPiece.color == PieceColor.BLACK && toPositionIsEmpty) Left(gameData)
      else Right(MoveIsInvalid(gameData, "Movement is not two straight"))