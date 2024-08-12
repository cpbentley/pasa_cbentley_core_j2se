package pasa.cbentley.core.fx.engine;

import javafx.application.Platform;
import pasa.cbentley.core.fx.ctx.FxCoreCtx;
import pasa.cbentley.core.j2se.engine.ExecutorJ2se;
import pasa.cbentley.core.src4.interfaces.IExecutor;
import pasa.cbentley.core.src4.logging.Dctx;

public class ExecutorFx extends ExecutorJ2se implements IExecutor {

   protected final FxCoreCtx fc;

   public ExecutorFx(FxCoreCtx fc) {
      super(fc);
      this.fc = fc;
   }

   public void executeMainLater(Runnable run) {
      Platform.runLater(run);
   }

   public boolean isMainThread() {
      return Platform.isFxApplicationThread();
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, ExecutorFx.class, 35);
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, ExecutorFx.class, 35);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }
   //#enddebug

}
