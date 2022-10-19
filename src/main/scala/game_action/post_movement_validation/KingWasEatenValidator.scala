package game_action.post_movement_validation:

  import game_data.GameData
  import game_interruption.GameInterruption
  import game_interruption.post_movement_validation.KingWasEaten
  import game_data.piece.PieceType

  case class KingWasEatenValidator() extends PostMovementValidator:
    def act(gameData: GameData): Either[GameData, GameInterruption] =
//      val turns = gameData.turns
//      val piece = turns.last.eatenPiece
//      if (piece.isEmpty) Left(gameData)
//      else if (piece.isDefined && piece.get.pieceType == PieceType.KING) Right(KingWasEaten(gameData))
//      else
        Left(gameData)

