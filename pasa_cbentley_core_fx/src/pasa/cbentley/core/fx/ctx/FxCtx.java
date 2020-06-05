package pasa.cbentley.core.fx.ctx;

import java.util.concurrent.CountDownLatch;

import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import pasa.cbentley.core.j2se.ctx.J2seCtx;
import pasa.cbentley.core.src5.ctx.C5Ctx;

public class FxCtx extends J2seCtx {

   public FxCtx(C5Ctx c5) {
      super(c5);
   }

   /**
    * Called when you want to initialize a {@link JFXPanel} 
    */
   public void initializePlatform() {
      final CountDownLatch latch = new CountDownLatch(1);
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new JFXPanel(); // initializes JavaFX environment for the media
            latch.countDown();
         }
      });
      try {
         latch.await();
         //#debug
         toDLog().pFlow("JavaFx Platform initialized", this, FxCtx.class, "initializePlatform", LVL_05_FINE, true);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   /**
    * Runs the specified {@link Runnable} on the
    * JavaFX application thread and waits for completion.
    *
    * @param action the {@link Runnable} to run
    * @throws NullPointerException if {@code action} is {@code null}
    */
   public void runAndWait(Runnable action) {
      if (action == null)
         throw new NullPointerException("action");

      // run synchronously on JavaFX thread
      if (Platform.isFxApplicationThread()) {
         action.run();
         return;
      }

      // queue on JavaFX thread and wait for completion
      final CountDownLatch doneLatch = new CountDownLatch(1);
      Platform.runLater(() -> {
         try {
            action.run();
         } finally {
            doneLatch.countDown();
         }
      });

      try {
         doneLatch.await();
      } catch (InterruptedException e) {
         // ignore exception
      }
   }
}
