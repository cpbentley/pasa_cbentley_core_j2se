package pasa.cbentley.core.j2se.engine;

import pasa.cbentley.core.j2se.ctx.J2seCoreCtx;
import pasa.cbentley.core.j2se.ctx.ObjectJ2C;
import pasa.cbentley.core.src4.interfaces.IExecutor;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.thread.IBRunnable;
import pasa.cbentley.core.src4.thread.WorkerThread;

public abstract class ExecutorJ2se extends ObjectJ2C implements IExecutor {
   private WorkerThread wt;

   public ExecutorJ2se(J2seCoreCtx j2c) {
      super(j2c);
   }

   public Object getThreadLocal(String key) {
      // TODO Auto-generated method stub
      return null;
   }

   public WorkerThread getWT() {
      if (wt == null) {
         wt = new WorkerThread(j2c.getUC());
      }
      return wt;
   }

   public void executeMainNow(Runnable run) {
      if (this.isMainThread()) {
         run.run();
      } else {
         executeMainLater(run);
      }
   }
   
   public void executeWorker(Runnable run) {
      WorkerThread wt = getWT();
      wt.addToQueue(run);
   }

   public void processRunnable(IBRunnable run) {
      if (run.hasRunFlag(IBRunnable.FLAG_07_UI_THREAD)) {
         this.executeMainLater(run);
      } else {
         getWT().addToQueue(run);
      }
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, ExecutorJ2se.class, 40);
      toStringPrivate(dc);
      super.toString(dc.sup());

      dc.nlLvl(wt, "wt");
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, ExecutorJ2se.class, 40);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }
   //#enddebug

}
