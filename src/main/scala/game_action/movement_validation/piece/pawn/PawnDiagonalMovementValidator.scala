package game_action.movement_validation.piece.pawn

import game_action.movement_validation.MovementValidator
import game_action.movement_validation.generic.movement.{MovementIsDiagonalDownTopColorValidator, MovementIsDiagonalUpBottomColorValidator, MovementIsDiagonalValidator, MovementIsOneDiagonalUpValidator, OneDiagonalRespectingColorValidator}
import game_action.movement_validation.generic.{AndCompositeValidator, OrCompositeValidator, ToPiecePositionIsDifferentColorValidator, ToPositionIsEmptyOrPieceIsDifferentColorValidator}
import game_data.GameData
import game_data.board.Coordinate
import game_data.piece.PieceColor
import game_interruption.{GameInterruption, MoveIsInvalid}

  case class PawnDiagonalMovementValidator() extends MovementValidator() :
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      val movement = gameData.movement
      val from = movement.from
      val fromPiece = gameData.board.getPiece(from).get
      val maybePiece = gameData.board.getPiece(movement.to)
      val toPositionIsEmpty = maybePiece.isEmpty
      val vector = movement.vector()
      if (toPositionIsEmpty) Right(MoveIsInvalid(gameData, "Movement is not diagonal: Position empty"))
      else if (vector.x.abs == 1 && vector.y == -1 && fromPiece.color == PieceColor.WHITE && maybePiece.get.color != PieceColor.WHITE) Left(gameData)
      else if (vector.x.abs == 1 && vector.y == 1 && fromPiece.color == PieceColor.BLACK && maybePiece.get.color == PieceColor.BLACK) Left(gameData)
      else Right(MoveIsInvalid(gameData, "Movement is not diagonal"))