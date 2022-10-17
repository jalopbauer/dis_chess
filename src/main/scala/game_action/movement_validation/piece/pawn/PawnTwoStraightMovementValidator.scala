package game_action.movement_validation.piece.pawn:
  
  import game_action.movement_validation.generic.movement.*
  import game_action.movement_validation.generic.{AndCompositeValidator, OrCompositeValidator, ToPositionIsEmptyOrPieceIsDifferentColorValidator, ToPositionIsEmptyValidator}
  import game_data.piece.PieceColor
  
  case class PawnTwoStraightMovementValidator(bottomColor: PieceColor
                                              , topColor: PieceColor) extends AndCompositeValidator(ToPositionIsEmptyValidator()
                                                                          , OneStraightRespectingColorValidator(bottomColor: PieceColor, topColor: PieceColor))
