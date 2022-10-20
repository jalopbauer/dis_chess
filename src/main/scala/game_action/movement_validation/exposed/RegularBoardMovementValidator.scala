package game_action.movement_validation.exposed:
  
  import game_action.movement_validation.MovementValidator
  import game_action.movement_validation.piece.{BishopValidator, KnightValidator, PawnValidator, QueenValidator, RookValidator, KingValidator}
  import game_data.GameData
  import game_data.piece.{PieceColor, PieceType}
  import game_interruption.GameInterruption

  import scala.util.Right
  
  case class RegularBoardMovementValidator() extends MovementValidator():
    val bishopValidator: MovementValidator = BishopValidator()
    val knightValidator: MovementValidator = KnightValidator()
    val queenValidator: MovementValidator = QueenValidator()
    val rookValidator: MovementValidator = RookValidator()
    val pawnValidator: MovementValidator = PawnValidator(PieceColor.WHITE, PieceColor.BLACK)
    val kingValidator: MovementValidator = KingValidator()
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      gameData.board.getPiece(gameData.movement.from).get.pieceType match
          case PieceType.BISHOP => bishopValidator.act(gameData)
          case PieceType.KNIGHT => knightValidator.act(gameData)
          case PieceType.QUEEN => queenValidator.act(gameData)
          case PieceType.ROOK => rookValidator.act(gameData)
          case PieceType.KING => kingValidator.act(gameData)
          case PieceType.PAWN => pawnValidator.act(gameData)
