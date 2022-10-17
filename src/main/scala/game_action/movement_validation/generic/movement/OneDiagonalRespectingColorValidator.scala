package game_action.movement_validation.generic.movement:
  
  import game_action.movement_validation.generic.movement.{MovementIsDiagonalDownTopColorValidator, MovementIsDiagonalUpBottomColorValidator, MovementIsDiagonalValidator, MovementIsOneDiagonalUpValidator}
  import game_action.movement_validation.generic.{AndCompositeValidator, OrCompositeValidator, ToPositionIsEmptyOrPieceIsDifferentColorValidator}
  import game_data.piece.PieceColor
  
  case class OneDiagonalRespectingColorValidator(bottomColor: PieceColor, topColor: PieceColor) extends OrCompositeValidator(MovementIsDiagonalUpBottomColorValidator(bottomColor)
                                                                            ,MovementIsDiagonalDownTopColorValidator(topColor))
