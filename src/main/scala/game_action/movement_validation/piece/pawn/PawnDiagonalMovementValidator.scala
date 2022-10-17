package game_action.movement_validation.piece.pawn

import game_action.movement_validation.generic.movement.{MovementIsDiagonalDownTopColorValidator, MovementIsDiagonalUpBottomColorValidator, MovementIsDiagonalValidator, MovementIsOneDiagonalUpValidator, OneDiagonalRespectingColorValidator}
import game_action.movement_validation.generic.{AndCompositeValidator, OrCompositeValidator, ToPiecePositionIsDifferentColorValidator, ToPositionIsEmptyOrPieceIsDifferentColorValidator}
import game_data.piece.PieceColor

  case class PawnDiagonalMovementValidator(bottomColor: PieceColor, topColor: PieceColor) extends AndCompositeValidator(ToPiecePositionIsDifferentColorValidator()
                                                                            ,OneDiagonalRespectingColorValidator(bottomColor,topColor))
