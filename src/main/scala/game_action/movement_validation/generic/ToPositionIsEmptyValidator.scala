package game_action.movement_validation.generic:

  import game_action.movement_validation.MovementValidator
  import game_data.GameData
  import game_interruption.GameInterruption
  import game_interruption.movement_validation.ToPositionIsNotEmpty

  case class ToPositionIsEmptyValidator() extends MovementValidator:
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      val to = gameData.movement.to
      if(gameData.board.getPiece(to).isDefined) Right(ToPositionIsNotEmpty(gameData))
      else Left(gameData)
