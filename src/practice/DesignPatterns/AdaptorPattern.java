package practice.DesignPatterns;

public class AdaptorPattern {

    public static void main(String[] args) {
        Charger micro = new MicroUSBCharger();
        micro.charge();

        
        TypeCCharger typeCCharger = new TypeCCharger();
        Charger typec = new ChargerAdaptor(typeCCharger);
        typec.charge();


    }


}

interface Charger {
    void charge();
}

class MicroUSBCharger implements Charger{

    @Override
    public void charge() {
        System.out.println("Charging with MicroUSBCharger");
    }
}

class TypeCCharger{

    public void chargeWithTypeC() {
        System.out.println("Charging using Type-C charger.");
    }
}


class ChargerAdaptor implements Charger{

    TypeCCharger typeCCharger;
    public ChargerAdaptor(TypeCCharger typeCCharger){
        this.typeCCharger = typeCCharger;
    }

    @Override
    public void charge() {
        this.typeCCharger.chargeWithTypeC();
    }
}

