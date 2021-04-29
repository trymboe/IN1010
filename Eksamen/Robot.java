import java.util.Random;

class Robot{
    public int leverSvar(int alternativer){
        if(alternativer == 1){
            return 1;
        }
        else{
            double data = Math.random()*alternativer;
            int valg = (int)Math.ceil(data);
            return valg;
        }
    }
}
