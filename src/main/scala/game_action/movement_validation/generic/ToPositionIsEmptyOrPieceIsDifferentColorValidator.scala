package game_action.movement_validation.generic:

  import game_action.movement_validation.MovementValidator
  import game_data.GameData
  import game_interruption.GameInterruption
  import game_interruption.movement_validation.MoveIsInvalid

  case class ToPositionIsEmptyOrPieceIsDifferentColorValidator() extends MovementValidator:
    val toPositionIsEmptyValidator: ToPositionIsEmptyValidator = ToPositionIsEmptyValidator()
    val toPiecePositionIsDifferentColorValidator: ToPiecePositionIsDifferentColorValidator = ToPiecePositionIsDifferentColorValidator()
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      if (toPositionIsEmptyValidator.act(gameData).isLeft) Left(gameData)
      else if(toPiecePositionIsDifferentColorValidator.act(gameData).isLeft) Left(gameData)
      else Right(MoveIsInvalid(gameData))


