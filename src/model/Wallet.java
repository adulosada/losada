package model;

public class Wallet {
    public static final int LIMITE_BILLETERA = 500000;

    //Atrivutos
    private int saldo;
    private boolean tieneLimite;
    private int meta;

    //constructor
    public Wallet(boolean limite) {
        super();
        saldo = 0;
        meta = 0;
        tieneLimite = limite;
    }

    public int getSaldo(){
        return saldo;
    }
    public String putSaldo(int valor){
        if (saldo + valor > LIMITE_BILLETERA  && tieneLimite){
            return "No puede superar el limite";
        }
        saldo += valor; 
        if(verificarMeta()){System.out.println("Has superado la meta!");}
        return "Operacion exitosa, nuevo saldo: " + saldo;
    }
    public String extSaldo(int valor){
        if (saldo - valor < 0){
            return "No se puede retirar este monto, monto máximo: " + saldo;
        }
        saldo -= valor;
        return "Opración exitosa, nuevo saldo: " + saldo;
    }
    public String getMoney(int valor){
        //if (valor > saldo){
        // return "saldo insuficiente";    
        //}
        if(valor>saldo){
            int saldoTemp = saldo;
            saldo = 0;
            return "Solo se retiro" + saldoTemp;
        }
        saldo -= valor;
        return "Retiro exitoso, nuevo saldo" + saldo;  
    }

    public String definirMeta(int valor){
        if(valor == 0){
            meta = valor;
            return "Nueva meta agregada!";    
        }
        if(valor > LIMITE_BILLETERA && tieneLimite){
            return "No se puede establecer una meta mas alta que el limite";
        }
        if(valor <= 0){
            return "Valor ingresado no valido";
        }
        if (valor <= saldo){
            return "Ya has superado este valor";
        }  
        meta = valor;
        return "Nueva meta agregada!";
    }

    public boolean verificarMeta(){
        if(saldo >= meta && meta > 0){
            return true;
        }
        return false;
    }
}
