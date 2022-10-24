package game_engine:

  import edu.austral.dissis.chess.gui.{BoardSize, GameEngine, InitialState, Move, MoveResult, NewGameState}
  import game.Game
  import game_data.GameData
  import game_data.board.Board
  import game_data.piece.PieceColor
  import game_data.turn.Turn
  import game_integration.{GameInterruptionToMoveResult, MiPiecesToChessPiece, MoveToMovement, MyPieceColorToPlayerColor}
  import player.Player

  import scala.::
  import scala.collection.mutable.ListBuffer


  class MyGameEngine(private val game:Game, private var board: Board, private var currentPlayerColor:PieceColor, private var turns: List[Turn]) extends GameEngine:

    private val miPiecesToChessPiece: MiPiecesToChessPiece = MiPiecesToChessPiece()
    private val myPieceColorToPlayerColor: MyPieceColorToPlayerColor = MyPieceColorToPlayerColor()
    private val moveToMovement: MoveToMovement = MoveToMovement()
    private val gameInterruptionToMoveResult: GameInterruptionToMoveResult = GameInterruptionToMoveResult()
    override def init(): InitialState =
      new InitialState (BoardSize (8, 8), miPiecesToChessPiece.transform(board.getPieces), myPieceColorToPlayerColor.transform(PieceColor.WHITE))


    override def applyMove(move: Move): MoveResult =
      val movement = moveToMovement.create(move, Player(currentPlayerColor))
      val gameData = GameData(board, movement, turns)
      val dataOrInterruption = game.play(gameData)
      dataOrInterruption match
        case Left(gameData) =>
          board = gameData.board
          turns = gameData.turns
          currentPlayerColor = if (currentPlayerColor == PieceColor.WHITE) PieceColor.BLACK else PieceColor.WHITE
          new NewGameState(miPiecesToChessPiece.transform(board.getPieces), myPieceColorToPlayerColor.transform(currentPlayerColor))
        case Right(error) => gameInterruptionToMoveResult.transform(error)

