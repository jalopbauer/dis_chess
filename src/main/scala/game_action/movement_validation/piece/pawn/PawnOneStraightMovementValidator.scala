package game_action.movement_validation.piece.pawn

import game_action.movement_validation.MovementValidator
import game_action.movement_validation.generic.movement.{MovementIsDiagonalDownTopColorValidator, MovementIsDiagonalUpBottomColorValidator, MovementIsDiagonalValidator, MovementIsOneDiagonalUpValidator, MovementIsStraightDownTopColorValidator, MovementIsStraightUpBottomColorValidator, OneStraightRespectingColorValidator}
import game_action.movement_validation.generic.{AndCompositeValidator, OrCompositeValidator, ToPositionIsEmptyOrPieceIsDifferentColorValidator, ToPositionIsEmptyValidator}
import game_data.GameData
import game_data.board.Coordinate
import game_data.piece.PieceColor
import game_interruption.{GameInterruption, MoveIsInvalid}

  case class PawnOneStraightMovementValidator() extends MovementValidator():
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      val movement = gameData.movement
      val fromPiece = gameData.board.getPiece(movement.from).get
      val toPositionIsEmpty = gameData.board.getPiece(movement.to).isEmpty
      val vector = movement.vector()
      if (vector == Coordinate(0,-1) && fromPiece.color == PieceColor.WHITE && toPositionIsEmpty) Left(gameData)
      else if (vector == Coordinate(0,1) && fromPiece.color == PieceColor.BLACK && toPositionIsEmpty) Left(gameData)
      else Right(MoveIsInvalid(gameData, "Movement is not one straight"))