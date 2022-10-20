package game_action.movement_validation.generic.movement:

  import game_action.movement_validation.MovementValidator
  import game_data.GameData
  import game_interruption.GameInterruption
  import game_interruption.movement_validation.IsNotOneStraightDown

  case class MovementIsOneStraightDownValidator() extends MovementValidator:
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      val movement = gameData.movement
      val vector = movement.to.vector(movement.from)
      if (vector.x == 0 && vector.y == 1)
        Left(gameData)
      else
        Right(IsNotOneStraightDown(gameData))





