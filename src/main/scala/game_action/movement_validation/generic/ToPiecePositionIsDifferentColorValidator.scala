package game_action.movement_validation.generic:

  import game_action.movement_validation.MovementValidator
  import game_data.GameData
  import game_interruption.GameInterruption
  import game_interruption.movement_validation.MoveIsInvalid

  case class ToPiecePositionIsDifferentColorValidator() extends MovementValidator:
    val toPositionIsNotEmptyValidator: ToPositionIsNotEmptyValidator = ToPositionIsNotEmptyValidator()
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      toPositionIsNotEmptyValidator.act(gameData) match
        case Left(gameData) =>
          if (gameData.board.getPiece(gameData.movement.to).get.color != gameData.board.getPiece(gameData.movement.from).get.color)
            Left(gameData)
          else
            Right(MoveIsInvalid(gameData))
        case Right(moveIsInvalid) => Right(moveIsInvalid)





