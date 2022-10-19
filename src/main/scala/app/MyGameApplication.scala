package app:
  
  import edu.austral.dissis.chess.gui.{AbstractChessGameApplication, CachedImageResolver, DefaultImageResolver, GameEngine, ImageResolver, SimpleGameEngine}
  import factory.board.RegularBoardFactory
  import game.RegularGame
  import game_data.piece.PieceColor
  import game_engine.MyGameEngine
  
  class MyGameApplication() extends AbstractChessGameApplication():
    val gameEngine = MyGameEngine(RegularGame(), RegularBoardFactory().createBoard(), PieceColor.WHITE, List())
    val imageResolver = new CachedImageResolver(new DefaultImageResolver())
    def getGameEngine: GameEngine = gameEngine 
    def getImageResolver: ImageResolver = imageResolver