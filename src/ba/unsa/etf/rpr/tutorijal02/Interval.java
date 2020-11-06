package ba.unsa.etf.rpr.tutorijal02;

public class Interval{
    double pocetnaTacka,krajnjaTacka;
    boolean boolPocetna,boolKrajnja;
    Interval(double pocetnaTacka,double krajnjaTacka,boolean boolPocetna,boolean boolKrajnja){

        this.pocetnaTacka=pocetnaTacka;
        this.krajnjaTacka=krajnjaTacka;
        this.boolPocetna=boolPocetna;
        this.boolKrajnja=boolKrajnja;
    }
    Interval(){pocetnaTacka=0; krajnjaTacka=0;boolPocetna=false;boolKrajnja=false; }
    public boolean isNull(){
        if(this.equals(new Interval()))return true;
        return false;
    }
    public boolean isIn(double tacka){
        if(tacka>=pocetnaTacka && tacka<=krajnjaTacka)return true;
        return false;
    }
    public Interval intersect(Interval a){
        Interval povratni =new Interval();
        if(this.pocetnaTacka>=a.pocetnaTacka) {
            povratni.pocetnaTacka = this.pocetnaTacka;
            povratni.boolPocetna= this.boolPocetna;
        }
        else{
            povratni.pocetnaTacka=a.pocetnaTacka;
            povratni.boolPocetna=a.boolPocetna;
        }
        if(this.krajnjaTacka<=a.krajnjaTacka) {
            povratni.krajnjaTacka = this.krajnjaTacka;
            povratni.boolKrajnja=this.boolKrajnja;
        }
        else{
            povratni.krajnjaTacka=a.krajnjaTacka;
            povratni.boolKrajnja=this.boolKrajnja;
        }
        return povratni;
    }
    static Interval intersect(Interval a,Interval b){
        Interval povratni=new Interval();
        if(a.pocetnaTacka>=b.pocetnaTacka) {
            povratni.pocetnaTacka = a.pocetnaTacka;
            povratni.boolPocetna=a.boolPocetna;
        }
        else{
            povratni.pocetnaTacka=b.pocetnaTacka;
            povratni.boolPocetna=b.boolPocetna;
        }
        if(a.krajnjaTacka<=b.krajnjaTacka) {
            povratni.krajnjaTacka = a.krajnjaTacka;
            povratni.boolKrajnja=a.boolKrajnja;
        }
        else{
            povratni.krajnjaTacka=b.krajnjaTacka;
            povratni.boolKrajnja=b.boolKrajnja;
        }


        return povratni;
    }
    @Override
    public boolean equals(Object a){
        Interval that= (Interval) a;
        if(this.pocetnaTacka-that.pocetnaTacka==0 && that.krajnjaTacka-that.krajnjaTacka==0 && boolPocetna==that.boolPocetna && boolKrajnja==that.boolKrajnja)return true;
        return false;
    }
    @Override
    public String toString(){
        if(this.isNull())return "()";
        String pocetak=new String("(");
        String kraj= new String(")");

        if(this.boolKrajnja==true)kraj="]";
        if(this.boolPocetna==true)pocetak="[";

        return ""+pocetak + this.pocetnaTacka +","+ this.krajnjaTacka +  kraj;
    }
}
