abstract class Subklasser{
  protected String farge;

  protected Subklasser(String farge){
    this.farge = farge;
  }

  public String hentFarge(){
    return farge;
  }
}

class Sirkel extends Subklasser{
  private int radius;

  public Sirkel(String farge, int radius){
    super(farge);
    this.radius = radius;
  }

  public double areal(){
    return 3.14*Math.pow(radius, 2);
  }
}

class Rektangel extends Subklasser{
  protected int lengde, bredde;

  public Rektangel(String farge, int lengde, int bredde){
    super(farge);
    this.lengde = lengde;
    this.bredde = bredde;
  }

  public int areal(){
    return lengde*bredde;
  }
}

class Kvadrat extends Rektangel{

  public Kvadrat(String farge, int lengde){
    super(farge, lengde, lengde);
  }
}
