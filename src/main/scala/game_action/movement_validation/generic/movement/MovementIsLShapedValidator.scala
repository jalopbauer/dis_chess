package game_action.movement_validation.generic.movement

  import game_action.movement_validation.MovementValidator
  import game_data.GameData
  import game_interruption.GameInterruption
  import game_interruption.movement_validation.MoveIsInvalid
  
  case class MovementIsLShapedValidator() extends MovementValidator:
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      val vector = gameData.movement.to.vector(gameData.movement.from)
      if ((vector.x * vector.y).abs == 2)
        Left(gameData)
      else
        Right(MoveIsInvalid(gameData))





