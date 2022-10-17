package game_action.movement_validation.piece.pawn

import game_action.movement_validation.generic.movement.{MovementIsDiagonalDownTopColorValidator, MovementIsDiagonalUpBottomColorValidator, MovementIsDiagonalValidator, MovementIsOneDiagonalUpValidator, MovementIsStraightDownTopColorValidator, MovementIsStraightUpBottomColorValidator}
  import game_action.movement_validation.generic.{AndCompositeValidator, OrCompositeValidator, ToPositionIsEmptyOrPieceIsDifferentColorValidator}
  import game_data.piece.PieceColor

  case class PawnOneStraightMovementValidator(bottomColor: PieceColor
                                              , topColor: PieceColor) extends OrCompositeValidator(MovementIsStraightUpBottomColorValidator(bottomColor)
                                                                            , MovementIsStraightDownTopColorValidator(topColor))
