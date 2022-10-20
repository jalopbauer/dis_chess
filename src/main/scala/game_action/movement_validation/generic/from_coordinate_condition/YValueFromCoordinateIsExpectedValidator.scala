package game_action.movement_validation.generic.from_coordinate_condition:

  import game_action.movement_validation.MovementValidator
  import game_data.GameData
  import game_interruption.GameInterruption
  import game_interruption.movement_validation.YValueFromCoordinateIsNotExpected

  case class YValueFromCoordinateIsExpectedValidator(yValue:Int) extends MovementValidator :
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      if (gameData.movement.from.y != yValue) Right(YValueFromCoordinateIsNotExpected(gameData))
      Left(gameData)