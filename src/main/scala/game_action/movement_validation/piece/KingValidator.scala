package game_action.movement_validation.piece:
  
  import game_action.movement_validation.MovementValidator
  import game_action.movement_validation.generic.movement.MovementIsLShapedValidator
  import game_action.movement_validation.generic.{AndCompositeValidator, ToPositionIsEmptyOrPieceIsDifferentColorValidator}
  import game_data.GameData
  import game_data.piece.PieceColor
  import game_interruption.{GameInterruption, MoveIsInvalid}

  case class KingValidator() extends MovementValidator() :
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      val movement = gameData.movement
      val from = movement.from
      val fromPiece = gameData.board.getPiece(from).get
      val vector = movement.vector()
      if ((vector.x.abs == 1 || vector.x == 0) && (vector.y.abs == 1 || vector.y == 0))
        val maybePiece = gameData.board.getPiece(movement.to)
        val toPositionIsEmpty = maybePiece.isEmpty
        if (toPositionIsEmpty) Left(gameData)
        else if (maybePiece.get.color != fromPiece.color) Left(gameData)
        else Right(MoveIsInvalid(gameData, "King cannot eat their pieces"))
      else Right(MoveIsInvalid(gameData, "Movement is not valid for king"))