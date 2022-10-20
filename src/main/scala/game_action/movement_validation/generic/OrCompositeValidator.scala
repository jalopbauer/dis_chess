package game_action.movement_validation.generic:
  
  import game_action.movement_validation.MovementValidator
  import game_data.GameData
  import game_interruption.GameInterruption
  import game_interruption.movement_validation.OrValidationNotMet

  trait OrCompositeValidator(leftValidator: MovementValidator, rightValidator: MovementValidator) extends MovementValidator:
    def act(gameData: GameData): Either[GameData, GameInterruption] = {
      val leftDataOrInterruption = leftValidator.act(gameData)
      if (leftDataOrInterruption.isLeft) Left(gameData)
      else {
        val rightDataOrInterruption = rightValidator.act(gameData)
        if (rightDataOrInterruption.isLeft) Left(gameData)
        else Right(OrValidationNotMet(gameData, leftDataOrInterruption, rightDataOrInterruption))
      }
    }


