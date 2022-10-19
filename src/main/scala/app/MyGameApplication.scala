package app:
  
  import edu.austral.dissis.chess.gui.{AbstractChessGameApplication, CachedImageResolver, DefaultImageResolver, GameEngine, ImageResolver, SimpleGameEngine}
  
  class MyGameApplication() extends AbstractChessGameApplication():
    val gameEngine = new SimpleGameEngine()
    val imageResolver = new CachedImageResolver(new DefaultImageResolver())
    def getGameEngine: GameEngine = gameEngine 
    def getImageResolver: ImageResolver = imageResolver