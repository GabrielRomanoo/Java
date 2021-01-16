

class Generic<T> {
    T ob;
    
    Generic(T o) {
        ob = o;
    }
    
    T getTob() {
      return ob;
    }
}


public class JavaApplication3 {
    public static void main(String[] args) {
        Generic<Double> gen = new Generic<>(44.7);
        Generic<String> gns = new Generic<>("Genérico");
        
        System.out.println("Valor de ob: " + gen.getTob() + "\tClasse: " +
                gen.ob.getClass().getName());
        System.out.println("Valor de ob: " + gns.getTob() + "\tClasse: " +
                gns.ob.getClass().getName());
        
        gen = gns;
        
        System.out.println("Valor de ob: " gen.getTob());
    }
}