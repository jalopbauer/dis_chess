package game_action.post_movement_validation:

  import game_data.GameData
  import game_interruption.GameInterruption
  import game_interruption.post_movement_validation.KingWasEaten
  import game_data.piece.PieceType

  case class KingWasEatenValidator() extends PostMovementValidator:
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      val piece = gameData.turns.last.eatenPiece
      if (piece.isDefined && piece.get.pieceType == PieceType.KING) Right(KingWasEaten(gameData))
      Left(gameData)

