package pasa.cbentley.core.j2se.ctx;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.core.src4.logging.IStringable;

public class ObjectJ2C implements IStringable {

   protected final J2seCoreCtx j2c;

   public ObjectJ2C(J2seCoreCtx j2c) {
      this.j2c=j2c;
   }
   
   //#mdebug
   public IDLog toDLog() {
      return toStringGetUCtx().toDLog();
   }

   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, ObjectJ2C.class, 26);
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, ObjectJ2C.class);
      toStringPrivate(dc);
   }

   public UCtx toStringGetUCtx() {
      return j2c.getUC();
   }

   //#enddebug
   

}
