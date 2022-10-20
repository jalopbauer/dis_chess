package game_action.post_movement_validation

import game_data.GameData
import game_data.piece.{Piece, PieceType}
import game_interruption.GameInterruption
import game_interruption.post_movement_validation.KingWasEaten

  case class CrownPawn() extends PostMovementValidator:
    def act(gameData: GameData): Either[GameData, GameInterruption] = {
      val movement = gameData.movement
      val to = movement.to
      val from = movement.from
      val board = gameData.board
      val piece = board.getPiece(from).get
      if ((to.y == 8 || to.y == 1) && piece.pieceType == PieceType.PAWN)
        val newBoard = board.putPieceInCoordinate(from, Piece(piece.color,PieceType.QUEEN, piece.id))
        Left(GameData(newBoard,movement,gameData.turns))
      else Left(gameData)

    }

