package game_action.movement_validation.generic.color:

  import game_action.movement_validation.MovementValidator
  import game_action.movement_validation.generic.ToPositionIsNotEmptyValidator
  import game_data.GameData
  import game_data.piece.PieceColor
  import game_interruption.GameInterruption
  import game_interruption.movement_validation.PieceColorIsNotExpected

  case class PieceColorIsExpectedValidator(expectedPieceColor:PieceColor) extends MovementValidator :
    val toPositionIsNotEmptyValidator: ToPositionIsNotEmptyValidator = ToPositionIsNotEmptyValidator()
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      toPositionIsNotEmptyValidator.act(gameData) match
        case Left(gameData) =>
          if (expectedPieceColor == gameData.board.getPiece(gameData.movement.from).get.color)
            Left(gameData)
          else
            Right(PieceColorIsNotExpected(gameData))
        case Right(moveIsInvalid) => Right(moveIsInvalid)
