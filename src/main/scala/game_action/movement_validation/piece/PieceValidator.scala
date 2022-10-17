package game_action.movement_validation.piece:
  
  import game_action.movement_validation.MovementValidator
  import game_action.movement_validation.generic.ToPositionIsEmptyOrPieceIsDifferentColorValidator
  import game_data.GameData
  import game_interruption.GameInterruption
  import game_interruption.movement_validation.MoveIsInvalid

  trait PieceValidator(pieceMovement:MovementValidator) extends MovementValidator:
    val toPositionIsEmptyOrPieceIsDifferentColorValidator: ToPositionIsEmptyOrPieceIsDifferentColorValidator = ToPositionIsEmptyOrPieceIsDifferentColorValidator()
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      if (pieceMovement.act(gameData).isRight) Right(MoveIsInvalid(gameData))
      else if (toPositionIsEmptyOrPieceIsDifferentColorValidator.act(gameData).isRight) Right(MoveIsInvalid(gameData))
      else Left(gameData)