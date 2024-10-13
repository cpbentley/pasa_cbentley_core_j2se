package pasa.cbentley.core.fx.ctx;

import pasa.cbentley.core.src4.ctx.ConfigAbstract;
import pasa.cbentley.core.src4.logging.Dctx;

public class ConfigFxCoreDef extends ConfigAbstract implements IConfigFxCore {

   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, ConfigFxCoreDef.class, 15);
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, ConfigFxCoreDef.class, 15);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {
      
   }
   //#enddebug
   

}
