package game_action.movement_validation.piece.pawn:

  import game_action.movement_validation.generic.OrOrCompositeValidator
  import game_data.piece.PieceColor

  case class PawnValidator(bottomColor: PieceColor, topColor: PieceColor) extends OrOrCompositeValidator(PawnDiagonalMovementValidator(bottomColor: PieceColor, topColor: PieceColor), PawnOneStraightMovementValidator(bottomColor: PieceColor, topColor: PieceColor), PawnTwoStraightMovementValidator())