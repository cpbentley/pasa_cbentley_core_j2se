package pasa.cbentley.core.j2se.engine;

import java.io.IOException;
import java.io.InputStream;

import pasa.cbentley.core.j2se.ctx.J2seCtx;
import pasa.cbentley.core.src4.interfaces.IInputStreamFactory;

public class InputStreamFactoryJ2se implements IInputStreamFactory {

   protected final J2seCtx jc;

   public InputStreamFactoryJ2se(J2seCtx jc) {
      this.jc = jc;
      
   }
   
   public InputStream getResourceAsStream(String name) throws IOException {
      return jc.getClass().getResourceAsStream(name);
   }

}
