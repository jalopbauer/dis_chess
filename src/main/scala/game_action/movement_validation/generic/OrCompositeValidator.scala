package game_action.movement_validation.generic:
  
  import game_action.movement_validation.MovementValidator
  import game_data.GameData
  import game_interruption.GameInterruption
  import game_interruption.movement_validation.MoveIsInvalid

  trait OrCompositeValidator(leftValidator: MovementValidator, rightValidator: MovementValidator) extends MovementValidator:
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      if (leftValidator.act(gameData).isLeft) Left(gameData)
      else if(rightValidator.act(gameData).isLeft) Left(gameData)
      else Right(MoveIsInvalid(gameData))


