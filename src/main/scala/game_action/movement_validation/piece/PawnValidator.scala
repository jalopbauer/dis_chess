package game_action.movement_validation.piece:
  
  import game_action.movement_validation.generic.OrOrCompositeValidator
  import game_action.movement_validation.piece.pawn.{PawnDiagonalMovementValidator, PawnOneStraightMovementValidator, PawnTwoStraightMovementValidator}
  import game_data.piece.PieceColor
  
  case class PawnValidator()
    extends OrOrCompositeValidator(PawnOneStraightMovementValidator()
      , PawnTwoStraightMovementValidator(),
      PawnDiagonalMovementValidator())
