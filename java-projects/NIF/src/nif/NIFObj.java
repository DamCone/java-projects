package nif;
public class NIFObj {

    /**
     * @return the valorNif
     */
    public String getValorNif() {
        return valorNif;
    }

    /**
     * @param valorNif the valorNif to set
     */
    public void setValorNif(String valorNif) {
        this.valorNif = valorNif;
    }
    private String valorNif;
    private long num;
    
    public NIFObj(){}
            
    boolean comprobarNif()
    {
        boolean val = true;
        int indice,x,pasenum=0;
        char letra;
        String letras = new String(), letra2;
                
        letras = "TRWAGMYFPDXBNJZSQVHLCKET";

        // comprobar que num son todo nunmeros
        for(x=0;x<=(getValorNif().length()-2);x++)
        {
            if(Character.isLetter(getValorNif().charAt(x)))
            {
                val = false;
            }
        }
         
        // y que letra es una letra.
        if(Character.isDigit(getValorNif().charAt(getValorNif().length()-1)))
        {
            val = false;
        }
        if(val)
        {
            num = Long.parseLong(getValorNif().substring(0,(getValorNif().length()-1)));
            setValorNif(getValorNif().toUpperCase());
            letra = getValorNif().charAt(getValorNif().length()-1);
            indice = (int) (num % 23);
            val = false;
            if(letra == letras.charAt(indice))
            {
                val=true;
            }
        }
        return(val);

}
}
