package pasa.cbentley.core.j2se.ctx;

import pasa.cbentley.core.j2se.engine.InputStreamFactoryJ2se;
import pasa.cbentley.core.src4.ctx.ACtx;
import pasa.cbentley.core.src4.interfaces.IInputStreamFactory;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src5.ctx.C5Ctx;

/**
 * Base Context class for Swing,SWT, JavaFX core contexts.
 * 
 * <p>
 * All J2SE graphical base modules
 * </p>
 * @see {@link InputStreamFactoryJ2se}
 * 
 * @author Charles Bentley
 *
 */
public abstract class J2seCtx extends ACtx {

   protected final C5Ctx          c5;

   private InputStreamFactoryJ2se isFac;

   public J2seCtx(C5Ctx c5) {
      super(c5.getUCtx());
      this.c5 = c5;
      isFac = new InputStreamFactoryJ2se(this);
   }

   public C5Ctx getC5() {
      return c5;
   }

   public IInputStreamFactory getInputStreamFactory() {
      return isFac;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "J2seCtx");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "J2seCtx");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }

   //#enddebug

}
