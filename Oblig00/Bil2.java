class Bil2{
  private static int nr = 1;
  private String bilNr;

  public Bil2(){
    this.bilNr = Integer.toString(this.nr);
    this.nr++;
  }

  public void print(){
    System.out.println("Jeg er en bil");
    System.out.println("Mitt nr er " + this.bilNr);
  }

}
