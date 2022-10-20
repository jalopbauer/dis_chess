package game_action.movement_validation.generic:
  
  import game_action.movement_validation.MovementValidator
  import game_data.GameData
  import game_interruption.GameInterruption
  import game_interruption.movement_validation.AndValidationNotMet

  trait AndCompositeValidator(leftValidator: MovementValidator, rightValidator: MovementValidator) extends MovementValidator:
    def act(gameData: GameData): Either[GameData, GameInterruption] = {
      val leftDataOrInterruption = leftValidator.act(gameData)
      val rightDataOrInterruption = rightValidator.act(gameData)
      if (leftDataOrInterruption.isLeft && rightDataOrInterruption.isLeft) Left(gameData)
      else Right(AndValidationNotMet(gameData, leftDataOrInterruption.getOrElse("").toString, rightDataOrInterruption.getOrElse("").toString))
    }


