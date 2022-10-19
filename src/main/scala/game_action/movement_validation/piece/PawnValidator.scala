package game_action.movement_validation.piece:
  
  import game_action.movement_validation.generic.OrOrCompositeValidator
  import game_action.movement_validation.piece.pawn.{PawnDiagonalMovementValidator, PawnOneStraightMovementValidator, PawnTwoStraightMovementValidator}
  import game_data.piece.PieceColor
  
  case class PawnValidator(bottomColor: PieceColor, topColor: PieceColor)
    extends OrOrCompositeValidator( PawnOneStraightMovementValidator(bottomColor: PieceColor, topColor: PieceColor)
      , PawnTwoStraightMovementValidator(),
      PawnDiagonalMovementValidator(bottomColor: PieceColor, topColor: PieceColor))
